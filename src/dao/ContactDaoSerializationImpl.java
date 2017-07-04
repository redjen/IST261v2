package dao;

import contacts.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 * The ContactDaoSerializationImpl class provides methods to read and persist
 * Contact objects between application runs.
 *
 */
public class ContactDaoSerializationImpl implements ContactDao {

   /**
    * {@inheritDoc }
    */
   @Override
   public ArrayList<Contact> getContacts() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public ArrayList<Contact> getTestContacts() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public void saveContacts(List<Contact> contacts) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
