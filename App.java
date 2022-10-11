import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {


        // Emils no tucthy zone
        ArrayList<String> testString = new ArrayList<String>();
        testString.add("hej");
        testString.add("lassebasse");
        testString.add("hej");
        testString.add("lassebasse");
        testString.add("hej");
        testString.add("lassebasse");

        WordCombiner test = new WordCombiner(testString);
        test.Combine();

        //-------------------------------



        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(panel.width, panel.height);
        window.setVisible(true);

        ParseFile parser = new ParseFile();
        parser.readFile("config.txt");

    }
}
