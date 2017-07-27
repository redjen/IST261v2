package app;

import data.AbstractInteraction;
import data.Contact;
import data.ContactList;
import search.ContactSearchIndex;
import search.ContactSearchIndexRowFilter;
import data.ContactTableModel;
import data.InteractionList;
import data.InteractionTableModel;
import persist.PersistDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultRowSorter;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Controller is the main controller for the application
 */
public class Controller {

    private final PersistDataController persistDataController;

    private final ContactList contactList;
    private final ContactTableModel contactTableModel;
    private boolean isCreatingNewContact;

    private final InteractionList interactionList;
    private final InteractionTableModel interactionTableModel;

    private final ContactSearchIndex csi;

    private final AppFrame appFrame;
    private final MainPanel mainPanel;
    private ContactDetailView contactView;
    private final JTable contactListTable;
    private final TableRowSorter sorter;

    public Controller() {

        persistDataController = new PersistDataController();
        persistDataController.setObserver();

        // contact model and views
        isCreatingNewContact = false;
        contactList = persistDataController.getContacts();
        contactTableModel = new ContactTableModel(contactList);
        contactTableModel.addTableModelListener(persistDataController);

// interaction model and views
        interactionList = persistDataController.getInteractions();
        interactionTableModel = new InteractionTableModel(interactionList, this);
        interactionTableModel.addTableModelListener(persistDataController);

        // search index
        csi = new ContactSearchIndex(contactList.getList());
        try (PrintWriter out = new PrintWriter(System.out)) {
            csi.printIndex(out);
        }

        appFrame = new AppFrame("Contacts");
        mainPanel = new MainPanel(contactTableModel, interactionTableModel);
        appFrame.setContentPane(mainPanel);

        contactListTable = mainPanel.getContactTablePanel().getContactTable();
        sorter = new TableRowSorter(contactTableModel);
        contactListTable.setRowSorter(sorter);
//      sorter.setRowFilter(new ContactSearchIndexRowFilter(csi, "st11"));

        appFrame.setVisible(true);

        addListeners();

    }

    public ContactTableModel getContactTableModel() {
        return contactTableModel;
    }

    /**
     * Gets the contact at the specified table model row
     *
     * @param row the table model row
     * @return corresponding contact
     */
    public Contact getContact(int row) {
        Contact contact;
        long contactId;

        contactId = (long) contactTableModel.getValueAt(row, 0);
        contact = contactList.getById((long) contactId);

        return contact;
    }

    /**
     * Gets the contact by its unique ID
     *
     * @param id the ID
     * @return the contact or null if it does not exist
     */
    public Contact getContactById(long id) {
        return contactList.getById(id);
    }

    public AbstractInteraction getInteractionById(long id) {
        return interactionList.getById(id);
    }

    /**
     * Constructs and shows the detail view for the specified contact
     *
     * @param row the contact's row number in the table model
     */
    private void getDetailView(int row) {
        contactView = new ContactDetailView(this, row);
        mainPanel.getContactDetailPanel().setContent(contactView);

        // interactions list
        ArrayList<InteractionContactDetailView> views = new ArrayList<>();
        for (AbstractInteraction interaction
                : interactionList.getInteractionsByContactId(contactView.getCurrentContactId())) {
            views.add(new InteractionContactDetailView(interaction));
        }
        contactView.addInteractions(views);
        mainPanel.setContactDetailVisible(true);
    }

    /**
     * Saves changes for the current contact or creates a new contact if the new
     * contact form is active.
     */
    private void handleSaveButton() {
        if (isCreatingNewContact) {

            contactList.add(contactView.getFirstNameField().getText(),
                    contactView.getLastNameField().getText(),
                    contactView.getPhoneNumberField().getText(),
                    contactView.getEmailField().getText(),
                    contactView.getTwitterField().getText(),
                    contactView.getFacebookField().getText());

            contactTableModel.fireTableDataChanged();
            isCreatingNewContact = false;

        } else {

            long contactId = contactView.getCurrentContactId();
            contactList.update(contactId, contactView.getFirstNameField().getText(),
                    contactView.getLastNameField().getText(),
                    contactView.getPhoneNumberField().getText(),
                    contactView.getEmailField().getText(),
                    contactView.getTwitterField().getText(),
                    contactView.getFacebookField().getText());
            contactTableModel.fireTableDataChanged();
        }

        unloadContactView();
    }

