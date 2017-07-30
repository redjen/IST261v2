package app;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * ContactTablePanel is used to display a ContactDetailView and associated
 * controls. Is is part of the "detail" portion of the list-detail pattern.
 *
 */
public class ContactDetailPanel extends CardPanelBase {

   private final static String ICON_PATH = "resources/icons/contact/";
   private final static String ADD_ICON = ICON_PATH + "ic_person_add_18pt.png";
   private final static String SAVE_ICON = ICON_PATH + "ic_save_black_18dp.png";
   private final static String DELETE_ICON = ICON_PATH + "ic_delete_black_18dp.png";
   private static final String TABLE_ICON = ICON_PATH + "ic_contacts_18pt.png";

   private final JButton addContactButton;
   private final JButton saveContactButton;
   private final JButton deleteContactButton;
   private final JButton tableButton;
   
   public ContactDetailPanel() {
      super();

      addContactButton = new JButton("New", new ImageIcon(ADD_ICON));
      addContactButton.setToolTipText("new contact");
      addToButtonPanel(addContactButton);

      deleteContactButton = new JButton("Delete", new ImageIcon(DELETE_ICON));
      deleteContactButton.setToolTipText("delete contact");
      addToButtonPanel(deleteContactButton);

      saveContactButton = new JButton("Save", new ImageIcon(SAVE_ICON));
      saveContactButton.setToolTipText("save changes");
      addToButtonPanel(saveContactButton);

      tableButton = new JButton("Contacts", new ImageIcon(TABLE_ICON));
      tableButton.setToolTipText("show table");
      addToButtonPanel(tableButton);

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

   public JButton getTableButton() {
      return tableButton;
   }

}
