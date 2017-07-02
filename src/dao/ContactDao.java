package dao;

import contacts.Contact;
import java.util.ArrayList;

/**
 * The interface ContactDao defines the behavior of a class that reads and
 * persists contact data
 *
 */
public interface ContactDao {

   /**
    * Returns a list of saved contacts
    * @return the list of contacts
    */
   public ArrayList<Contact> getContacts();
}
