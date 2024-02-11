import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;

public class GameFrame extends JFrame implements WindowListener {
    private JPanel mainPanel;
    public GameFrame() {
        setSize(Config.screenSize.width, Config.screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.gameTitle);

        this.mainPanel = new JPanel();

        // Set up the Card Layout

        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        add(mainPanel);

        createALlPanels();

        cardLayout.show(mainPanel, "gamePanel");


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

    // TODO CLEAN THIS UP
    public void createALlPanels() {
        StartPanel startPanel = new StartPanel();
        mainPanel.add(startPanel, "startPanel");

        // Create the map
        FloatMap floatMap = new FloatMap(300, 300, "map100x100");
        MapGenerator mapGenerator = new MapGenerator();
//        TileMap tileMap = mapGenerator.generateRandomMap(floatMap);
        MapType mapType = MapType.RIVERS2; // The type of map to be created
        // Assign the probability value for each TileType depending on the map theme
        float currentValue = 0;
        for (Map.Entry<TileType, Integer> entry : mapType.getMapConfiguration().getTitleDistribution().entrySet()) {
            entry.getKey().setLowerBound(currentValue / 100);
            currentValue += entry.getValue();
            entry.getKey().setUpperBound(currentValue / 100);
        }

//        TileType.GRASS.setLowerBound(0f);
//        TileType.GRASS.setUpperBound(0.5f);
//        TileType.WATER.setLowerBound(0.5f);
//        TileType.WATER.setUpperBound(1f);
        MapConfiguration mapConfiguration = mapType.getMapConfiguration();
        GenerationAlgo generationAlgo = mapConfiguration.getMapGeneratorAlgo();
        int iterations = mapConfiguration.getIterations();
        TileMap tileMap = null;
        switch (generationAlgo) {
            case RANDOM_NOISE -> {

            }
            case CELLULAR_AUTOMATA_NORMAL -> {
                tileMap = mapGenerator.generateCellularNormalMap(floatMap, iterations);
            }
            case CELLULAR_AUTOMATA_SMOOTH -> {
                tileMap = mapGenerator.generateCellularSmoothMap(floatMap, iterations);
            }
            case PERLINNOISE -> {

            }
            default -> {

            }
        }
//        TileMap tileMap = mapGenerator.generateCellularMap(floatMap, 10);


//        floatMap = mapGenerator.generatePerlinNoiseMap(floatMap, 3);
        if (tileMap == null) {
            throw new IllegalArgumentException();
        }

        GamePanel gamePanel = new GamePanel(tileMap, floatMap);
        mainPanel.add(gamePanel, "gamePanel");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO: Write to database??
        // TODO: Save all player profiles
        // TODO: Maybe use a addShutdownHook instead for detecting application turn off
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
