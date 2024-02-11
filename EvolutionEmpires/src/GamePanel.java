import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private TileMap tileMap;
    private FloatMap floatMap;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel mapPanel;

    public GamePanel(TileMap tileMap, FloatMap floatMap) {
        super(true);
        this.tileMap = tileMap;
        this.floatMap = floatMap;

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        this.northPanel = new GradientPanel(Config.themeColor1, Config.themeColor2);
        this.eastPanel = new JPanel();
        this.westPanel = new JPanel();
        this.southPanel = new JPanel();
        this.centerPanel = new JPanel();
        this.mapPanel = new JPanel();

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        // Set preferred size for panels, centerPanel gets the remaining space
        northPanel.setPreferredSize(new Dimension(0, 30));
        southPanel.setPreferredSize(new Dimension(0, 100));
        westPanel.setPreferredSize(new Dimension(100, 0));
        eastPanel.setPreferredSize(new Dimension(100, 0));

        northPanel.setBackground(Color.RED);
        southPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.YELLOW);
        eastPanel.setBackground(Color.BLUE);


        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(null);

        createMapPanel();
        centerPanel.add(mapPanel);

        showMap();
//        showMapBW();

    }

    public void createMapPanel() {
        GridLayout gridLayout = new GridLayout(tileMap.getWidth(), tileMap.getHeight());
        mapPanel.setLayout(gridLayout);
        mapPanel.setBounds(300, 0, 800, 800);
        mapPanel.setBackground(Color.BLACK);
    }



    public void showMap() {
        int width = tileMap.getWidth();
        int height = tileMap.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                JPanel tilePanel = new JPanel();
                TileType tile = tileMap.getTileAt(x, y);
                tilePanel.setBackground(tile.getColor());
                mapPanel.add(tilePanel);
            }
        }
    }

    public void showMapBW() {
        int width = floatMap.getWidth();
        int height = floatMap.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                JPanel tilePanel = new JPanel();
                float tileValue = floatMap.getTileValueAt(x, y);
                int colorValue = (int)(tileValue * 256);
                Color color = new Color(colorValue, colorValue, colorValue);
                tilePanel.setBackground(color);
                mapPanel.add(tilePanel);
            }
        }
    }
}
