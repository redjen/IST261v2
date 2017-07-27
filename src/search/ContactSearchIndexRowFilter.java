package search;

import data.ContactTableModel;
import search.ContactSearchIndex;
import javax.swing.RowFilter;

/**
 *
 * @author jsm
 */
public class ContactSearchIndexRowFilter extends RowFilter<ContactTableModel, Integer> {

    private final ContactSearchIndex csi;
    private String searchText;

    /**
     * Constructs a new ContactTableModel RowFilter using the ContactSearchIndex
     * as its data source
     *
     * @param csi the ContactSearchIndex data source
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
