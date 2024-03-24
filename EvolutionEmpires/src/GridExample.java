import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GridExample extends JPanel {

    public static final int GRID_SIZE = 128;
    public static final int CELL_SIZE = 10;

    private Color[][] gridColors;

    public GridExample() {
        // Initialize the grid with random colors
        initializeGrid();
    }

    private void initializeGrid() {
        gridColors = new Color[GRID_SIZE][GRID_SIZE];
        Random random = new Random();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // Generate a random color
                gridColors[i][j] = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the grid of colored cells
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                g.setColor(gridColors[i][j]);
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}