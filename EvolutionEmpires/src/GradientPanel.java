import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


// TODO: Make this handle more than 2 colors??
public class GradientPanel extends JPanel {
    private Color color1;
    private Color color2;

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast to Graphics2D for gradient
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);

        // Set the paint to the Graphics2D context
        g2d.setPaint(gradient);

        // Fill the entire panel with the gradient
        g2d.fillRect(0, 0, width, height);
    }
}
