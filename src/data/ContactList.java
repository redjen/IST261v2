package data;

/**
 * ContactList is a collection of Contacts and methods to interact add, delete,
 * access, and update them.
 *
 */
public class ContactList extends AbstractDataList<Contact> {
   private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ContactList populated with test contacts
     *
     */
    public ContactList() {
        super();
    }

    /**
     * Add a new contact at the end of the list and return its ID
     *
     * @param firstName
     * @param lastName
     * @return the contact's ID
     */
    public long add(String firstName, String lastName) {
        long id = add(firstName, lastName, "", "", "", "");
        setChanged();
        notifyObservers();
        return id;
    }

    /**
     * Add a new contact at the end of the list with all fields and returns its
     * IDl
     *
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param twitterId
     * @param facebookId
     * @return the contact's unique ID
     */
    public long add(String firstName, String lastName, String phoneNumber,
            String email, String twitterId, String facebookId) {
        Contact c = new Contact(getNextId(), firstName, lastName, phoneNumber, email, twitterId, facebookId);
        long id = add(c);
        setChanged();
        notifyObservers();
        return id;
    }

    /**
     * Create a new contact and add it to the end of the list
     * @param person the Person object to convert to a Contact
     * @return the contact's unique ID
     */
    public long add(Person person) {
        return add(person.getFirstName(), person.getLastName(), person.getPhoneNumber(),
                person.getEmail(), person.getTwitterId(), person.getFacebookId());
    }

    /**
     * Updates a contact's attributes
     *
     * @param contactId
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param twitterId
     * @param facebookId
     */
    public void update(long contactId, String firstName, String lastName, String phoneNumber,
            String email, String twitterId, String facebookId) {

        getById(contactId).update(firstName, lastName, phoneNumber, email, twitterId, facebookId);
        setChanged();
        notifyObservers();
    }

}
