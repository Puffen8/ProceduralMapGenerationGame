import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private TileMap tileMap;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel mapPanel;

    public GamePanel(TileMap tileMap) {
        super(true);
        this.tileMap = tileMap;

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        this.northPanel = new GradientPanel(Config.THEME_COLOR_1, Config.THEME_COLOR_2);
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
