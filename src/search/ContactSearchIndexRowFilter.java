package search;

import data.ContactTableModel;
import javax.swing.RowFilter;

/**
 * ContactSearchIndexRowFilter is a Swing table row filter that uses a 
 * ContactSearchIndex as its source. It filters out contacts that do not contain
 * the search term in any field.
 */
public class ContactSearchIndexRowFilter extends RowFilter<ContactTableModel, Integer> {

    private final ContactSearchIndex csi;
    private final String searchText;

    /**
     * Constructs a new ContactTableModel RowFilter using the ContactSearchIndex
     * as its data source
     *
     * @param csi the ContactSearchIndex data source
    * @param searchText the search term
     */
    public ContactSearchIndexRowFilter(ContactSearchIndex csi, String searchText) {
        super();
        this.csi = csi;
        this.searchText = searchText;
    }

    @Override
    public boolean include(Entry<? extends ContactTableModel, ? extends Integer> entry) {
        return csi.getMatchesFor(searchText).contains((long) entry.getValue(0));
    }

}
