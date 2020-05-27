import java.util.Stack;

//3.5
//My code
public class StackSort {
    Stack<Integer> stack;
    Stack<Integer> buffer;

    public StackSort(){
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void push(int data){
        stack.push(data);
    }

    public int pop(){
        return stack.pop();
    }

    public void stackSort(){
        while(!stack.isEmpty()){
            int data = stack.pop();

            if(buffer.isEmpty()){
                buffer.push(data);
            } else {
                while(!buffer.isEmpty()){
                    if(data < buffer.peek())
                        stack.push(buffer.pop());
                    else
                        break;
                }
                buffer.push(data);
            }
        }

        while(!buffer.isEmpty()){
            stack.push(buffer.pop());
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}