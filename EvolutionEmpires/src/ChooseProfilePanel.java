import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ChooseProfilePanel extends JPanel {
    public ChooseProfilePanel() {
        super(true);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        JPanel northPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        // Add title text
        northPanel.add(createTitleText(), BorderLayout.NORTH);

        // Add profile list
        centerPanel.add(createProfileList(), BorderLayout.CENTER);

        // Add chosen profile panel
        centerPanel.add(createChosenProfile(), BorderLayout.CENTER);



    }

    // TODO: Make this TitleText a separate class
    public JPanel createTitleText() {
        JTextPane titlePane = new JTextPane();

        // Remove all interactions
        titlePane.setEditable(false);
        titlePane.setFocusable(false);
        titlePane.setHighlighter(null);
        titlePane.setTransferHandler(null); // Remove dragging feature

        // Style
        StyledDocument styledDoc = titlePane.getStyledDocument();
        Style style = styledDoc.addStyle("HeaderStyle", null);
        StyleConstants.setFontFamily(style, Config.mainFontName);
        StyleConstants.setFontSize(style, Config.headerFontSize);
        titlePane.setFont(Config.mainFont);
        titlePane.setOpaque(false); // Transparent background
        try {
            styledDoc.insertString(styledDoc.getLength(), Config.gameTitle, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        JPanel titlePanel = new JPanel();
        titlePanel.add(titlePane, BorderLayout.CENTER);

        return titlePanel;
    }

    // TODO: Make this ScrollPanel a separate class
    public JPanel createProfileList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("PlayerProfile1");
        listModel.addElement("PlayerProfile2");
        listModel.addElement("PlayerProfile3");
        // Create a JList with the data
        JList<String> guiList = new JList<>(listModel);
        guiList.setCellRenderer(new ListItemRenderer()); // Implement MyListCellRenderer to customize the appearance

        // Create a JScrollPane and set its border
        JScrollPane scrollPane = new JScrollPane(guiList);
        scrollPane.setLayout(new ScrollPaneLayout()); // Set your layout manager
        scrollPane.setBorder(new LineBorder(Config.themeColor2, 2)); // Set the border color and thickness
        scrollPane.setPreferredSize(new Dimension(300, 200));


        // Create a JScrollPane and add the JList to it
        JPanel profileListPane = new JPanel();
        profileListPane.add(scrollPane, BorderLayout.CENTER);
        return profileListPane;
    }

    public JPanel createChosenProfile() {
        JPanel profilePane = new JPanel();

        return profilePane;
    }
}
