package contacts;

import dao.PersistDataController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ContactList is a collection of Contacts and methods to interact add, delete,
 * access, and update them.
 *
 */
public class ContactList {

   private final ArrayList<Contact> contacts;
   private long lastId;
   private final PersistDataController persistDataController;

   private final HashMap<Long, Contact> contactsById;

   public ContactList(PersistDataController persistDataController) {
      this.persistDataController = persistDataController;
      contacts = new ArrayList<>();
      contactsById = new HashMap<>();
      lastId = 0;
      
      contacts.addAll(persistDataController.getContacts());
      // get test contacts if none were previously saved
      if (contacts.isEmpty()) {
         System.out.println("No saved contacts, getting test contacts");
         contacts.addAll(persistDataController.getTestContacts());         
      }
      reIndexContacts();      
   }

   /**
    * Add a new contact at the end of the list and return its ID
    *
    * @param firstName
    * @param lastName
    * @return the contact's ID
    */
   public long add(String firstName, String lastName) {
      return add(firstName, lastName, "", "", "", "");
   }

   /**
    * Add a new contact at the end of the list with all fields and returns its
    * IDl
    *
    * @param firstName
    * @param lastName
    * @param phoneNumber
    * @param email
    * @param twitterId
    * @param facebookId
    * @return the contact's unique ID
    */
   public long add(String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      lastId++;
      Contact c = new Contact(lastId, firstName, lastName, phoneNumber, email, twitterId, facebookId);
      contacts.add(c);
      contactsById.put(c.getId(), c);

      return c.getId();
   }

   /**
    * Adds a list of contacts
    *
    * @param newContacts
    */
   public void addAll(List<Contact> newContacts) {
      for (Contact newContact : newContacts) {
         if (newContact.getId() > lastId) {
            lastId = newContact.getId();
         }
         contacts.add(newContact);
         contactsById.put(newContact.getId(), newContact);
      }
   }

   /**
    * Updates a contact's attributes
    *
    * @param contactId
    * @param firstName
    * @param lastName
    * @param phoneNumber
    * @param email
    * @param twitterId
    * @param facebookId
    */
   public void update(long contactId, String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      contactsById.get(contactId).update(firstName, lastName, phoneNumber, email, twitterId, facebookId);
   }

   /**
    * Deletes the specified contact
    *
    * @param contactId the ID of the contact to remove
    */
   public void remove(long contactId) {
      Contact contact;
      if (contactsById.containsKey(contactId)) {
         contact = contactsById.get(contactId);
         contacts.remove(contact);
         contactsById.remove(contactId);
         System.out.printf("Removed contact %d%n", contactId);
      }
   }
   
   /**
    * Deletes all specified contacts
    * 
    * @param contactIds list of contact IDs to remove
    */
   public void removeAll(List<Long> contactIds) {
      for (Long contactId : contactIds) {
         remove(contactId);
      }
   }

   /**
    * Returns the length of the contact list
    *
    * @return the length
    */
   public int size() {
      return contacts.size();
   }

   /**
    * Returns the contact at the specified index or null if it doesn't exist.
    *
    * @param index the contact index
    * @return the contact or null if it doesn't exist
    */
   public Contact get(int index) {

      try {
         return contacts.get(index);
      } catch (IndexOutOfBoundsException ex) {
         return null;
      }

   }

   /**
    * Returns the contact with the specified ID
    *
    * @param id the ID
    * @return the contact or null if it does not exist
    */
   public Contact getById(long id) {
      Contact contact = null;

      if (contactsById.containsKey(id)) {
         contact = contactsById.get(id);
      } else {
         System.err.printf("Contact %d not found", id);
      }
      return contact;
   }


   /**
    * Tests if the contact list is empty
    *
    * @return
    */
   public boolean isEmpty() {
      return contacts.isEmpty();
   }
   
   /**
    * Regenerates the HashMap "indexes" for the contact list
    */
   private void reIndexContacts() {
      contactsById.clear();
      for (Contact contact : contacts) {
         contactsById.put(contact.getId(), contact);
      }
   }
}