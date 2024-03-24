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

        cardLayout.show(mainPanel, "gamePanel"); // Panel to show at start
    }

    // TODO CLEAN THIS UP
    public void createALlPanels() {
        StartPanel startPanel = new StartPanel();
        mainPanel.add(startPanel, "startPanel");

        // Create the map
        FloatMap floatMap = new FloatMap(100, 100, "map100x100");
        MapGenerator mapGenerator = new MapGenerator();
//        TileMap tileMap = mapGenerator.generateRandomMap(floatMap);
        MapType mapType = MapType.TEST; // The type of map to be created
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
        GenerationAlgos generationAlgo = mapConfiguration.getMapGeneratorAlgo();
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
            case PERLIN_NOISE -> {

            }
            default -> {

            }
        }

        System.out.println("Done generating map");

        if (tileMap == null) {
            throw new IllegalArgumentException("Failed to generate map");
        }

        GamePanel gamePanel = new GamePanel(tileMap, floatMap);
        System.out.println(mainPanel.getWidth() + " " + mainPanel.getHeight());
        mainPanel.add(gamePanel, "gamePanel");
        System.out.println("GamePanel width x height:" + gamePanel.getMapPanel().getWidth() + " x " + gamePanel.getMapPanel().getHeight());
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
