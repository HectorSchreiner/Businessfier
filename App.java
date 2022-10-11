import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {
        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(panel.width, panel.height);
        window.setVisible(true);

        window.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        ParseFile parser = new ParseFile();
        parser.readFile("config.txt");
        parser.printParsedFile();

    }
}
