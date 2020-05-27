import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CH4 {

    public static void main(String[] args) {

        // 4.1
        // Graph graph = new Graph(6);
        // graph.addEdge(0, 1, true);
        // graph.addEdge(0, 2, true);
        // graph.addEdge(0, 3, true);
        // graph.addEdge(1, 2, true);
        // graph.addEdge(2, 3, true);
        // graph.addEdge(3, 4, true);
        // graph.addEdge(4, 5, true);

        // graph.printVertexInfo();

        // if(graph.isConnectedVertex(0, 5))
        // System.out.println("Connected");
        // else
        // System.out.println("No");

        // 4.2
        // int arr[] = {1,2,3,4,5,6,7};
        // BTreeNode root = new BTreeNode();
        // root = root.makeLeastHeightBST(arr, 0, arr.length-1);
        // root.InorderTraversal(root);

        // 4.3
        // BTreeNode root = new BTreeNode(0);
        // BTreeNode n1 = new BTreeNode(1);
        // BTreeNode n2 = new BTreeNode(2);
        // BTreeNode n3 = new BTreeNode(3);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(5);
        // BTreeNode n6 = new BTreeNode(6);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // root.InorderTraversal(root);

        // ArrayList<LinkedList<BTreeNode>> lists = new ArrayList<>();
        // // root.makeTreeLists(root, lists, 0);
        // lists = root.makeTreeListsBFS(root);

        // for(LinkedList<BTreeNode> list : lists){
        // for(BTreeNode node : list){
        // System.out.print(node.data + " ");
        // }
        // System.out.println();
        // }

        // 4.4

        // 4.5
        // int arr[] = {1,2,3,4,5,6,7};
        // BTreeNode root = new BTreeNode();
        // root = root.makeLeastHeightBST(arr, 0, arr.length-1);
        // root.InorderTraversal(root);

        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(3);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(6);
        // BTreeNode n6 = new BTreeNode(10);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // root.InorderTraversal(root);

        // if(root.checkBST(root))
        // System.out.println("It's BST");
        // else
        // System.out.println("It's NOT BST");

        // 4.6
        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(3);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(6);
        // BTreeNode n6 = new BTreeNode(10);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // root.InorderTraversal(root);
        // System.out.println();

        // BTreeNode nNode = BTreeNode.inorderSuccessor(n4);
        // if(nNode != null)
        // System.out.println("Next : " + nNode.data);
        // else
        // System.out.println("Last Elem");

        // 4.8
        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(3);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(6);
        // BTreeNode n6 = new BTreeNode(10);

        // BTreeNode n7 = new BTreeNode(11);
        // BTreeNode n8 = new BTreeNode(9);
        // BTreeNode n9 = new BTreeNode(14);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // n4.setLeftSubTree(n7);
        // n4.setRightSubTree(n8);
        // n7.setRightSubTree(n9);

        // root.InorderTraversal(root);
        // BTreeNode result = root.findFirstCommonAncestor(root, n4, n8);
        // System.out.println("Common Ancestor : " + result.getData());

        // 4.9
        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(3);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(6);
        // BTreeNode n6 = new BTreeNode(10);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // // root.InorderTraversal(root);
        // // root.printBTreeBFS(root);
        // root.printSubTree(root,true);

        // 4.10
        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(3);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);
        // BTreeNode n4 = new BTreeNode(4);
        // BTreeNode n5 = new BTreeNode(6);
        // BTreeNode n6 = new BTreeNode(10);

        // BTreeNode n7 = new BTreeNode(8);
        // BTreeNode n8 = new BTreeNode(6);
        // BTreeNode n9 = new BTreeNode(10);
        // n7.setLeftSubTree(n8);
        // n7.setRightSubTree(n9);

        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        // n1.setRightSubTree(n4);
        // n2.setLeftSubTree(n5);
        // n2.setRightSubTree(n6);

        // if(root.containsTree(root, n7))
        // System.out.println("It's subtree");
        // else
        // System.out.println("Not subtree");

        // 4.11
        // BTreeNode root = new BTreeNode(5);
        // // root.insertInOrder(2);
        // // root.insertInOrder(6);

        // root.insertInOrder(1);
        // root.insertInOrder(2);
        // root.insertInOrder(3);
        // root.insertInOrder(4);
        // root.insertInOrder(6);
        // root.insertInOrder(7);
        // root.insertInOrder(8);
        // root.insertInOrder(9);

        // System.out.println("root size : " + root.size());
        // root.InorderTraversal(root);
        // System.out.println();
        // for(int i=0; i<10; ++i)
        // System.out.println("Random " + i + " : " + root.getRandomNode().getData());

        // 4.12
        BTreeNode root = new BTreeNode(5);
        BTreeNode n1 = new BTreeNode(-2);
        BTreeNode n2 = new BTreeNode(8);
        BTreeNode n3 = new BTreeNode(3);
        BTreeNode n4 = new BTreeNode(6);
        BTreeNode n5 = new BTreeNode(7);
        BTreeNode n6 = new BTreeNode(-4);
        BTreeNode n7 = new BTreeNode(-6);

        root.setLeftSubTree(n1);
        root.setRightSubTree(n2);
        n1.setLeftSubTree(n3);
        n1.setRightSubTree(n4);
        n2.setLeftSubTree(n5);
        n2.setRightSubTree(n6);
        n5.setRightSubTree(n7);


        // BTreeNode root = new BTreeNode(5);
        // BTreeNode n1 = new BTreeNode(-2);
        // BTreeNode n2 = new BTreeNode(8);
        // BTreeNode n3 = new BTreeNode(1);


        // root.setLeftSubTree(n1);
        // root.setRightSubTree(n2);
        // n1.setLeftSubTree(n3);
        
        System.out.println(root.countPathsWithSum(root, 9));
    }

}