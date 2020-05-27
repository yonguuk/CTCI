import java.util.Random;

//4.11 Solution #7
public class Tree {
    TreeNode root = null;
    public int size(){return root == null ? 0 : root.size();}

    public TreeNode getRandomNode(){
        if(root == null) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value){
        if(root == null){
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        int size = 0;
        public TreeNode(int d){
            data = d;
            size = 1;
        }
        public TreeNode getIthNode(int i){
            int leftSize = left == null ? 0 : left.size();
            if(i<leftSize){
                return left.getIthNode(i);
            } else if(i == leftSize){
                return this;
            } else {
                // leftSize+1 만큼의 노드를 건너뛸 것이므로 빼준다.
                return right.getIthNode(i-(leftSize + 1));
            }
        }

        //이전과 같음
        public void insertInOrder(int d){
            if(d <= data){
                if(left == null)
                    left = new TreeNode(d);
                else
                    left.insertInOrder(d);
            } else {
                if(right == null)
                    right = new TreeNode(d);
                else
                    right.insertInOrder(d);
            }
            size++;
        }
    
        public int size(){return size;}
        public int data(){return data;}
    
        public TreeNode find(int d){
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
}