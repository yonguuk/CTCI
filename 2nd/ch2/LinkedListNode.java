
public class LinkedListNode{
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data){
        this.data = data;
        next = null;
    }
    public LinkedListNode(){
        next = null;
    }
    public void appendToTail(int data){
        next = new LinkedListNode(data);
    }
    
    public void printList(){
        LinkedListNode n = this;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}