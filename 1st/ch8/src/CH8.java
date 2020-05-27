import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

public class CH8{
    // public static void main(String[] args) {
        
    //     // System.out.println("Fibo 10 : " + fibonacciDynamicBtmUp(10));

    //     //8.1 Triple Step
    //     // System.out.println("Step : " + countWays(3));

    //     //8.2
    //     // int[][] maze = {
    //     //     {1,1,1,1,0,1,1,1,1,1},
    //     //     {1,1,1,1,0,1,1,1,1,1},
    //     //     {1,1,1,1,0,1,1,1,1,1},
    //     //     {1,1,1,1,1,1,1,1,1,1},
    //     //     {1,1,1,1,0,1,1,1,1,1}
    //     // };

    //     // ArrayList<Point> result = findPath(maze);

    //     // for(int i=0; i<result.size(); ++i){
    //     //     System.out.println("(" + result.get(i).getX() + "," + result.get(i).getY() + ")");
    //     // }

    //     //8.3
    //     // int[] arr = {0,1,2,5,6,7};
    //     // int[] arr = {0,1,2,3,4,5};
    //     // int[] arr = {2,2,2,3,3,5};
    //     // ArrayList<Integer> list= findMagicIndex(arr);
    //     // for(int num : list)
    //     //     System.out.println(num);

    //     //8.4
    //     // int arr[] = {1,2,3,4,5,6};
    //     // ArrayList<String> resultList = findSubSet(arr);
        
    //     // for(int i=0; i<resultList.size(); ++i){
    //     //     System.out.println((i+1) + " : " + resultList.get(i));
    //     // }

    //     ////////////////////////////////////////////////////////

    //     // ArrayList<Integer> set = new ArrayList<>();
    //     // set.add(1);
    //     // set.add(2);
    //     // set.add(3);
    //     // set.add(4);

    //     // ArrayList<ArrayList<Integer>> allSubsets = getSubsetCom(set);
        
    //     // System.out.println("Result : ");
    //     // int i=0;
    //     // for(ArrayList<Integer> subset : allSubsets){
    //     //     System.out.print((i+1) + " : ");
    //     //     for(int n : subset){
    //     //         System.out.print(n + " ");
    //     //     }
    //     //     System.out.println();
    //     //     ++i;
    //     // }

    //     //8.5
    //     // System.out.println(reculsiveMultiplication(9, 9));

    //     // System.out.println(minProductS2(8, 12));

    //     //8.6
    //     // towerOfHanoi(5);

    //     //8.7
    //     // ArrayList<String> allPermutations = getPermutationWithNoDuplication("abcde");
    //     // for(String s : allPermutations)
    //     //     System.out.println(s);

    //     // String s = "a";
    //     // System.out.println(s.substring(2));

    //     // HashSet<String> allPermutations = getPermsWithDuplication("aab");
    //     // for(String s : allPermutations)
    //     //     System.out.println(s);

    //     // ArrayList<String> allPermutations = printPerms("aabbbbc");
    //     // for(String s : allPermutations)
    //     //     System.out.println(s);

    //     //8.9
    //     // ArrayList<String> allParenthesesSet = makeParenthesesSet(3);
    //     // for(String set : allParenthesesSet)
    //     //     System.out.println(set);


    //     // 8.10
    //     // HashSet<Point> set = new HashSet<>();
    //     // Point p1 = new Point(23, 3);
    //     // Point p2 = new Point(2, 33);
    //     // Point p3 = new Point(23, 3);
    //     // set.add(p1);
    //     // set.add(p2);
        
    //     // if(set.contains(p3))
    //     //     System.out.println("Already Exist Point");

    //     // for(Point p : set){
    //     //     System.out.println(p.getX() + "," + p.getY());
    //     // }

    //     // int[][] image = {
    //     //     {1,1,1,1,1,1,1,1,1,1},
    //     //     {1,1,2,1,3,1,1,1,1,1},
    //     //     {1,1,3,3,3,2,1,3,3,1},
    //     //     {1,1,4,3,3,3,1,1,1,1},
    //     //     {1,1,1,1,1,1,1,1,1,1}
    //     // };

