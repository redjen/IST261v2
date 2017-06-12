package interactions;

/**
 * The Tweet class represents
 * 
 */
public class Tweet extends Interaction implements Sociable<Integer> {
   
   private static final String SUMMARY_FORMATTER = "%s%n%n%s";
   private static final String URL_FORMATTER = "https://twitter.com/%s/%s";
   
   private final int remoteID;
   private final String remoteUsername;
   private final String remoteURL;

   public Tweet(int remoteID, String remoteUsername, long id, long contactId, String messageText) {
      super(id, contactId, messageText);
      this.remoteID = remoteID;
      this.remoteUsername = "@" + remoteUsername;
      this.remoteURL = String.format(URL_FORMATTER, remoteUsername, Integer.toString(remoteID));
   }  
   
   @Override
   public String getSummaryText() {
      return String.format(SUMMARY_FORMATTER, remoteUsername, getMessageText());
   }

   @Override
   public Integer getRemoteID() {
      return remoteID;
   }

   @Override
   public String getRemoteUsername() {
      return remoteUsername;
   }

   @Override
   public String getRemoteURL() {
      return remoteURL;
   }

}
