package interactions;

/**
 * PhoneCallType provides the type of a phone call such as missed, received,
 * or placed call.
 * 
 */
public enum PhoneCallType {
   MISSED("Missed call from "),
   RECEIVED("Received call from "),
   PLACED("Called ");
   
   private final String displayText;

   private PhoneCallType(String displayText) {
      this.displayText = displayText;
   }
   
   /**
    * Returns the text to be displayed for each type
    * @return display text
    */
   public String getDisplayText() {
      return displayText;
   }
   
}
