package app;

import data.PersonYouMayKnow;
import data.PersonYouMayKnowQueue;

/**
 * App is the application's main method
 *
 */
public class App {

   public static void main(String[] args) {

      Controller cldc = new Controller();
      PersonYouMayKnowQueue queue = new PersonYouMayKnowQueue();
      testLinkedList();
   }

   /**
    * Demonstrates the use of PersonYouMayKnowQueue for the assignment
    * "M08-A01 Implementing a LinkedList"
    */
   private static void testLinkedList() {

      PersonYouMayKnowQueue queue = new PersonYouMayKnowQueue();

      queue.addItem(new PersonYouMayKnow("new item", "this item should now be third", "", "", "", "", 4, 3));
      System.out.println("=====\n\nLinkedList with added item:");
      System.out.println(queue.toString());

      System.out.println();
      System.out.println();
      
      System.out.println("=====\n\nGet the item with the string 'should now'");
      PersonYouMayKnow found = queue.getItem("should now");
      System.out.println("Found: " + found.getFullName());

      System.out.println("=====\n\nRemove the found item");
      System.out.println("LinkedList with removed item:");
      queue.removeItem(found);
      System.out.println(queue.toString());
   }
}
