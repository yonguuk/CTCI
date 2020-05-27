import java.util.ArrayList;
import java.util.LinkedList;

public class Graph{

    enum Vertex{
        A, B, C, D, E, F, G, H, I, J, K, L, M, N
    }
    private ArrayList<GraphNode> nodes;
    // private final static String NAMES[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
    private Vertex[] v = Vertex.values();

    public Graph(){
        nodes = new ArrayList<>();
    }

    public Graph(int numVertex){
        nodes = new ArrayList<>();
        for(int i=0; i<numVertex; ++i){
            nodes.add(new GraphNode(v[i].toString(), i));
        }
    }

    // public void addVertex(String name){
    //     GraphNode nNode = new GraphNode(name);
    //     nodes.add(nNode);
    // }
    
    public void addEdge(int from, int to, boolean isDirected){
        nodes.get(from).add(nodes.get(to));
        if(isDirected == false)
            nodes.get(to).add(nodes.get(from));
    }

    public void printVertexInfo(){
        for(int i=0; i<nodes.size(); ++i){
            System.out.print(nodes.get(i).name + " : ");
            nodes.get(i).printAdjInfo();
            System.out.println();
        }
    }

    public boolean isConnectedVertex(int from, int to){
        boolean visitInfo[] = new boolean[nodes.size()];
        MyQueue queue = new MyQueue();
        GraphNode visitNode = nodes.get(from);

        visitVertex(visitInfo, visitNode);

        while(visitNode != null){
            for(GraphNode node : visitNode.adjList){
                if(node.getIdx() == to)
                    return true;
                if(visitVertex(visitInfo, node) == true){
                    queue.add(node);
                }
            }
            if(queue.isEmpty() == false)
                visitNode = queue.remove();
            else
                break;
        }

        // for(int i=0; i<nodes.size(); ++i){
        //     LinkedList list = nodes.get(i).adjList;
        //     for(int j=0; j<list.size(); ++j){
        //         GraphNode visitNode = (GraphNode)list.get(j);
        //         if(visitNode.getIdx() == to)
        //             return true;
        //         if(visitVertex(visitInfo, visitNode) == true){
        //             queue.add(visitNode);
        //         }
        //     }
        // }

        return false;
    }

    private boolean visitVertex(boolean[] visitInfo, GraphNode node){
        if(visitInfo[node.getIdx()] == false){
            visitInfo[node.getIdx()] = true;
            return true;
        } else {
            return false;
        }
    }
}