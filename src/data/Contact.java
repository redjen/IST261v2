package data;

import java.io.Serializable;

/**
 * The Contact class provides the attributes for a single contact and methods to
 * add, delete, and update those attributes.
 *
 */
public class Contact implements  DataListItem, Serializable {

   private static final long serialVersionUID = 3L;
   
   private long id;
   private String firstName;
   private String lastName;
   private String phoneNumber; // TODO format phone number as String
   private String email;
   private String twitterId;
   private String facebookId;

   public Contact(long id, String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.twitterId = twitterId;
      this.facebookId = facebookId;
   }

   public Contact(long id, String firstName, String lastName) {
      this(id, firstName, lastName, "", "", "", "");
   }

   public Contact(long id) {
      this(id, "", "", "", "", "", "");
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

   @Override
   public long getId() {
      return id;
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
      this.lastName = lastName;
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
}
