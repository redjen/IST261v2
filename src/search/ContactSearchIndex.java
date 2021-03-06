package search;

import data.Contact;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ContactSearchIndex is an index for searching contacts that contain a
 * specified string in any field. Methods are provided to index a contact,
 * remove all indices for a contact, update indices for a contact, and search
 * for a specified term.
 *
 * Make sure to always delete the indexes for a contact before deleting the
 * contact itself to avoid memory leaks.
 */
public class ContactSearchIndex implements Serializable {

   private final HashMap<String, HashSet<Long>> terms;

   private static final long serialVersionUID = 2L;
   private static final Logger log = Logger.getLogger("ContactSearchIndex");

   /**
    * Constructs a new, empty search index
    */
   public ContactSearchIndex() {
      terms = new HashMap<>();
   }

   /**
    * Constructs a new search index populated with the specified contacts
    *
    * @param contacts the contacts used for the search index
    */
   public ContactSearchIndex(List<Contact> contacts) {
      this();
      for (Contact contact : contacts) {
         createAllIndexesFor(contact);
      }
   }

   /**
    * Returns all contacts matching the term
    *
    * @param searchTerm the search term
    * @return the list of all matching contacts (empty if none found)
    */
   public HashSet<Long> getMatchesFor(String searchTerm) {
      return terms.getOrDefault(searchTerm, new HashSet<>());
   }

   /**
    * Indexes a contact
    *
    * The minimum string size is 3 to increase performance
    *
    * @param contact the contact to index
    */
   public void createAllIndexesFor(Contact contact) {
      HashSet<String> indexes = getIndexesFor(contact);

      for (String index : indexes) {
         terms.putIfAbsent(index, new HashSet<>());
         terms.get(index).add(contact.getId());
      }
   }

   /**
    * Deletes all indexes for a contact
    *
    * @param contact the contact to be deleted
    */
   public void deleteAllIndexesFor(Contact contact) {
      if (contact == null) {
         log.log(Level.WARNING, "Contact is null");
      }
      HashSet<String> indexes = getIndexesFor(contact);
      for (String index : indexes) {
         terms.get(index).remove(contact.getId());
         if (terms.get(index).isEmpty()) {
            terms.remove(index);
         }
      }
   }

   /**
    * Updates the indexes for a contact by removing and adding lists of search
    * terms
    *
    * @param contact the contact to be change
    * @param oldTerms search terms to be removed
    * @param newTerms new search terms to be added
    */
   public void updateIndexesFor(Contact contact, List<String> oldTerms, List<String> newTerms) {
      
      if (oldTerms != null && !oldTerms.isEmpty()) {
         for (String oldTerm : oldTerms) {
            HashSet<String> indexes = getSubstringsOf(oldTerm);
            for (String index : indexes) {
               terms.getOrDefault(index, new HashSet<>()).remove(contact.getId());
            }

         }
      }

      if (newTerms != null && !newTerms.isEmpty()) {
         for (String newTerm : newTerms) {
            HashSet<String> indexes = getSubstringsOf(newTerm);
            for (String index : indexes) {
               terms.putIfAbsent(index, new HashSet<>());
               terms.get(index).add(contact.getId());
            }

         }
      }
   }

   /**
    * Tests the index for emptiness
    *
    * @return true is empty, false otherwise
    */
   public boolean isEmpty() {
      return terms.isEmpty();
   }

   /**
    * Returns the number of items in the search index
    *
    * @return the number of items
    */
   public int size() {
      return terms.size();
   }

   /**
    * Tests for the specified key
    *
    * @param term the search term
    * @return
    */
   public boolean containsKey(String term) {
      return terms.containsKey(term);
   }

   /**
    * Generate the complete list of indexes for a contact covering all fields
    *
    * @param contact the contact to index
    * @return the list of indexes
    */
   public HashSet<String> getIndexesFor(Contact contact) {
      HashSet<String> indexes = new HashSet<>();
      ArrayList<String> searchTerms = new ArrayList<>(6);

      searchTerms.add(contact.getEmail());
      searchTerms.add(contact.getFacebookId());
      searchTerms.add(contact.getFirstName());
      searchTerms.add(contact.getLastName());
      searchTerms.add(contact.getPhoneNumber());
      searchTerms.add(contact.getTwitterId());

      for (String term : searchTerms) {
         if (term != null && term.length() > 0) {
            indexes.addAll(getSubstringsOf(term));
         }
      }

      return indexes;
   }

   /**
    * Generates the substrings of the specified string of minimum length 3
    *
    * @param term
    * @return
    */
   public HashSet<String> getSubstringsOf(String term) {
      HashSet<String> substrings = new HashSet<>();

      for (int i = 0; i <= term.length() - 3; i++) {
         for (int j = i + 3; j <= term.length(); j++) {
            substrings.add(term.substring(i, j).toLowerCase());
         }
      }

      return substrings;
   }

   /**
    * Prints the contents of the index to the console
    * @param out
    */
   public void printIndex(PrintWriter out) {
      for (String term : terms.keySet()) {
         out.format("%n[%s]: ", term);
         for (long id : terms.get(term)) {
            out.format("%d ", id);
         }
      }
      out.flush();
   }

}
