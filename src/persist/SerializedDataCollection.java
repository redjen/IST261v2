package persist;

import data.ContactList;
import data.InteractionList;
import java.io.Serializable;
import java.util.Observer;

/**
 * SerializedDataCollection is a container for classes to be serialized and
 * persisted.
 *
 */
public class SerializedDataCollection implements Serializable {

   private static final long serialVersionUID = 4L;

   private final ContactList contactList;
   private final InteractionList interactionList;

   public SerializedDataCollection() {
      this.contactList = new ContactList();
      this.interactionList = new InteractionList();
   }

   public ContactList getContactList() {
      return contactList;
   }
   
   public InteractionList getInteractionList() {
      return interactionList;
   }
   
   public void setObserver(Observer observer) {
      contactList.addObserver(observer);
      interactionList.addObserver(observer);
   }

}
