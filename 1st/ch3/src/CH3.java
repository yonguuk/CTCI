public class CH3{
    public static void main(String[] args) {
        //3.1
        // ArrStacks arrStacks = new ArrStacks(100, 3);
        // try{
        //     arrStacks.push(1, 0);
        //     arrStacks.push(2, 0);
        //     arrStacks.push(3, 0);
    
        //     arrStacks.push(4, 1);
        //     arrStacks.push(5, 1);
        //     arrStacks.push(6, 1);
    
        //     arrStacks.push(7, 2);
        //     arrStacks.push(8, 2);
        //     arrStacks.push(9, 2);
    
        //     System.out.println("Pop #1 : " + arrStacks.pop(0));
        //     System.out.println("Pop #2 : " + arrStacks.pop(1));
        //     System.out.println("Pop #3 : " + arrStacks.pop(2));


        //     System.out.println("\nPop #1 : " + arrStacks.pop(0));
        //     System.out.println("Pop #2 : " + arrStacks.pop(1));
        //     System.out.println("Pop #3 : " + arrStacks.pop(2));

        //     System.out.println("\nPop #1 : " + arrStacks.pop(0));
        //     System.out.println("Pop #2 : " + arrStacks.pop(1));
        //     System.out.println("Pop #3 : " + arrStacks.pop(2));

        //     System.out.println("\nPop #1 : " + arrStacks.pop(0));
        //     System.out.println("Pop #2 : " + arrStacks.pop(1));
        //     System.out.println("Pop #3 : " + arrStacks.pop(2));
        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        //3.2
        // StackWithMin stack = new StackWithMin();
        // stack.push(3);

        // try{
        //     System.out.println("Min : " + stack.getMin());
        //     stack.push(2);
        //     System.out.println("Min : " + stack.getMin());            
        //     stack.push(1);
        //     System.out.println("Min : " + stack.getMin());            

        //     System.out.println("Pop : " + stack.pop());
        //     System.out.println("Min : " + stack.getMin());            

        //     System.out.println("Pop : " + stack.pop());
        //     System.out.println("Min : " + stack.getMin());    

        //     System.out.println("Pop : " + stack.pop());
        //     System.out.println("Min : " + stack.getMin());

        // } catch(Exception e){
        //     e.printStackTrace();
        // }
        
        //3.3
        // SetOfStacks2 stack = new SetOfStacks2();
        // try{
        //     stack.push(1);
        //     stack.push(2);
        //     stack.push(3);
        //     stack.push(4);
        //     stack.push(5);
        //     stack.push(6);
        //     stack.push(7);
        //     stack.push(8);
        //     stack.push(9);
        //     stack.push(10);
        //     stack.push(11);

        //     for(int i=0; i<11; i++){
        //         System.out.println("Pop : " + stack.pop());
        //     }

        //     stack.push(1);
        //     stack.push(2);
        //     stack.push(3);
        //     stack.push(4);
        //     stack.push(5);
        //     stack.push(6);
        //     stack.push(7);
        //     stack.push(8);
        //     stack.push(9);
        //     stack.push(10);
        //     stack.push(11);

        //     for(int i=0; i<11; i++){
        //         System.out.println("Pop : " + stack.pop());
        //     }

        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        //3.4
        // QueueWithTwoStack queue = new QueueWithTwoStack();
        // try{
        //     queue.add(1);
        //     queue.add(2);
        //     queue.add(3);
        //     queue.add(4);
        //     queue.add(5);
    
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());

        //     queue.add(1);
        //     queue.add(2);
        //     queue.add(3);
        //     queue.add(4);
        //     queue.add(5);
    
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        //     System.out.println("remove : " + queue.remove());
        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        //3.5
        // MyStack stack = new MyStack();
        // try{
        //     stack.push(5);
        //     stack.push(2);
        //     stack.push(4);
        //     stack.push(1);
        //     stack.push(3);

        //     sortStack(stack);
            
        //     while(!stack.isEmpty()){
        //         System.out.println("Pop : " + stack.pop());
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        //3.6
        // AnimalShelter shelter = new AnimalShelter();
        // shelter.enqueue("cat");
        // shelter.enqueue("cat");
        // shelter.enqueue("dog");
        // shelter.enqueue("cat");
        
        // System.out.println("Dequeue Cat : " + shelter.dequeueCat() + "\n");
        // System.out.println("Dequeue Cat : " + shelter.dequeueCat() + "\n");
        // System.out.println("Dequeue Dog : " + shelter.dequeueDog() + "\n");

        // while(!shelter.isEmpty())
        //     System.out.println("Dequeue Any : " + shelter.dequeueAny());

        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(new Cat("cat1"));
        queue.enqueue(new Dog("dog1"));
        queue.enqueue(new Cat("cat2"));
        queue.enqueue(new Cat("cat3"));
            
        // System.out.println("Dequeue Any : " + queue.dequeueAny().getName());
        // System.out.println("Dequeue Any : " + queue.dequeueAny().getName());
        // System.out.println("Dequeue Any : " + queue.dequeueAny().getName());
        System.out.println("Dequeue Cat : " + queue.dequeueCat().getName());
        System.out.println("Dequeue Cat : " + queue.dequeueCat().getName());
        System.out.println();
        while(!queue.isEmpty()){
            System.out.println("Dequeue Any : " + queue.dequeueAny().getName());
        }
    }

    // public static MyStack sortStack(MyStack stack) throws Exception{
    //     MyStack tempStack = new MyStack();
    //     int elem = 0;

    //     while(!stack.isEmpty()){
    //         elem = stack.pop();

    //         if(tempStack.isEmpty()){
    //             tempStack.push(elem);
    //         } else {
    //             while(!tempStack.isEmpty()){
    //                 if(tempStack.peek() >= elem){
    //                     tempStack.push(elem);
    //                     break;
    //                 } else {
    //                     stack.push(tempStack.pop());
    //                 }
    //             } //Inner While
    //             if(tempStack.isEmpty())
    //                 tempStack.push(elem);
    //         }
    //     } // Outer while
    //     stack = tempStack;
    //     return stack;

    // } // End Of Method

    public static void sortStack(MyStack stack) throws Exception{
        MyStack tempStack = new MyStack();
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > tmp){
                stack.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }

        while(!tempStack.isEmpty())
            stack.push(tempStack.pop());
    }

}