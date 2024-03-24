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
}





