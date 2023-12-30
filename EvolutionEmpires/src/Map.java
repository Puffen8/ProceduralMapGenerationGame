public class Map {
    private Tile[][] grid;
    private int width;
    private int height;
    private int size;
    private String name;

    public Map(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.size = width * height;
        this.grid = new Tile[width][height];
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void setGrid(Tile[][] grid) {
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
