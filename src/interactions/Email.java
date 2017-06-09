package interactions;

/**
 * Email provides attributes and methods for email messages.
 *
 */
public class Email extends Interaction {

   private final static String SUMMARY_TEXT_FORMAT = "Subject: %s%n%n%s";
   private final String subject;

   public Email(long id, long contactId, String messageText, String subject) {
      super(id, contactId, messageText);
      this.subject = subject;
   }

   @Override
   public String getSummaryText() {
      return String.format(SUMMARY_TEXT_FORMAT, subject, getMessageText());
   }

   public String getSubject() {
      return subject;
   }

}
