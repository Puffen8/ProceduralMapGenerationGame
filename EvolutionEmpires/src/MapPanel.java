import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private TileMap tileMap;
    public MapPanel(TileMap tileMap) {
        this.tileMap = tileMap;
        GridLayout gridLayout = new GridLayout(tileMap.getWidth(), tileMap.getHeight());
        setLayout(gridLayout);
        setBounds(300, 0, 800, 800);
        setBackground(Color.BLACK);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int TILE_SIZE = 2; // Adjust the size of each square as needed
        int width = tileMap.getWidth();
        int height = tileMap.getHeight();
        System.out.println("Generating Map");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                TileType tile = tileMap.getTileAt(x, y);
                g.setColor(tile.getColor());
                g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
