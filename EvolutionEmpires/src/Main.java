import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        FloatMap floatMap = new FloatMap(64, 64, "TestMap64x64");
//        MapGenerator mapGenerator = new MapGenerator();
//        TileMap tileMap = mapGenerator.generateRandomMap(floatMap);
//        TileMap finalTileMap = tileMap;
        // Start the GraphicThread
        SwingUtilities.invokeLater(() -> {
            // Create mainFrame
            GameFrame frame = new GameFrame();
        });


    }

}