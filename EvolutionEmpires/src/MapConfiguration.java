import java.util.HashMap;
import java.util.Map;

public class MapConfiguration {
    private Map<TileType, Integer> titleDistribution = new HashMap<>();
    private int iterations;
    private GenerationAlgos mapGeneratorAlgo;

    public MapConfiguration(Map<TileType, Integer> titleDistribution, int iterations, GenerationAlgos mapGeneratorAlgo) {
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
    public static Map<TileType, Integer> createIslands2TileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 47);
            put(TileType.WATER, 53);
        }};
    }
    public static Map<TileType, Integer> createIslands3TileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 46);
            put(TileType.WATER, 54);
        }};
    }
    public static Map<TileType, Integer> createMainIslandWaterTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 60);
            put(TileType.WATER, 40);
        }};
    }

    public static Map<TileType, Integer> createSmallIslandsileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 45);
            put(TileType.WATER, 55);
        }};
    }
    public static Map<TileType, Integer> createMainIsland2TileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 49);
            put(TileType.WATER, 51);
        }};
    }

    public static Map<TileType, Integer> createMainLandTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 100);
            put(TileType.WATER, 0);
        }};
    }
    public static Map<TileType, Integer> testTileDistributionMap() {
        return new HashMap<>() {{
            put(TileType.GRASS, 50);
            put(TileType.WATER, 50);
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

    public GenerationAlgos getMapGeneratorAlgo() {
        return mapGeneratorAlgo;
    }

    public void setMapGeneratorAlgo(GenerationAlgos mapGeneratorAlgo) {
        this.mapGeneratorAlgo = mapGeneratorAlgo;
    }
}
