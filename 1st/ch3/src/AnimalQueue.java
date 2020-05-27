import java.util.LinkedList;

public class AnimalQueue{
    LinkedList<Animal> dogs = new LinkedList<>();
    LinkedList<Animal> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(order++);

        if(a instanceof Dog)
            dogs.add(a);
        else if(a instanceof Cat)
            cats.add(a);
    }

    public Animal dequeueAny(){
        try{
            if(isEmpty())
                throw new Exception("Queue is empty");
        } catch (Exception e){
            e.printStackTrace();
        }

        if(dogs.size() == 0)
            return cats.removeFirst();
        else if(cats.size() == 0)
            return cats.removeFirst();
        else if(dogs.peekFirst().isOlderThan(cats.peekFirst()))
            return dogs.removeFirst();
        else
            return cats.removeFirst();

    }

    public Animal dequeueDog(){
        try{
            if(dogs.size() == 0)
                throw new Exception("Dogs list is empty");
        } catch (Exception e){
            e.printStackTrace();
        }

        return dogs.removeFirst();
    }

    public Animal dequeueCat(){
        try{
            if(cats.size() == 0)
                throw new Exception("Cats list is empty");
        } catch (Exception e){
            e.printStackTrace();
        }

        return cats.removeFirst();
    }

    public boolean isEmpty(){
        if(dogs.size() == 0 && cats.size() == 0)
            return true;
        else
            return false;
    }
}