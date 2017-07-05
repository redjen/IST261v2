package data.interaction;

import data.AbstractDataList;
import data.DataList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * InteractionList is a list of Interaction lists and methods to control them.
 *
 * @see DataList
 *
 */
public class InteractionList extends AbstractDataList<AbstractInteraction>
        implements DataList<AbstractInteraction>, Serializable {

   private static final long serialVersionUID = 600L;
   private final HashMap<Long, ArrayList<AbstractInteraction>> itemsByContactId;

   public InteractionList() {
      super();
      this.itemsByContactId = new HashMap<>();
      indexAllByContactId();
   }

   /**
    * Adds a new text message interaction
    * @param contactId ID of the contact associated with this interaction
    * @param messageText text of the message
    * @return new interaction ID
    */
   public long addTextMessage(long contactId, String messageText) {
      TextMessage newMessage = new TextMessage(getNextId(), contactId, messageText);
      add(newMessage);
      indexByContactId(newMessage);
      return newMessage.getId();
   }

   /**
    * Adds a single item to the index of interactions referenced by the contact ID
    * @param item the interaction to index
    */
   private void indexByContactId(AbstractInteraction item) {
      if (itemsByContactId.containsKey(item.getContactId())) {
         itemsByContactId.get(item.getContactId()).add(item);
      } else {
         ArrayList<AbstractInteraction> list = new ArrayList<>();
         add(item);
         itemsByContactId.put(item.getContactId(), list);
      }
   }

   /**
    * Regenerates the index of contacts reference by the contact ID
    */
   void indexAllByContactId() {
      itemsByContactId.clear();
      ArrayList<AbstractInteraction> itemList = getAllItems();
      for (AbstractInteraction item : itemList) {
         indexByContactId(item);
      }
   }
}
