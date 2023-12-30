public enum Tile {
    GRASS(0.0f, 0.75f), WATER(0.75f, 1f);
    private float lowerBound;
    private float upperBound;

    // Constructor
    Tile(float lowerBound, float upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static Tile getTileType(double value) {
        for (Tile tile : Tile.values()) {
            if (value >= tile.lowerBound && value < tile.upperBound) {
                return tile;
            }
        }
        throw new IllegalArgumentException("No tile type found for value: " + value);
    }
}
