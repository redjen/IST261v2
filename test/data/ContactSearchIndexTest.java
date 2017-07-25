/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsm
 */
public class ContactSearchIndexTest {

    private static Contact contact;
    private static ContactSearchIndex csi;

    public ContactSearchIndexTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        contact = new Contact(0, "test1", "test2", "555", "aa", "twitter", "facebook");
        csi = new ContactSearchIndex();
    }

    @AfterClass
    public static void tearDownClass() {
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
    public void testDeleteAllIndexesFor() {
        System.out.println("deleteAllIndexesFor");
        Contact contact = null;
        ContactSearchIndex instance = new ContactSearchIndex();
        instance.deleteAllIndexesFor(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateIndexesFor method, of class ContactSearchIndex.
     */
    @Test
    public void testUpdateIndexesFor() {
        System.out.println("updateIndexesFor");
        Contact contact = null;
        List<String> newTerms = null;
        List<String> oldTerms = null;
        ContactSearchIndex instance = new ContactSearchIndex();
        instance.updateIndexesFor(contact, newTerms, oldTerms);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
