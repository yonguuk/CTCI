
public class Main {
    public static void main(String[] args) {
        CH2 ch2 = new CH2();
        // LinkedList list = new LinkedList();
        // list.appendToTail(1);
        // list.appendToTail(1);
        // list.appendToTail(2);
        // list.appendToTail(3);
        // list.appendToTail(4);
        // list.appendToTail(4);
        // list.appendToTail(4);
        // list.appendToTail(4);
        // list.appendToTail(4);
        // list.appendToTail(5);
        
        // list.printListElem();
        // ch2.deleteDups2(list);
        // list.printListElem();

        //2.2 
        // LinkedList list = new LinkedList();
        // list.appendToTail(1);
        // list.appendToTail(1);
        // list.appendToTail(2);
        // list.appendToTail(3);
        // list.appendToTail(4);
        // list.appendToTail(5);
        // list.appendToTail(6);
        // list.appendToTail(7);
        // list.appendToTail(8);
        // list.appendToTail(9);
        // System.out.println(ch2.findKthElemBackward(list, 2).data);

        //2.4
        // LinkedListNode n1 = new LinkedListNode(3);
        // LinkedListNode n2 = new LinkedListNode(5);
        // LinkedListNode n3 = new LinkedListNode(8);
        // LinkedListNode n4 = new LinkedListNode(5);
        // LinkedListNode n5 = new LinkedListNode(10);
        // LinkedListNode n6 = new LinkedListNode(2);
        // LinkedListNode n7 = new LinkedListNode(1);
        
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;

        // LinkedListNode n = n1;
        // while(n != null){
        //     System.out.print(n.data + " ");
        //     n = n.next;
        // }
        // System.out.println();

        // n = ch2.partition2(n1, 5);

        // while(n != null){
        //     System.out.print(n.data + " ");
        //     n = n.next;
        // }
        // System.out.println();

        //2.5
        // LinkedListNode n1 = new LinkedListNode(7);
        // LinkedListNode n2 = new LinkedListNode(1);
        // LinkedListNode n3 = new LinkedListNode(6);

        // LinkedListNode n4 = new LinkedListNode(5);
        // LinkedListNode n5 = new LinkedListNode(9);
        // LinkedListNode n6 = new LinkedListNode(2);
        // LinkedListNode n7 = new LinkedListNode(6);
        
        // n1.next = n2;
        // n2.next = n3;
        
        // n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;
        // LinkedListNode result = ch2.addReversedList(n1, n4);
        // while(result != null){
        //     System.out.print(result.data + " ");
        //     result = result.next;
        // }
        // System.out.println();

        // LinkedListNode n1 = new LinkedListNode(6);
        // LinkedListNode n2 = new LinkedListNode(1);
        // LinkedListNode n3 = new LinkedListNode(7);

        // LinkedListNode n4 = new LinkedListNode(2);
        // LinkedListNode n5 = new LinkedListNode(9);
        // LinkedListNode n6 = new LinkedListNode(5);

        
        // n1.next = n2;
        // n2.next = n3;

        // n4.next = n5;
        // n5.next = n6;
        
        // n1.printList();
        // n4.printList();

        // LinkedListNode result = ch2.addLists(n1, n4, 0);
        // result.printList();
        
        // 2.6
        // LinkedListNode n1 = new LinkedListNode(1);
        // LinkedListNode n2 = new LinkedListNode(2);
        // LinkedListNode n3 = new LinkedListNode(3);

        // LinkedListNode n4 = new LinkedListNode(1);

        // LinkedListNode n5 = new LinkedListNode(3);
        // LinkedListNode n6 = new LinkedListNode(2);
        // LinkedListNode n7 = new LinkedListNode(1);

        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;

        // LinkedListNode n1 = new LinkedListNode(1);
        // LinkedListNode n2 = new LinkedListNode(2);
        // LinkedListNode n3 = new LinkedListNode(3);
        // LinkedListNode n4 = new LinkedListNode(4);

        // LinkedListNode n5 = new LinkedListNode(4);
        // LinkedListNode n6 = new LinkedListNode(3);
        // LinkedListNode n7 = new LinkedListNode(2);
        // LinkedListNode n8 = new LinkedListNode(1);

        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;
        // n7.next = n8;

        // n1.printList();

        // if(ch2.isPalindrome4(n1))
        //     System.out.println("true");
        // else
        //     System.out.println("false");
        
        // 2.7
        // LinkedListNode n1 = new LinkedListNode(1);
        // LinkedListNode n2 = new LinkedListNode(2);
        // LinkedListNode n3 = new LinkedListNode(3);
        // LinkedListNode n4 = new LinkedListNode(4);
        // LinkedListNode n5 = new LinkedListNode(5);
        // LinkedListNode n6 = new LinkedListNode(6);
        // LinkedListNode n7 = new LinkedListNode(7);
        // LinkedListNode n8 = new LinkedListNode(8);
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;
        // n7.next = n8;

        // LinkedListNode m1 = new LinkedListNode(11);
        // LinkedListNode m2 = new LinkedListNode(12);
        // LinkedListNode m3 = new LinkedListNode(13);
        // m1.next = m2;
        // m2.next = m3;
        // m3.next = n6;

        // n1.printList();
        // m1.printList();

        // LinkedListNode result = ch2.listIntersection(n1, m1);
        // result.printList();

        //2.8
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);
        LinkedListNode n7 = new LinkedListNode(7);
        LinkedListNode n8 = new LinkedListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n5;

        LinkedListNode result = ch2.findCircle(n1);
        System.out.println(result.data);

    }
}