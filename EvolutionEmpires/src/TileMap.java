import java.util.Map;

public class TileMap {
    private TileType[][] grid;
    private int width;
    private int height;
    private int size;
    private String name;
    private MapType mapType;

    public TileMap(int width, int height, String name, MapType mapType) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.size = width * height;
        this.grid = new TileType[width][height];
        this.mapType = mapType;


    }
    public TileMap copy() {
        return new TileMap(this.getWidth(), this.getHeight(), this.getName(), this.getMapType());
    }
    public TileType getTileAt(int x, int y) {
        return grid[x][y];
    }
    public void setTileAt(int x, int y, TileType tile) {
        this.grid[x][y] = tile;
    }

    public TileType[][] getGrid() {
        return grid;
    }

    public void setGrid(TileType[][] grid) {
        this.grid = grid;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapType getMapType() {
        return mapType;
    }

    public void setMapType(MapType mapType) {
        this.mapType = mapType;
    }
}
