import java.util.EmptyStackException;

//3.1
// My Code
public class FixedMultiStack {
    int[] stackArr;
    int[] startIdx;
    int[] top;

    public FixedMultiStack(int size){
        stackArr = new int[size];
        startIdx = new int[3];
        top = new int[3];

        startIdx[0] = 0;
        startIdx[1] = size/3;
        startIdx[2] = 2*(size/3);

        top[0] = startIdx[0];
        top[1] = startIdx[1];
        top[2] = startIdx[2];
    }

    public void push(int stackNum, int data){
        if(isFull(stackNum)){
            System.out.println("Stack " + stackNum + " is Full!");
            return;
        } else {
            ++top[stackNum];
            stackArr[top[stackNum]] = data;
        }
    }
    
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("Stack " + stackNum + " is Empty");
            throw new EmptyStackException();
        } else {
            int rData = stackArr[top[stackNum]];
            --top[stackNum];
            return rData;
        }
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("Stack " + stackNum + " is Empty");
            throw new EmptyStackException();
        } else {
            return stackArr[top[stackNum]];
        }
    }

    public boolean isEmpty(int stackNum){
        if(top[stackNum] == startIdx[stackNum])
            return true;
        else
            return false;
    }
    public boolean isFull(int stackNum){
        return top[stackNum] == (startIdx[stackNum] + (stackArr.length)/3 - 1);
    }

}

// Solution
// public class FixedMultiStack{
//     private int numberOfStacks = 3;
//     private int stackCapacity;
//     private int[] values;
//     private int[] sizes;

//     public FixedMultiStack(int stackSize){
//         stackCapacity = stackSize;
//         values = new int[stackSize * numberOfStacks];
//         sizes = new int[numberOfStacks];
//     }

//     public void push(int stackNum, int value) throws FullStackException{
//         if(isFull(stackNum)){
//             throw new FullStackException();
//         }
//         sizes[stackNum]++;
//         values[indexOfTop(stackNum)] = value;
//     }

//     public int pop(int stackNum){
//         if(isEmpty(stackNum)){
//             throw new EmptyStackException();
//         }
//         int topIndex = indexOfTop(stackNum);
//         int value = values[topIndex];
//         values[topIndex] = 0;
//         sizes[stackNum]--;
//         return value;
//     }

//     public int peek(int stackNum){
//         if(isEmpty(stackNum)){
//             throw new EmptyStackException();
//         }
//         return values[indexOfTop(stackNum)];
//     }
//     public boolean isEmpty(int stackNum){
//         return sizes[stackNum] == 0;
//     }

//     public boolean isFull(int stackNum){
//         return sizes[stackNum] == stackCapacity;
//     }

//     private int indexOfTop(int stackNum){
//         int offset = stackNum * stackCapacity;
//         int size = sizes[stackNum];
//         return offset + size - 1;
//     }
// }