public class StackWithMin extends MyStack{
    MyStack minStack = new MyStack();

    @Override
    public void push(int item) {
        super.push(item);
        if(minStack.isEmpty())
            minStack.push(item);
        
        try{
            if(item < getMin())
                minStack.push(item);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int pop() throws Exception {
        // TODO Auto-generated method stub
        if(getMin() == peek())
            minStack.pop();
        return super.pop();
    }

    public int getMin() throws Exception{
        return minStack.peek();
    }
}