import java.util.Map;

public class GameManager {
    private GameConfiguration gameConfiguration;

    public GameManager(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }
    public TileMap createMap() {
        // Create the map
        FloatMap floatMap = new FloatMap(100, 100, "map100x100");
        MapGenerator mapGenerator = new MapGenerator();
//        TileMap tileMap = mapGenerator.generateRandomMap(floatMap);
        MapType mapType = MapType.RIVERS2; // The type of map to be created
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

        System.out.println("Done generating map");

        if (tileMap == null) {
            throw new IllegalArgumentException("Failed to generate map");
        }
        return tileMap;
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public void setGameConfiguration(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

}
