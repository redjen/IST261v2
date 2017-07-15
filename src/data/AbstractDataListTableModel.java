package data;

import javax.swing.table.AbstractTableModel;

/**
 * ContactTableModel is table model for use with tables that display a list
 * of contacts.
 *
 */
public abstract class AbstractDataListTableModel extends AbstractTableModel {

   private final String[] columnNames;
   protected final TableModelDataList dataList;

   public AbstractDataListTableModel(TableModelDataList dataList, String[] column_names) {
      super();
      this.columnNames = column_names;
      this.dataList = dataList;
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public int getRowCount() {
      return dataList.size();
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public int getColumnCount() {
      return columnNames.length;
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public String getColumnName(int index) {
      return columnNames[index];
   }

   /**
    * {@inheritDoc }
    */
   @Override
   public abstract Object getValueAt(int rowIndex, int columnIndex);

   /**
    * {@inheritDoc }
    */
   @Override
   public abstract boolean isCellEditable(int row, int col);

   /**
    * {@inheritDoc }
    */
   @Override
   public abstract void setValueAt(Object value, int row, int col);

}
