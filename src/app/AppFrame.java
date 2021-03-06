package app;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The main frame of the application
 *
 *
 *
 */
public class AppFrame extends JFrame {

    public AppFrame(String title) throws HeadlessException {
        super(title);

        try {

            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//            if ("Nimbus".equals(info.getName())) {
//               UIManager.setLookAndFeel(info.getClassName());
//               break;
//            } else {
//               UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//            }
//         }

            // Set Y so that the app isn't shown under a top-positioned Windows toolbar
            setBounds(0, 100, 800, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
