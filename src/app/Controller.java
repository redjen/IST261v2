package app;

import data.Contact;
import data.ContactList;
import data.ContactTableModel;
import persist.PersistDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 * Controller for the application
 */
public class Controller {

   private final PersistDataController persistDataController;
   private final ContactList contactList;
   private final ContactTableModel contactTableModel;
   private boolean isCreatingNewContact;

   private final AppFrame appFrame;
   private final MainPanel mainPanel;
   private ContactDetailView contactView;
   private final JTable contactListTable;

   public Controller() {

      persistDataController = new PersistDataController();

      isCreatingNewContact = false;

      contactList = persistDataController.getContacts();

      contactTableModel = new ContactTableModel(contactList);

      appFrame = new AppFrame("Contacts");
      mainPanel = new MainPanel(contactTableModel);
      appFrame.setContentPane(mainPanel);

      contactListTable = mainPanel.getTablePanel().getContactTable();
      contactListTable.setAutoCreateRowSorter(true);

      appFrame.setVisible(true);

      addListeners();

   }

   public ContactTableModel getContactTableModel() {
      return contactTableModel;
   }

   /**
    * Gets the contact at the specified table model row
    *
    * @param row the table model row
    * @return corresponding contact
    */
   public Contact getContact(int row) {
      Contact contact;
      long contactId;

      contactId = (long) contactTableModel.getValueAt(row, 0);
      contact = contactList.getById((long) contactId);

      return contact;
   }

   /**
    * Constructs and shows the detail view for the specified contact
    *
    * @param row the contact's row number in the table model
    */
   private void getDetailView(int row) {
      contactView = new ContactDetailView(this, row);
      mainPanel.getDetailPanel().setContent(contactView);
      mainPanel.setDetailVisible(true);
   }

   /**
    * Saves changes for the current contact or creates a new contact if the
    * new contact form is active.
    */
   private void handleSaveButton() {
      if (isCreatingNewContact) {

         contactList.add(contactView.getFirstNameField().getText(),
                 contactView.getLastNameField().getText(),
                 contactView.getPhoneNumberField().getText(),
                 contactView.getEmailField().getText(),
                 contactView.getTwitterField().getText(),
                 contactView.getFacebookField().getText());

         contactTableModel.fireTableDataChanged();
         isCreatingNewContact = false;

      } else {

         long contactId = contactView.getCurrentContactId();
         contactList.update(contactId, contactView.getFirstNameField().getText(),
                 contactView.getLastNameField().getText(),
                 contactView.getPhoneNumberField().getText(),
                 contactView.getEmailField().getText(),
                 contactView.getTwitterField().getText(),
                 contactView.getFacebookField().getText());
         contactTableModel.fireTableDataChanged();
      }

      unloadContactView();
   }

   /**
    * Returns the model row index for selected table rows
    *
    * @return the model row index or -1 if there is no corresponding index
    */
   private int getSelectedContactRow() {
      int selectedRow = contactListTable.getSelectedRow();
      if (selectedRow >= 0) {
         int selectedRowModel = contactListTable.convertRowIndexToModel(selectedRow);
         return selectedRowModel;

      } else {
         return -1;
      }
   }

   /**
    * Handler for showing the detail view for the selected contact.
    */
   private void handleDetailButton() {
      if (contactListTable.getSelectedRowCount() == 1) {
         int selectedRow = getSelectedContactRow();

         if (selectedRow >= 0) {
            getDetailView(selectedRow);
         }
      }

   }

   /**
    * Handler for deleting one or more contacts from the table view
    */
   private void handleDeleteTableButton() {
      ArrayList<Long> contactIds = new ArrayList<>();
      for (int selectedRow : contactListTable.getSelectedRows()) {
         int selectedRowModel = contactListTable.convertRowIndexToModel(selectedRow);
         long contactId = (long) contactListTable.getValueAt(selectedRowModel, 0);
         contactIds.add(contactId);
      }
      contactList.removeAll(contactIds);
      contactTableModel.fireTableDataChanged();
   }

   /**
    * Handler for deleting the current contact from the detail view
    */
   private void handleDeleteDetailButton() {
      if (!isCreatingNewContact) {
         contactList.remove(contactView.getCurrentContactId());
         contactTableModel.fireTableDataChanged();
      }
      unloadContactView();
   }

   /**
    * Handler for showing the add contact view
    */
   private void handleAddButton() {
      contactView = new ContactDetailView(Controller.this);
      mainPanel.getDetailPanel().setContent(contactView);
      mainPanel.setDetailVisible(true);
      isCreatingNewContact = true;
   }

   /**
    * Destroys the current contact view and shows the table view
    */
   private void unloadContactView() {
      contactView = null;
      mainPanel.getDetailPanel().setContent(null);
      mainPanel.setTableVisible(true);
   }

   /**
    * Handler for showing the table view from the detail view
    */
   private void handleTableButton() {
      mainPanel.setTableVisible(true);
   }

   private void handleExit() {
      persistDataController.writeData();
      appFrame.dispose();
   }

   /**
    * Sets action listeners on controls
    */
   private void addListeners() {

      appFrame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.out.println("closing");
            handleExit();
         }
      });

      mainPanel.getDetailPanel().getTableButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleTableButton();
         }
      });

      mainPanel.getTablePanel().getDetailButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleDetailButton();
         }
      });

      mainPanel.getTablePanel().getDeleteContactButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleDeleteTableButton();
         }
      });

      mainPanel.getDetailPanel().getDeleteContactButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleDeleteDetailButton();
         }
      });

      mainPanel.getTablePanel().getAddContactButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleAddButton();
         }
      });

      mainPanel.getDetailPanel().getAddContactButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleAddButton();
         }
      });

      mainPanel.getDetailPanel().getSaveContactButton().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            handleSaveButton();
         }
      });

   }

}
