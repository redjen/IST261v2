package app;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The CardPanelBase is an abstract class to be used as the superclass for
 * the views added to MainPanel.
 *
 * It provides two subcomponents: a panel for action buttons and a scrollable
 * panel for content. Action buttons can be added with the addButton method.
 * the panel's content can be set in the constructor or using setContent after
 * construction. Methods that manipulate the panel's layout call revalidate to
 * update the UI.
 *
 */
public abstract class CardPanelBase extends JPanel {

   private final JPanel buttonPanel;
   private JScrollPane scrollPane;

   /**
    * Constructs a new CardPanelBase view with content
    *
    * @param content the component to display in the scrollable content area
    */
   public CardPanelBase(JComponent content) {
      buttonPanel = new JPanel(new FlowLayout());
      setContent(content);
      setLayout();
      setVisible(true);
   }

   public CardPanelBase() {
      buttonPanel = new JPanel(new FlowLayout());
      setLayout();
      setVisible(true);
   }

   /**
    * Adds a button to the end of the button panel
    * @param button the button to add
    */
   public final void addButton(JButton button) {
      buttonPanel.add(button);
   }

   /**
    * Sets the component to be displayed in the scrollable content pane
    * @param component the new component
    */
   public void setContent(JComponent component) {
      if (scrollPane != null) {
         remove(scrollPane);
      }
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridy = 1;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      scrollPane = new JScrollPane(component);
      add(scrollPane, gbc);
      revalidate();
   }

   /**
    * Sets the initial layout and creates the button panel
    */
   private void setLayout() {
      this.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();

      // add button panel
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.weightx = 1.0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(buttonPanel, gbc);
   }

}
