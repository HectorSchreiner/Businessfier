import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws IOException {
        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(450, 350);
        window.setVisible(true);
    }

}
