package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * InteractionList is a list of Interaction lists and methods to control them.
 *
 * @see DataList
 *
 */
public class InteractionList extends AbstractDataList<AbstractInteraction> {

//   private static final long serialVersionUID = 3L;
   private final HashMap<Long, TreeSet<AbstractInteraction>> itemsByContactId;

   public InteractionList() {
      super();
      this.itemsByContactId = new HashMap<>();
   }

   /**
    * Returns the interactions associated with the contact ID
    *
    * @param contactId the contact ID
    * @return the interactions or an empty set if none found
    */
   public TreeSet<AbstractInteraction> getInteractionsByContactId(long contactId) {
      return itemsByContactId.getOrDefault(contactId, new TreeSet<>());
   }

   /**
    * Adds a new text message interaction
    *
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

   @Override
   public void addAll(List<AbstractInteraction> newItems) {
      super.addAll(newItems);
      indexAllByContactId();
   }

   /**
    * Adds a single item to the index of interactions referenced by the contact
    * ID
    *
    * @param item the interaction to index
    */
   private void indexByContactId(AbstractInteraction item) {
      TreeSet<AbstractInteraction> ts = itemsByContactId.getOrDefault(item.getContactId(), new TreeSet<>());
      ts.add(item);
      itemsByContactId.put(item.getContactId(), ts);
   }

   /**
    * Regenerates the index of contacts reference by the contact ID
    */
   private void indexAllByContactId() {
      itemsByContactId.clear();
      ArrayList<AbstractInteraction> itemList = getAllItems();
      for (AbstractInteraction item : itemList) {
         indexByContactId(item);
      }
   }
}
