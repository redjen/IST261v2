package contacts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ContactListView is the view for displaying contacts and the controls for
 * interacting with contacts
 * 
 * I split the view for this assignment into two separate views. I couldn't 
 * get the elements in the contact view to line up nicely with the buttons,
 * and just gave up after burning way too much time on it.
 *
 */
public class ContactListView extends JPanel {

   private static final String ICON_PATH = "resources/icons/contact/";
   private final static String ADD_ICON = ICON_PATH + "ic_person_add_18pt.png";
   private final static String SAVE_ICON = ICON_PATH + "ic_save_black_18dp.png";
   private final static String DELETE_ICON = ICON_PATH + "ic_delete_black_18dp.png";
   private final static String NEXT_ICON = ICON_PATH + "ic_navigate_next_36pt.png";
   private final static String PREVIOUS_ICON = ICON_PATH + "ic_navigate_before_36pt.png";

   private final JButton addContactButton;
   private final JButton saveContactButton;
   private final JButton deleteContactButton;
   private final JButton previousButton;
   private final JButton nextButton;
   private final ContactView contactView;

   public ContactListView() {
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

      previousButton = new JButton(new ImageIcon(PREVIOUS_ICON));
      previousButton.setToolTipText("Previous contact");
      saveContactButton.setBounds(0, 0, 18, 18);
      previousButton.setEnabled(false);

      contactView = new ContactView();

      nextButton = new JButton(new ImageIcon(NEXT_ICON));
      nextButton.setToolTipText("Next contact");
      saveContactButton.setBounds(0, 0, 18, 18);
      nextButton.setEnabled(false);

      setupViewGBLayout();
      setVisible(true);
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

   public JButton getPreviousButton() {
      return previousButton;
   }

   public JButton getNextButton() {
      return nextButton;
   }

   public ContactView getContactView() {
      return contactView;
   }

   /**
    * Creates the view's layout and adds all elements
    */
   private void setupViewGBLayout() {
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      GridBagConstraints gbc = new GridBagConstraints();
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

      // save contact button
      gbc.gridx++;
      gbc.fill = GridBagConstraints.NONE;
      add(saveContactButton, gbc);

      // delete contact button
      gbc.gridx++;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 0;
      add(deleteContactButton, gbc);

      // layout settings for row 1 (navigation and contact view)
      gbc.gridy++;
      gbc.weighty = 1.0;

      // Previous button
      gbc.gridx = 0;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.VERTICAL;
      add(previousButton, gbc);

      // Contact card
      gbc.gridx++;
      gbc.weightx = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      add(contactView, gbc);

      // Next button
      gbc.gridx++;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.weightx = 0;
      add(nextButton, gbc);

   }

}
