import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameFrame extends JFrame implements WindowListener {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    public GameFrame() {
        setSize(Config.SCREEN_SIZE.width, Config.SCREEN_SIZE.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.GAME_TITLE);

        this.mainPanel = new JPanel();
        add(mainPanel);

        // Set up the Card Layout for the mainPanel of the GameFrame
        this.cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

    }

    public void createStartPanel() {
        ProfilePanel startPanel = new ProfilePanel();
        mainPanel.add(startPanel, "startPanel");
    }

    public void createGamePanel (TileMap tileMap) {
        GamePanel gamePanel = new GamePanel(tileMap);
        mainPanel.add(gamePanel, "gamePanel");
    }

    public void switchToPanel(String panel) {
        cardLayout.show(mainPanel, panel);
        revalidate();
        repaint();
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
