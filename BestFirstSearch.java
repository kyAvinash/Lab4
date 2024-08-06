import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class BestFirstSearch {
    private Node start;
    private Node goal;

    public BestFirstSearch(Node start, Node goal) {
        this.start = start;
        this.goal = goal;
    }

    public List<String> search() {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        start.cost = 0;
        openList.add(start);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();

            if (currentNode == goal) {
                return reconstructPath(goal);
            }

            for (Node.Edge edge : currentNode.neighbors) {
                Node neighbor = edge.node;
                int newCost = currentNode.cost + edge.cost;

                if (neighbor.cost > newCost) {
                    neighbor.cost = newCost;
                    neighbor.parent = currentNode;
                    openList.add(neighbor);
                }
            }
        }
        return null; // No path found
    }

    private List<String> reconstructPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(node.name);
            node = node.parent;
        }
        java.util.Collections.reverse(path);
        return path;
    }
}
