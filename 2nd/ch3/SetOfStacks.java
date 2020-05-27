import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<T> {
    ArrayList<Stack<T>> stacks;
    int stackSize;
    int numStacks;

    public SetOfStacks(int stackSize){
        stacks = new ArrayList<>();
        stacks.add(new Stack<T>());
        numStacks = 1;
        this.stackSize = stackSize;
    }

    public void push(T data){
        if(getCurrentStack().size() == stackSize){
            stacks.add(new Stack<T>());
            ++numStacks;
        }
        getCurrentStack().push(data);
    }

    public T pop() throws Exception{
        if(isEmpty()){
            throw new Exception("SetOfStacks is Empty");
        }
        T popData = getCurrentStack().pop();
        if(getCurrentStack().isEmpty() && numStacks != 1){
            stacks.remove(numStacks-1);
            --numStacks;
        }
        return popData;
    }

    public boolean isEmpty(){
        return numStacks == 1 && getCurrentStack().isEmpty();
    }

    public int getStackNum(){
        return numStacks;
    }
    private Stack<T> getCurrentStack(){
        return stacks.get(numStacks-1);
    }
}

//3.3 Solution
// public class SetOfStacks{
//     ArrayList stacks = new ArrayList():
//     public int capacity;
//     public SetOfStacks(int capacity){
//         this.capacity = capacity;
//     }

//     public Stack getLastStack(){
//         if(stacks.size() == 0) return null;
//         return stacks.get(stacks.size() -1);
//     }
    
//     void push(int v){
//         Stack last = getLastStack();
//         if(last != null && !last.isFull()){
//             last.push(v);
//         } else {
//             Stack stack = new Stack(capacity);
//             stack.push(v);
//             stacks.add(stack);
//         }
//     }

//     int pop(){
//         Stack last = getLastStack();
//         if(last == null) throw new EmptyStackException();
//         int v = last.pop();
//         if(last.size == 0) stacks.remove(stacks.size() - 1);
//         return v;
//     }

//     public boolean isEmpty(){
//         Stack last = getLastStack();
//         return last == null || last.isEmpty();
//     }

//     public int popAt(int index){
//         return leftShift(index, true);
//     }

//     public int leftShift(int index, boolean removeTop){
//         Stack stack = stacks.get(index);
//         int removed_item;
//         if(removeTop) removed_item = stack.pop();
//         else removed_item = stack.removeBottom();
//         if(stack.isEmpty()){
//             stacks.remove(index);
//         } else if(stacks.size() > index + 1){
//             int v = leftShift(index + 1, false);
//             stack.push(v);
//         }
//         return removed_item;
//     }
// }

// public class Stack{
//     private int capacity;
//     public Node top, bottom;
//     public int size;

//     public Stack(int capacity){this.capacity = capacity;}
//     public boolean ifFull(){return capacity == size;}

//     public void join(Node above, Node below){
//         if(below != null) below.above = above;
//         if(above != null) above.below = below;
//     }

//     public boolean push(int v){
//         if(sizw >= capacity) return false;
//         size++;
//         Node n = new Node(v);
//         if(size == 1) bottom = n;
//         join(n, top);
//         top = n;
//         return false;
//     }

//     public int pop(){
//         Node t = top;
//         top = top.below;
//         size--;
//         return t.value;
//     }

//     public boolean isEmpty(){
//         return size == 0;
//     }

//     public int removeBottom(){
//         Node b = bottom;
//         bottom = bottom.above;
//         if(bottom != null) bottom.below = null;
//         size--;
//         return b.value;
//     }
// }