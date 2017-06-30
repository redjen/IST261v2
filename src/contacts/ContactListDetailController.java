package contacts;

import app.AppFrame;
import dao.ContactDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

public class ContactListDetailController {
   
   private final ContactList contactList;
   private final ContactTableModel contactTableModel;
   private int currentContactIndex;
   private boolean isCreatingNewContact;
   
   private final AppFrame appFrame;
   private final ContactListDetailView contactListView;
   private final ContactView contactView;
   private final JTable contactListable;
   private final JButton deleteButton;
   private final JButton addButton;
   private final JButton saveButton;
   private final JButton detailButton;
   
   public ContactListDetailController() {
      
      this.currentContactIndex = 0;
      isCreatingNewContact = false;
      
      contactList = new ContactList();
      createTestContacts();
      contactTableModel = new ContactTableModel(contactList);
      
      appFrame = new AppFrame("Contacts");
      contactListView = new ContactListDetailView(contactTableModel);
      appFrame.setContentPane(contactListView);
      
      contactView = contactListView.getContactView();
      addButton = contactListView.getAddContactButton();
      deleteButton = contactListView.getDeleteContactButton();
      saveButton = contactListView.getSaveContactButton();
      detailButton = contactListView.getContactDetailButton();
      
      contactListable = contactListView.getContactTable();
      contactListable.setAutoCreateRowSorter(true);
      
      appFrame.setVisible(true);
      
      addListeners();
      
   }
   
   public ContactTableModel getContactTableModel() {
      return contactTableModel;
   }

   /**
    * Sets action listeners on controls
    */
   private void addListeners() {
      
      deleteButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (!isCreatingNewContact) {
               contactList.remove(currentContactIndex);
               // TODO implement for list-detail view
            }
         }
      });
      
      addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            contactView.clearView();
            isCreatingNewContact = true;
         }
      });
      
      saveButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            saveContact();
         }
      });
      
      detailButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            contactListView.showContactDetail();
            // TODO show new contact view
         }
      });
   }

   /**
    * Saves changes for the current contact or creates a new contact if the
    * new contact form is active.
    */
   private void saveContact() {
      if (isCreatingNewContact) {
         currentContactIndex = contactList.add(contactView.getFirstNameField().getText(),
                 contactView.getLastNameField().getText(),
                 contactView.getPhoneNumberField().getText(),
                 contactView.getEmailField().getText(),
                 contactView.getTwitterField().getText(),
                 contactView.getFacebookField().getText());
         isCreatingNewContact = false;
         
      } else {
         contactList.update(currentContactIndex, contactView.getFirstNameField().getText(),
                 contactView.getLastNameField().getText(),
                 contactView.getPhoneNumberField().getText(),
                 contactView.getEmailField().getText(),
                 contactView.getTwitterField().getText(),
                 contactView.getFacebookField().getText());
      }
   }

   /**
    * Creates contacts for testing purposes
    */
   private void createTestContacts() {
      ContactDao dao = new ContactDao();
      contactList.addAll(dao.getContacts());
   }
}
