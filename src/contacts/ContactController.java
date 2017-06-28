package contacts;

import app.AppFrame;
import dao.ContactDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ContactController {

   private final ContactList contactList;
   private final AppFrame appFrame;
   private final ContactListView contactListView;

   private final ContactView contactView;
   private final JButton previousButton;
   private final JButton nextButton;
   private final JButton deleteButton;
   private final JButton addButton;
   private final JButton saveButton;

   private int currentContactIndex;
   private boolean isCreatingNewContact;

   public ContactController() {

      this.currentContactIndex = 0;
      isCreatingNewContact = false;

      contactList = new ContactList();
      appFrame = new AppFrame("Contacts");
      contactListView = new ContactListView();
      appFrame.setContentPane(contactListView);

      contactView = contactListView.getContactView();
      previousButton = contactListView.getPreviousButton();
      nextButton = contactListView.getNextButton();
      addButton = contactListView.getAddContactButton();
      deleteButton = contactListView.getDeleteContactButton();
      saveButton = contactListView.getSaveContactButton();

      createTestContacts();
      navigateList(0);
      nextButton.setEnabled(true);

      appFrame.setVisible(true);

      addListeners();

   }

   /**
    * Updates the contact view to show the contact at the current index plus
    * the distance away specified by step. The new contact form is shown if
    * the contact list is empty. The contact closest to the specified index is
    * shown if the new index is out of bounds.
    * @param step the distance from the current contact
    */
   private void navigateList(int step) {

      int newContactIndex = currentContactIndex + step;
      Contact newContact = null;

      if (contactList.isEmpty()) {
         newContactIndex = 0;
         contactView.clearView();
         isCreatingNewContact = true;
         currentContactIndex = 0;
      } else {
         if (newContactIndex >= contactList.size()) {
            newContactIndex = contactList.getLastIndex();
         } else if (newContactIndex < 0) {
            newContactIndex = 0;
         }

         newContact = contactList.get(newContactIndex);
         contactView.updateView(newContact);
         isCreatingNewContact = false;
      }

      previousButton.setEnabled(contactList.hasPrevious(newContactIndex));
      nextButton.setEnabled(contactList.hasNext(newContactIndex));
      currentContactIndex = newContactIndex;
   }

   /**
    * Sets action listeners on controls
    */
   private void addListeners() {

      previousButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            navigateList(-1);
         }
      });

      nextButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            navigateList(1);
         }
      });

      deleteButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (!isCreatingNewContact) {
               contactList.remove(currentContactIndex);
               navigateList(-1);
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
      navigateList(0);
   }

   /**
    * Creates contacts for testing purposes
    */
   private void createTestContacts() {
      ContactDao dao = new ContactDao();
      contactList.addAll(dao.getContacts());
   }
}
