import java.util.HashMap;

public class CH2{
    public static void main(String[] args) {

        // // 리스트 생성
        // LinkedList list = new LinkedList();

        // for(int i=0; i<6; i++){
        //     // n.next = new Node(i);
        //     // n = n.next;
        //     list.appendToTail(i);
        //     list.appendToTail(6-i);
        //     // list.appendToTail(i);
        //     // list.appendToTail(i);
        // }

        // // for(int i=1; i<10; i++){
        // //     list.appendToTail(i);
        // // }

        // // for(int i=1; i<10; i++){
        // //     list.appendToTail(i+10);
        // // }

        // list.printListData();

        // // for(int i=0; i<10; i++){
        // //     list.delNode(i);
        // // }

        // // list.printListData();
        // // 2.1
        // // System.out.println("Delete duplicated Elems");
        // // removeListDuplication(list);
        // // list.printListData();
        

        // // 2.2
        // // int k = 9;
        // // // System.out.println("뒤에서 " + k + " 번째 원소 : " + findKFromEnd(list, k));
        // // findKFromEnd(list, k);

        // //2.3
        // // Node n = list.getHead();
        // // n = n.next.next.next;
        // // System.out.println("삭제할 노드 : " + n.data);
        // // deleteMidNode(n);
        // // list.printListData();

        // // //2.4
        // // Node head = divList(list, 5);
        // // list.setHead(head);
        // // list.printListData();

        // LinkedList list1 = new LinkedList();
        // LinkedList list2 = new LinkedList();

        // list1.appendToTail(7);
        // list1.appendToTail(1);
        // list1.appendToTail(6);
        
        // list2.appendToTail(5);
        // list2.appendToTail(9);
        // list2.appendToTail(2);
        // list2.appendToTail(1);
        
        // System.out.print("List 1 : ");
        // list1.printListData();
        // System.out.print("List 2 : ");
        // list2.printListData();

        // // LinkedList result = ListSum(list1, list2);
        // ListSum(list1, list2).printListData();

        // //2.6
        // LinkedListNode list = new LinkedListNode(1);
        // list.appendToTail(2);
        // list.appendToTail(3);
        // list.appendToTail(4);
        // list.appendToTail(3);
        // list.appendToTail(2);
        // list.appendToTail(1);

        // list.printListNode();
        
        // list = reverseList(list);
        // list.printListNode();

        // if(isPalindrome(list))
        //     System.out.println("It's Palindrome");
        // else
        //     System.out.println("It's not Palindrome");

        // //2.7
        // LinkedListNode list = new LinkedListNode(1);
        // LinkedListNode list2 = new LinkedListNode(4);
        

    }

    // 2.1
    static void removeListDuplication(LinkedList list){
        long start = System.currentTimeMillis();
        //1) HashMap 이용 -> 이따구로하면 안됨, delNode에서 이미 O(n)
        // HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Node n = list.getHead();

        // while(n != null){
        //     if(hashMap.containsValue(n.data)) // 중복이 있으면
        //         list.delNode(n.data);
        //     else{
        //         hashMap.put(n.data, n.data);
        //     }
        //     n = n.next;
        // }

        // HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Node n = list.getHead();
        // Node prev = null;

        // while(n != null){
        //     if(hashMap.containsValue(n.data)){
        //         prev.next = n.next;
        //     }
        //     else{
        //         hashMap.put(n.data, n.data);
        //         prev = n;
        //     }
        //     n = n.next;
        // }



        //2) 정렬 후 제거 
        // 정렬 생략 -> O(nlogn)
        // Node n = list.getHead();

        // // 탐색하면서 중복 제거 -> O(n^2)?
        // while(n.next != null){
        //     if(n.data == n.next.data)
        //         list.delNode(n.data);

        //     n = n.next;
        // }


        /* 3) Runner Pointer */ 
        
        Node n = list.getHead();
        Node runner = null;
        
        while(n != null){
            runner = n;
            while(runner.next != null){
                if(runner.next.data == n.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            n = n.next;
        }



        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start) + "ms");
    }

