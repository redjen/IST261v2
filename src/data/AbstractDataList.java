package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

/**
 * The AbstractDataList is the base class for TableModelDataList objects
 *
 * @param <T> the type of DataListItem for the instance
 *
 * @see TableModelDataList
 */
public abstract class AbstractDataList<T extends AbstractDataListItem> extends Observable
        implements Serializable, TableModelDataList {

   private final ArrayList<T> items;
   private final HashMap<Long, T> itemsById;
   private long nextId;
   private static final long serialVersionUID = 4L;

   public AbstractDataList() {
      items = new ArrayList<>();
      itemsById = new HashMap<>();
      nextId = 0;
   }

   /**
    * Adds a new DataListItem
    *
    * @param item
    * @return
    */
   public long add(T item) {
      items.add(item);
      itemsById.put(item.getId(), item);
      nextId++;
      if (item.getId() > nextId) {
         nextId = item.getId() + 1;
      }
      setChanged();
      notifyObservers();
      return item.getId();
   }

   public void addAll(List<T> newItems) {
      newItems.forEach((newItem) -> {
         // TODO this notifies the observer once for each item, which is costly
         add(newItem);
      });
   }

   public T get(int index) {
      try {
         return items.get(index);
      } catch (IndexOutOfBoundsException ex) {
         return null;
      }
   }

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

   public boolean isEmpty() {
      return items.isEmpty();
   }

   public void remove(long id) {
      if (itemsById.containsKey(id)) {
         T item = itemsById.get(id);
         items.remove(item);
         itemsById.remove(id);
      }
      setChanged();
      notifyObservers();
   }

   public void removeAll(List<Long> ids) {
      // TODO this notifies the observer once for each item, which is costly
      ids.forEach((id) -> {
         remove(id);
      });
   }

   public int size() {
      return items.size();
   }

   /**
    * Returns the next available ID
    *
    * @return
    */
   protected long getNextId() {
      return nextId;
   }

}
