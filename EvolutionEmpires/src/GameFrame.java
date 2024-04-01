import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

        cardLayout.show(mainPanel, "startPanel"); // Panel to show at start
    }

    public void createStartPanel() {
        ChooseProfilePanel startPanel = new ChooseProfilePanel();
        mainPanel.add(startPanel, "startPanel");
    }

    public void createGamePanel (TileMap tileMap) {
        GameViewPanel gamePanel = new GameViewPanel(tileMap);
        mainPanel.add(gamePanel, "gamePanel");
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
