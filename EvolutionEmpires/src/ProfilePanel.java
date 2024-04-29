import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProfilePanel extends JPanel implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public ProfilePanel() {
        super(true);

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        JPanel northPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        // Debugging ---------------------------
        northPanel.setBackground(Color.GRAY);
        eastPanel.setBackground(Color.BLUE);
        westPanel.setBackground(Color.YELLOW);
        southPanel.setBackground(Color.RED);
        centerPanel.setBackground(Color.GREEN);
        // -------------------------------------

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        // Add title text
        JTextPane titleText = createTitleText();
        northPanel.add(titleText);

        // Add profile list
        JScrollPane profileScrollPane = createProfileList();
        profileScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(profileScrollPane);
        centerPanel.add(Box.createVerticalStrut( 50));


        // Add Next Button
        JButton nextButton = createNextButton();
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(nextButton);

    }

    public JTextPane createTitleText() {
        JTextPane titlePane = new JTextPane();

        // Remove all interactions
        titlePane.setEditable(false);
        titlePane.setFocusable(false);
        titlePane.setHighlighter(null);
        titlePane.setTransferHandler(null); // Remove dragging feature

        // Style
        StyledDocument styledDoc = titlePane.getStyledDocument();
        Style style = styledDoc.addStyle("HeaderStyle", null);
        StyleConstants.setFontFamily(style, Config.MAIN_FONT_NAME);
        StyleConstants.setFontSize(style, Config.HEADER_FONT_SIZE);
        titlePane.setFont(Config.HEADER_FONT);
        titlePane.setOpaque(false); // Transparent background
        try {
            styledDoc.insertString(styledDoc.getLength(), Config.GAME_TITLE, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        return titlePane;
    }

    public JScrollPane createProfileList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("PlayerProfile1");
        listModel.addElement("PlayerProfile2");
        listModel.addElement("PlayerProfile3");

        // Create a JList with the data
        JList<String> guiList = new JList<>(listModel);
        guiList.setCellRenderer(new ListItemRenderer());

        // Create a JScrollPane and set its border
        JScrollPane scrollPane = new JScrollPane(guiList);
        scrollPane.setLayout(new ScrollPaneLayout()); // Set your layout manager
        scrollPane.setBorder(new LineBorder(Config.THEME_COLOR_2, 2)); // Set the border color and thickness
        Dimension preferredSize = new Dimension(400, 300);
        scrollPane.setMaximumSize(preferredSize);

        return scrollPane;
    }

    public JButton createNextButton() {
        JButton nextButton = new JButton("Next");
        Dimension preferredSize = new Dimension(300, 50);
        nextButton.setMaximumSize(preferredSize);
        nextButton.setFont(Config.TEXT_FONT);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObservers();
            }
        });


        return nextButton;
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }



}
