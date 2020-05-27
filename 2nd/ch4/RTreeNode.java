import java.util.Random;

public class RTreeNode {
    int data;
    RTreeNode left;
    RTreeNode right;
    int size = 0;
    public RTreeNode(int d){
        data = d;
        size = 1;
    }

    public RTreeNode getRandomNode(){
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();

        int index = random.nextInt(size);

        if(index < leftSize){
            return left.getRandomNode();
        } else if(index == leftSize){
            return this;
        } else{
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d){
        if(d <= data){
            if(left == null)
                left = new RTreeNode(d);
            else
                left.insertInOrder(d);
        } else {
            if(right == null)
                right = new RTreeNode(d);
            else
                right.insertInOrder(d);
        }
        size++;
    }

    public int size(){return size;}
    public int data(){return data;}

    public RTreeNode find(int d){
        if(data == d){
            return this;
        } else if(data < d){
            return left != null ? left.find(d) : null;
        } else if(d > data){
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}