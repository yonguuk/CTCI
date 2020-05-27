public class QueueWithTwoStack{
    MyStack newestStack = new MyStack();
    MyStack oldestStack = new MyStack();

    public void add(int item){
        newestStack.push(item);
    }

    public int remove() throws Exception{
        if(oldestStack.isEmpty())
            fillOldestStack();
        return oldestStack.pop();
    }

    public int peek() throws Exception{
        if(oldestStack.isEmpty())
            fillOldestStack();
        return oldestStack.peek();
    }

    private void fillOldestStack() throws Exception{
        while(!newestStack.isEmpty()){
            oldestStack.push(newestStack.pop());
        }
    }
}