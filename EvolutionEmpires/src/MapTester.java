import javax.swing.*;
import java.util.Map;

public class MapTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GridExample.GRID_SIZE * GridExample.CELL_SIZE + 15, GridExample.GRID_SIZE * GridExample.CELL_SIZE + 40); // Adjusted for border and title bar
        frame.setLocationRelativeTo(null);

        FloatMap floatMap = new FloatMap(20, 20, "map100x100");
        MapGenerator mapGenerator = new MapGenerator();
//        TileMap tileMap = mapGenerator.generateRandomMap(floatMap);
        MapType mapType = MapType.TEST; // The type of map to be created
        // Assign the probability value for each TileType depending on the map theme
        float currentValue = 0;
        for (Map.Entry<TileType, Integer> entry : mapType.getMapConfiguration().getTitleDistribution().entrySet()) {
            entry.getKey().setLowerBound(currentValue / 100);
            currentValue += entry.getValue();
            entry.getKey().setUpperBound(currentValue / 100);
        }

//        TileType.GRASS.setLowerBound(0f);
//        TileType.GRASS.setUpperBound(0.5f);
//        TileType.WATER.setLowerBound(0.5f);
//        TileType.WATER.setUpperBound(1f);
        MapConfiguration mapConfiguration = mapType.getMapConfiguration();
        GenerationAlgos generationAlgo = mapConfiguration.getMapGeneratorAlgo();
        int iterations = mapConfiguration.getIterations();
        TileMap tileMap = null;
        switch (generationAlgo) {
            case RANDOM_NOISE -> {

            }
            case CELLULAR_AUTOMATA_NORMAL -> {
                tileMap = mapGenerator.generateCellularNormalMap(floatMap, iterations);
            }
            case CELLULAR_AUTOMATA_SMOOTH -> {
                tileMap = mapGenerator.generateCellularSmoothMap(floatMap, iterations);
            }
            case PERLIN_NOISE -> {

            }
            default -> {

            }
        }

        GamePanel gridExample = new GamePanel(tileMap, floatMap);
        frame.add(gridExample);

        frame.setVisible(true);
    }
}
