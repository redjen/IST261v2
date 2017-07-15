package data;

import java.io.Serializable;

/**
 * The AbstractDataListItem class represents
 *
 */
public abstract class AbstractDataListItem implements Serializable {

   private static final long serialVersionUID = 2L;
   private final long id;

   public AbstractDataListItem(long id) {
      this.id = id;
   }

   public long getId() {
      return id;
   }

}
