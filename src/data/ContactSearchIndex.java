/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ContactSearchIndex is an index for searching contacts that contain a
 * specified string in any field. Methods are provided to index a contact,
 * remove all indices for a contact, update indices for a contact, and search
 * for a specified term.
 *
 * Make sure to always delete the indexes for a contact before deleting the
 * contact itself to avoid memory leaks.
 */
public class ContactSearchIndex implements Serializable {

    private final HashMap<String, HashSet<String>> terms;
    private final HashMap<Contact, HashSet<String>> contacts;

    private static final long serialVersionUID = 1L;

    public ContactSearchIndex() {

        terms = new HashMap<>();
        contacts = new HashMap<>();

    }

    /**
     * Returns all contacts matching the term
     *
     * @param searchTerm the search term
     * @return the list of all matching contacts (empty if none found)
     */
    public ArrayList<Contact> getMatchesFor(String searchTerm) {
        ArrayList<Contact> matches = new ArrayList<>();

        return matches;
    }

    /**
     * Indexes a contact
     *
     * @param contact the contact to index
     */
    public void createAllIndexesFor(Contact contact) {
        
    }

    /**
     * Deletes all indexes for a contact
     *
     * @param contact the contact to be deleted
     */
    public void deleteAllIndexesFor(Contact contact) {

    }

    /**
     * Updates the indexes for a contact by removing and adding lists of search
     * terms
     *
     * @param contact the contact to be change
     * @param newTerms new search terms to be added
     * @param oldTerms old search terms to be removed
     */
    public void updateIndexesFor(Contact contact, List<String> newTerms, List<String> oldTerms) {

    }

    /**
     * Generate the complete list of indexes for a contact covering all fields
     *
     * @param contact the contact to index
     * @return the list of indexes
     */
    public HashSet<String> getIndexesFor(Contact contact) {
        HashSet<String> indexes = new HashSet<>();
        

        
        return indexes;
    }
    
    public HashSet<String> getSubstringsOf(String term) {
        HashSet<String> substrings = new HashSet<>();
        
        for (int i = 0; i <= term.length() - 3; i++) {
            for (int j = i+3; j <= term.length(); j++) {
                substrings.add(term.substring(i, j).toLowerCase());
            }
        }
        
        return substrings;
    }

}
