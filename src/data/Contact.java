package data;

/**
 * The Contact class provides the attributes for a single contact and methods to
 * add, delete, and update those attributes.
 *
 */
public class Contact extends Person implements DataListItem {

    private final long id;
    private static final long serialVersionUID = 1L;

    public Contact(long id, String firstName, String lastName, String phoneNumber,
            String email, String twitterId, String facebookId) {
        super(firstName, lastName, phoneNumber, email, twitterId, facebookId);
        this.id = id;
    }

    public Contact(long id, String firstName, String lastName) {
        this(id, firstName, lastName, "", "", "", "");
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        Contact other = (Contact) o;
        return (super.equals(o) && id == other.getId());
    }
}
