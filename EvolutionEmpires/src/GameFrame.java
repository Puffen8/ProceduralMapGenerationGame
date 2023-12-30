import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JPanel mapPanel;
    public GameFrame(Map map) {
        this.mapPanel = new JPanel();
        setSize(Config.screenSize.width, Config.screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.gameTitle);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        add(mainPanel);
        StartPanel startPanel = new StartPanel();
        mainPanel.add(startPanel);

//
//        getContentPane().setLayout(null);
//        mapPanel.setLayout(new GridLayout(map.getWidth(), map.getHeight()));
//        add(mapPanel);
//        mapPanel.setBounds((int)((Config.screenSize.getWidth() - Config.screenSize.getHeight()) / 2), 0, (int)Config.screenSize.getHeight(), (int)Config.screenSize.getHeight());
//        mapPanel.setBackground(Color.BLACK);
//
//        showMap(map);

//        float[][] mapGrid = perlinNoiseMap;
//        for (int x = 0; x < map.getWidth(); x++) {
//            for (int y = 0; y < map.getHeight(); y++) {
//                JPanel tile = new JPanel();
////                tile.setSize(new Dimension(5,5));
//                int value = (int)(mapGrid[x][y] * 255);
//                Color color = new Color(value, value, value);
//                tile.setBackground(color);
//                mainPanel.add(tile);
//            }
//        }



        setVisible(true);
    }

    public void showMap(Map map) {
        Tile[][] mapGrid = map.getGrid();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                JPanel tile = new JPanel();
//                tile.setSize(new Dimension(5,5));
                switch (mapGrid[x][y]) {
                    case GRASS -> tile.setBackground(Color.GREEN);
                    case WATER -> tile.setBackground(Color.BLUE);
                }
                mapPanel.add(tile);
            }
        }
    }
}
