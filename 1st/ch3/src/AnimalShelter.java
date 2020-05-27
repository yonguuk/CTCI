public class AnimalShelter{
    public static class QueueNode{
        private String data;
        private QueueNode next;
        public QueueNode(String data){
            this.data = data;
        }
    }
    QueueNode first;
    QueueNode last;

    public AnimalShelter(){
        first = null;
        last = null;
    }
    public void enqueue(String data){
        QueueNode newNode = new QueueNode(data);
        if(isEmpty()){
            first = newNode;
            last = first;
        }
        last.next = newNode;
        last = newNode;
    }

    public String dequeueAny(){
        String rData = null;
        try{
            if(isEmpty())
                throw new Exception("Queue is Empty");

            rData = first.data;
            first = first.next;
            if(first == null)
                last = null;
        } catch(Exception e){
            e.printStackTrace();
        }
        return rData;
    }

    public String dequeueDog(){
        // String rData = null;
        // QueueNode finder = null;
        // QueueNode prev = null;

        // try{
        //     if(isEmpty())
        //         throw new Exception("Queue is Empty");

        //     finder = first;
        //     while(finder != null && !finder.data.equals("dog")){
        //         prev = finder;
        //         finder = finder.next;
        //     }
            
        //     if(finder == null)
        //         throw new Exception("No Left Dogs");
            
        //     rData = finder.data;
        //     prev.next = finder.next;
        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        return dequeueItem("dog");
    }

    public String dequeueCat(){

        return dequeueItem("cat");
    }

    public String peek(){
        try{
            if(isEmpty())
                throw new Exception("Queue is Empty");
        } catch(Exception e){
            e.printStackTrace();
        }
        return first.data;
    }
    public boolean isEmpty(){
        if(first == null && last == null)
            return true;
        else
            return false;
    }

    private String dequeueItem(String name){
        String rData = null;
        QueueNode finder = null;
        QueueNode prev = null;

        try{
            if(isEmpty())
                throw new Exception("Queue is Empty");

            if(first.data.equals(name)){
                rData = first.data;
                first = first.next;
            } else {
                finder = first.next;
                prev = first;
                while(finder != null && !finder.data.equals(name)){
                    prev = finder;
                    finder = finder.next;
                }
                if(finder == null)
                throw new Exception("No Left " + name);
            
                rData = finder.data;
                prev.next = finder.next;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return rData;
    }
}