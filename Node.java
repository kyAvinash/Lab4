import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    int heuristic;
    List<Edge> neighbors;
    Node parent;
    int cost;

    public Node(String name, int heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.neighbors = new ArrayList<>();
        this.parent = null;
        this.cost = Integer.MAX_VALUE;
    }

    public void addNeighbor(Node neighbor, int cost) {
        neighbors.add(new Edge(neighbor, cost));
    }

    public static class Edge {
        public Node node;
        public int cost;

        Edge(Node node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
