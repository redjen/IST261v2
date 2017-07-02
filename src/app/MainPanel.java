package app;

import contacts.ContactTableModel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * MainPanel is the top-level panel for the application's views. It provides
 * methods to show and hide its child panels.
 *
 */
public class MainPanel extends JPanel {

   private final ContactTablePanel tablePanel;
   private final ContactDetailPanel detailPanel;

   public MainPanel(ContactTableModel model) {
      super();

      this.setLayout(new CardLayout());
      detailPanel = new ContactDetailPanel();
      this.add(detailPanel);

      tablePanel = new ContactTablePanel(model);
      this.add(tablePanel);

      setTableVisible(true);
      setVisible(true);
   }

   /**
    * Controls the visibility of the contact table. Setting the contact table
    * to visible will hide the detail view and vice versa
    *
    * @param visible true to show the contact table, otherwise false
    */
   public void setTableVisible(boolean visible) {
      tablePanel.setVisible(visible);
      detailPanel.setVisible(!visible);
      revalidate();
   }

   /**
    * Controls the visibility of the detail view. Setting the detail view
    * to visible will hide the table view and vice versa
    *
    * @param visible true to show the detail view, otherwise false
    */
   public void setDetailVisible(boolean visible) {
      tablePanel.setVisible(!visible);
      detailPanel.setVisible(visible);
      revalidate();
   }

   public ContactTablePanel getTablePanel() {
      return tablePanel;
   }

   public ContactDetailPanel getDetailPanel() {
      return detailPanel;
   }

}
