package contacts;

import java.util.ArrayList;

/**
 * ContactList is a collection of Contacts and methods to interact add, delete,
 * access, and update them.
 *
 */
public class ContactList {

   private final ArrayList<Contact> contacts;
   private long lastId;

   public ContactList() {
      contacts = new ArrayList<>();
      lastId = 0;
   }

   /**
    * Add a new contact at the end of the list and return its index
    *
    * @param firstName
    * @param lastName
    * @return
    */
   public int add(String firstName, String lastName) {
      lastId++;
      Contact c = new Contact(lastId, firstName, lastName);
      contacts.add(c);
      return contacts.size() - 1;
   }

   /**
    * Add a new contact at the end of the list with all fields and returns its
    * index
    *
    * @param firstName
    * @param lastName
    * @param phoneNumber
    * @param email
    * @param twitterId
    * @param facebookId
    * @return
    */
   public int add(String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      lastId++;
      Contact c = new Contact(lastId, firstName, lastName, phoneNumber, email, twitterId, facebookId);
      contacts.add(c);
      return contacts.size() - 1;
   }

   /**
    * Updates a contact's attributes
    *
    * @param index
    * @param firstName
    * @param lastName
    * @param phoneNumber
    * @param email
    * @param twitterId
    * @param facebookId
    */
   public void update(int index, String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      contacts.get(index).update(firstName, lastName, phoneNumber, email, twitterId, facebookId);
   }

   /**
    * Deletes the specified contact
    * @param index 
    */
   public void remove(int index) {
      if (index >= 0 && index < contacts.size()) {
         contacts.remove(index);
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
    * Returns the index of the last Contact
    * @return 
    */
   public int getLastIndex() {
      return contacts.size() - 1;
   }

   /**
    * Tests if the contact list is empty
    * @return 
    */
   public boolean isEmpty() {
      return contacts.isEmpty();
   }

   /**
    * Convenience method for testing if there exists a contact at index - 1
    *
    * This method supports testing indices out of bounds.
    *
    * @param index the index to test
    * @return true if there is a preceding index, otherwise false
    */
   public boolean hasPrevious(int index) {
      return index > 0;
   }

   /**
    * Convenience method for testing if there exists a contact at index + 1
    *
    * This method supports testing indices out of bounds.
    *
    * @param index the index to test
    * @return true if there is a following index, otherwise false
    */
   public boolean hasNext(int index) {
      return index + 1 < contacts.size();
   }

}