    //     // for(int i=0; i<image.length; ++i){
    //     //     for(int j=0; j<image[0].length; ++j){
    //     //         System.out.print(image[i][j]+" ");
    //     //     }
    //     //     System.out.println();
    //     // }

    //     // paintFill(image, 0, 0, 7);

    //     // for(int i=0; i<image.length; ++i){
    //     //     for(int j=0; j<image[0].length; ++j){
    //     //         System.out.print(image[i][j]+" ");
    //     //     }
    //     //     System.out.println();
    //     // }

    //     //8.11
    //     // HashSet<String> list = coins(60);
    //     // for(String s : list){
    //     //     System.out.println(s);
    //     // }
        
    //     // System.out.println(makeChange(10));

    //     //8.12
    //     eightQueens(new int[4][4]);
    // }

    public int fibonacci(int i){
        if(i == 0)
            return 0;
        if (i == 1)
            return 1;
        
        return fibonacci(i-2) + fibonacci(i-1);
    }

    public int fibonacciDynamic(int i){
        int[] memo = new int[i+1];

        return fibonacciDynamicHelper(i, memo);
    }

    private int fibonacciDynamicHelper(int i, int[] memo){
        if(i == 0)
            return 0;
        if(i == 1)
            return 1;

        if(memo[i] == 0){
            memo[i] = fibonacciDynamicHelper(i-2, memo) + fibonacciDynamicHelper(i-1, memo);
        }
        
        return memo[i];
    }

    public int fibonacciDynamicBtmUp(int n){
        return fibonacciDynamicHelper(n, new int[n+1]);
    }

