package dao;

import data.contact.ContactList;
import data.interaction.InteractionList;
import java.io.Serializable;

/**
 * SerializedDataCollection is a container for classes to be serialized and
 * persisted.
 *
 */
public class SerializedDataCollection implements Serializable {

   private static final long serialVersionUID = 301L;

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

}
