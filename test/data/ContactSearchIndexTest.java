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
    private static ContactSearchIndex index;
    
    public ContactSearchIndexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        contact = new Contact(0, "test1", "test2", "555", "aa", "twitter", "facebook");
        index = new ContactSearchIndex();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getMatchesFor method, of class ContactSearchIndex.
     */
    @Test
    public void testGetMatchesFor() {
        System.out.println("getMatchesFor");
        String searchTerm = "";
        ContactSearchIndex instance = new ContactSearchIndex();
        ArrayList<Contact> expResult = null;
        ArrayList<Contact> result = instance.getMatchesFor(searchTerm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAllIndexesFor method, of class ContactSearchIndex.
     */
    @Test
    public void testCreateAllIndexesFor() {
        System.out.println("createAllIndexesFor");
        Contact contact = null;
        ContactSearchIndex instance = new ContactSearchIndex();
        instance.createAllIndexesFor(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("getIndexesFor");
        Contact contact = null;
        ContactSearchIndex instance = new ContactSearchIndex();
        HashSet<String> expResult = null;
        HashSet<String> result = instance.getIndexesFor(contact);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubstringsOf method, of class ContactSearchIndex.
     */
    @Test
    public void testGetSubstringsOf() {
        HashSet<String> result = index.getSubstringsOf("tesTtest");
        String[] expectedResults = {"tes", "est", "stt", "tte", "test", "estt", "stte", "ttes", 
            "testt", "estte", "sttes", "ttest", "testte", "esttes", "sttest", 
            "testtes", "esttest", "testtest"};
        
        assertEquals(expectedResults.length, result.size());
        for (String expected : expectedResults) {
            assertTrue(result.contains(expected));
        }
        
    }
    
}
