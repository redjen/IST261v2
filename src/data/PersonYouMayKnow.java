package data;

/**
 * 
 */
public class PersonYouMayKnow extends Person {

    private final int sharedContactsFirstDegree;
    private final int sharedContactsSecondDegree;

    public PersonYouMayKnow(String firstName, String lastName, String phoneNumber,
            String email, String twitterId, String facebookId,
            int sharedContactsFirstDegree, int sharedContactsSecondDegree) {
        super(firstName, lastName, phoneNumber, email, twitterId, facebookId);
        this.sharedContactsFirstDegree = sharedContactsFirstDegree;
        this.sharedContactsSecondDegree = sharedContactsSecondDegree;
    }

    public boolean equals(Object o) {
        PersonYouMayKnow other = (PersonYouMayKnow) o;

        return (super.equals(other)
                && sharedContactsFirstDegree == other.sharedContactsFirstDegree
                && sharedContactsSecondDegree == other.sharedContactsSecondDegree);
    }

    public int compareTo(PersonYouMayKnow o) {
        int diff = Integer.compare(sharedContactsFirstDegree, o.sharedContactsFirstDegree);
        if (diff == 0) {
            diff = Integer.compare(sharedContactsFirstDegree, o.sharedContactsFirstDegree);
        }
        if (diff == 0) {
            diff = getFullName().compareTo(o.getFullName());
        }
        return diff;
    }

}
