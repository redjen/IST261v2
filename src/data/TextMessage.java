package data;

/**
 * TextMessage is the text message type implementation of interaction
 *
 */
public class TextMessage extends AbstractInteraction {

   private static final String ICON_LOCATION = "ic_message_18pt";
//   private static final long serialVersionUID = 3L;

   public TextMessage(long id, long contactId, String messageText) {
      super(id, contactId, messageText, ICON_LOCATION);
   }
   
   public TextMessage(long id, long contactId, String messageText, String timestampString) {
      super(id, contactId, messageText, timestampString, ICON_LOCATION);
   }
}
