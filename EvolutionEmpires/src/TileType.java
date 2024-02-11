import java.awt.*;

public enum TileType {
    GRASS(0.0f, 0.4f, Color.GREEN),
    WATER(0.4f, 1f, Color.BLUE);
    private float lowerBound;
    private float upperBound;
    private Color color;

    // Constructor
    TileType(float lowerBound, float upperBound, Color color) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.color = color;
    }

    public static TileType getTileType(double value) {
        for (TileType tile : TileType.values()) {
            if (value >= tile.lowerBound && value < tile.upperBound) {
                return tile;
            }
        }
        throw new IllegalArgumentException("No tile type found for value: " + value);
    }

    public float getLowerBound() {
        return lowerBound;
    }

    public float getUpperBound() {
        return upperBound;
    }

    public Color getColor() {
        return color;
    }

    public void setLowerBound(float lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(float upperBound) {
        this.upperBound = upperBound;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
