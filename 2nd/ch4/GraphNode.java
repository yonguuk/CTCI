import java.util.LinkedList;

public class GraphNode {
    int value;
    boolean visited;
    LinkedList<GraphNode> adjList;

    public GraphNode(int value){
        this.value = value;
        visited = false;
        adjList = new LinkedList<>();
    }
}