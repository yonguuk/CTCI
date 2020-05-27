import jdk.nashorn.internal.runtime.NumberToString;

public class SetOfStacks{
    private static final int MAX_STACK_NUM = 5;
    MyStack stacks[];
    int numStack;
    int numItem;
    int stackSize;

    public SetOfStacks(int stackSize){
        stacks = new MyStack[MAX_STACK_NUM];
        numStack = 1;
        this.stackSize = stackSize;

        stacks[numStack-1] = new MyStack();
    }

    public void push(int item) throws Exception{
         // Current Stack is full
        if(!isEmpty() && numItem%stackSize == 0){
            //Create new stack
            ++numStack;
            if(numStack >= MAX_STACK_NUM)
                throw new Exception("Max Stack Num Exception");

            stacks[numStack-1] = new MyStack();
            System.out.println("Create New Stack");
        }

        getCurStack().push(item);
        ++numItem;
    }

    public int pop()throws Exception{
        int item = getCurStack().pop();
        --numItem;

        if(!isEmpty() && numItem%stackSize == 0)
            --numStack;
        return item;
    }

    public int peek()throws Exception{
        return getCurStack().peek();
    }

    public boolean isEmpty(){
        if(numItem == 0)
            return true;
        else
            return false;
    }
    // private MyStack getCurStack() throws Exception{
    //     if(!isEmpty() && numItem%stackSize == 0){
    //         ++numStack;
    //         if(numStack >= MAX_STACK_NUM)
    //             throw new Exception("Max Stack Num Exception");

    //         stacks[numStack-1] = new MyStack();
    //         System.out.println("Create New Stack");
    //         return stacks[numStack-1];
    //     } else {
    //         return stacks[numStack-1];
    //     }
    // }

    private MyStack getCurStack(){
        return stacks[numStack-1];
    }


}