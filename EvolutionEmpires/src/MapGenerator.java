import java.util.Random;

public class MapGenerator {
    private Random random;
    public MapGenerator() {
        this.random = new Random();
    }

    public void generateRandomMap(Map map) {
        Tile[][] mapGrid = map.getGrid();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                mapGrid[i][j] = Tile.getTileType(random.nextFloat());
            }
        }
    }

/*    public float[][] generatePerlinNoise(Map map) {
        float[][] floatMap = new float[map.getWidth()][map.getHeight()];

        generateOctane(floatMap, 4, map.getWidth(), map.getHeight());


        return floatMap;
    }
    public float[][] generateOctane(float[][] map, int octane, int width, int height) {
        for (int i = 0; i < width / octane; i++) {
            for (int j = 0; j < height / octane; j++) {
                float value = random.nextFloat();
                for (int subI = i; subI <= i * octane; subI++) {
                    for (int subJ = j; subJ <= j * octane; subJ++) {
                        map[subI][subJ] = (map[subI][subJ] / value) / 2;
                    }
                }

//                System.out.println(floatMap[i][j]);
            }
        }
        return map;
    }*/
}
