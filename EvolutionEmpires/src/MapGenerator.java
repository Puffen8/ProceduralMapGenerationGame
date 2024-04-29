import java.util.Random;

public class MapGenerator {
    private final Random random;
    public MapGenerator() {
        this.random = new Random();
    }

    public TileMap FloatMapToTileMap(FloatValueTileMap floatValueTileMap, MapType mapType) {
        TileMap tileMap = new TileMap(floatValueTileMap.getWidth(), floatValueTileMap.getHeight(), floatValueTileMap.getName(), mapType);
        TileType[][] mapGrid = tileMap.getGrid();
        for (int i = 0; i < floatValueTileMap.getWidth(); i++) {
            for (int j = 0; j < floatValueTileMap.getHeight(); j++) {
                mapGrid[i][j] = TileType.getTileType(floatValueTileMap.getTileValueAt(i, j));
            }
        }
        return tileMap;
    }
    public FloatValueTileMap generateRandomValueFloatMap(FloatValueTileMap floatValueTileMap) {
        float[][] mapGrid = floatValueTileMap.getGrid();
        for (int i = 0; i < floatValueTileMap.getWidth(); i++) {
            for (int j = 0; j < floatValueTileMap.getHeight(); j++) {
                mapGrid[i][j] = random.nextFloat();
            }
        }
        return floatValueTileMap;
    }

    public TileMap generateRandomMap(FloatValueTileMap floatValueTileMap) {
        TileMap tileMap = new TileMap(floatValueTileMap.getWidth(), floatValueTileMap.getHeight(), floatValueTileMap.getName(), null); // TODO: Fix last parameter
        TileType[][] mapGrid = tileMap.getGrid();
        for (int i = 0; i < floatValueTileMap.getWidth(); i++) {
            for (int j = 0; j < floatValueTileMap.getHeight(); j++) {
                mapGrid[i][j] = TileType.getTileType(random.nextFloat());
            }
        }
        return tileMap;
    }

    public TileMap generateCellularNormalMap(FloatValueTileMap floatValueTileMap, int iterations) {
        // Create initial random map
        TileMap tileMap = generateRandomMap(floatValueTileMap);
        if (iterations <= 0) {
            return tileMap;
        }
        for (int i = 0; i < iterations; i++) {
            tileMap = cellularIter(tileMap);

        }

        return tileMap;

    }

    private TileMap cellularIter(TileMap tileMap) {
        TileMap newTileMap = tileMap.copy();
        for (int x = 0; x < tileMap.getWidth(); x++) {
            for (int y = 0; y < tileMap.getHeight(); y++) {
                // Loop through neighbors of (x, y)
                int count = 0;
                for (int x1 = x - 1; x1 <= x + 1; x1++) {
                    for (int y1 = y - 1; y1 <= y + 1; y1++) {
                        if ((x1 == x && y1 == y) || x1 < 0 || y1 < 0 || x1 >= tileMap.getWidth() || y1 >= tileMap.getHeight()) {
                            continue;
                        }
                        if (tileMap.getTileAt(x1, y1) == TileType.GRASS) {
                            count++;
                        }
                    }
                }
                if (count >= 4) { // > or >=???
                    newTileMap.setTileAt(x, y, TileType.GRASS);
                } else {
                    newTileMap.setTileAt(x, y, TileType.WATER);
                }

            }

        }
        return newTileMap;
    }

    public TileMap generateCellularSmoothMap(FloatValueTileMap floatValueTileMap, int iterations) {
        // Create initial random map
        TileMap tileMap = generateRandomMap(floatValueTileMap);
        if (iterations <= 0) {
            return tileMap;
        }
        for (int i = 0; i < iterations; i++) {
            tileMap = cellularIterSmooth(tileMap);

        }

        return tileMap;

    }
    private TileMap cellularIterSmooth(TileMap tileMap) {
        TileMap newTileMap = tileMap.copy();
        for (int x = 0; x < tileMap.getWidth(); x++) {
            for (int y = 0; y < tileMap.getHeight(); y++) {
                // Loop through neighbors of (x, y)
                int count = 0;
                for (int x1 = x - 2; x1 <= x + 2; x1++) {
                    for (int y1 = y - 2; y1 <= y + 2; y1++) {
                        if ((x1 == x && y1 == y) || x1 < 0 || y1 < 0 || x1 >= tileMap.getWidth() || y1 >= tileMap.getHeight()) {
                            continue;
                        }
                        if (tileMap.getTileAt(x1, y1) == TileType.GRASS) {
                            count++;
                        }
                    }
                }
                if (count >= 12) { // > or >= ???
                    newTileMap.setTileAt(x, y, TileType.GRASS);
                } else {
                    newTileMap.setTileAt(x, y, TileType.WATER);
                }

            }

        }
        return newTileMap;
    }

// OLD FUNCTIONS TO REVISIT AND SEE IF ANYTHING SHOULD BE SAVED ---------------



