/*
 * Works as adapter between logic and graphics
 */
public class GameController {
    private GameManager gameManager;
    private GameViewer gameViewer;
    public GameController() {
        this.gameManager = new GameManager(null);
        this.gameViewer = new GameViewer();
    }

    public void init() {
        gameViewer.initGraphics();
    }

    public void startGame() {
        gameViewer.displayStartPanel();
    }
    // Starts the game after the start panel
    public void runGame() {
        TileMap tileMap = gameManager.createMap();
        gameViewer.displayGamePanel(tileMap);
    }


}
