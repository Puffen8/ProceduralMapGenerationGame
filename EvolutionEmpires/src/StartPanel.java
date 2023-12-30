import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class StartPanel extends JPanel {
    public StartPanel() {
        super(true);
        setLayout(new BorderLayout());

        // Add title text
        JTextPane titleText = createTitleText();
        titleText.setOpaque(false); // Transparent background
        JPanel titlePanel = new JPanel();
        add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(titleText, BorderLayout.CENTER);

        // Add profile button
        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};

        // Create a JList with the data
        JList<String> list = new JList<>(data);

        // Create a JScrollPane and add the JList to it
        JPanel profileList = new JPanel();
        add(profileList, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(list);
        profileList.add(scrollPane, BorderLayout.CENTER);

    }

    public static JTextPane createTitleText() {
        JTextPane titlePane = new JTextPane();

        // Remove all interactions
        titlePane.setEditable(false);
        titlePane.setFocusable(false);
        titlePane.setHighlighter(null);
        titlePane.setTransferHandler(null); // Remove dragging feature

        // Style
        StyledDocument styledDoc = titlePane.getStyledDocument();
        Style style = styledDoc.addStyle("HeaderStyle", null);
        StyleConstants.setFontFamily(style, Config.fontName);
        StyleConstants.setFontSize(style, Config.headerFontSize);
        titlePane.setFont(Config.mainFont);
        try {
            styledDoc.insertString(styledDoc.getLength(), Config.gameTitle, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        return titlePane;
    }
}
