package contacts;

import javax.swing.table.AbstractTableModel;

/**
 * The ContactTableModel class represents
 * 
 */
public class ContactTableModel extends AbstractTableModel {
   
   private static final String[] COLUMN_NAMES = {"ID", "First Name", "Last Name", "Phone"};
   private final ContactList contactList;

   public ContactTableModel(ContactList contactList) {
      super();
      this.contactList = contactList;      
   }

   @Override
   public int getRowCount() {
      return contactList.size();
   }

   @Override
   public int getColumnCount() {
      return COLUMN_NAMES.length;
   }
   
   @Override
   public String getColumnName(int index) {
      return COLUMN_NAMES[index];
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      switch (columnIndex) {
         case 0:
            return (Object) contactList.get(rowIndex).getId();
         case 1:
            return (Object) contactList.get(rowIndex).getFirstName();
         case 2:
            return (Object) contactList.get(rowIndex).getLastName();
         case 3: 
            return (Object) contactList.get(rowIndex).getPhoneNumber();
         default:
            return null;
      }
   }

}
