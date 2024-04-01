import javax.swing.*;

public class GameViewer {
    private GameFrame gameFrame;

    public GameViewer() {
        this.gameFrame = new GameFrame();
    }
    public void initGraphics() {
        SwingUtilities.invokeLater(() -> {
            gameFrame.setVisible(true);

        });
    }
    public void displayStartPanel() {
        gameFrame.createStartPanel();
        repaint();
    }

    public void displayGamePanel(TileMap tileMap) {
        gameFrame.createGamePanel(tileMap);
        repaint();
    }
    public void repaint() {
        SwingUtilities.invokeLater(() -> {
            gameFrame.revalidate();
            gameFrame.repaint();
        });

    }
}





