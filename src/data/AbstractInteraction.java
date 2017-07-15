package data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * AbstractInteraction is a base class providing attributes and methods for an
 * interaction between two users.
 *
 */
public abstract class AbstractInteraction extends AbstractDataListItem
        implements Comparable<AbstractInteraction>, Serializable {

   private final long contactId;
   private final String messageText;
   private final ZonedDateTime timestamp;
   private final String iconLocation;

   public AbstractInteraction(long id, long contactId, String messageText, String iconLocation) {
      this(id, contactId, messageText, ZonedDateTime.now().toString(), iconLocation);
   }

   public AbstractInteraction(long id, long contactId, String messageText, String timestampString, String iconLocation) {
      super(id);
      this.contactId = contactId;
      this.messageText = messageText;
      this.timestamp = ZonedDateTime.parse(timestampString);
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

   public String getLocalTimestampString() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/y h:m a");
      return timestamp.toLocalDateTime().format(dtf);
   }

   @Override
   public int compareTo(AbstractInteraction o) {
      return o.getTimestamp().compareTo(this.getTimestamp());
   }

}
