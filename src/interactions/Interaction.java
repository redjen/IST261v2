package interactions;

/**
 * Interaction is a base class providing attributes and methods for an interaction
 * between two users. 
 * 
 */
public class Interaction implements Comparable<Interaction> {
   
   private final long id;
   private long contactId;
   private final String messageText;

   public Interaction(long id, long contactId, String messageText) {
      this.id = id;
      this.contactId = contactId;
      this.messageText = messageText;
   }
   
   /**
    * Provides a short text summary of the interaction for display
    * @return text summary
    */
   public String getSummaryText() {
      return this.messageText;
   }

   public long getId() {
      return id;
   }

   public long getContactId() {
      return contactId;
   }

   public void setContactId(long contactId) {
      this.contactId = contactId;
   }
   public String getMessageText() {
      return messageText;
   }

   @Override
   public int compareTo(Interaction o) {
      return Long.compare(id, o.getId());
   }

   
}
