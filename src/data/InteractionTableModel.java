package data;

/**
 * The InteractionTableModel class represents
 *
 */
public class InteractionTableModel extends AbstractDataListTableModel<InteractionList> {

   private static final String[] COLUMN_NAMES = {"ID", "Contact Name", "Time"};

   public InteractionTableModel(InteractionList interactionList) {
      super(interactionList, COLUMN_NAMES);
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      TextMessage interaction = (TextMessage) dataList.get(rowIndex);

      switch (columnIndex) {
         case 0:
            return (Object) interaction.getId();
         case 1:
            return (Object) interaction.getContactId();
         case 2:
            return (Object) interaction.getTimestamp().toString();
         default:
            return null;
      }
   }

   @Override
   public void setValueAt(Object value, int row, int col) {
      // no-op
   }

   @Override
   public boolean isCellEditable(int row, int col) {
      return false;
   }

}
