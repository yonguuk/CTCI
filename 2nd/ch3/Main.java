
public class Main {
    public static void main(String[] args) {
    //     FixedMultiStack stack = new FixedMultiStack(100);

    //     int n = 0;
    //     for(int i=1; i<100; ++i){
    //         if(!stack.isFull(n)){
    //             stack.push(n, i);
    //         } else {
    //             ++n;
    //         }
    //     }

    //     for(int i=2; i>=0; --i){
    //         while(!stack.isEmpty(i)){
    //             System.out.println(stack.pop(i));
    //         }
    //     }

        //3.2
        // MinStack stack = new MinStack(10);
        // stack.push(5);
        // stack.push(6);
        // stack.push(3);
        // stack.push(2);
        // stack.push(7);
        // stack.push(1);

        // System.out.println("Min : " + stack.min());

        // while(!stack.isEmtpy()){
        //     System.out.println("Pop : " + stack.pop() + " Min : " + stack.min());
        // }

        //3.3
        // SetOfStacks<Integer> stack = new SetOfStacks<>(5);
        // for(int i = 1; i<33; ++i){
        //     stack.push(i);
        //     System.out.println("Data : " + i + " stack num : " + stack.getStackNum());
        // }

        // try{
        //     while(!stack.isEmpty()){
        //         System.out.println("Stack num : " + stack.getStackNum() + " Pop Data : " + stack.pop());
        //     }
        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        //3.4
        // TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        // for(int i=1; i<30; ++i){
        //     queue.add(i);
        // }

        // try{
        //     while(!queue.isEmpty()){
        //         System.out.println(queue.remove());
        //     } 
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        //3.5
        StackSort stack = new StackSort();
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(3);

        stack.stackSort();

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}