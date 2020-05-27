import java.util.NoSuchElementException;

public class MyQueue{
    public static class QueueNode{
        private GraphNode data;
        private QueueNode next;
        public QueueNode(GraphNode data){
            this.data = data;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public void add(GraphNode item){
        QueueNode newNode = new QueueNode(item);
        
        if(last != null)
            last.next = newNode;

        last = newNode;

        if(first == null)
            first = newNode;
    }

    public GraphNode remove(){
        if(first == null) throw new NoSuchElementException();

        GraphNode rData = first.data;
        first = first.next;

        if(first == null)
            last = null;

        return rData;
    }

    public GraphNode peek(){
        if(first == null) throw new NoSuchElementException();

        return first.data;
    }

    public boolean isEmpty(){
        return (first == null) && (last == null);
    }
}