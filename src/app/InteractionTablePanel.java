package app;

import data.InteractionTableModel;
import javax.swing.JTable;

/**
 * The InteractionTablePanel class represents
 * 
 */
public class InteractionTablePanel extends CardPanelBase {

   private final JTable interactionTable;

   public InteractionTablePanel(InteractionTableModel model) {
      super();
      this.interactionTable = new JTable(model);
      setContent(interactionTable);
      revalidate();
   }

   public JTable getInteractionTable() {
      return interactionTable;
   }
   
}
