package contacts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ContactView is the view for displaying a contact
 *
 * I split the view for this assignment into two separate views. I couldn't
 * get the elements in the contact view to line up nicely with the buttons,
 * and just gave up after burning way too much time on it.
 *
 */
public class ContactView extends JPanel {

   private static final String ICON_PATH = "resources/icons/contact/";
   private static final String PERSON_ICON = ICON_PATH + "ic_person_36pt_3x.png";

   private final JTextField firstNameField;
   private final JTextField lastNameField;
   private final JLabel imageField;
   private final JTextField phoneNumberField;
   private final JTextField emailField;
   private final JTextField twitterField;
   private final JTextField facebookField;

   public ContactView() {
      super();
      imageField = new JLabel(new ImageIcon(PERSON_ICON), JLabel.LEFT);
      imageField.setBounds(0, 0, 36, 36);

      firstNameField = new JTextField();
      lastNameField = new JTextField();
      phoneNumberField = new JTextField();
      emailField = new JTextField();
      twitterField = new JTextField();
      facebookField = new JTextField();

      setupViewLayout();
      setOpaque(true);
      setVisible(true);
   }

   /**
    * Updates the current view to show the specified contact
    *
    * @param contact
    */
   public void updateView(Contact contact) {

      firstNameField.setText(contact.getFirstName());
      lastNameField.setText(contact.getLastName());
      phoneNumberField.setText(contact.getPhoneNumber());
      emailField.setText(contact.getEmail());
      twitterField.setText(contact.getTwitterId());
      facebookField.setText(contact.getFacebookId());
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

   /**
    * Creates the view's layout and adds all elements
    */
   private void setupViewLayout() {

      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);

      GridBagConstraints gbc = new GridBagConstraints();

      gbc.insets = new Insets(5, 5, 5, 5);

      // Row 0 (image, first name, last name)
      // image
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.BASELINE;
      gbc.gridy = 0;
      gbc.gridx = 0;
      gbc.gridheight = 2;
      gbc.weightx = 0;
      add(imageField, gbc);
      gbc.gridx++;

      // first name
      gbc.anchor = GridBagConstraints.SOUTHWEST;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      add(firstNameField, gbc);
      gbc.gridx++;

      // last name
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.gridy++;
      gbc.gridx = 1;
      gbc.weightx = 1.0;
      add(lastNameField, gbc);
      gbc.gridy++;

      insertRow(phoneNumberField, "Phone", gbc);
      insertRow(emailField, "Email", gbc);
      insertRow(twitterField, "Twitter", gbc);
      insertRow(facebookField, "Facebook", gbc);

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
      // label
      gbc.weighty = 0;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      gbc.gridx = 0;

      add(jLabel, gbc);
      gbc.gridx++;

      // text field
      gbc.weightx = 1.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      add(jtf, gbc);

      // prepare for next row
      gbc.gridx = 0;
      gbc.gridy++;
   }

}
