package data;

import java.util.List;

/**
 * The interface DataList represents
 * 
 */
public interface DataList<T> {
   
   public long add(T item);
   public void addAll(List<T> newItems);
   public T get(int index);
   public T getById(long id);
   public boolean isEmpty();
   public void remove(long id);
   public void removeAll(List<Long> ids);
   public int size();
   
}
