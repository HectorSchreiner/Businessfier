import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {

        WordCombiner combiner = new WordCombiner("config.txt");
        combiner.Combine();

        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(450, 350);
        window.setVisible(true);
    }
}
