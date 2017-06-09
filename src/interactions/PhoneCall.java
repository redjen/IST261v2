package interactions;

/**
 * PhoneCall provides attributes and methods for a phone call.
 *
 */
public class PhoneCall extends Interaction {

   private final static String SUMMARY_TEXT_CALL_TYPE_FORMAT = "%s%d%n";
   private final static String SUMMARY_TEXT_DURATION_FORMAT = "%d:%d";
   private final int durationSeconds;
   private final PhoneCallType callType;

   public PhoneCall(long id, long contactId, int durationSeconds, PhoneCallType callType) {
      super(id, contactId, "");
      this.callType = callType;
      
      if (callType.equals(PhoneCallType.MISSED)) {
         this.durationSeconds = 0;
      } else {
         this.durationSeconds = durationSeconds;
      }
   }

   @Override
   public String getSummaryText() {
      StringBuilder sb = new StringBuilder();
      
      sb.append(String.format(SUMMARY_TEXT_CALL_TYPE_FORMAT, callType.getDisplayText(), getContactId()));

      if (!callType.equals(PhoneCallType.MISSED)) {
         sb.append(String.format(SUMMARY_TEXT_DURATION_FORMAT, durationSeconds / 60, durationSeconds % 60));
      }

      return sb.toString();
   }
   
   @Override
   public String getMessageText() {
      return getSummaryText();
   }

   public int getDurationSeconds() {
      return durationSeconds;
   }

   public PhoneCallType getCallType() {
      return callType;
   }
   
 }
