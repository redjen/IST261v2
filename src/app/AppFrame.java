package app;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The AppFrame class represents
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

         setBounds(0, 0, 800, 600);
         setDefaultCloseOperation(EXIT_ON_CLOSE);

      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
         Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
