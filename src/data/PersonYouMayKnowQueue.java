package data;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * PersonYouMayKnowQueue manages a list of PersonYouMayKnow objects.
 *
 * @see PersonYouMayKnow
 */
public class PersonYouMayKnowQueue {

    private final LinkedList<PersonYouMayKnow> people;

    public PersonYouMayKnowQueue() {
        this.people = new LinkedList<>();
        createTestData();

        try (PrintWriter out = new PrintWriter(System.out)) {
            printTestData(out);
        }
    }

    /**
     * Adds the new item, maintaining sort order
     *
     * @param person the item to add
     */
    public void addItem(PersonYouMayKnow person) {
        ListIterator<PersonYouMayKnow> iter = people.listIterator();
        boolean added = false;

        if (people.isEmpty()) {
            people.add(person);
        } else {
            while (iter.hasNext()) {
                PersonYouMayKnow nextPerson = iter.next();
                if (person.compareTo(nextPerson) >= 0) {
                    people.add(iter.previousIndex(), person);
                    added = true;
                    break;
                }
            }
            if (!added) {
                people.add(person);
            }
        }

    }

    /**
     * Returns the first item that contains the specified string in any field
     *
     * @param searchTerm the string to search for
     * @return the first matching item or null if not found
     */
    public PersonYouMayKnow getItem(String searchTerm) {

        for (PersonYouMayKnow person : people) {
            if (person.containsTerm(searchTerm)) {
                return person;
            }
        }

        return null;
    }

    /**
     * Removes all instances of the item in the queue
     *
     * @param person tje item to remove
     */
    public void removeItem(PersonYouMayKnow person) {
        ListIterator<PersonYouMayKnow> iter = people.listIterator();

        if (!people.isEmpty()) {

            while (iter.hasNext()) {
                Person nextPerson = iter.next();
                if (person.equals(nextPerson)) {
                    iter.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String printFormat = "%s, %s, %s, %s, %s%n";

        if (people.isEmpty()) {
            sb.append("No people found.");
        } else {
            for (PersonYouMayKnow p : people) {
                sb.append(String.format(printFormat, p.getFullName(), p.getPhoneNumber(),
                        p.getEmail(), p.getTwitterId(), p.getFacebookId()));
            }
        }

        return sb.toString();
    }

    /**
     * Creates test data for assignment "M08-A01 Implementing a LinkedList"
     */
    private void createTestData() {

        addItem(new PersonYouMayKnow("final", "test item", "", "", "", "", 0, 0));
        addItem(new PersonYouMayKnow("second", "test item", "", "", "", "", 5, 0));
        addItem(new PersonYouMayKnow("first",
                "test item", "", "", "", "", 5, 2));
        addItem(new PersonYouMayKnow("third", "test item", "", "", "", "", 0, 10));
    }

    /**
     * Prints test data for assignment "M08-A01 Implementing a LinkedList"
     */
    private void printTestData(PrintWriter out) {
        out.println("Test data:");
        out.println(this.toString());
        out.println();
        out.flush();
    }

}
