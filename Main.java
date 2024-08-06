import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create nodes
        Node a = new Node("A", 10);
        Node b = new Node("B", 8);
        Node c = new Node("C", 9);
        Node d = new Node("D", 7);
        Node e = new Node("E", 0);

        // Define neighbors and costs
        a.addNeighbor(b, 1);
        a.addNeighbor(c, 4);
        b.addNeighbor(d, 2);
        c.addNeighbor(e, 3);

        // Perform Best-First Search
        BestFirstSearch bfs = new BestFirstSearch(a, e);
        List<String> path = bfs.search();

        // Print the result
        System.out.println("Path found: " + path);

        // Display the tree structure
        SwingUtilities.invokeLater(() -> {
            TreeVisualization treeVisualization = new TreeVisualization(a, e);
            JFrame frame = new JFrame("Best-First Search Tree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(treeVisualization);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