    // Working, and creates an island with water around use 10-30 iterations
//    private TileMap cellularIter(TileMap tileMap) {
//        TileMap newTileMap = tileMap.copy();
//        for (int x = 0; x < tileMap.getWidth(); x++) {
//            for (int y = 0; y < tileMap.getHeight(); y++) {
//                // Loop through neighbors of (x, y)
//                int count = 0;
//                Tile currentTile = tileMap.getTileAt(x, y);
//                Tile oppositeTile = currentTile == Tile.WATER ? Tile.GRASS : Tile.WATER;
//                for (int x1 = x - 1; x1 <= x + 1; x1++) {
//                    for (int y1 = y - 1; y1 <= y + 1; y1++) {
//                        if ((x1 == x && y1 == y) || x1 < 0 || y1 < 0 || x1 >= tileMap.getWidth() || y1 >= tileMap.getHeight()) {
//                            continue;
//                        }
//                        if (tileMap.getTileAt(x1, y1) == Tile.GRASS) {
//                            count++;
//                        }
//                    }
//                }
//                if (count > 4) {
//                    newTileMap.setTileAt(x, y, Tile.GRASS);
//                } else {
//                    newTileMap.setTileAt(x, y, Tile.WATER);
//                }
//
//            }
//
//        }
//        return newTileMap;
//    }

    // This works pretty well for 50 / 50 WATER GRASS generation // Tho flips grass and water every iteration

//    private TileMap cellularIter(TileMap tileMap) {
//        TileMap newTileMap = tileMap.copy();
//        for (int x = 0; x < tileMap.getWidth(); x++) {
//            for (int y = 0; y < tileMap.getHeight(); y++) {
//                // Loop through neighbors of (x, y)
//                int count = 0;
//                Tile currentTile = tileMap.getTileAt(x, y);
//                Tile oppositeTile = currentTile == Tile.WATER ? Tile.GRASS : Tile.WATER;
//                for (int x1 = x - 1; x1 <= x + 1; x1++) {
//                    for (int y1 = y - 1; y1 <= y + 1; y1++) {
//                        if ((x1 == x && y1 == y) || x1 < 0 || y1 < 0 || x1 >= tileMap.getWidth() || y1 >= tileMap.getHeight()) {
//                            continue;
//                        }
//                        if (tileMap.getTileAt(x1, y1) == currentTile) {
//                            count++;
//                        }
//                    }
//                }
//                if (currentTile == Tile.GRASS) {
//                    if (count < 2) {
//                        newTileMap.setTileAt(x, y, Tile.WATER);
//                    } else if (count >= 2 && count <= 3) {
//                        newTileMap.setTileAt(x, y, Tile.GRASS);
//                    }
//                    else {
//                        newTileMap.setTileAt(x, y, Tile.WATER);
//                    }
//
//                } else if (currentTile == Tile.WATER) {
//                    if (count > 2) {
//                        newTileMap.setTileAt(x, y, Tile.GRASS);
//
//                    } else {
//                        newTileMap.setTileAt(x, y, Tile.WATER);
//
//                    }
//                }
//
//            }
//
//        }
//        return newTileMap;
//    }

//    private TileMap cellularIter(TileMap tileMap) {
//        TileMap newTileMap = tileMap.copy();
//        for (int x = 0; x < tileMap.getWidth(); x++) {
//            for (int y = 0; y < tileMap.getHeight(); y++) {
//                // Loop through neighbors of (x, y)
//                int count = 0;
//                Tile currentTile = tileMap.getTileAt(x, y);
//                Tile oppositeTile = currentTile == Tile.WATER ? Tile.GRASS : Tile.WATER;
//                if (currentTile == Tile.WATER) {
//                    newTileMap.setTileAt(x, y, Tile.WATER);
//                }
//                for (int x1 = x - 1; x1 <= x + 1; x1++) {
//                    for (int y1 = y - 1; y1 <= y + 1; y1++) {
//                        if ((x1 == x && y1 == y) || x1 < 0 || y1 < 0 || x1 >= tileMap.getWidth() || y1 >= tileMap.getHeight()) {
//                            continue;
//                        }
//                        if (tileMap.getTileAt(x1, y1) == currentTile) {
//                            count++;
//                        }
//                    }
//                }
//                if (count < 2) {
//                    newTileMap.setTileAt(x, y, oppositeTile);
//                } else if (count >= 2 && count <= 3) {
//                    newTileMap.setTileAt(x, y, currentTile);
//                }
//                else {
//                    newTileMap.setTileAt(x, y, oppositeTile);
//                }
//            }
//
//        }
//        return newTileMap;
//    }

}
