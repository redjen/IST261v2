package dao;

import contacts.Contact;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ContactDaoTextImpl is a very simple Dao for storing and retrieving
 * contacts.
 *
 * This was used only used to get stored contact data for testing. It's being
 * retained for historical and possible future purposes.
 *
 */
@Deprecated
public class ContactDaoTextImpl implements ContactDao {

   private final static String DATA_FILE = "resources/defaultData/contacts.txt";

   public ContactDaoTextImpl() {
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public ArrayList<Contact> getContacts() {
      // unused pre M07
      return getTestContacts();
   }

   @Override
   public ArrayList<Contact> getTestContacts() {
      ArrayList contacts = new ArrayList();

      try (Scanner scanner = new Scanner(new File(DATA_FILE))) {
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(0) != '#') {
               Contact contact = null;
               String[] tokens = line.split(",");
               contact = new Contact(Long.parseLong(tokens[0]), tokens[1], tokens[2],
                       tokens[3], tokens[4], tokens[5], tokens[6]);
               contacts.add(contact);
            }

         }
      } catch (FileNotFoundException ex) {
         Logger.getLogger(ContactDaoTextImpl.class.getName()).log(Level.SEVERE, null, ex);
      }

      return contacts;
   }

   @Override
   public void saveContacts(List<Contact> contacts) {
      // no-op
   }

}
