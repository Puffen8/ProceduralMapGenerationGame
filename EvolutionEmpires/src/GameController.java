import javax.swing.*;

public class GameController {
    private GameManager gameManager;
    private GameViewer gameViewer;
    public GameController() {
        this.gameManager = new GameManager(null);

        this.gameViewer = new GameViewer();
    }

    public void initGame() {
        gameViewer.initGraphics();
    }

}
