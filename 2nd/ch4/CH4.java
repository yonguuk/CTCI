import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CH4 {

    //4.2
    public TreeNode makeBST(int[] arr){
        return makeBST(arr, 0, arr.length-1);
    }

    public TreeNode makeBST(int[] arr, int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = makeBST(arr, start, mid-1);
        node.right = makeBST(arr, mid+1, end);

        return node;
    }

    //4.2 Solution
    TreeNode createMinimalBST(int array[]){
        return createMinimalBST(array, 0, array.length-1);
    }
    
    TreeNode createMinimalBST(int arr[], int start, int end){
        if(end < start){
            return null;
        }
    
        int mid = (start + end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid-1);
        n.right = createMinimalBST(arr, mid+1, end);
    
        return n;
    }

    //4.3
    public void makeList(TreeNode root, ArrayList<LinkedList<TreeNode>> treeList, int level){
        if(root == null) return;

        if(treeList.size() <= level){
            treeList.add(new LinkedList<TreeNode>());
        }

        treeList.get(level).add(root);
        makeList(root.left, treeList, level+1);
        makeList(root.right, treeList, level+1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if(root != null)
            current.add(root);

        while(current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;

            current = new LinkedList<>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    //4.4
    class Result{
        int height;
        boolean balanced;
    }

    public boolean isBalanced(TreeNode root){
        return isBalancedHelper(root).balanced;
    }

    public Result isBalancedHelper(TreeNode node){
        if(node == null){
            Result result = new Result();
            result.height = 0;
            result.balanced = true;
            return result;
        }

        Result left = isBalancedHelper(node.left);
        Result right = isBalancedHelper(node.right);

        Result result = new Result();

        if(left.balanced == true && right.balanced == true){
            result.balanced = Math.abs(left.height - right.height) <= 1;
            result.height = left.height < right.height ? right.height+1 : left.height+1;
            System.out.println("node : " + node.value + " height : " + result.height + " balanced : " + result.balanced);
            return result;
        } else {
            result.balanced = false;
            return result;
        }
    }

    //4.4 Solution
    // int checkHeight(TreeNode root){
    //     if(root == null) return -1;
    
    //     int leftHeight = checkHeight(root.left);
    //     if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // 에러 반환
    
    //     int rightHeight = checkHeight(root.right);
    //     if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
    //     int heightDiff = leftHeight - rightHeight;
    //     if(Math.abs(heightDiff) > 1){
    //         return Integer.MIN_VALUE;
    //     } else {
    //         return Math.max(leftHeight, rightHeight) + 1;
    //     }
    // }
    
    // boolean isBalanced(TreeNode root){
    //     return checkHeight(root) != Integer.MIN_VALUE;
    // }

    public boolean checkBST(TreeNode node){
        if(node == null) return true;

        boolean checkLeft = checkBST(node.left);

        if(node.left != null && node.value < node.left.value)
            return false;
        else if(node.right != null && node.value > node.right.value)
            return false;
        
        boolean checkRight = checkBST(node.right);

        return (checkLeft && checkRight);
    }

    public boolean checkBST_BFS(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode n = queue.remove();
            if(n.left != null){
                if(n.value < n.left.value)
                    return false;
                queue.add(n.left);
            }

            if(n.right != null){
                if(n.value > n.right.value)
                    return false;
                queue.add(n.right);
            }
        }

        return true;
    }


    //4.6 My code
    TreeNode inOrderSucc(TreeNode n){
        if(n.parent == null || n.right != null){ // root인 경우
            TreeNode x = n.right;
            while(x.left != null){
                x = x.left;
            }
            return x;
        } else if(n.equals(n.parent.left)){
            return n.parent;
        } else {
            TreeNode x = n.parent;
            while(x != null && !x.equals(x.parent.left)){
                x = x.parent;
            }

            if(x == null){
                //root 까지 올라왔음 -> 방문할 노드가 없다.
                return null;
            } else {
                return x.parent;
            }
        }
    }
    //4.6 Solution

    // TreeNode inorderSucc(TreeNode n){
    //     if(n==null) return null;
        
    //     // 오른쪽 자식이 존재 -> 오른쪽 부분 트리에서 가장 왼쪽 노드를 반환한다.
    //     if(n.right != null){
    //         return leftMostChild(n.right);
    //     } else {
    //         TreeNode q = n;
    //         TreeNode x = q.parent;
    //         //오른쪽이 아닌 왼쪽에 있을 때까지 위로 올라간다.
    //         while(x != null && x.left != q){
    //             q = x;
    //             x = x.parent;
    //         }
    //         return x;
    //     }
    // }
    
    // TreeNode leftMostChild(TreeNode n){
    //     if(n == null){
    //         return null;
    //     }
    //     while(n.left != null){
    //         n = n.left;
    //     }
    //     return n;
    // }
    

    //4.7 Solution
    Project[] findBuildOrder(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    // 그래프를 만든다. 프로젝트 b가 a에 종속되어 있으면 그래프에 간선 (a,b)를 추가한다.
    // 각 노드의 쌍은 '실행 순서' 대로 나열되어 있다.(a,b) 쌍은 종속 관계를 의미하는데,
    // 프로젝트 b가 a에 종속되어 있고(의존한다), b 전에 a가 반드시 먼저 실행되어야 한다.
    Graph buildGraph(String[] projects, String[][] dependencies){
        Graph graph = new Graph();
        for(String project : projects){
            graph.createNode(project);
        }

        for(String[] dependency : dependencies){
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    Project[] orderProjects(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];

        // '루트'를 프로젝트 리스트에 먼저 추가한다
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while(toBeProcessed < order.length){
            Project current = order[toBeProcessed];

            //종속된 프로젝트가 없는 프로젝트가 존재하지 않으므로 프로젝트 종속 관계에 사이클이 존재한다.
            if(current == null){
                return null;
            }

            // 종속 관계에서 현재 노드를 제거한다.
            ArrayList<Project> children = current.getChildren();
            for(Project child : children){
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }
    
    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
        for(Project project : projects){
            if(project.getNumberDependencies() == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    class Graph{
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name){
            if(!map.containsKey(name)){
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void addEdge(String startName, String endName){
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes(){
            return nodes;
        }

        public void createNode(String project){
            Project node = new Project(project);
            nodes.add(node);
            map.put(project, node);
        }
    }

    class Project{
        private ArrayList<Project> children = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

        public Project(String n){
            name = n;
        }

        public void addNeighbor(Project node){
            if(!map.containsKey(node.getName())){
                children.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }
        
        public void incrementDependencies(){
            dependencies++;
        }
        public void decrementDependencies(){
            dependencies--;
        }
        public String getName(){
            return name;
        }
        public ArrayList<Project> getChildren(){
            return children;
        }
        public int getNumberDependencies(){
            return dependencies;
        }
    }

    //4.7 Solution #2 : DFS
    // Stack<Project> findBuildOrder(String[] projects, String[][] dependencies){
    //     Graph graph = buildGraph(projects, dependencies);
    //     return orderProjects(graph.getNodes());
    // }

    // Stack<Project> orderProjects(ArrayList<Project> projects){
    //     Stack<Project> stack = new Stack<>();
    //     for(Project project : projects){
    //         if(project.getState() == Project.State.BLANK){
    //             if(!doDFS(project, stack)){
    //                 return null;
    //             }
    //         }
    //     }
    //     return stack;
    // }

    // boolean doDFS(Project project, Stack stack){
    //     if(project.getState() == Project.State.PARTIAL){
    //         return false; // 사이클
    //     }

    //     if(project.getState() == Project.State.BLANK){
    //         project.setState(Project.State.PARTIAL);
    //         ArrayList<Project> children = project.getChildren();
    //         for(Project child : children){
    //             if(!doDFS(child, stack)){
    //                 return false;
    //             }
    //         }
    //         project.setState(Project.State.COMPLETE);
    //         stack.push(project);
    //     }
    //     return true;
    // }

    // // 이전 코드와 같다.
    // Graph buildGraph(String[] projects, String[][] dependencies){
    //     Graph graph = new Graph();
    //     for(String project : projects){
    //         graph.createNode(project);
    //     }

    //     for(String[] dependency : dependencies){
    //         String first = dependency[0];
    //         String second = dependency[1];
    //         graph.addEdge(first, second);
    //     }

    //     return graph;
    // }

    // 이전 코드에 새로운 부분 추가됨.
    // class Project{
    //     public enum State {COMPLETE, PARTIAL, BLANK};
    //     private State state = State.BLANK;
    //     public State getState(){
    //         return state;
    //     }
    //     public void setState(State st){
    //         state = st;
    //     }
    // }

    
    //4.8
    TreeNode findFirstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
        TreeNode result;

        if(searchNode(root.left, n1) && searchNode(root.left, n2)){
            result = findFirstCommonAncestor(root.left, n1, n2);
        } else if(searchNode(root.right, n1) && searchNode(root.right, n2)){
            result = findFirstCommonAncestor(root.right, n1, n2);
        } else { // 양쪽에 하나씩 or 없거나
            result = root;
        }

        return result;
    }

    boolean searchNode(TreeNode node, TreeNode n){
        if(node == null) return false;

        if(node.value == n.value){
                return true;
        }

        return searchNode(node.left, n) || searchNode(node.right, n);
    }

    //4.8 Solution #2
    // TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    //     // 같은 트리 안에 있는지 하나가 다른 하나를 이미 덮고 있는지 확인한다.
    //     if(!covers(root, p) || covers(root,q)){
    //         return null;
    //     } else if(covers(p, q)){
    //         return p;
    //     } else if(covers(q, p)){
    //         return q;
    //     }
    
    //     // q를 덮을 수 있는 노드가 나올 때까지 위로 올라간다
    //     TreeNode sibling = getSibling(p);
    //     TreeNode parent = p.parent;
    //     while(!covers(sibling, q)){
    //         sibling = getSibling(parent);
    //         parent = parent.parent;
    //     }
    //     return parent;
    // }
    
    boolean covers(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
    
    TreeNode getSibling(TreeNode node){
        if(node == null || node.parent == null){
            return null;
        }
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    //4.8 Solution #3
    // TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    //     // 에러 체크 : 노드가 같은 트리 안에 있는지
    //     if(!covers(root, p) || !covers(root, q)){
    //         return null;
    //     }
    //     return ancestorHelper(root, p, q);
    // }

    // TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
    //     if(root == null || root == p || root == q){
    //         return root;
    //     }

    //     boolean pIsOnLeft = covers(root.left, p);
    //     boolean qIsOnLeft = covers(root.left, q);

    //     if(pIsOnLeft != qIsOnLeft){ // 두 노드가 다른 쪽에 놓여 있다.
    //         return root;
    //     }
    //     TreeNode childSide = pIsOnLeft ? root.left : root.right;
    //     return ancestorHelper(childSide, p, q);
    // }


    //4.8 Solution #4
    class Result2{
        public TreeNode node;
        public boolean isAncestor;
        public Result2(TreeNode n, boolean isAnc){
            node = n;
            isAncestor = isAnc;
        }
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Result2 r = commonAncHelper(root, p, q);
        if(r.isAncestor){
            return r.node;
        }
        return null;
    }

    Result2 commonAncHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new Result2(null, false);

        if(root == p && root == q){
            return new Result2(root, true);
        }

        Result2 rx = commonAncHelper(root.left, p, q);
        if(rx.isAncestor){ // 공통 조상을 찾았다.
            return rx;
        }

        Result2 ry = commonAncHelper(root.right, p, q);
        if(ry.isAncestor){
            return ry;
        }

        if(rx.node != null && ry.node != null){
            return new Result2(root, true);
        } else if(root == p || root == q){
            // 현재 노드가 p 혹은 q 이고, 이들 중 하나가 부분 트리에 속해 있다면,
            // 현재 노드는 반드시 조상이어야 하며 플래그도 참이 되어야 한다.
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result2(root, isAncestor);
        } else {
            return new Result2(rx.node != null ? rx.node : ry.node, false);
        }
    }


    // 4.9 Solution
    ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
    
        if(node == null){
            result.add(new LinkedList<Integer>());
            return result;
        }
    
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);
    
        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
    
        /* Weave together each list from the left and right side.*/
        for(LinkedList<Integer> left : leftSeq){
            for(LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
    
        return result;
    }
    
    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        // One List is empty. Add remainder to [a cloned] prefix and store result
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
    
        /* Recurse with head of first added to the prefix. Removing the head 
        will damage first, so we'll need to put it back where we found it afterwards.
        */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
    
        // Do the same thing with second, damaging and then restoring the lsit
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    //4.10 Solution #1
    // boolean containsTree(TreeNode t1, TreeNode t2){
    //     StringBuilder string1 = new StringBuilder();
    //     StringBuilder string2 = new StringBuilder();
    //     getOrderString(t1, string1);
    //     getOrderString(t2, string2);
        
    //     return string1.toString().indexOf(string2.toString()) > -1;
    // }
    
    // void getOrderString(TreeNode node, StringBuilder sb){
    //     if(node == null){
    //         sb.append("X");
    //         return;
    //     }
    //     sb.append(node.value + " ");
    //     getOrderString(node.left, sb);
    //     getOrderString(node.right, sb);
    // }

    //4.10 Solution #2

    boolean containsTree(TreeNode t1, TreeNode t2){
        if(t2 == null) return true;
        return subTree(t1, t2);
    }

    boolean subTree(TreeNode r1, TreeNode r2){
        if(r1 == null)
            return false;

        if(r1.value == r2.value && matchTree(r1, r2))
            return true;

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    boolean matchTree(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null)
            return true;
        else if(r1 == null || r2 == null)
            return false;
        else if(r1.value != r2.value)
            return false;
        else
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }

    //4.12
    class ValueSum{
        int dist;
        int sum;
        LinkedList<Integer> values;

        public ValueSum(int dist){
            this.dist = dist;
            values = new LinkedList<>();
            sum = 0;
        }

        // public void addValue(int v){
        //     values.addLast(v);
        //     sum += v;
        //     if(dist+1 < values.size()){
        //         int rm = values.removeFirst();
        //         sum -= rm;
        //     }
        // }

        public void addFirst(int v){
            values.addFirst(v);
            sum += v;
        }

        public void addLast(int v){
            values.addLast(v);
            sum += v;
        }

        public int removeLast(){
            int rm = values.removeLast();
            sum -= rm;
            return rm;
        }
        public int removeFirst(){
            int rm = values.removeFirst();
            sum -= rm;
            return rm;
        }
        public int getSum(){
            return sum;
        }

        public boolean addedEnough(){
            return dist+1 == values.size() ? true : false;
        }

        public void printList(){
            for(int v : values)
                System.out.print(v + " ");
            
            System.out.println();
        }
    }

    int findSumPath(TreeNode root, int n){
        int level = getTreeLevel(root, 0);
        int count = 0;
        for(int i=0; i<=level; ++i){
            System.out.println("Dist : " + i);
            count += findSumPath(root, n, new ValueSum(i), 0);
        }
        return count;
    }

    int findSumPath(TreeNode node, int n, ValueSum valueSum, int level){
        if(node == null){
            valueSum.addLast(Integer.MIN_VALUE); // null node
            return 0;
        }
        int count = 0;

        valueSum.addLast(node.value);
        
        //설정한 dist 만큼 원소가 들어왔는지 확인(중복 제거)
        if(valueSum.addedEnough() && valueSum.getSum() == n){
            ++count;
            valueSum.printList();
        }

        int leftCount = 0;
        int rightCount = 0;
        int removeFirst = Integer.MIN_VALUE;

        if(valueSum.addedEnough())
            removeFirst = valueSum.removeFirst();

        leftCount = findSumPath(node.left, n, valueSum, level+1);
        valueSum.removeLast();
        rightCount = findSumPath(node.right, n, valueSum, level+1);
        valueSum.removeLast();

        if(removeFirst != Integer.MIN_VALUE)
            valueSum.addFirst(removeFirst);
        
        return leftCount + rightCount + count;
    }

    int getTreeLevel(TreeNode node, int level){
        if(node == null){
            return level-1;
        }
        int leftLevel = getTreeLevel(node.left, level+1);
        int rightLevel = getTreeLevel(node.right, level+1);

        return leftLevel > rightLevel ? leftLevel : rightLevel;
    }

    // 4.12 Solution
    int countPathsWithSum(TreeNode root, int targetSum){
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer,Integer>());
    }

    int countPathsWithSum(TreeNode node, int targetSum, 
                int runningSum, HashMap<Integer, Integer> pathCount){        
        if(node  == null){ return 0; }

        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if(runningSum == targetSum){
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer,Integer> hashTable, int key, int delta){
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if(newCount == 0){
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
/////////////////////////////////////////////////
    public void inOrderTraversal(TreeNode root){
        if(root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

}