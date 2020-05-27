import java.util.Stack;

//3.4 my code
public class TwoStackQueue<T> {
    Stack<T> pushStack;
    Stack<T> popStack;

    public TwoStackQueue(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void add(T data){
        while(!popStack.isEmpty()){
            pushStack.push(popStack.pop());
        }
        pushStack.push(data);
    }

    public T remove() throws Exception{
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        if(popStack.isEmpty()){
            throw new Exception("Queue is Empty");
        } else {
            return popStack.pop();
        }
    }

    public T peek() throws Exception{
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        if(popStack.isEmpty()){
            throw new Exception("Queue is Empty");
        } else {
            return popStack.peek();
        } 
    }

    public boolean isEmpty(){
        return pushStack.isEmpty() == true && popStack.isEmpty() == true;
    }
}

// 3.4 Solution
// public class MyQueue{
//     Stack stackNewest, stackOldest;

//     public MyQueue(){
//         stackNewest = new Stack();
//         stackOldest = new Stack();
//     }

//     public int size(){
//         return stackNewest.size() + stackOldest.size();
//     }

//     public void add(T value){
//         stackNewest.push(value);
//     }

//     private void shiftStacks(){
//         if(stackOldest.isEmpty()){
//             while(!stackNewest.isEmpty()){
//                 stackOldest.push(stackNewest.pop);
//             }
//         }
//     }

//     public T peek(){
//         shiftStacks();
//         return stackOldest.peek();
//     }

//     public T remove(){
//         shiftStack();
//         return stackOldest.pop();
//     }
// }