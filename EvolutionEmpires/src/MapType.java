public enum MapType {
    ISLANDS("Islands", new MapConfiguration(MapConfiguration.createIslandsTileDistributionMap(), 25, GenerationAlgos.CELLULAR_AUTOMATA_NORMAL)), // 35 / 65
    MAIN_ISLAND("Main Island", new MapConfiguration(MapConfiguration.createMainIslandTileDistributionMap(), 15, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)), // 50 / 50
    ISLANDS2("Islands 2", new MapConfiguration(MapConfiguration.createIslands2TileDistributionMap(), 15, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)), // 53 / 53 and => in MapGenerator
    ISLANDS3("Islands 3", new MapConfiguration(MapConfiguration.createIslands3TileDistributionMap(), 50, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)), // 53 / 53 and => in MapGenerator
    RIVERS("Rivers", new MapConfiguration(MapConfiguration.createRiversTileDistributionMap(), 8, GenerationAlgos.CELLULAR_AUTOMATA_NORMAL)), // 40 / 60
    RIVERS2("Rivers 2", new MapConfiguration(MapConfiguration.createRivers2TileDistributionMap(), 15, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)), // 48 / 52 >= in MapGenerator
    MAIN_LAND("Main Land", new MapConfiguration(MapConfiguration.createMainLandTileDistributionMap(), 0, GenerationAlgos.CELLULAR_AUTOMATA_NORMAL)), // 100 / 0
    MAIN_LAND_WATER("Main Land Water", new MapConfiguration(MapConfiguration.createMainIslandWaterTileDistributionMap(), 15, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)), // 53 / 53 and >= in MapGenerator
    TEST("Main Land Water", new MapConfiguration(MapConfiguration.testTileDistributionMap(), 0, GenerationAlgos.CELLULAR_AUTOMATA_SMOOTH)); // 53 / 53 and >= in MapGenerator
    private String name;
    private MapConfiguration mapConfiguration;

    MapType(String name, MapConfiguration mapConfiguration) {
        this.name = name;
        this.mapConfiguration = mapConfiguration;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapConfiguration getMapConfiguration() {
        return mapConfiguration;
    }

    public void setMapConfiguration(MapConfiguration mapConfiguration) {
        this.mapConfiguration = mapConfiguration;
    }
}
