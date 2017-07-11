package data;

import java.io.Serializable;

/**
 * ContactList is a collection of Contacts and methods to interact add, delete,
 * access, and update them.
 *
 */
public class ContactList extends AbstractDataList<Contact> implements DataList<Contact>, Serializable {

   private static final long serialVersionUID = 3L;

   /**
    * Constructs a new ContactList populated with test contacts
    *
    */
   public ContactList() {
      super();
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
      Contact c = new Contact(getNextId(), firstName, lastName, phoneNumber, email, twitterId, facebookId);
      return add(c);
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
      
      getById(contactId).update(firstName, lastName, phoneNumber, email, twitterId, facebookId);
   }

}
