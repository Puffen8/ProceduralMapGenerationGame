import java.util.Map;

public class GameManager {
    private GameConfiguration gameConfiguration;

    public GameManager(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }
    public TileMap createMap() {
        MapGenerator mapGenerator = new MapGenerator();

        // Create the map
        FloatValueTileMap floatValueTileMap = new FloatValueTileMap(1000, 1000, "map100x100"); // TODO: Extract the data from the gameConfiguration instead of hard coded

        MapType mapType = MapType.RIVERS2; // The type of map to be created

        setupTileDistribution(mapType);


        GenerationAlgo generationAlgo = mapType.getGenerationAlgo();
        int iterations = mapType.getIterations();
        TileMap tileMap = null;
        switch (generationAlgo) {
            case RANDOM_NOISE -> {
                tileMap = mapGenerator.generateRandomMap(floatValueTileMap);
            }
            case CELLULAR_AUTOMATA_NORMAL -> {
                tileMap = mapGenerator.generateCellularNormalMap(floatValueTileMap, iterations);
            }
            case CELLULAR_AUTOMATA_SMOOTH -> {
                tileMap = mapGenerator.generateCellularSmoothMap(floatValueTileMap, iterations);
            }
            case PERLIN_NOISE -> {

            }
            default -> {

            }
        }

        if (tileMap == null) {
            throw new IllegalArgumentException("Failed to generate map");
        }
        System.out.println("Successfully generated map");

        return tileMap;
    }
    public void setupTileDistribution(MapType mapType) {
        float currentValue = 0;
        for (Map.Entry<TileType, Integer> entry : mapType.getTileDistribution().entrySet()) {
            entry.getKey().setLowerBound(currentValue / 100);
            currentValue += entry.getValue();
            entry.getKey().setUpperBound(currentValue / 100);
        }
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public void setGameConfiguration(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

}
