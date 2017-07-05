package data.interaction;

import data.AbstractDataList;
import data.DataList;
import java.io.Serializable;

/**
 * InteractionList is a list of Interaction lists and methods to control them.
 * 
 * @see DataList
 *
 */
public class InteractionList extends AbstractDataList<AbstractInteraction>
        implements DataList<AbstractInteraction>, Serializable {
   
   private static final long serialVersionUID = 600L;

   public InteractionList() {
      super();
   }

   public long addTextMessage(long contactId, String messageText) {
      return add(new TextMessage(getNextId(), contactId, messageText));
   }

}
