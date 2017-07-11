package app;

import data.ContactTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * ContactTablePanel is the view for displaying a table of contacts. It is the
 * "list" portion of the list-detail pattern. Accessors are provided for the
 * buttons added to the UI.
 *
 */
public class ContactTablePanel extends CardPanelBase {

   private final static String ICON_PATH = "resources/icons/contact/";
   private final static String ADD_ICON = ICON_PATH + "ic_person_add_18pt.png";
   private final static String DELETE_ICON = ICON_PATH + "ic_delete_black_18dp.png";
   private static final String PERSON_ICON = ICON_PATH + "ic_person_18pt.png";

   private final JButton addContactButton;
   private final JButton deleteContactButton;
   private final JButton detailButton;
   private final JTable contactTable;

   public ContactTablePanel(ContactTableModel model) {
      super();

      addContactButton = new JButton("Add", new ImageIcon(ADD_ICON));
      addContactButton.setToolTipText("new contact");
      addButton(addContactButton);

      deleteContactButton = new JButton("Delete", new ImageIcon(DELETE_ICON));
      deleteContactButton.setToolTipText("delete contact");
      addButton(deleteContactButton);

      detailButton = new JButton("Details", new ImageIcon(PERSON_ICON));
      detailButton.setToolTipText("show details");
      addButton(detailButton);

      contactTable = new JTable(model);
      setContent(contactTable);
      revalidate();
   }

   public JButton getAddContactButton() {
      return addContactButton;
   }

   public JButton getDeleteContactButton() {
      return deleteContactButton;
   }

   public JButton getDetailButton() {
      return detailButton;
   }

   public JTable getContactTable() {
      return contactTable;
   }

}
