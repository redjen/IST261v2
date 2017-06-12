package interactions;

/**
 * The Facebook class provides attributes of a Facebook post and methods to
 * generate its views.
 *
 */
public class Facebook extends Interaction implements Sociable<String> {

   private final String remoteId;
   private final String remoteUsername;
   private final FacebookType remoteType;
   
   // URL prefix, username, posttype, remoteId
   private static final String URL_FORMATTER = "%s/%s/%s/%s";
   
   // contactId, remoteUsername, messageText, remoteURL
   private static final String SUMMARY_FORMATTER = "%d (+%s)%n%s%n%n %s";

   public Facebook(long id, long contactId, String messageText, String remoteId, 
           String remoteUsername, FacebookType remoteType) {
      
      super(id, contactId, messageText);
      this.remoteId = remoteId;
      this.remoteUsername = remoteUsername;
      this.remoteType = remoteType;
   }

   @Override
   public String getRemoteID() {
      return remoteId;
   }

   @Override
   public String getRemoteUsername() {
      return remoteUsername;
   }

   @Override
   public String getRemoteURL() {
      return getRemoteURL(FacebookClientType.DESKTOP);
   }
   
   public String getRemoteURL(FacebookClientType clientType) {
      return String.format(URL_FORMATTER, clientType.getUrlPrefix(), remoteUsername, 
              remoteType.getURLPart(), remoteId);
   }

   public FacebookType getRemoteType() {
      return remoteType;
   }
   
   @Override
   public String getSummaryText() {      

      return String.format(SUMMARY_FORMATTER, getContactId(), remoteUsername, 
              getMessageText(), getRemoteURL());
   }

}