    /**
     * Filters the table so that only rows matching the search term are shown.
     * Search for an empty string to reset.
     */
    private void handleSearchButton() {
        if (mainPanel.getContactTablePanel().getSearchField().getText() != null
                && !mainPanel.getContactTablePanel().getSearchField().getText().isEmpty()) {
            sorter.setRowFilter(new ContactSearchIndexRowFilter(csi,
                    mainPanel.getContactTablePanel().getSearchField().getText()));
        } else {
            sorter.setRowFilter(null);
        }

    }

    /**
     * Clears the current search
     */
    private void handleClearSearchButton() {
        mainPanel.getContactTablePanel().getSearchField().setText(null);
        handleSearchButton();
    }

    /**
     * Returns the model row index for selected table rows
     *
     * @return the model row index or -1 if there is no corresponding index
     */
    private int getSelectedContactRow() {
        int selectedRow = contactListTable.getSelectedRow();
        if (selectedRow >= 0) {
            int selectedRowModel = contactListTable.convertRowIndexToModel(selectedRow);
            return selectedRowModel;

        } else {
            return -1;
        }
    }

    /**
     * Handler for showing the detail view for the selected contact.
     */
    private void handleDetailButton() {
        if (contactListTable.getSelectedRowCount() == 1) {
            int selectedRow = getSelectedContactRow();

            if (selectedRow >= 0) {
                getDetailView(selectedRow);
            }
        }

    }

    /**
     * Handler for deleting one or more contacts from the table view
     */
    private void handleDeleteTableButton() {
        ArrayList<Long> contactIds = new ArrayList<>();
        for (int selectedRow : contactListTable.getSelectedRows()) {
            int selectedRowModel = contactListTable.convertRowIndexToModel(selectedRow);
            long contactId = (long) contactListTable.getValueAt(selectedRowModel, 0);
            contactIds.add(contactId);
        }
        contactList.removeAll(contactIds);
        contactTableModel.fireTableDataChanged();
    }

    /**
     * Handler for deleting the current contact from the detail view
     */
    private void handleDeleteDetailButton() {
        if (!isCreatingNewContact) {
            contactList.remove(contactView.getCurrentContactId());
            contactTableModel.fireTableDataChanged();
        }
        unloadContactView();
    }

    /**
     * Handler for showing the add contact view
     */
    private void handleAddButton() {
        contactView = new ContactDetailView(Controller.this);
        mainPanel.getContactDetailPanel().setContent(contactView);
        mainPanel.setContactDetailVisible(true);
        isCreatingNewContact = true;
    }

    /**
     * Destroys the current contact view and shows the table view
     */
    private void unloadContactView() {
        contactView = null;
        mainPanel.getContactDetailPanel().setContent(null);
        mainPanel.setContactTableVisible(true);
    }

    /**
     * Handler for showing the table view from the detail view
     */
    private void handleTableButton() {
        mainPanel.setContactTableVisible(true);
    }

    /**
     * Handler for closing the last window.
     *
     * This method saves application data
     */
    private void handleExit() {
        persistDataController.writeData();
        appFrame.dispose();
    }

    /**
     * Sets action listeners on controls
     */
    private void addListeners() {

        appFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleExit();
            }
        });

        mainPanel.getContactDetailPanel().getTableButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTableButton();
            }
        });

        mainPanel.getContactTablePanel().getDetailButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDetailButton();
            }
        });

        mainPanel.getContactTablePanel().getDeleteContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteTableButton();
            }
        });

        mainPanel.getContactDetailPanel().getDeleteContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteDetailButton();
            }
        });

        mainPanel.getContactTablePanel().getAddContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddButton();
            }
        });

        mainPanel.getContactTablePanel().getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExit();
            }
        });

        mainPanel.getContactTablePanel().getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchButton();
            }
        });

        mainPanel.getContactTablePanel().getClearSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearSearchButton();
            }
        });

        mainPanel.getContactDetailPanel().getAddContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddButton();
            }
        });

        mainPanel.getContactDetailPanel().getSaveContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveButton();
            }
        });

        mainPanel.getContactDetailPanel().getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExit();
            }
        });

    }

}
