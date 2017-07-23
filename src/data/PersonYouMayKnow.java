package data;

/**
 * PersonYouMayKnow represents a contact suggestion in the app. Each suggestion
 * has the same fields as a contact plus a count of how many first- and second-
 * degree contacts are shared.
 *
 * The native ordering is number of first-degree shared contacts > number of
 * second-degree shared contacts > name.
 */
public class PersonYouMayKnow extends Person  {

   private static final long serialVersionUID = 1L;
   private final int sharedContactsFirstDegree;
   private final int sharedContactsSecondDegree;

   public PersonYouMayKnow(String firstName, String lastName, String phoneNumber,
           String email, String twitterId, String facebookId,
           int sharedContactsFirstDegree, int sharedContactsSecondDegree) {
      super(firstName, lastName, phoneNumber, email, twitterId, facebookId);
      this.sharedContactsFirstDegree = sharedContactsFirstDegree;
      this.sharedContactsSecondDegree = sharedContactsSecondDegree;
   }

   /**
    * Searches all attributes for the specified string
    *
    * @param term the string to search for
    * @return true if the string is found, otherwise false
    */
   public boolean containsTerm(String term) {
      return (getFirstName().contains(term) || getLastName().contains(term)
              || getPhoneNumber().contains(term) || getEmail().contains(term)
              || getTwitterId().contains(term) || getFacebookId().contains(term));
   }

   @Override
   public boolean equals(Object o) {
      PersonYouMayKnow other = (PersonYouMayKnow) o;

      return (super.equals(other)
              && sharedContactsFirstDegree == other.sharedContactsFirstDegree
              && sharedContactsSecondDegree == other.sharedContactsSecondDegree);
   }

   public int compareTo(PersonYouMayKnow o) {
      int diff = Integer.compare(sharedContactsFirstDegree, o.sharedContactsFirstDegree);
      if (diff == 0) {
         diff = Integer.compare(sharedContactsSecondDegree, o.sharedContactsSecondDegree);
      }
      return diff;
   }

}
