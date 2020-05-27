import java.util.HashSet;
import java.util.Stack;

public class CH2 {
    // 2.1
    //#1
    void deleteDups(LinkedList list){
        HashSet<Integer> set = new HashSet<>();
        Node n = list.head;        
        Node prev = null;
        while(n != null){
            if(set.contains(n.data)){
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    //#2
    void deleteDups2(LinkedList list){
        Node current = list.head;
        
        while(current != null){
            Node runner = current;
            while(runner.next != null){
                if(current.data == runner.next.data){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //2.2
    Node findKthElemBackward(LinkedList list, int k){
        Node n = list.head;
        int len = 0;
        while(n != null){
            n = n.next;
            ++len;
        }
        n = list.head;
        for(int i=0; i<len-k; ++i){
            n = n.next;
        }
        return n;
    }

    //2.2 Solution
    // #1
    class Index{
        public int value = 0;
    }

    LinkedListNode kthToLast(LinkedListNode head, int k){
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    LinkedListNode kthToLast(LinkedListNode head, int k, Index idx){
        if(head == null){
            return null;
        }
        LinkedListNode node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if(idx.value == k){
            return head;
        }
        return node;
    }

    //#2
    LinkedListNode nthToLast(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i = 0; i<k; i++){
            if(p1 == null) return null; 
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //2.3
    boolean deleteNode(LinkedListNode n){
        if(n == null || n.next == null)
            return false;
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    //2.4
    LinkedListNode splitWithX(LinkedListNode node, int x){
        LinkedListNode leftHead = null;
        LinkedListNode rightHead = null;
        LinkedListNode n = node;

        while(n != null){
            LinkedListNode next = n.next;
            if(n.data < x){
                if(leftHead == null){
                    leftHead = n;
                    leftHead.next = null;
                } else {
                    n.next = leftHead.next;
                    leftHead.next = n;
                }
            } else {
                if(rightHead == null){
                    rightHead = n;
                    rightHead.next = null;
                } else {
                    n.next = rightHead.next;
                    rightHead.next = n;
                }
            }
            n = next;
        }

        n = leftHead;
        while(n.next != null){
            n = n.next;
        }
        n.next = rightHead;

        return leftHead;
    }
    //2.4 Solution
    //#1
    LinkedListNode partition(LinkedListNode node, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null){
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else{
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //#2
    LinkedListNode partition2(LinkedListNode node, int x){
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null){
            LinkedListNode next = node.next;
            if(node.data < x){
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    LinkedListNode addReversedList(LinkedListNode n1, LinkedListNode n2){
        LinkedListNode tail = null;
        LinkedListNode head = null;
        int carry = 0;

        while(n1 != null || n2 != null){
            int sum = 0;
            LinkedListNode nNode = null;

            if(n1 != null)
                sum += n1.data;
            if(n2 != null)
                sum += n2.data;
            sum += carry;

            if(sum >= 10){
                nNode = new LinkedListNode(sum-10);
                carry = 1;
            } else {
                nNode = new LinkedListNode(sum);
                carry = 0;
            }

            if(tail == null){
                tail = nNode;
                head = nNode;
            } else {
                tail.next = nNode;
                tail = nNode;
            }

            if(n1 != null)
                n1 = n1.next;
            if(n2 != null)
                n2 = n2.next;
        }

        if(carry == 1){
            LinkedListNode nNode = new LinkedListNode(carry);
            tail.next = nNode;
            tail = nNode;
        }

        return head;
    }

    LinkedListNode addReversedList2(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 1){
                return new LinkedListNode(1);
            } else {
                return null;
            }
        }

        int sum = 0;
        if(l1 != null)
            sum += l1.data;
        if(l2 != null)
            sum += l2.data;
        sum += carry;

        System.out.println("Sum : " + sum + ", carry : " +carry);
        LinkedListNode nNode;
        if(sum < 10){
            nNode = new LinkedListNode(sum);
            carry = 0;
        } else {
            nNode = new LinkedListNode(sum-10);
            carry = 1;
        }

        LinkedListNode result;
        if(l1 !=null && l2 == null)
            result = addReversedList2(l1.next, null, carry);
        else if(l1 == null && l2 != null)
            result = addReversedList2(null, l2.next, carry);
        else
            result = addReversedList2(l1.next, l2.next, carry);

        nNode.next = result;
        return nNode;
    }

    class Result{
        public int carry;
        LinkedListNode head;
    }

    LinkedListNode addListReculsive(LinkedListNode n1, LinkedListNode n2){
        int n1Len = getListLen(n1);
        int n2Len = getListLen(n2);

        if(n1Len > n2Len)
            n2 = addZeroNodes(n2, n1Len-n2Len);
        else if(n1Len < n2Len)
            n1 = addZeroNodes(n1, n2Len-n1Len);

        Result result;
        
        result = addListReculsiveHelper(n1, n2);
        if(result.carry == 1){
            LinkedListNode nNode = new LinkedListNode(result.carry);
            nNode.next = result.head;
            result.head = nNode;
        }
        return result.head;
    }


    Result addListReculsiveHelper(LinkedListNode n1, LinkedListNode n2){
        if(n1 == null && n2 == null){
            return new Result();
        }

        Result result;

        if(n1 != null && n2 != null){
            result = addListReculsiveHelper(n1.next, n2.next);
        } else if(n1 != null && n2 == null){
            result = addListReculsiveHelper(n1.next, null);
        } else {
            result = addListReculsiveHelper(null, n2.next);
        }
        
        int sum = 0;
        if(n1 != null)
            sum += n1.data;
        if(n2 != null)
            sum += n2.data;
        sum += result.carry;

        LinkedListNode nNode; 
        if(sum < 10){
            nNode = new LinkedListNode(sum);
            result.carry = 0;
        } else {
            nNode = new LinkedListNode(sum-10);
            result.carry = 1;
        }
        if(result.head == null){
            result.head = nNode;
        } else {
            nNode.next = result.head;
            result.head = nNode;

        }
        return result;
    }

    int getListLen(LinkedListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            ++count;
        }
        return count;
    }

    LinkedListNode addZeroNodes(LinkedListNode head, int num){
        for(int i=0; i<num; ++i){
            LinkedListNode nNode = new LinkedListNode(0);
            nNode.next = head;
            head = nNode;
        }
        return head;
    }

    //2.5 Solution
    // #1
    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if(l1 != null)
            value += l1.data;
        if(l2 != null)
            value += l2.data;

        result.data = value % 10;
        if(l1 != null || l2 != null){
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                            l2 == null ? null : l2.next,
                                            value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    //#2
    // class PartialSum{
    //     public LinkedListNode sum = null;
    //     public int carry;
    // }

    // LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){
    //     int len1 = length(l1);
    //     int len2 = length(l2);

    //     if(len1 < len2)
    //         l1 = padList(l1, len2-len1);
    //     else
    //         l2 = paddList(l2, len1-len2);
        
    //     PartialSum sum = addListHelper(l1, l2);
    //     if(sum.carry == 0){
    //         return sum.sum;
    //     } else {
    //         LinkedListNode result = insertBefore(sum.sum, sum.carry);
    //         return result;
    //     }
    // }

    // PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2){
    //     if(l1 == null && l2 == null){
    //         PartialSum sum = new PartialSum();
    //         return sum;
    //     }
    //     PartialSum sum = addListsHelper(l1.next, l2.next);
    //     int val = sum.carry + l1.data + l2.data;
    //     LinkedListNode full_result = insertBefore(sum.sum, val%10);

    //     sum.sum = full_result;
    //     sum.carry = val/10;
    //     return sum;
    // }

    // LinkedListNode padLint(linkedListNode l, int padding){
    //     LinkedListNode head = l;
    //     for(int i=0; i<padding; i++){
    //         head = insertBefore(head, 0);
    //     }
    //     return head;
    // }

    // LinkedListNode insertBefore(LinkedListNode list, int data){
    //     LinkedListNode node = new LinkedListNode(data);
    //     if(list != null){
    //         node.next = list;
    //     }
    //     return node;
    // }

    //2.6
    boolean isPalindrome(LinkedListNode list){
        int listLen = 0;
        LinkedListNode n = list;
        while(n != null){
            n = n.next;
            ++listLen;
        }
        int[] halfList = new int[listLen/2];
        n = list;
        int count = 0;
        while(n != null){
            if(count >= listLen/2)
                break;
            
            halfList[count++] = n.data;
            n = n.next;
        }
        
        if(listLen%2 == 1)
            n = n.next;

        while(n != null){
            System.out.println("+n.data : " + n.data + " arr : " + halfList[count-1]);
            if(halfList[count-1] != n.data){
                return false;
            } else {
                n = n.next;
                --count;
            }
        }
        return true;
    }

    // 2.6 Solution
    // #1
    boolean isPalindrome2(LinkedListNode head){
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }
    LinkedListNode reverseAndClone(LinkedListNode node){
        LinkedListNode head = null;
        while(node != null){
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(LinkedListNode one, LinkedListNode two){
        while(one != null && two != null){
            if(one.data != two.data)
                return false;
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    // #2
    boolean isPalindrome3(LinkedListNode head){
        Stack<Integer> stack = new Stack<>();
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            int top = stack.pop().intValue();
            if(top != slow.data)
                return false;
            slow = slow.next;
        }

        return true;
    }

    //#3
    //내가 푼거
    class Result2{
        public boolean isSame;
        public LinkedListNode prev;

        public Result2(boolean isSame, LinkedListNode prev){
            this.isSame = isSame;
            this.prev = prev;
        }
    }

    boolean isPalindrome4(LinkedListNode head){
        LinkedListNode n = head;
        int length = 0;
        while(n != null){
            n = n.next;
            ++length;
        }

        return isPalindromeReculsive(head, length).isSame;
    }

    Result2 isPalindromeReculsive(LinkedListNode node, int length){
        if(length == 0){
            return new Result2(true, node);
        } else if(length == 1){
            return new Result2(true, node.next);  
        }

        Result2 result = isPalindromeReculsive(node.next, length-2);
        if(result.isSame == true){
            if(node.data == result.prev.data){
                result.prev = result.prev.next;
            } else {
                result.isSame = false;
            }
        } 
        return result;
    }

    // solution
    // 이름 충돌이 생겨서 주석처리
    // class Result{
    //     public LinkdedListNode node;
    //     public boolean result;
    // }
    // Result isPalindrome(LinkedListNode head){
    //     int length = lengthOfList(head);
    //     Result p = isPalindromeRecurse(head, length);
    //     return p.result;
    // }

    // Result isPalindromeRecurse(LinkedListNode head, int length){
    //     if(head == null || length == 0){
    //         return new Result(head, true);
    //     } else if(length == 1){
    //         return new Result(head.next, true);
    //     }

    //     Result res = isPalindromeRecurse(head.next, length-2);
    //     if(!res.result || res.node == null){
    //         return res;
    //     }
    //     res.result = (head.data == res.node.data);
    //     res.node = res.node.next;
    //     return res;
    // }

    // int lengthOfList(LinkedListNode n){
    //     int size = 0;
    //     while(n != null){
    //         size++;
    //         n = n.next;
    //     }
    //     return size;
    // }
    LinkedListNode listIntersection(LinkedListNode list1, LinkedListNode list2){
        HashSet<LinkedListNode> set = new HashSet<>();
        LinkedListNode n1 = list1;
        LinkedListNode n2 = list2;

        while(n1 != null && n2 != null){
            if(!set.contains(n1))
                set.add(n1);
            else
                return n1;
            
            if(!set.contains(n2))
                set.add(n2);
            else
                return n2;

            n1 = n1.next;
            n2 = n2.next;
        }
        
        return null;
    }

    // 2.7 Solution
    // LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2){
    //     if(list1 == null || list2 == null) return null;

    //     Result result1 = getTailAndSize(list1);
    //     Result result2 = getTailAndSize(list2);

    //     if(result1.tail != result2.tail){
    //         return null;
    //     }

    //     LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
    //     LinkedListNode longer = result1.size < result2.size ? list2 : list1;

    //     longer = getKthNode(longer, Math.abs(result1.size - result2.size));

    //     while(shorter != longer){
    //         shorter = shorter.next;
    //         longer = longer.next;
    //     }

    //     return longer; // or shorter
    // }

    // class Result{
    //     public LinkedListNode tail;
    //     public int size;
    //     public Result(LinkedListNode tail, int size){
    //         this.tail = tail;
    //         this.size = size;
    //     }
    // }

    // Result getTailAndSize(LinkedListNode list){
    //     if(list == null) return null;

    //     int size = 1;
    //     LinkedListNode current = list;
    //     while(current.next != null){
    //         size++;
    //         current = current.next;
    //     }
    //     return new Result(current, size);
    // }

    // LinkedListNode getKthNode(LinkedListNode head, int k){
    //     LinkedListNode current = head;
    //     while(k > 0 && current != null){
    //         current = current.next;
    //         k--;
    //     }
    //     return current;
    // }

    //2.8
    LinkedListNode findCircle(LinkedListNode list){
        HashSet<LinkedListNode> set = new HashSet<>();
        LinkedListNode n = list;

        while(n != null){
            if(set.contains(n))
                return n;
            else
                set.add(n);
            n = n.next; 
        }

        return null;
    }

    LinkedListNode FindBeginning(LinkedListNode head){
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while(slowPointer != null && fastPointer != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                break;
            }
        }
        
        if(fastPointer == null || fastPointer.next == null){
            return null;
        }

        slowPointer = head;

        while(slowPointer != fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return fastPointer;
    }
}