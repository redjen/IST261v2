package data;

/**
 * ContactTableModel is table model for use with tables that display a list
 * of contacts.
 *
 */
public class ContactTableModel extends AbstractDataListTableModel<ContactList> {

   private static final String[] COLUMN_NAMES = {"ID", "First Name", "Last Name", "Phone"};

   public ContactTableModel(ContactList contactList) {
      super(contactList, COLUMN_NAMES);
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {

      Contact c = (Contact) dataList.get(rowIndex);

      switch (columnIndex) {
         case 0:
            return (Object) c.getId();
         case 1:
            return (Object) c.getFirstName();
         case 2:
            return (Object) c.getLastName();
         case 3:
            return (Object) c.getPhoneNumber();
         default:
            return null;
      }
   }
   

   /**
    * {@inheritDoc }
    */
   @Override
   public void setValueAt(Object value, int row, int col) {
      String newValue = (String) value;
      Contact contact = (Contact) dataList.get(row);
      switch (col) {
         case 1:
            contact.setFirstName(newValue);
            break;
         case 2:
            contact.setLastName(newValue);
            break;
         case 3:
            contact.setPhoneNumber(newValue);
            break;
         default:
            break;
      }
      fireTableCellUpdated(row, col);
   }

   @Override
   public boolean isCellEditable(int row, int col) {
      return (col > 0);
   }
}
