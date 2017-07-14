package app;

import data.Contact;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * ContactDetailView is the view for displaying a contact view. It is part of
 * the "detail" portion of the list-detail pattern. It provides methods to
 * display a contact's data and can also be used as a form for creating new
 * contacts.
 */
public class ContactDetailView extends JPanel {

   private static final String ICON_PATH = "resources/icons/contact/";
   private static final String PERSON_ICON = ICON_PATH + "ic_person_36pt_3x.png";
   private final Controller controller;
   private Contact currentContact;
   private final GridBagConstraints gbc;

   private final JTextField firstNameField;
   private final JTextField lastNameField;
   private final JLabel imageField;
   private final JTextField phoneNumberField;
   private final JTextField emailField;
   private final JTextField twitterField;
   private final JTextField facebookField;


   /**
    * Constructs a new ContactDetailView and displays the specified contact's
    * information
    *
    * @param controller the application controller
    * @param row the index of the table model row for the contact to be
    * displayed
    */
   public ContactDetailView(Controller controller, int row) {
      this(controller);

      this.currentContact = controller.getContact(row);

      updateView();
   }

   /**
    * Constructs an empty ContactDetailView
    *
    * @param controller the application controller
    */
   public ContactDetailView(Controller controller) {
      super();

      this.controller = controller;

      imageField = new JLabel(new ImageIcon(PERSON_ICON), JLabel.LEFT);
      imageField.setBounds(0, 0, 36, 36);

      firstNameField = new JTextField();
      lastNameField = new JTextField();
      phoneNumberField = new JTextField();
      emailField = new JTextField();
      twitterField = new JTextField();
      facebookField = new JTextField();

      gbc = new GridBagConstraints();
      setupViewLayout();
      setOpaque(true);
   }

   /**
    * Clears all fields
    */
   public void clearView() {
      firstNameField.setText("");
      lastNameField.setText("");
      phoneNumberField.setText("");
      emailField.setText("");
      twitterField.setText("");
      facebookField.setText("");
   }

   public JTextField getFirstNameField() {
      return firstNameField;
   }

   public JTextField getLastNameField() {
      return lastNameField;
   }

   public JTextField getPhoneNumberField() {
      return phoneNumberField;
   }

   public JTextField getEmailField() {
      return emailField;
   }

   public JTextField getTwitterField() {
      return twitterField;
   }

   public JTextField getFacebookField() {
      return facebookField;
   }

   public long getCurrentContactId() {
      if (currentContact != null) {
         return currentContact.getId();
      } else {
         return -1;
      }
   }

   public void addInteractions(List<InteractionContactDetailView> interactions) {

      if (interactions.size() > 0) {
         JPanel jp = new JPanel();
         jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
         gbc.fill = GridBagConstraints.BOTH;
         gbc.gridy++;
         gbc.gridx = 0;
         gbc.weightx = 1.0;
         gbc.weighty = 1.0;
         gbc.gridwidth = 2;
         
         for (InteractionContactDetailView interaction : interactions) {
            jp.add(interaction);
         }     
         add(new JScrollPane(jp), gbc);
      }
   }

   /**
    * Updates the current view to show the specified contact
    */
   private void updateView() {

      firstNameField.setText(currentContact.getFirstName());
      lastNameField.setText(currentContact.getLastName());
      phoneNumberField.setText(currentContact.getPhoneNumber());
      emailField.setText(currentContact.getEmail());
      twitterField.setText(currentContact.getTwitterId());
      facebookField.setText(currentContact.getFacebookId());

   }

   /**
    * Creates the view's layout and adds all elements
    */
   private void setupViewLayout() {

      GridBagLayout layout = new GridBagLayout();
      layout.setConstraints(this, gbc);
      setLayout(layout);

      gbc.insets = new Insets(5, 5, 5, 5);

      // Row 0 (image, first name, last name)
      // image
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.BASELINE;
      gbc.gridy = 0;
      gbc.gridx = 0;
      gbc.gridy++;

      insertRow(firstNameField, "First name", gbc);
      gbc.gridy++;
      insertRow(lastNameField, "Last name", gbc);
      gbc.gridy++;
      insertRow(phoneNumberField, "Phone", gbc);
      gbc.gridy++;
      insertRow(emailField, "Email", gbc);
      gbc.gridy++;
      insertRow(twitterField, "Twitter", gbc);
      gbc.gridy++;
      insertRow(facebookField, "Facebook", gbc);
      gbc.gridy++;
   }

   /**
    * Convenience method for inserting a label/text field row
    *
    * @param jtf the text field
    * @param label the text field's label
    * @param gbc the current gridbagconstraints
    */
   private void insertRow(JTextField jtf, String label, GridBagConstraints gbc) {

      JLabel jLabel = new JLabel(label);
      jLabel.setHorizontalAlignment(JLabel.LEFT);
      // label
      gbc.weighty = 0;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      gbc.gridx = 0;
      gbc.anchor = GridBagConstraints.WEST;

      add(jLabel, gbc);
      gbc.gridx++;

      // text field
      gbc.weightx = 1.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      add(jtf, gbc);

      // prepare for next row
      gbc.gridx = 0;
   }

}
