import java.util.Map;

public enum MapType {
    ISLANDS("Islands", new MapConfiguration(MapConfiguration.createIslandsTileDistributionMap(), 25, GenerationAlgo.CELLULAR_AUTOMATA_NORMAL)), // 35 / 65
    MAIN_ISLAND("Main Island", new MapConfiguration(MapConfiguration.createMainIslandTileDistributionMap(), 15, GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH)), // 50 / 50
    ISLANDS2("Islands 2", new MapConfiguration(MapConfiguration.createMainIslandTileDistributionMap(), 5, GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH)), // 53 / 53 and > in MapGenerator
    RIVERS("Rivers", new MapConfiguration(MapConfiguration.createRiversTileDistributionMap(), 8, GenerationAlgo.CELLULAR_AUTOMATA_NORMAL)), // 40 / 60
    RIVERS2("Rivers 2", new MapConfiguration(MapConfiguration.createRivers2TileDistributionMap(), 15, GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH)), // 48 / 52 >= in MapGenerator
    MAIN_LAND("Main Land", new MapConfiguration(MapConfiguration.createMainLandTileDistributionMap(), 0, GenerationAlgo.CELLULAR_AUTOMATA_NORMAL)); // 100 / 0
//    MAIN_LAND_WATER("Islands 2", new MapConfiguration(MapConfiguration.createMainIslandTileDistributionMap(), 5, GenerationAlgo.CELLULAR_AUTOMATA_SMOOTH)), // 53 / 53 and >= in MapGenerator
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
