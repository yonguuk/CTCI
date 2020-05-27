import java.util.NoSuchElementException;

public class MyQueue{
    public static class QueueNode{
        private String data;
        private QueueNode next;
        public QueueNode(String data){
            this.data = data;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public void add(String item){
        QueueNode newNode = new QueueNode(item);
        
        if(last != null)
            last.next = newNode;

        last = newNode;

        if(first == null)
            first = newNode;
    }

    public String remove(){
        if(first == null) throw new NoSuchElementException();

        String rData = first.data;
        first = first.next;

        if(first == null)
            last = null;

        return rData;
    }

    public String peek(){
        if(first == null) throw new NoSuchElementException();

        return first.data;
    }

    public boolean isEmpty(){
        return (first == null) && (last == null);
    }
}