    private int fibonacciDynamicBtmUpHelper(int n, int[] memo){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        
        memo[0] = 0;
        memo[1] = 1;

        for(int i=2; i<memo.length; ++i){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    private int tripleStep(int n){
        return tripleStepHelper(n, new int[n+1]);
    }

    private int tripleStepHelper(int n, int[] memo){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i=4; i<=n; ++i){
            memo[i] = memo[i-3] + memo[3];
        }

        return memo[n];
    }

    public int countWays(int n){
        return countWaysHelper(n, new int[n+1]);
    }

    public int countWaysHelper(int n, int[] memo){
        if(n<0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }

        if(memo[n] == 0){
            memo[n] = countWaysHelper(n-1, memo) + countWaysHelper(n-2, memo) + countWaysHelper(n-3, memo);
        }

        return memo[n];
    }

    // //8.2 Solution #1 - DFS-like
    // public ArrayList<Point> findPath(int[][] maze){
    //     Point curPos = new Point(0,0);

    //     while(true){
    //         if(moveRight(maze, curPos)){

    //         } else if(moveDown(maze, curPos)){

    //         } else {

    //         }
    //     }
    // }

    // public boolean moveRight(int[][] maze, Point curPos){
    //     if(curPos.getX()+1 > maze[0].length){
    //         return false;
    //     }
    //     else if(maze[curPos.getX()+1][curPos.getY()] == 0){
    //         return false;
    //     }
    //     else{
    //         curPos.setX(curPos.getX()+1);
    //         return true;
    //     }
    // }

    // public boolean moveDown(int[][] maze, Point curPos){
    //     if(curPos.getY() + 1 > maze.length){
    //         return false;
    //     }
    //     else if(maze[curPos.getX()][curPos.getY()+1] == 0){
    //         return false;
    //     }
    //     else{
    //         curPos.setY(curPos.getY()+1);
    //         return true;
    //     }
    // }

    // 8.2 Solution #2
    // public ArrayList<Point> findPath(int[][] maze){
    //     int r = maze.length;
    //     int c = maze[0].length;
    //     ArrayList<Point> path = new ArrayList<>();
    //     HashSet<Point> failedPoints = new HashSet<>();
    //     findPath(maze, path, r-1, c-1, failedPoints);

    //     return path;
    // }

    // public boolean findPath(int[][] maze, ArrayList<Point> path, int r, int c, HashSet<Point> failedPoints){
    //     if(r < 0 || c < 0 || maze[r][c] == 0)
    //         return false;

    //     boolean isAtOrigin = (r == 0) && (c == 0);
    //     Point Point = new Point(r, c);

    //     if(failedPoints.contains(Point))
    //         return false;
        
    //     if(isAtOrigin || findPath(maze, path, r-1, c, failedPoints) || findPath(maze, path, r, c-1, failedPoints)){
    //         path.add(Point);
    //         return true;
    //     }

    //     failedPoints.add(Point);
    //     return false;
    // }

    //8.3
    public ArrayList<Integer> findMagicIndex(int[] arr){
        ArrayList<Integer> resultList = new ArrayList<>();
        findMagicIndexHelper(arr, 0, arr.length-1, resultList);

        return resultList;
    }

    public void findMagicIndexHelper(int[] arr, int first, int last, ArrayList<Integer> resultList){
        int mid = (first + last)/2;

        if(first > last)
            return;
        
        // if(mid == arr[mid]){
        //     resultList.add(mid);
        //     findMagicIndexHelper(arr, first, mid-1, resultList);
        //     findMagicIndexHelper(arr, mid+1, last, resultList);
        // } else if(mid < arr[mid]){
        //     findMagicIndexHelper(arr, first, mid-1, resultList);
        // } else {
        //     findMagicIndexHelper(arr, mid+1, last, resultList);
        // }
        if(mid == arr[mid])
            resultList.add(mid);

        findMagicIndexHelper(arr, first, mid-1, resultList);
        findMagicIndexHelper(arr, mid+1, last, resultList);
    }

    // 8.4 #1 My solution
    public ArrayList<String> findSubSet(int[] set){
        return findSubSet(set, 0, set.length-1);
    }

    public ArrayList<String> findSubSet(int[] set, int first, int last){
        if(first == last){
            ArrayList<String> resultList = new ArrayList<>();
            resultList.add(set[first]+"");
            return resultList;
        }
        
        int mid = (first+last)/2;

        ArrayList<String> leftSubset = findSubSet(set, first, mid);
        ArrayList<String> rightSubset = findSubSet(set, mid+1, last);

        ArrayList<String> resultSubset = new ArrayList<>();
        
        for(String l : leftSubset)
            resultSubset.add(l);
        
        for(String r : rightSubset)
            resultSubset.add(r);
        
        for(String l : leftSubset){
            for(String r : rightSubset){
                    resultSubset.add(l+" "+r);
                }
            }
        
        return resultSubset;
    }

    //8.4 Solution #1 Reculsive
    public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        if(set.size()-1 == index){
            allSubsets.add(new ArrayList<Integer>());
            ArrayList<Integer> subset = new ArrayList<>();
            subset.add(set.get(index));
            allSubsets.add(subset);
            return allSubsets;
        } else {
            allSubsets = getSubset(set, index+1);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            int item = set.get(index);

            for(ArrayList<Integer> subset : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    //8.4 Solution #2 roop
    public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        allSubsets.add(new ArrayList<Integer>());
        ArrayList<Integer> initSubset = new ArrayList<>();
        initSubset.add(set.get(0));
        allSubsets.add(initSubset);

        for(int i=1; i<set.size(); ++i){
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            // moreSubsets.addAll(allSubsets);

            // for(ArrayList<Integer> subset : moreSubsets){
            //     subset.add(set.get(i));
            // }

            // allSubsets.addAll(moreSubsets);

            for(ArrayList<Integer> subset : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(set.get(i));
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    //8.4 Solution #2 Combinatorics
    public ArrayList<ArrayList<Integer>> getSubsetCom(ArrayList<Integer> set){
        System.out.println("getSubsetCom");
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();
        for(int i=0; i<max; ++i){
            allSubsets.add(convertIntToSubset(set, i));
        }

        return allSubsets;
    }

    public ArrayList<Integer> convertIntToSubset(ArrayList<Integer> set, int num){
        ArrayList<Integer> subset = new ArrayList<>();
        for(int i=0; i<set.size(); ++i){
            if(((num >> i) & 1) == 1){
                subset.add(set.get(i));
            }
        }

        return subset;
    }

    //8.5
    public int reculsiveMultiplication(int a, int b){
        if(b == 0)
            return 0;
        return reculsiveMultiplication(a, b-1) + a;
    }

    //8.5 Solution #1
    public int minProduct(int smaller, int bigger){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        }
        int s = smaller >> 1;
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if(smaller%2 != 0)
            side2 = minProduct(smaller-s, bigger);
        
        return side1 + side2;
    }

    public int minProductS2(int smaller, int bigger){
        int[] cache = new int[smaller+1];

        return minProductS2Helper(smaller, bigger, cache);
    }

    public int minProductS2Helper(int smaller, int bigger, int[] cache){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        }

        if(cache[smaller] != 0)
            return cache[smaller];
        
        int s = smaller >> 1;
        int side1 = minProductS2Helper(s, bigger, cache);
        int side2 = side1;
        if(smaller%2 != 0)
            side2 = minProductS2Helper(smaller-s, bigger, cache);
        
        cache[smaller] = side1 + side2;

        return cache[smaller];
    }

    public static final int COLUMN1 = 0;
    public static final int COLUMN2 = 1;
    public static final int COLUMN3 = 2;

    public void towerOfHanoi(int n){
        // LinkedList<Integer>[] columns = new LinkedList<Integer>[3];
        ArrayList<LinkedList<Integer>> columns = new ArrayList<>();
        columns.add(new LinkedList<Integer>());
        columns.add(new LinkedList<Integer>());
        columns.add(new LinkedList<Integer>());


        for(int i=n; i>0; --i){
            columns.get(COLUMN1).add(i);
        }

        movePlate(columns, COLUMN3, COLUMN1, COLUMN2, n);

        for(int plate : columns.get(COLUMN3))
            System.out.print(plate + " ");
    }

    public void movePlate(ArrayList<LinkedList<Integer>> columns, int to, int from, int other, int num){
        System.out.println("status");
        System.out.print("Colum 1 : ");
        for(int plate : columns.get(0))
            System.out.print(plate + " ");
        
        System.out.println();

        System.out.print("Colum 2 : ");
        for(int plate : columns.get(1))
            System.out.print(plate + " ");
            
        System.out.println();

        System.out.print("Colum 3 : ");
        for(int plate : columns.get(2))
            System.out.print(plate + " ");
        
        System.out.println();

        if(num == 1){
            columns.get(to).add(columns.get(from).removeLast());
            return;
        }
        movePlate(columns, other, from, to, num-1);
        movePlate(columns, to, from, other, 1);
        movePlate(columns, to, other, from, num-1);
    }

    public ArrayList<String> getPermutationWithNoDuplication(String s){
        HashSet<Character> usedChar = new HashSet<>();

        return getPermutationWithNoDuplication(s, usedChar, s.length());
    }

    //8.7 Solution 2
    public ArrayList<String> getPermutationWithNoDuplication(String s, HashSet<Character> usedChar, int len){
        if(len == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        ArrayList<String> allPermutations = new ArrayList<>();

        for(int i=0; i<s.length(); ++i){
            if(usedChar.contains(s.charAt(i)))
                continue;
            usedChar.add(s.charAt(i));

             ArrayList<String> permutations = getPermutationWithNoDuplication(s, usedChar, len-1);

            for(String permutation : permutations){
                permutation = s.charAt(i)+permutation;
                allPermutations.add(permutation);
            }
            
            usedChar.remove(s.charAt(i));
        }

        return allPermutations;
    }

    //8.7 Solution 1
    public ArrayList<String> getPerms(String s){
        ArrayList<String> allPermutations = new ArrayList<>();
        if(s.length() == 0){
            allPermutations.add("");
            return allPermutations;
        }
        char firstChar = s.charAt(0);
        String remainder = s.substring(1);

        ArrayList<String> newPermutations = getPerms(remainder);

        for(String perm : newPermutations){
            for(int j=0; j<=perm.length(); ++j){
                allPermutations.add(InsertCharAt(perm, j, firstChar));
            }
        }
        return allPermutations;

    }

    public static String InsertCharAt(String s, int index, char c){
        String leftSub = s.substring(0, index);
        String rightSub = s.substring(index);

        return leftSub + c + rightSub;
        
    }

    //8.8
    public HashSet<String> getPermsWithDuplication(String s){
        HashSet<String> allPermutations = new HashSet<>();

        if(s.length() == 0){
            allPermutations.add("");
            return allPermutations;
        }

        char firstChar = s.charAt(0);
        String remainder = s.substring(1);
        
        HashSet<String> newPermutations = getPermsWithDuplication(remainder);
        
        for(String perm : newPermutations){
            for(int j=0; j<=perm.length(); ++j){
                allPermutations.add(InsertCharAt(perm, j, firstChar));
            }
        }
        
        return allPermutations;
    }

    //8.8 Solution
    public ArrayList<String> printPerms(String s){
        HashMap<Character, Integer> freqMap = buildFreqTable(s);
        ArrayList<String> result = new ArrayList<>();
        printPerms(freqMap, "", s.length(), result);
        
        return result;
    }
    public void printPerms(HashMap<Character, Integer> freqMap, String prefix,
                                                int remaining, ArrayList<String> result){

        if(remaining == 0){
            result.add(prefix);
            return;
        }

        for(char c : freqMap.keySet()){
            int count = freqMap.get(c);
            if(count == 0){
                continue;
            }
            freqMap.put(c, count-1);
            printPerms(freqMap, prefix+c, remaining-1, result);
            freqMap.put(c, count);
        }
    }

    public HashMap<Character, Integer> buildFreqTable(String s){
        HashMap<Character, Integer> freqTable = new HashMap<>();

        for(char c : s.toCharArray()){
            if(!freqTable.containsKey(c)){
                freqTable.put(c, 0);
            }
            freqTable.put(c, freqTable.get(c)+1);
        }

        return freqTable;
    }

    //8.9
    public ArrayList<String> makeParenthesesSet(int numParentheses){
        ArrayList<String> result = new ArrayList<>();
        makeParenthesesSet(numParentheses, numParentheses, "", result);

        return result;
    }

    public void makeParenthesesSet(int lCount, int rCount, String prev, ArrayList<String> result){

        if(lCount == 0 && rCount == 0){
            result.add(prev);
            return;
        }

        if(lCount == 0){
            makeParenthesesSet(lCount, rCount-1, prev+')', result);
        } else if(lCount == rCount){
            makeParenthesesSet(lCount-1, rCount, prev+'(', result);
        } else {
            makeParenthesesSet(lCount-1, rCount, prev+'(', result);
            makeParenthesesSet(lCount, rCount-1, prev+')', result);
        }

    }

    //8.10
    public void paintFill(int[][] org, int row, int col, int changeColor){
        HashSet<Point> visitInfo = new HashSet<>();
        Point pos = new Point(row, col);
        int orgColor = org[row][col];
        System.out.println("row: " + row + " col: " + col + " Current Color : " + orgColor + " Change Color : " + changeColor);
        paintFill(org, pos, orgColor, changeColor, visitInfo);
    }

    public void paintFill(int[][] org, Point pos, int orgColor, int changeColor, HashSet<Point> visitInfo){

        if((pos.getRow() > org.length-1 || pos.getRow() < 0) || (pos.getCol() > org[0].length-1 || pos.getCol() < 0)){
            return;
        }

        if (visitInfo.contains(pos))
            return;
        
        int color = org[pos.getRow()][pos.getCol()];

        if(color == orgColor){
            org[pos.getRow()][pos.getCol()] = changeColor;
            visitInfo.add(pos);
            paintFill(org, new Point(pos.getRow()+1, pos.getCol()+1), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow()+1, pos.getCol()), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow()+1, pos.getCol()-1), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow(), pos.getCol()+1), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow(), pos.getCol()-1), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow()-1, pos.getCol()+1), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow()-1, pos.getCol()), orgColor, changeColor, visitInfo);
            paintFill(org, new Point(pos.getRow()-1, pos.getCol()-1), orgColor, changeColor, visitInfo);
        }

    }

    //8.11
    // 내 풀이 -> 너무 느림 (60부터)
    // public HashSet<String> coins(int n){
    //     HashSet<String> result = new HashSet<>();
    //     Cents cents = new Cents();
    //     coins(n, cents, result);
    //     return result;
    // }

    // public void coins(int remainder, Cents cents, HashSet<String> result){

    //     if(remainder < 0)
    //         return;
        
    //     if(remainder == 0){
    //         result.add(cents.numQuarters+","+cents.numDimes+","+cents.numNickels+","+cents.numPennies);
    //         return;
    //     }

    //     ++cents.numQuarters;
    //     coins(remainder-Cents.QUARTER, cents, result);
    //     --cents.numQuarters;

    //     ++cents.numDimes;
    //     coins(remainder-Cents.DIME, cents, result);
    //     --cents.numDimes;

    //     ++cents.numNickels;
    //     coins(remainder-Cents.NICKEL, cents, result);
    //     --cents.numNickels;

    //     ++cents.numPennies;
    //     coins(remainder-Cents.PENNY, cents, result);
    //     --cents.numPennies;
    // }

    //Solution -> 이상함
    public int makeChange(int n){
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    public int makeChange(int amount, int[] denoms, int index){
        if(index == denoms.length)
            return 1;

        int ways = 0;
        int denomAmount = denoms[index];

        for(int i=0; i*denomAmount <= amount; ++i){
            int remainder = amount - i*denomAmount;
            ways += makeChange(remainder, denoms, index+1);
        }

        return ways;
    }

    //8.12 (미완성)
    public void eightQueens(int[][] board){
        int[][] visitInfo = new int[board.length][board[0].length];
        eightQueens(board, visitInfo, 0);
    }

    public void eightQueens(int[][] board, int[][] visitInfo, int column){

        if(column >= board[0].length){
            for(int i=0; i<visitInfo.length; ++i){
                for(int j=0; j<visitInfo[0].length; ++j){
                    System.out.print(visitInfo[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        
        for(int i=0; i<visitInfo.length; ++i){
            for(int j=0; j<visitInfo[0].length; ++j){
                System.out.print(visitInfo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0; i<board.length; ++i){
            if(visitInfo[i][column] == 2)
                continue;
            
            for(int j=0; j<board[0].length; ++j){
                visitInfo[j][column] = 2;
                visitInfo[i][j] = 2;
                
                if(i+j+1 < board.length-1 && column+j+1 < board[0].length-1)
                    visitInfo[i+j+1][column+j+1] = 2;
            }

            visitInfo[i][column] = 1;
            eightQueens(board, visitInfo, column+1);
        }
    }

    // 8.12 Solution
    public static final int GRID_SIZE = 8;

    public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row == GRID_SIZE){
            results.add(columns.clone());
            return;
        }

        for(int col = 0; col<GRID_SIZE; ++col){
            if(checkValid(columns, row, col)){
                columns[row] = col;
                placeQueens(row+1, columns, results);
            }
        }
    }

    public boolean checkValid(Integer[] columns, int row1, int column1){
        for(int row2 = 0; row2<row1; ++row2){
            int column2 = columns[row2];

            if(column2 == column1)
                return false;

            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = Math.abs(row1 - row2);

            if(columnDistance == rowDistance)
                return false;
        }
        return true;
    }

    // 8.13 Solution 1
    public int createStack(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];

        for(int i=0; i<boxes.size(); ++i){
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    public int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap){

        if(stackMap[bottomIndex] != 0)
            return stackMap[bottomIndex];
        
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for(int i=bottomIndex+1; i<boxes.size(); ++i){
            int height = 0;
            if(boxes.get(i).canBeAbove(bottom)){
                height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        stackMap[bottomIndex] = maxHeight+bottom.height;
        return stackMap[bottomIndex];
    }


    class BoxComparator implements Comparator<Box>{
        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }
}

