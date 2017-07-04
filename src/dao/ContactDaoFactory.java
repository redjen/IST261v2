package dao;

/**
 * The ContactDaoFactory generates a ContactDao object. 
 * 
 * Change this class when changing storage methods.
 * 
 */
public class ContactDaoFactory {
   
   public static ContactDao getDao() {
      return new ContactDaoTextImpl();
   }
}
