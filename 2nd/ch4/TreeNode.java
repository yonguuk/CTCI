
public class TreeNode {
    int value;
    TreeNode left, right, parent;
    
    public TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }    
    public TreeNode(){
        this.value = Integer.MIN_VALUE;
        left = null;
        right = null;
    }
}