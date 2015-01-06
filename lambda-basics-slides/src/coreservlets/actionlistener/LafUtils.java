package coreservlets.actionlistener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LafUtils {
    public static void SetNimbusLaf() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }
}
