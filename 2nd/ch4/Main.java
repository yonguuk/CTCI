import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CH4 ch4 = new CH4();
    //     MyGraph graph = new MyGraph();

    //     //4.1
    //     for(int i=0; i<5; ++i){
    //         graph.makeNode(i);
    //     }

    //     graph.addPathBoth(graph.nodes.get(0), graph.nodes.get(1));
    //     graph.addPathBoth(graph.nodes.get(1), graph.nodes.get(2));
    //     graph.addPathBoth(graph.nodes.get(1), graph.nodes.get(3));
    //     // graph.addPathBoth(graph.nodes.get(3), graph.nodes.get(4));

    //     if(graph.isConnected(graph.nodes.get(0), graph.nodes.get(4)))
    //         System.out.println("Connected");
    //     else
    //         System.out.println("Not Connected");

        //4.2
        // TreeNode root = new TreeNode();
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // root = ch4.makeBST(arr);
        // ch4.inOrderTraversal(root);

        //4.3
        // TreeNode root = new TreeNode();
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // root = ch4.makeBST(arr);
        // ArrayList<LinkedList<TreeNode>> treeList = new ArrayList<>();
        // // ch4.makeList(root, treeList, 0);
        // treeList = ch4.createLevelLinkedList(root);
        // for(LinkedList<TreeNode> list : treeList){
        //     for(TreeNode n : list){
        //         System.out.print(n.value + " ");
        //     }
        //     System.out.println();
        // }


        //4.4
        // TreeNode root = new TreeNode();
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // root = ch4.makeBST(arr);
        // ArrayList<LinkedList<TreeNode>> treeList = new ArrayList<>();
        // treeList = ch4.createLevelLinkedList(root);
        // for(LinkedList<TreeNode> list : treeList){
        //     for(TreeNode n : list){
        //         System.out.print(n.value + " ");
        //     }
        //     System.out.println();
        // }
        // if(ch4.isBalanced(root))
        //     System.out.println("balanced");
        // else
        //     System.out.println("unbalanced");

        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(3);
        // TreeNode n4 = new TreeNode(4);
        // TreeNode n5 = new TreeNode(5);
        // TreeNode n6 = new TreeNode(6);
        // TreeNode n7 = new TreeNode(7);
        // TreeNode n8 = new TreeNode(8);
        // TreeNode n9 = new TreeNode(9);

        // n1.left = n2;
        // n1.right = n3;
        // n2.left = n4;
        // n2.right = n5;
        // n3.left = n6;
        // n3.right = n7;
        // n7.right = n8;
        // n8.right = n9;

        // ArrayList<LinkedList<TreeNode>> treeList = new ArrayList<>();
        // treeList = ch4.createLevelLinkedList(n1);
        // for(LinkedList<TreeNode> list : treeList){
        //     for(TreeNode n : list){
        //         System.out.print(n.value + " ");
        //     }
        //     System.out.println();
        // }
        // if(ch4.isBalanced(n1))
        //     System.out.println("balanced");
        // else
        //     System.out.println("unbalanced");

        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(3);
        // TreeNode n4 = new TreeNode(4);
        // TreeNode n5 = new TreeNode(5);
        // TreeNode n6 = new TreeNode(6);
        // TreeNode n7 = new TreeNode(7);
        // TreeNode n8 = new TreeNode(8);
        // TreeNode n9 = new TreeNode(9);

        // n1.left = n2;
        // n1.right = n3;
        // n2.left = n4;
        // n2.right = n5;
        // n3.left = n6;
        // n3.right = n7;
        // n7.right = n8;
        // n8.right = n9;

        // if(ch4.checkBST_BFS(n1))
        //     System.out.println("Is BST");
        // else
        //     System.out.println("Not BST");

        // TreeNode root = new TreeNode();
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // root = ch4.makeBST(arr);

        // if(ch4.checkBST_BFS(root))
        //     System.out.println("Is BST");
        // else
        //     System.out.println("Not BST");


        //4.8
        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(3);
        // TreeNode n4 = new TreeNode(4);
        // TreeNode n5 = new TreeNode(5);
        // TreeNode n6 = new TreeNode(6);
        // TreeNode n7 = new TreeNode(7);
        // TreeNode n8 = new TreeNode(8);
        // TreeNode n9 = new TreeNode(9);

        // n1.left = n2;
        // n1.right = n3;
        // n2.left = n4;
        // n2.right = n5;
        // n3.left = n6;
        // n3.right = n7;
        // n7.right = n8;
        // n8.right = n9;

        // TreeNode result = ch4.findFirstCommonAncestor(n1, n6, n9);
        // System.out.println(result.value);


    
        //4.12
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(10);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(ch4.countPathsWithSum(n1, 14));

    }//main


}