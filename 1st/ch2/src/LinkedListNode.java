public class LinkedListNode{

    int data;
    LinkedListNode next;

    public LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(){
        this.next = null;
    }

    public void setData(int data){
        this.data = data;
    }

    public void appendToTail(int data){
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }

    public void printListNode(){
        LinkedListNode n = this;
        while(n != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }

    public int getLength(){
        int count = 0;
        LinkedListNode n = this;
        while(n != null){
            ++count;
            n = n.next;
        }
        return count;
    }

}