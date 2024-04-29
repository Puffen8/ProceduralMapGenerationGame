/*
 * This is the highest class in the hierarchy.
 * It works as adapter between logic and graphics.
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

        gameViewer.getGameFrame().createStartPanel();

        TileMap tileMap = gameManager.createMap();
        gameViewer.getGameFrame().createGamePanel(tileMap);

    }

    public void startGame() {
        // Panel to show at the start of the game
        gameViewer.getGameFrame().switchToPanel("gamePanel");
    }


}
