package dao;

import contacts.Contact;
import java.util.ArrayList;
import java.util.List;

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
   
   /**
    * Returns a list of existing test contacts
    * 
    * Per assignment requirements, this method should be called whenever there
    * are no persisted contacts
    * 
    * @return the list of contacts
    */
   public ArrayList<Contact> getTestContacts();
   
   /**
    * Persists the list of saved contacts
    * @param contacts 
    */
   public void saveContacts(List<Contact> contacts);
}
