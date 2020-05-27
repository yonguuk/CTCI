
public class LinkedList{
    Node head;

    public LinkedList(){
        head = null;
    }

    public void appendToTail(int data){
        Node n = head;
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;
        else{
            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public void appendToHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public Node delNode(int data){
        Node n = this.head;
        if(n.data == data){
            head = head.next;
            return n;
        }

        while(n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    public Node delNode(Node head, int data){
        Node n = head;
        if(n.data == data){
            head = head.next;
            return n;
        }

        while(n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    public void printListData(){
        Node n = head;
        while(n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println("");
    }

    public Node getHead(){
        return head;
    }

    public void setHead(Node node){
        this.head = node;
    }
}