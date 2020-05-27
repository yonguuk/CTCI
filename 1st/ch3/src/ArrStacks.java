public class ArrStacks{
    private int arrLen;
    private int stackNum;
    private int offset;
    private int[] stackArray;
    private int[] topIdx;

    public ArrStacks(int arrLen, int stackNum){
        this.arrLen = arrLen;
        this.stackNum = stackNum;

        stackArray = new int[this.arrLen];
        topIdx = new int[stackNum];
        this.offset = arrLen/stackNum;

        //Initialize top idx
        for(int i=0; i<stackNum; ++i){
            topIdx[i] = i*offset - 1;
        }
    }

    public void push(int item, int stackNum) throws Exception{
        if(isFull(stackNum)){
            throw new Exception("Array Stack #" + stackNum + " is Full!");
        } else {
            stackArray[++topIdx[stackNum]] = item;
        }
    }

    public int pop(int stackNum) throws Exception{
        if(isEmpty(stackNum))
            throw new Exception("Array Stack #" + stackNum + " is Empty");
        
        return stackArray[topIdx[stackNum]--];
    }

    public int peek(int stackNum) throws Exception{
        if(isEmpty(stackNum))
            throw new Exception("Array Stack #" + stackNum + " is Empty");
        
        return stackArray[topIdx[stackNum]];
    }

    public boolean isEmpty(int stackNum){
        if(topIdx[stackNum] == stackNum*offset - 1)
            return true;
        else
            return false;
    }

    public boolean isFull(int stackNum){
        if(topIdx[stackNum] == (stackNum+1) * offset - 1)
            return true;
        else
            return false;
    }
}
