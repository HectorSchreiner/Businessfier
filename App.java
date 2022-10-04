import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        GraphicsPanel panel = new GraphicsPanel();

        JFrame window = new JFrame("GraphicsPanel");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(panel.width, panel.height);
        window.setVisible(true);

        window.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    public static void gameLoop() {

    }

}
