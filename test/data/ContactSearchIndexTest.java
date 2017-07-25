
package data;

import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 */
public class ContactSearchIndexTest {

   private Contact contact;
   private ContactSearchIndex csi;

   public ContactSearchIndexTest() {
   }

   @Before
   public void setUp() {
      contact = new Contact(0, "test1", "test2", "555", "aa", "twitter", "facebook");
      csi = new ContactSearchIndex();
   }

   /**
    * Test of createAllIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testCreateAllIndexesFor() {
      HashSet<String> expectedResults = csi.getIndexesFor(contact);
      csi.createAllIndexesFor(contact);

      for (String expected : expectedResults) {
         assertTrue(String.format("Expected to find %s but result was empty%n", expected),
                 csi.getMatchesFor(expected).size() > 0);
         assertTrue(String.format("Expected to find %s but was not found%n", expected),
                 csi.getMatchesFor(expected).contains(contact));
      }
   }

   /**
    * Test of createAllIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testCreateAllIndexesForTwo() {
      Contact contact2 = new Contact(1, "testfirst", "");
      HashSet<String> expectedResults = csi.getIndexesFor(contact2);
      csi.createAllIndexesFor(contact);
      csi.createAllIndexesFor(contact2);

      for (String expected : expectedResults) {
         assertTrue(String.format("Expected to find %s but was not found%n", expected),
                 csi.getMatchesFor(expected).contains(contact2));
      }

      assertEquals(2, csi.getMatchesFor("tes").size());
      assertEquals(2, csi.getMatchesFor("est").size());
      assertEquals(2, csi.getMatchesFor("test").size());
   }

   /**
    * Test of deleteAllIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testDeleteAllIndexesForSingle() {
      csi.createAllIndexesFor(contact);
      csi.deleteAllIndexesFor(contact);
      assertTrue(csi.isEmpty());

   }

   /**
    * Test of deleteAllIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testDeleteAllIndexesForDouble() {
      Contact contact2 = new Contact(1, "testfirst", "");
      HashSet<String> expectedRetained = csi.getIndexesFor(contact);

      HashSet<String> expectedRemoved = csi.getIndexesFor(contact2);
      expectedRemoved.removeAll(expectedRetained);

      csi.createAllIndexesFor(contact);
      csi.createAllIndexesFor(contact2);
      csi.deleteAllIndexesFor(contact2);

      for (String expected : expectedRetained) {
         assertEquals(1, csi.getMatchesFor(expected).size());
      }

      for (String expected : expectedRemoved) {
         assertEquals(false, csi.containsKey(expected));
      }
   }

   /**
    * Test of updateIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testUpdateIndexesFor() {
      ArrayList<String> oldTerms = new ArrayList<>();
      ArrayList<String> newTerms = new ArrayList<>();

      oldTerms.add("twitter");
      newTerms.add("replaced");
      csi.createAllIndexesFor(contact);
      csi.updateIndexesFor(contact, oldTerms, newTerms);

      for (String term : csi.getSubstringsOf("twitter")) {
         assertFalse(String.format("Expected <false> for %s but got <true>", term),
                 csi.getMatchesFor(term).contains(contact));
      }

      for (String term : csi.getSubstringsOf("replaced")) {
         assertTrue(String.format("Expected <true> for %s but got <false>", term),
                 csi.getMatchesFor(term).contains(contact));
      }
   }

   /**
    * Test of getIndexesFor method, of class ContactSearchIndex.
    */
   @Test
   public void testGetIndexesFor() {
      HashSet<String> result = csi.getIndexesFor(contact);
      for (String string : result) {
         System.out.println(string);
      }
   }

   /**
    * Test of getSubstringsOf method, of class ContactSearchIndex.
    */
   @Test
   public void testGetSubstringsOf() {
      HashSet<String> result = csi.getSubstringsOf("tesTtest");
      String[] expectedResults = {"tes", "est", "stt", "tte", "test", "estt", "stte", "ttes",
         "testt", "estte", "sttes", "ttest", "testte", "esttes", "sttest",
         "testtes", "esttest", "testtest"};

      assertEquals(expectedResults.length, result.size());
      for (String expected : expectedResults) {
         assertTrue(result.contains(expected));
      }

   }

}
