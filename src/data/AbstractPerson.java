package data;

import java.io.Serializable;

/**
 * AbstractPerson provides the attributes for a single person and methods to
 * add, delete, and update those attributes.
 *
 */
public class AbstractPerson implements Serializable, Comparable<AbstractPerson> {

   private String firstName;
   private String lastName;
   private String phoneNumber; // TODO format phone number as String
   private String email;
   private String twitterId;
   private String facebookId;

   public AbstractPerson(String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.twitterId = twitterId;
      this.facebookId = facebookId;
   }

   public AbstractPerson(String firstName, String lastName) {
      this(firstName, lastName, "", "", "", "");
   }

   /**
    * Updates all contact fields with new values
    *
    * @param firstName
    * @param lastName
    * @param phoneNumber
    * @param email
    * @param twitterId
    * @param facebookId
    */
   public void update(String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.twitterId = twitterId;
      this.facebookId = facebookId;
   }

   /**
    * Returns the contact's full name
    *
    * @return the full name
    */
   public String getFullName() {
      return firstName + " " + lastName;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTwitterId() {
      return twitterId;
   }

   public void setTwitterId(String twitterId) {
      this.twitterId = twitterId;
   }

   public String getFacebookId() {
      return facebookId;
   }

   public void setFacebookId(String facebookId) {
      this.facebookId = facebookId;
   }

    @Override
    public int compareTo(AbstractPerson o) {
        return getFirstName().compareTo(o.getFullName());
    }

}
