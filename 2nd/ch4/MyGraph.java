import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {
    LinkedList<GraphNode> nodes;
    int numNodes;
    public MyGraph(){
        nodes = new LinkedList<>();
        numNodes = 0;
    }
    public void makeNode(int value){
        nodes.add(new GraphNode(value));
        ++numNodes;
    }

    public void addPath(GraphNode from, GraphNode to){
        from.adjList.add(to);
    }

    public void addPathBoth(GraphNode n1, GraphNode n2){
        n1.adjList.add(n2);
        n2.adjList.add(n1);
    }

    //4.1
    public boolean isConnected(GraphNode from, GraphNode to){
        if(from == to) return true;
        if(from == null || to == null) return false;

        Queue<GraphNode> queue = new LinkedList<>();
        from.visited = true;
        queue.add(from);

        while(!queue.isEmpty()){
            GraphNode n = queue.remove();
            
            for(GraphNode adj : n.adjList){
                if(adj.equals(to)){
                    return true;
                } else if(adj.visited == false){
                    adj.visited = true;
                    queue.add(adj);
                }
            }
            
        }
        resetVisitInfo();
        return false;
    }

//4.1 Solution
// enum State{Unvisited, Visited, Visiting;}

// boolean search(Graph g, Node start, Node end){
//     if(start == end) return true;

//     LinkedList q = new LinkedList();

//     for(Node u : g.getNodes()){
//         u.state = State.Unvisited;
//     }

//     start.state = State.Visiting;
//     q.add(start);
//     Node u;
//     While(!q.isEmpty()){
//         u = q.removeFirst();
//         if(u != null){
//             for(Node v : u.getAdjacent()){
//                 if(v.state == State.Unvisited){
//                     if(v == end){
//                         return true;
//                     } else {
//                         v.state = State.Visiting;
//                         q.add(v);
//                     }
//                 }
//             }
//             u.state = State.Visited;
//         }
//     }
//     return false;
// }

    public void resetVisitInfo(){
        for(GraphNode n : nodes){
            n.visited = false;
        }
    }
}