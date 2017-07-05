package data.interaction;

import data.DataListItem;
import java.time.ZonedDateTime;

/**
 * AbstractInteraction is a base class providing attributes and methods for an
 * interaction between two users.
 *
 */
public abstract class AbstractInteraction implements Comparable<AbstractInteraction>, DataListItem {

   private final long id;
   private final long contactId;
   private final String messageText;
   private final ZonedDateTime timestamp;
   private final String iconLocation;

   public AbstractInteraction(long id, long contactId, String messageText, String iconLocation) {
      this.id = id;
      this.contactId = contactId;
      this.messageText = messageText;
      this.timestamp = ZonedDateTime.now();
      this.iconLocation = iconLocation;
   }

   /**
    * Provides a short text summary of the interaction for display
    *
    * @return text summary
    */
   public String getSummaryText() {
      return this.messageText;
   }

   @Override
   public long getId() {
      return id;
   }

   public long getContactId() {
      return contactId;
   }

   public String getIconLocation() {
      return iconLocation;
   }

   public String getMessageText() {
      return messageText;
   }

   public ZonedDateTime getTimestamp() {
      return timestamp;
   }

   @Override
   public int compareTo(AbstractInteraction o) {
      return Long.compare(id, o.getId());
   }

}
