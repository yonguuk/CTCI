import java.util.ArrayList;

public class SetOfStacks2{
    ArrayList<MyStack> stacks = new ArrayList<>();

    public void push(int item){
        MyStack stack = getLastStack();
        if(stack != null && !stack.isFull()){
            stack.push(item);
        } else {
            MyStack nStack = new MyStack();
            nStack.push(item);
            stacks.add(nStack);
        }
    }

    public int pop() throws Exception{
        MyStack stack = getLastStack();
        if(stack == null)
            throw new Exception("Stack is Empty");

        int popData = stack.pop();

        if(stack.isEmpty())
            stacks.remove(stacks.size()-1);
        
        return popData;
    }

    public int peek() throws Exception{
        MyStack stack = getLastStack();
        if(stack == null)
            throw new Exception("Stack is Empty");

        return stack.peek();
    }

    public int popAt(int index){
        return 0;
    }

    private MyStack getLastStack(){
        if(stacks.size() == 0)
            return null;
        return stacks.get(stacks.size()-1);
    }
}