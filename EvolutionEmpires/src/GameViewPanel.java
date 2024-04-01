import javax.swing.*;
import java.awt.*;

public class GameViewPanel extends JPanel {
    private TileMap tileMap;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel mapPanel;

    public GameViewPanel(TileMap tileMap) {
        super(true);
        this.tileMap = tileMap;

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

//        createMapPanel();
        mapPanel = new MapPanel(tileMap);
        centerPanel.add(mapPanel);
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        int tileSize = 10; // Adjust the size of each square as needed
//        int width = tileMap.getWidth();
//        int height = tileMap.getHeight();
//        System.out.println("Drawing Map");
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                TileType tile = tileMap.getTileAt(x, y);
//                System.out.println(x + " " + y + " " + tile.getColor());
//                g.setColor(tile.getColor());
//                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
//            }
//        }
//
////        for (int i = 0; i < GRID_SIZE; i++) {
////            for (int j = 0; j < GRID_SIZE; j++) {
////                g.setColor(gridColors[i][j]);
////                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
////            }
////        }
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        int tileSize = 10; // Adjust the size of each mapTile as needed
//        int width = tileMap.getWidth();
//        int height = tileMap.getHeight();
//        return new Dimension(width * tileSize, height * tileSize);
//    }

//    public void createMapPanel() {
//        GridLayout gridLayout = new GridLayout(tileMap.getWidth(), tileMap.getHeight());
//        mapPanel.setLayout(gridLayout);
//        mapPanel.setBounds(300, 0, 800, 800);
//        mapPanel.setBackground(Color.BLACK);
//    }



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

    public TileMap getTileMap() {
        return tileMap;
    }

    public void setTileMap(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(JPanel westPanel) {
        this.westPanel = westPanel;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public void setEastPanel(JPanel eastPanel) {
        this.eastPanel = eastPanel;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JPanel getMapPanel() {
        return mapPanel;
    }

    public void setMapPanel(JPanel mapPanel) {
        this.mapPanel = mapPanel;
    }
}
