
//3.2
public class MinStack {
    int stackSize;
    int[] values;
    int[] minIdx;
    int top;

    public MinStack(int size){
        stackSize = size;
        values = new int[size];
        minIdx = new int[size];
        top = -1;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack is Full");
        } else {
            ++top;
            values[top] = data;
            if(top == 0){
                minIdx[top] = 0;
            } else {
                if(data < values[top-1])
                    minIdx[top] = top;
                else
                    minIdx[top] = minIdx[top-1];
            }
        }
    }

    public int pop(){
        try{
            if(isEmtpy()){
                throw new Exception("Stack is Empty");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        int rData = values[top];
        values[top] = 0;
        minIdx[top] = 0;
        --top;

        return rData;
    }

    public boolean isEmtpy(){
        return top == -1;
    }

    public int min(){
        if(isEmtpy())
            return Integer.MIN_VALUE;
        else
            return values[minIdx[top]];
    }

    public boolean isFull(){
        return top == stackSize-1;
    }
}

// 3.3 Solution #1
// public class StackWithMin extends Stack{
//     public void push(int value){
//         int newMin = Math.min(value, min());
//         super.push(new NodeWithMin(value, newMin));
//     }

//     public int min(){
//         if(this.isEmpty()){
//             return Integer.MAX_VALUE;
//         } else {
//             return peek().min;
//         }
//     }

//     class NodeWithMin{
//         public int value;
//         public int min;
//         public NodeWithMin(int v, int min){
//             value = v;
//             this.min = min;
//         }
//     }
// }

//3.3 Solution #2
// public class StackWithMin2 extends Stack{
//     Stack s2;
//     public StackWithMin2(){
//         s2 = new Stack();
//     }

//     public void push(int value){
//         if(value <= min()){
//             s2.push(value);
//         }
//         super.push(value);
//     }
    
//     public Integer pop(){
//         int value = super.pop();
//         if(value == min()){
//             s2.pop();
//         }
//         return value;
//     }

//     public int min(){
//         if(s2.isEmpty()){
//             return Integer.MAX_VALUE;
//         } else {
//             return s2.peek();
//         }
//     }
// }