package contacts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * ContactListHorizontalView is the view for displaying contacts and the
 * controls for
 * interacting with contacts
 *
 * I split the view for this assignment into two separate views. I couldn't
 * get the elements in the contact view to line up nicely with the buttons,
 * and just gave up after burning way too much time on it.
 *
 */
public class ContactListDetailView extends JPanel {

   private static final String ICON_PATH = "resources/icons/contact/";
   private final static String ADD_ICON = ICON_PATH + "ic_person_add_18pt.png";
   private final static String SAVE_ICON = ICON_PATH + "ic_save_black_18dp.png";
   private final static String DELETE_ICON = ICON_PATH + "ic_delete_black_18dp.png";

   private final GridBagConstraints gbc;

   private final JButton addContactButton;
   private final JButton saveContactButton;
   private final JButton deleteContactButton;
   private final JButton contactDetailButton;
   private final JScrollPane tableScrollPane;
   private final JTable contactTable;
   private final ContactView contactView;

   public ContactListDetailView(ContactTableModel model) {
      super();

      addContactButton = new JButton(new ImageIcon(ADD_ICON));
      addContactButton.setBounds(0, 0, 18, 18);
      addContactButton.setToolTipText("new contact");

      deleteContactButton = new JButton(new ImageIcon(DELETE_ICON));
      deleteContactButton.setBounds(0, 0, 18, 18);
      deleteContactButton.setToolTipText("delete contact");

      saveContactButton = new JButton(new ImageIcon(SAVE_ICON));
      saveContactButton.setBounds(0, 0, 18, 18);
      saveContactButton.setToolTipText("save changes");

      contactDetailButton = new JButton(new ImageIcon(SAVE_ICON));
      contactDetailButton.setBounds(0, 0, 18, 18);
      contactDetailButton.setToolTipText("show details");

      contactView = new ContactView();

      contactTable = new JTable(model);
      tableScrollPane = new JScrollPane(contactTable);

      gbc = new GridBagConstraints();
      setupViewGBLayout();
      setVisible(true);
   }

   /**
    * Hides the contact list view and shows the detail view for the specified
    * contact.
    */
   public void showContactDetail() {

      gbc.gridy = 1;
      gbc.gridx = 0;
      gbc.gridwidth = 4;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;

      remove(tableScrollPane);
      add(contactView, gbc);
      revalidate();
   }

   /**
    * Hides the contact detail view and shows the list view.
    */
   public void showContactList() {

      gbc.gridy = 1;
      gbc.gridx = 0;
      gbc.gridwidth = 4;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      remove(contactView);
      add(tableScrollPane, gbc);
      revalidate();

   }

   public JButton getAddContactButton() {
      return addContactButton;
   }

   public JButton getSaveContactButton() {
      return saveContactButton;
   }

   public JButton getDeleteContactButton() {
      return deleteContactButton;
   }

   public ContactView getContactView() {
      return contactView;
   }

   public JButton getContactDetailButton() {
      return contactDetailButton;
   }

   public JTable getContactTable() {
      return contactTable;
   }

   /**
    * Creates the view's layout and adds all elements
    */
   private void setupViewGBLayout() {
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      gbc.anchor = GridBagConstraints.NORTHEAST;
      gbc.fill = GridBagConstraints.NONE;
      gbc.insets = new Insets(5, 5, 5, 5);

      // layout settings for row 0 (add/delete buttons)
      gbc.gridy = 0;
      gbc.gridx = 0;
      gbc.weighty = 0;

      // new contact button
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      add(addContactButton, gbc);
      
      // contact details button
      gbc.gridx++;
      add(contactDetailButton, gbc);

      // save contact button
      gbc.gridx++;
      gbc.fill = GridBagConstraints.NONE;
      add(saveContactButton, gbc);

      // delete contact button
      gbc.gridx++;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 0;
      add(deleteContactButton, gbc);

      showContactList();
   }

}
