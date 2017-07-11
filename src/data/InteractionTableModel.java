package data;

import app.Controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * The InteractionTableModel class represents
 *
 */
public class InteractionTableModel extends AbstractDataListTableModel<InteractionList> {

   private static final String[] COLUMN_NAMES = {"ID", "Contact Name", "Time", "Message"};
   private final Controller controller;

   public InteractionTableModel(InteractionList interactionList, Controller controller) {
      super(interactionList, COLUMN_NAMES);
      this.controller = controller;
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      TextMessage interaction = (TextMessage) dataList.get(rowIndex);

      switch (columnIndex) {
         case 0:
            return (Object) interaction.getId();
         case 1:
            Contact contact;
            long contactId = interaction.getContactId();
            contact = controller.getContactById(contactId);
            if (contact != null) {
               return (Object) contact.getFullName();
            } else {
               return (Object) "";
            }
         case 2:
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/y h:m a");
            LocalDateTime ldt = interaction.getTimestamp().toLocalDateTime();
            return (Object) ldt.format(dtf);
         case 3:
            return (Object) interaction.getSummaryText();
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
