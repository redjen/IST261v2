package data.interaction;

import java.io.Serializable;

/**
 * TextMessage is the text message type implementation of interaction
 *
 */
public class TextMessage extends AbstractInteraction implements Serializable {

   private static final String ICON_LOCATION = "resources/interaction/ic_message_18pt";
   private static final long serialVersionUID = 500L;

   public TextMessage(long id, long contactId, String messageText) {
      super(id, contactId, messageText, ICON_LOCATION);
   }
   
}
