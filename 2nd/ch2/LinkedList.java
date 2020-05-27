
public class LinkedList {
    Node head;

    public LinkedList(){
        head = null;
    }

    public void appendToTail(int data){
        Node nNode = new Node(data);

        if(head == null){
            head = nNode;
            return;
        }
        Node n = head;
        while(n.next != null){
            n = n.next;
        }
        n.next = nNode;
    }
    public void printListElem(){
        Node n = head;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}