public class TileMap {
    private TileType[][] grid;
    private int width;
    private int height;
    private int size;
    private String name;

    public TileMap(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.size = width * height;
        this.grid = new TileType[width][height];
    }
    public TileMap copy() {
        return new TileMap(this.getWidth(), this.getHeight(), this.getName());
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
}
