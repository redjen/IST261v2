package data;

/**
 * TableModelDataList defines the behaviors required for a list of objects to
 * be used with table models.
 *
 * @param <T> the type of objects the class manages
 */
public interface TableModelDataList<T> {

   public T get(int index);

   public int size();
}
