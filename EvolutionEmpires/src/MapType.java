import java.util.HashMap;

public enum MapType {
    TEST("Test",
            new HashMap<>() {{
                put(TileType.GRASS, 50);
                put(TileType.WATER, 50);
            }},
                    0,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH), // 53 / 53 and >= in MapGenerator
    DEFAULT("Default",
            new HashMap<>() {{
                put(TileType.GRASS, 50);
                put(TileType.WATER, 50);
            }},
                    0,
                    null), // 50 / 50
    ISLANDS("Islands",
            new HashMap<>() {{
                put(TileType.GRASS, 35);
                put(TileType.WATER, 65);
            }},
                    25,
                    GenerationAlgo.CELLULAR_AUTOMATA_NORMAL), // 35 / 65
    MAIN_ISLAND("Main_Island",
            new HashMap<>() {{
                put(TileType.GRASS, 50);
                put(TileType.WATER, 50);
            }},
                    15,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH), // 50 / 50
    ISLANDS2("Islands_2",
            new HashMap<>() {{
                put(TileType.GRASS, 47);
                put(TileType.WATER, 53);
            }},
                    15,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH), // 53 / 53 and => in MapGenerator
    ISLANDS3("Islands_3",
            new HashMap<>() {{
                put(TileType.GRASS, 46);
                put(TileType.WATER, 54);
            }},
                    50,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH), // 53 / 53 and => in MapGenerator
    RIVERS("Rivers",
            new HashMap<>() {{
                put(TileType.GRASS, 40);
                put(TileType.WATER, 60);
            }},
                    8,
                    GenerationAlgo.CELLULAR_AUTOMATA_NORMAL), // 40 / 60
    RIVERS2("Rivers_2",
                    new HashMap<>() {{
        put(TileType.GRASS, 48);
        put(TileType.WATER, 52);
    }},
                    15,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH), // 48 / 52 >= in MapGenerator
    MAIN_LAND("Main_Land",
            new HashMap<>() {{
                put(TileType.GRASS, 100);
                put(TileType.WATER, 0);
            }},
                    0,
                    GenerationAlgo.CELLULAR_AUTOMATA_NORMAL), // 100 / 0
    MAIN_LAND_WATER("Main_Land_Water",
            new HashMap<>() {{
                put(TileType.GRASS, 60);
                put(TileType.WATER, 40);
            }},
                    15,
                    GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH); // 53 / 53 and >= in MapGenerator

    private String name;
    private HashMap<TileType, Integer> tileDistribution;
    private int iterations;
    private GenerationAlgo generationAlgo;

    MapType(String name, HashMap<TileType, Integer> tileDistribution, int iterations, GenerationAlgo generationAlgo) {
        this.name = name;
        this.tileDistribution = tileDistribution;
        this.iterations = iterations;
        this.generationAlgo = generationAlgo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<TileType, Integer> getTileDistribution() {
        return tileDistribution;
    }

    public void setTileDistribution(HashMap<TileType, Integer> tileDistribution) {
        this.tileDistribution = tileDistribution;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public GenerationAlgo getGenerationAlgo() {
        return generationAlgo;
    }

    public void setGenerationAlgo(GenerationAlgo generationAlgo) {
        this.generationAlgo = generationAlgo;
    }
}
