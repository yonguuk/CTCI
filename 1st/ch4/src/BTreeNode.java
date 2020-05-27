import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class BTreeNode{
    int data;
    int size;
    BTreeNode left;
    BTreeNode right;
    BTreeNode pNode;

    public BTreeNode(int data){
        this.data = data;
        size = 1;
        left = null;
        right = null;
        pNode = null;
    }

    public BTreeNode(){
        size = 1;
        left = null;
        right = null;
        pNode = null;
    }

    public void setLeftSubTree(BTreeNode node){
        left = node;
        node.pNode = this;
    }

    public void setRightSubTree(BTreeNode node){
        right = node;
        node.pNode = this;
    }

    public void insertInOrder(int data){
        if(data <= this.data){
            if(this.left == null)
                this.left = new BTreeNode(data);
            else
                this.left.insertInOrder(data);
        } else {
            if(this.right == null)
                this.right = new BTreeNode(data);
            else
                this.right.insertInOrder(data);
        }

        ++size;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int size(){
        return size;
    }

    private BTreeNode getIthNode(int i){
        int leftSize = left == null ? 0 : left.size;
        if(i < leftSize){
            return left.getIthNode(i);
        } else if(i == leftSize){
            return this;
        } else {
            return right.getIthNode(i-(leftSize+1));
        }
    }
    public BTreeNode getRandomNode(){
        Random random = new Random();
        int i = random.nextInt(size);
        return getIthNode(i);
    }

    public void InorderTraversal(BTreeNode node){
        if(node == null)
            return;

        InorderTraversal(node.left);
        System.out.print(node.data + " ");
        InorderTraversal(node.right);
    }

    public void PreorderTraversal(BTreeNode node){
        if(node == null)
            return;
        System.out.print(node.data + " ");
        PreorderTraversal(node.left);
        PreorderTraversal(node.right);
    }

    public void makeTreeLists(BTreeNode node, ArrayList<LinkedList<BTreeNode>> lists, int level){

        if(node == null)
            return;
        
        //해당 레벨에 리스트가 없다면 -> 레벨의 첫 노드라면 -> 리스트 생성
        if(lists.size() == level)
            lists.add(new LinkedList<>());

        lists.get(level).addLast(node);
        makeTreeLists(node.left, lists, level+1);
        makeTreeLists(node.right, lists, level+1);

    }

    public ArrayList<LinkedList<BTreeNode>> makeTreeListsBFS(BTreeNode root){
        ArrayList<LinkedList<BTreeNode>> lists = new ArrayList<>();
        makeTreeListsBFS(root, lists);
        
        return lists;
    }

    public void makeTreeListsBFS(BTreeNode root, ArrayList<LinkedList<BTreeNode>> lists){
        LinkedList<BTreeNode> current = new LinkedList<>();
        
        if(root != null)
            current.add(root);

        while(current.size() > 0){
            lists.add(current);
            LinkedList<BTreeNode> parents = current;
            current = new LinkedList<>();
            for(BTreeNode parent : parents){
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }
    }

    // public static void makeBST(BTreeNode root, int arr[]){
    //     int mid = arr.length/2;

    //     root.data = arr[mid];
        
    //     for(int i=0; i<arr.length; ++i){
    //         if(i == mid)
    //             continue;
                
    //         BTreeNode node = root;
    //         BTreeNode pNode = null;
    //         while(node != null){
    //             if(arr[i] < node.data){
    //                 pNode = node;
    //                 node = node.left;
    //             } else {
    //                 pNode = node;
    //                 node = node.right;
    //             }
    //         }

    //         node = new BTreeNode(arr[i]);
    //         if(node.data < pNode.data)
    //             pNode.left = node;
    //         else
    //             pNode.right = node;
    //     }
    // }

    public BTreeNode makeLeastHeightBST(int arr[], int left, int right){
        if(left > right)
            return null;
        
        int mid = (left+right)/2;
        BTreeNode node = new BTreeNode(arr[mid]);

        node.left = makeLeastHeightBST(arr, left, mid-1);
        node.right = makeLeastHeightBST(arr, mid+1, right);

        return node;
    }

    // 내가했는데 틀린거
    // public boolean isBST(BTreeNode root){
        
    //     if(root.left == null &&  root.right == null)
    //         return true;

    //     if((root.left != null) && (root.data < root.left.data))
    //         return false;
        
    //     if((root.right != null) && (root.data > root.right.data))
    //         return false;


    //     if(isBST(root.left) && isBST(root.right))
    //         return true;
    //     else
    //         return false;

    // }
    
    Integer last_printed = null;
    public boolean checkBSTInorder(BTreeNode node){
        if(node == null)
            return true;

        if(checkBSTInorder(node.left) == false)
            return false;
        
        if(last_printed != null && node.data < last_printed)
            return false;
        last_printed = node.data;

        if(checkBSTInorder(node.right) == false)
            return false;

        return true;
    }

    public boolean checkBST(BTreeNode node){
        // return checkBSTMinMax(node, null, null);
        return checkBSTInorder(node);
    }

    public boolean checkBSTMinMax(BTreeNode node, Integer min, Integer max){
        if(node == null)
            return true;

        if((min != null && node.data < min) || (max != null && node.data > max))
            return false;

        if(checkBSTMinMax(node.left, min, node.data) == false)
            return false;

        if(checkBSTMinMax(node.right, node.data, max) == false)
            return false;

        return true;
    }

    public static BTreeNode inorderSuccessor(BTreeNode node){

        if(node == null)
            return null;
        
        BTreeNode x = null;
        //오른쪽 하위 트리가 있는경우 -> 하위 트리의 가장 왼쪽 노드
        if(node.right != null){
            x = node.right;
            while(x.left != null)
                x = x.left;
        } 
        //오른쪽 하위 트리가 없는 경우
        else {
            BTreeNode q = node;
            x = node.pNode;

            while(x != null && x.right == q){
                q = x;
                x = x.pNode;
            }
            // //node 가 부모 노드의 왼쪽 노드이면 -> 부모노드 방문할 차례
            // if(q.left == node)
            //     x = q;
            // // node가 부모 노드의 오른쪽 노드이면
            // else{
            //     x = q.pNode;
            //     while(x.right == q){
            //         q = x;
            //         x = x.pNode;
            //         if(x == null)
            //             break;
            //     }
            // }

        }

        return x;
    }
    
    // 4.8 내가 푼거
    public BTreeNode findFirstCommonAncestor(BTreeNode root, BTreeNode n1, BTreeNode n2){
        if(root == null)
            return null;

        if(!findNode(root, n1) || !findNode(root, n2))
            return null;
  
        BTreeNode rNode = root;
        rNode = findAncestor(root, n1, n2);

        if(rNode == null)
            return root;
        else
            return rNode;
    }
    private BTreeNode findAncestor(BTreeNode pNode, BTreeNode n1, BTreeNode n2){
        if(pNode == null)
            return null;

        BTreeNode rNode = null;

        if(findNode(pNode.left, n1) && findNode(pNode.left, n2)){
            rNode = findAncestor(pNode.left, n1, n2);
            if(rNode == null)
                rNode = pNode;
        } else if(findNode(pNode.right, n1) && findNode(pNode.right, n2)){
            rNode = findAncestor(pNode.right, n1, n2);
            if(rNode == null)
                rNode = pNode;
        } else if((pNode.left.data == n1.data && pNode.right.data == n2.data) 
                    || (pNode.left.data == n2.data && pNode.right.data == data)){
            rNode = pNode;
        }

        return rNode;
    }

    public boolean findNode(BTreeNode root, BTreeNode node){
        if(root == null)
            return false;

        if(root == node)
            return true;

        if(findNode(root.left, node) || findNode(root.right, node))
            return true;
        else
            return false;
    }

    //4.8 솔루션 방법 풀이
    class Result{
        public BTreeNode node;
        public boolean isAncestor;
        public Result(BTreeNode n, boolean isAnc){
            node = n;
            isAncestor = isAnc;
        }
    }

    BTreeNode commonAncestor(BTreeNode root, BTreeNode p, BTreeNode q){
        Result r = commonAncestorHelper(root, p, q);
        
        if(r.isAncestor){
            return r.node;
        }

        return null;
    }

    Result commonAncestorHelper(BTreeNode root, BTreeNode p, BTreeNode q){
        if(root == null)
            return new Result(null, false);
        
        if(root == p && root == q){
            return new Result(root, true);
        }

        Result rl = commonAncestorHelper(root.left, p, q);
        if(rl.isAncestor == true){
            return rl;
        }
        Result rr = commonAncestorHelper(root.right, p, q);
        if(rr.isAncestor == true){
            return rr;
        }
        if(rl.node != null && rr.node != null){
            return new Result(root, true);            
        } else if(root == p || root == q){
            boolean isAncestor = rl.node != null || rr.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rl.node != null ? rl.node : rr.node, false);
        }
    }

    // 4.9 미완성
    // public void printBTreeBFS(BTreeNode root){
    //     LinkedList<BTreeNode> nodeList = new LinkedList<>();
    //     if(root == null)
    //         return;
        
    //     nodeList.addFirst(root);

    //     while(!nodeList.isEmpty()){
    //         BTreeNode visitNode = nodeList.removeLast();
    //         printSubTree(visitNode, true);
    //         printSubTree(visitNode, false);

    //         if(visitNode.left != null)
    //             nodeList.addFirst(visitNode.left);
    //         if(visitNode.right != null)
    //             nodeList.addFirst(visitNode.right);
    //     }
    // }
    // public void printSubTree(BTreeNode root, boolean leftFirst){
    //     System.out.print(leftFirst ? root.left.data + " " : root.right.data + " ");
    //     System.out.print(leftFirst ? root.right.data + " " : root.left.data + " ");
    // }

    //4.10 문자열 비교 방식
    // public boolean containsTree(BTreeNode t1, BTreeNode t2){
    //     StringBuilder sb1 = new StringBuilder();
    //     StringBuilder sb2 = new StringBuilder();

    //     getPreorderString(t1, sb1);
    //     getPreorderString(t2, sb2);

    //     return sb1.toString().indexOf(sb2.toString()) >= 0;
    // }

    // public void getPreorderString(BTreeNode node, StringBuilder sb){
    //     if(node == null){
    //         sb.append("x ");
    //         return;
    //     }

    //     sb.append(node.data + " ");
        
    //     getPreorderString(node.left, sb);
    //     getPreorderString(node.right, sb);
    // }

    //4.10 풀이 2
    public boolean containsTree(BTreeNode t1, BTreeNode t2){
        if(t2 == null)
            return true;
        
        return subTree(t1, t2);
    }

    private boolean subTree(BTreeNode t1, BTreeNode t2){
        if(t1 == null){
            return false;
        } else if(t1.data == t2.data && matchTree(t1, t2)){
            return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(BTreeNode t1, BTreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        else if(t1 == null || t2 == null)
            return false;
        
        if(t1.data != t2.data)
            return false;
        else
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

    //4.12 내가푼거
    // class Count{
    //     int num;
    //     public Count(){
    //         num = 0;
    //     }
    // }
    // static Count count = new Count();

    // public int countSumPath(int n){
    //     // Count count = new Count();
    //     countSumPathHelper(n, 0, count);

    //     if(this.left != null){
    //         this.left.countSumPath(n);
    //     }
    //     if(this.right != null){
    //         this.right.countSumPath(n);
    //     }

    //     int result = count.num;
    //     count.num = 0;
    //     return result;
    // }

    // private void countSumPathHelper(int n, int partialSum, Count count){
    //     System.out.println("Cur Node : " + this.data);
    //     System.out.println("Partial Sum : " + (partialSum + this.data));
    //     if(partialSum + this.data == n){
    //         System.out.println("found : " + partialSum);
    //         System.out.println();
    //         ++count.num;
    //         return;
    //     }
    //     System.out.println();

    //     if(this.left != null){
    //         this.left.countSumPathHelper(n, partialSum + this.data, count);
    //     }
        
    //     if(this.right != null){
    //         this.right.countSumPathHelper(n, partialSum + this.data, count);
    //     }
    // }
    
    //4.12 풀이 - 무식한 방법
    // public int countPathsWithSum(BTreeNode root, int targetSum){
    //     if(root == null)
    //         return 0;
        
    //     int countFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
    //     int countFromLeft = 0;
    //     int countFromRight = 0;

    //     if(root.left != null){
    //         countFromLeft = countPathsWithSum(root.left, targetSum);
    //     }
    //     if(root.right != null){
    //         countFromRight = countPathsWithSum(root.right, targetSum);
    //     }

    //     return countFromRoot + countFromLeft + countFromRight;
    // }

    // public int countPathsWithSumFromNode(BTreeNode node, int targetSum, int currentSum){
    //     int count = 0;
    //     currentSum += node.data;
    //     System.out.println("Current Node : " + node.data);
    //     System.out.println("currnet Sum : " + currentSum);
    //     if(currentSum == targetSum){
    //         ++count;
    //         System.out.println("found");
    //         System.out.println();
    //     }
    //     System.out.println();
    //     if(node.left != null){
    //         count += countPathsWithSumFromNode(node.left, targetSum, currentSum);
    //     }

    //     if(node.right != null){
    //         count += countPathsWithSumFromNode(node.right, targetSum, currentSum);
    //     }

    //     return count;
    // }

    //4.12 풀이 - 최적화

}