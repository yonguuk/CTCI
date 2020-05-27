import java.util.LinkedList;

public class GraphNode{
    public String name;
    public LinkedList<GraphNode> adjList;
    private int idx;

    public GraphNode(){
        adjList = new LinkedList<>();
    }

    public GraphNode(String name){
        this.name = name;
        adjList = new LinkedList<>();
    }

    public GraphNode(String name, int idx){
        this.name = name;
        this.idx = idx;
        adjList = new LinkedList<>();
    }

    public void add(GraphNode n){
        adjList.addLast(n);
    }

    public void printAdjInfo(){
        for(int i=0; i<adjList.size(); ++i)
            System.out.print(adjList.get(i).name + " ");
    }

    public int getIdx(){
        return idx;
    }
}