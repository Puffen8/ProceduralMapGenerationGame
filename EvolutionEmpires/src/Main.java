import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(64, 64, "TestMap64x64");
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.generateRandomMap(map);
        Map finalMap = map;
        // Start the GraphicThread
        SwingUtilities.invokeLater(() -> {
            // Create mainFrame
            GameFrame frame = new GameFrame(finalMap);
        });


    }
}