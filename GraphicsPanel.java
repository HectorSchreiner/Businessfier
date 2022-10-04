import java.awt.*;
import javax.swing.*;

public class GraphicsPanel extends JPanel {
    int width = 600;
    int height = 600;
    int gridSize = 20;

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // tegn først baggrunden på panelet
        grid(g);
    }

    public void grid(Graphics g) {
        for (int y = 0; y < this.width; y += this.gridSize) {
            for (int x = 0; x < this.height; x += this.gridSize) {
                Color farve = new Color(x % 256, (x * 2) % 256, (y * 4) % 256);
                g.setColor(farve);
                g.fillRect(x, y, this.gridSize, this.gridSize);
            }
        }
    }
}
