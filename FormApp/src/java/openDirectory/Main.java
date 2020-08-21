package openDirectory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
// открывает указанную папку 
          Desktop.getDesktop().open(new File("C:/PerfLogs"));
       
    }

}
