import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TreeVisualization extends JPanel {
    private Node root;
    private Node goal;

    public TreeVisualization(Node root, Node goal) {
        this.root = root;
        this.goal = goal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, root, getWidth() / 2, 30, getWidth() / 4, 30);
    }

    private void drawTree(Graphics g, Node node, int x, int y, int xOffset, int yOffset) {
        if (node != null) {
            g.drawString(node.name, x, y);
            for (Node.Edge edge : node.neighbors) {
                int childX = x - xOffset + (int) (Math.random() * 2 * xOffset);
                int childY = y + yOffset;
                g.drawLine(x, y, childX, childY);
                drawTree(g, edge.node, childX, childY, xOffset / 2, yOffset);
            }
        }
    }
}