    //2.2
    static int findKFromEnd(LinkedList list, int k){
        // 단방향 연결리스트 -> 빠꾸가 안됨
        // 뒤에서 k번째 원소 = n-k+1 번째 원소, n-k 인덱스 원소

    //     /* 1) n-k 번째 원소 찾기 */
    //     int listLen = 0;
    //     Node n = list.getHead();

    //     while(n != null){
    //         ++listLen;
    //         n = n.next;
    //     }

    //     if(k>listLen){
    //         System.out.println("Invalid value k");
    //         return -1;
    //     }

    //     n = list.getHead();
    //     for(int i=0; i<listLen-k; ++i){
    //         n = n.next;
    //     }
    //     return n.data;

        /* 2) Two Pointers */
        // if(k<1)
        //     return -1;
        // Node n = list.getHead();
        // Node aheadKFromN = n;
        // int counter = 0;
        // // runner 를 k-1번 먼저 이동
        // while(aheadKFromN.next != null){
        //     if(counter<k-1){
        //         aheadKFromN = aheadKFromN.next;
        //         counter++;
        //     } else {
        //         aheadKFromN = aheadKFromN.next;
        //         n = n.next;
        //     }
        // }

        // return n.data;

        /* 3) 재귀 */
        Node n = list.getHead();
        return findKFromEndHelper(n, k);
    }

    static int findKFromEndHelper(Node n, int k){
        if(n == null)
            return 1;
        
        int count = findKFromEndHelper(n.next, k);

        if(count == k){
            System.out.println("뒤에서 " + k + " 번째 원소 : " + n.data);
        }

        return ++count;
    }

    static boolean deleteMidNode(Node n){
        if(n == null || n.next == null)
            return false;

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;

        return true;
    }

    static Node divList(LinkedList list, int div){
        Node n = list.getHead();
        Node head = n;
        Node tail = n;
        Node next = null;
        
        while(n != null){
            next = n.next;
            if(n.data >= div){
                tail.next = n;
                tail = n;
            } else{
                n.next = head;
                head = n;
            }

            n = next;
        }
        tail.next = null;
        return head;
    }

    //2.6
    public static boolean isPalindrome(final LinkedListNode list){
        LinkedListNode reverseList = reverseList(list);
        LinkedListNode originList = list;
        while(originList.next != null && reverseList.next != null){
            if(originList.data != reverseList.data)
                return false;
            originList = originList.next;
            reverseList = reverseList.next;
        }
        return true;
    }
    private static LinkedListNode reverseList(final LinkedListNode list){
        if(list.next == null)
            return new LinkedListNode(list.data);
        
        LinkedListNode resultList = reverseList(list.next);
        resultList.appendToTail(list.data);

        return resultList;
    }

    //2.7
    public static LinkedListNode findListIntersection(LinkedListNode list1, LinkedListNode list2){
        if(list1 == null || list2 == null)
            return null;

        // List 길이 계산
        int len1 = list1.getLength();
        int len2 = list2.getLength();
        int diff = 0;

        LinkedListNode resultList;
        LinkedListNode headL1 = list1;
        LinkedListNode headL2 = list2;

        // 1) 탐색하는동안 길이가 같도록 더 긴 리스트의 포인터를 이동
        if(len1 > len2){
            diff = len1-len2;
            for(int i=0; i<diff; i++){
                headL1 = headL1.next;
            }

        }
        else if(len1 < len2){
            diff = len2-len1;
            for(int i=0; i<diff; i++){
                headL2 = headL2.next;
            }
        }

        while(headL1 != null && headL2 != null){
            if(headL1 == headL2)
                return headL1;
            headL1 = headL1.next;
            headL2 = headL2.next;
        }

        return false;
        
    }
}