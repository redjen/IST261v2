package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The AbstractDataList is the base class for DataList objects
 *
 * @param <T> the type of DataListItem for the instance
 * 
 * @see DataList
 */
public abstract class AbstractDataList<T extends DataListItem> implements DataList<T>, Serializable {

   private final ArrayList<T> items;
   private final HashMap<Long, T> itemsById;
   private long nextId;
   private static final long serialVersionUID = 100L;

   public AbstractDataList() {
      items = new ArrayList<>();
      itemsById = new HashMap<>();
      nextId = 0;
   }

   @Override
   public long add(T item) {
      items.add(item);
      itemsById.put(item.getId(), item);
      if (item.getId() > nextId) {
         nextId = item.getId() + 1;
      }
      return item.getId();
   }

   @Override
   public void addAll(List<T> newItems) {
      for (T newItem : newItems) {
         add(newItem);
      }
   }

   @Override
   public T get(int index) {
      try {
         return items.get(index);
      } catch (IndexOutOfBoundsException ex) {
         return null;
      }
   }

   @Override
   public T getById(long id) {
      T item = null;
      if (itemsById.containsKey(id)) {
         return itemsById.get(id);
      }

      return item;
   }

   protected ArrayList<T> getAllItems() {
      return items;
   }

   @Override
   public boolean isEmpty() {
      return items.isEmpty();
   }

   @Override
   public void remove(long id) {
      if (itemsById.containsKey(id)) {
         T item = itemsById.get(id);
         items.remove(item);
         itemsById.remove(id);
      }
   }

   @Override
   public void removeAll(List<Long> ids) {
      for (Long id : ids) {
         remove(id);
      }
   }

   @Override
   public int size() {
      return items.size();
   }

   /**
    * Returns the next available ID
    *
    * @return
    */
   protected long getNextId() {
      nextId++;
      return nextId;
   }

}
