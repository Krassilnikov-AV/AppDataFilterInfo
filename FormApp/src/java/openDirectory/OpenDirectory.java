package openDirectory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class OpenDirectory extends JFileChooser {

    /**
     *
     */
    public static void open() {

        try {
            Desktop.getDesktop().open(new File("C:/ProgramData"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
