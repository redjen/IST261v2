package app;

import data.ContactTableModel;
import data.InteractionTableModel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * MainPanel is the top-level panel for the application's views. It provides
 * methods to show and hide its child panels.
 *
 */
public class MainPanel extends JTabbedPane {

   private final JPanel contactTopPanel;
   private final ContactTablePanel contactTablePanel;
   private final ContactDetailPanel contactDetailPanel;
   
   private final JPanel interactionTopPanel;
   private final InteractionTablePanel interactionTablePanel;
   
   public MainPanel(ContactTableModel contactModel, InteractionTableModel interactionModel) {
      super();
      
      // create panels and panes
      contactTopPanel = new JPanel();
      contactDetailPanel = new ContactDetailPanel();
      contactTablePanel = new ContactTablePanel(contactModel);
      interactionTopPanel = new JPanel();
      interactionTablePanel = new InteractionTablePanel(interactionModel);
      setupPanels();
      
      // set visibility on subviews
      setContactTableVisible(true);
      setVisible(true);
   }

   /**
    * Controls the visibility of the contact table. Setting the contact table
    * to visible will hide the detail view and vice versa
    *
    * @param visible true to show the contact table, otherwise false
    */
   public void setContactTableVisible(boolean visible) {
      contactTablePanel.setVisible(visible);
      contactDetailPanel.setVisible(!visible);
      revalidate();
   }

   /**
    * Controls the visibility of the detail view. Setting the detail view
    * to visible will hide the table view and vice versa
    *
    * @param visible true to show the detail view, otherwise false
    */
   public void setContactDetailVisible(boolean visible) {
      contactTablePanel.setVisible(!visible);
      contactDetailPanel.setVisible(visible);
      revalidate();
   }

   public ContactTablePanel getContactTablePanel() {
      return contactTablePanel;
   }

   public ContactDetailPanel getContactDetailPanel() {
      return contactDetailPanel;
   }

   private void setupPanels() {
      
      // contact views
      contactTopPanel.setLayout(new CardLayout());
      contactTopPanel.add(contactDetailPanel);
      contactTopPanel.add(contactTablePanel);
      
      // interaction views
      interactionTopPanel.setLayout(new CardLayout());
      interactionTopPanel.add(interactionTablePanel);
      
      // add tabs
      this.addTab("Contacts", contactTopPanel);
//      this.addTab("Interactions", interactionTopPanel);
      
   }
}
