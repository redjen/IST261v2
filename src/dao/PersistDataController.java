package dao;

import data.contact.Contact;
import data.contact.ContactList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PersistDataController is responsible for reading and writing persisted data
 * 
 */
public class PersistDataController {

   private final static String DATA_FILE = "data.ser";
   private final static String TEST_CONTACTS_DATA_FILE = "resources/defaultData/contacts.txt";

   private SerializedDataCollection data;

   public PersistDataController() {
      data = readData();

   }

   /**
    * Reads and returns test contacts from the predefined data file.
    *
    * @return
    */
   public ArrayList<Contact> getTestContacts() {
      ArrayList contacts = new ArrayList();

      try (Scanner scanner = new Scanner(new File(TEST_CONTACTS_DATA_FILE))) {
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
         Logger.getLogger(PersistDataController.class.getName()).log(Level.SEVERE, null, ex);
      }

      return contacts;
   }

   /**
    * Reads and returns persisted contacts.
    *
    * @return
    */
   public ContactList getContacts() {
      return data.getContactList();
   }

   /**
    * Reads the persisted data
    *
    * @return the persisted data, or an empty SerializedDataCollection if none
    * was stored
    */
   private SerializedDataCollection readData() {

      SerializedDataCollection newData = null;

      File dataFile = new File(DATA_FILE);

      if (!dataFile.exists()) {
         return createSerializedDataCollection();
      }

      try (java.io.FileInputStream fis = new FileInputStream(dataFile);
              java.io.ObjectInputStream in = new ObjectInputStream(fis)) {

         newData = (SerializedDataCollection) in.readObject();

      } catch (FileNotFoundException ex) {
         Logger.getLogger(PersistDataController.class.getName()).log(Level.INFO, "Data file not found, using test data");
         newData = createSerializedDataCollection();
      } catch (IOException | ClassNotFoundException ex) {
         Logger.getLogger(PersistDataController.class.getName()).log(Level.SEVERE, null, ex);

      } finally {
         return newData;
      }

   }

   /**
    * Saves the application data
    */
   public void writeData() {
      File dataFile = new File(DATA_FILE);

      try (java.io.FileOutputStream fos = new FileOutputStream(dataFile, false);
              java.io.ObjectOutputStream out = new ObjectOutputStream(fos)) {

         out.writeObject(data);

      } catch (IOException ex) {
         Logger.getLogger(PersistDataController.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   /**
    * Constructs a new SerializedDataCollection when no data has been persisted
    * using existing test data
    *
    * @return a new SerializedDataCollection
    */
   private SerializedDataCollection createSerializedDataCollection() {
      SerializedDataCollection sdc = new SerializedDataCollection();
      sdc.getContactList().addAll(getTestContacts());
      return sdc;
   }

}
