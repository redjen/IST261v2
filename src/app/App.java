package app;

import data.PersonYouMayKnow;
import data.PersonYouMayKnowQueue;
import java.util.TreeSet;

/**
 * App is the application's main method
 *
 */
public class App {

    public static void main(String[] args) {

        Controller cldc = new Controller();
        createTestPeople();
    }

    private static void createTestPeople() {

        PersonYouMayKnowQueue queue = new PersonYouMayKnowQueue();

        System.out.println("Adding items:");
        queue.addItem(new PersonYouMayKnow("final", "this item should be last", "", "", "", "", 0, 0));
        queue.addItem(new PersonYouMayKnow("second", "this item should be second", "", "", "", "", 5, 0));
        queue.addItem(new PersonYouMayKnow("first", 
                "this item should be first and the match for the search", "findme", "", "", "", 5, 2));
        queue.addItem(new PersonYouMayKnow("third", "this item should be  third", "", "", "", "", 0, 10));
        System.out.println(queue.toString());
        
        System.out.println();
        System.out.println();
        System.out.println("Get the item with the string 'findme'");

        PersonYouMayKnow found = queue.getItem("findme");
        System.out.println("Found: " + found.getFullName());

               System.out.println();
        System.out.println();
        System.out.println("Remove the found item");
        System.out.println();
        
        queue.removeItem(found);
        System.out.println(queue.toString());
    }
}
