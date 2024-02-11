import java.util.HashMap;
import java.util.Map;

public class MapConfiguration {
    private Map<TileType, Integer> titleDistribution = new HashMap<>();
    private int iterations;
    private GenerationAlgo mapGeneratorAlgo;

    public MapConfiguration(Map<TileType, Integer> titleDistribution, int iterations, GenerationAlgo mapGeneratorAlgo) {
        this.titleDistribution = titleDistribution;
        this.iterations = iterations;
        this.mapGeneratorAlgo = mapGeneratorAlgo;
    }

    public static Map<TileType, Integer> createIslandsTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 35);
            put(TileType.WATER, 65);
        }};

    }

    public static Map<TileType, Integer> createMainIslandTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 50);
            put(TileType.WATER, 50);
        }};
    }

    public static Map<TileType, Integer> createRivers2TileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 48);
            put(TileType.WATER, 52);
        }};
    }

    public static Map<TileType, Integer> createRiversTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 40);
            put(TileType.WATER, 60);
        }};
    }

    public static Map<TileType, Integer> createMainLandTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 100);
            put(TileType.WATER, 0);
        }};
    }

    public Map<TileType, Integer> getTitleDistribution() {
        return titleDistribution;
    }

    public void setTitleDistribution(Map<TileType, Integer> titleDistribution) {
        this.titleDistribution = titleDistribution;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public GenerationAlgo getMapGeneratorAlgo() {
        return mapGeneratorAlgo;
    }

    public void setMapGeneratorAlgo(GenerationAlgo mapGeneratorAlgo) {
        this.mapGeneratorAlgo = mapGeneratorAlgo;
    }
}
