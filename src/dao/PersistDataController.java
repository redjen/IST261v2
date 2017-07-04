/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contacts.Contact;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author redjen
 */
public class PersistDataController {

   private final static String DATA_FILE = "resources/defaultData/contacts.txt";

   public PersistDataController() {
   }

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
         Logger.getLogger(PersistDataController.class.getName()).log(Level.SEVERE, null, ex);
      }

      return contacts;
   }

   public ArrayList<Contact> getContacts() {
      ArrayList<Contact> list = new ArrayList<>();

      return list;
   }

}
