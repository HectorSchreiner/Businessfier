import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {

        String[] a = new String[] { "test", "helloo", "what?", "yomama", "uno", "1", "hectorama", "fefoas", "dres",
                "dos" };
        WordChecker test = new WordChecker(a);
        test.CheckLength();

        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(panel.width, panel.height);
        window.setVisible(true);

        window.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        ParseFile parser = new ParseFile();
        parser.readFile("config.txt");
        System.out.println(parser.FileArray);
    }
}
