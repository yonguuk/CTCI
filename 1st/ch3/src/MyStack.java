import java.util.EmptyStackException;

public class MyStack{
    // private static class StackNode{
    //     private String data;
    //     private StackNode next;
    //     public StackNode(String data){
    //         this.data = data;
    //     }
    // }

    // private StackNode top;
    // private static int min;

    // public String pop() throws Exception{
    //     if(top == null)
    //         throw new Exception("Stack is Empty");
    //     String item = top.data;
    //     top = top.next;
    //     return item;
    // }

    // public void push(String item){
    //     StackNode newNode = new StackNode(item);
    //     newNode.next = top;
    //     top = newNode;
    // }

    // public String peek() throws Exception{
    //     if(top == null) throw new Exception("Stack is Empty");

    //     return top.data;
    // }

    // public boolean isEmpty(){
    //     return top == null;
    // }
//////////////////////////////////////////////////////////
    private static class StackNode{
        private int data;
        private StackNode next;
        public StackNode(int data){
            this.data = data;
        }
    }

    private StackNode top;
    private int itemCount = 0;

    public int pop() throws Exception{
        if(top == null)
            throw new Exception("Stack is Empty");
        int item = top.data;
        top = top.next;
        --itemCount;
        return item;
    }

    public void push(int item){
        StackNode newNode = new StackNode(item);
        newNode.next = top;
        top = newNode;
        ++itemCount;
    }

    public int peek() throws Exception{
        if(top == null) throw new Exception("Stack is Empty");

        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public boolean isFull(){
        if(itemCount >= 5)
            return true;
        else
            return false;
    }
}