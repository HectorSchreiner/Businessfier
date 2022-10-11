import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {

        ArrayList<String> testString = new ArrayList<String>();
        testString.add("hej");
        testString.add("lassebasse");
        testString.add("hej");
        testString.add("lassebasse");
        testString.add("hej");
        testString.add("lassebasse");

        WordCombiner test = new WordCombiner(testString);
        test.Combine();

        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(450, 350);
        window.setVisible(true);

        ParseFile parser = new ParseFile();
        parser.readFile("config.txt");
<<<<<<< HEAD

        String list = parser.readList(parser.FileArray);
        //System.out.println(list);
=======
>>>>>>> 0dcc1c6b9c120c97cd83a042b8e23aefd220bd8d
    }
}
