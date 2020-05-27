import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class CH8 {
    
    // 8.1
    public int tripleStep(int n, int[] memo){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 4;

        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = tripleStep(n-1, memo) + tripleStep(n-2, memo) + tripleStep(n-3, memo);
        return memo[n];
    }

    // 8.1 Solution
    int countWays(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    int countWays(int n, int[] memo){
        if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        } else if(memo[n] > -1){
            return memo[n];
        } else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }

    // 8.2
    public void findPath(int[][] grid, int row, int col, String path){

        if(row == grid.length-1 && col == grid[0].length-1){
            System.out.println(path.toString());
            return;
        }

        if(row+1 < grid.length && grid[row+1][col] != 0)
            findPath(grid, row+1, col, path+"D ");
        if(col+1 < grid[0].length && grid[row][col+1] != 0)
            findPath(grid, row, col+1, path+"R ");
    }

    // 8.2 Solution
    class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    // ArrayList<Point> getPath(boolean[][] maze){
    //     if(maze == null || maze.length == 0) return null;

    //     ArrayList<Point> path = new ArrayList<Point>();
    //     if(getPath(maze, maze.length-1, maze[0].length-1, path)){
    //         return path;
    //     }
    //     return null;
    // }

    // boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path){
    //     if(col < 0 || row < 0 || !maze[row][col]){
    //         return false;
    //     }

    //     boolean isAtOrigin = (row == 0) && (col == 0);

    //     if(isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze, row-1, col, path)){
    //         Point p = new Point(row, col);
    //         path.add(p);
    //         return true;
    //     }
    //     return false;
    // }

    ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0) return null;
    
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<>();
        if(getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)){
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
        if(col < 0 || row < 0 || !maze[row][col]){
            return false;
        }

        Point p = new Point(row, col);
        if(failedPoints.contains(p)){
            return false;
        } 

        boolean isAtOrigin = (row == 0) && (col == 0);

        if(isAtOrigin || getPath(maze, row, col-1, path, failedPoints) || 
                    getPath(maze, row-1, col, path, failedPoints)){
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    //8.3
    ArrayList<Integer> findMagicIndex(int a[]){
        boolean found = false;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<a.length; ++i){
            if(a[i] == i){
                if(found == false)
                    found = true;
                result.add(i);
                found = true;
            } else {
                if(found == true)
                    break;
            }
        }

        return result;
    }

    //8.3 Solution
    // int magicFast(int [] array){
    //     return magicFast(array, 0, array.length-1);
    // }
    
    // int magicFast(int[] array, int start, int end){
    //     if(start > end)
    //         return -1;

    //     int mid = (start + end)/2;

    //     if(array[mid] == mid){
    //         return mid;
    //     } else if(array[mid] < mid){
    //         return magicFast(array, mid+1, end);
    //     } else{
    //         return magicFast(array, start, mid-1);
    //     }
    // }

    //8.3 Follow up
    int magicFast(int [] array){
        return magicFast(array, 0, array.length-1);
    }
    
    int magicFast(int[] array, int start, int end){
        if(start > end)
            return -1;

        int midIndex = (start + end)/2;
        int midValue = array[midIndex];

        if(midValue == midIndex)
            return midIndex;

        int leftIndex = Math.min(midIndex-1, midValue);
        int left = magicFast(array, start, leftIndex);
        if(left >= 0){
            return left;
        }

        int rightIndex = Math.max(midIndex+1, midValue);
        int right = magicFast(array, rightIndex, end);
        return right;
    }

    //8.4 
    // ArrayList<HashSet<Character>> getSubsets(char[] set, int n){
    //     if(n < 0){
    //         ArrayList<HashSet<Character>> result = new ArrayList<>();
    //         HashSet<Character> list = new HashSet<>();
    //         list.add(' ');
    //         result.add(list);
    //         return result;
    //     }

    //     ArrayList<HashSet<Character>> subsets = getSubsets(set, n-1);
    //     ArrayList<HashSet<Character>> newSubsets = new ArrayList<>();

    //     for(HashSet<Character> subset : subsets){
    //         HashSet<Character> newSubset = (HashSet<Character>)subset.clone();
    //         newSubset.add(set[n]);
    //         newSubsets.add(newSubset);
    //     }

    //     subsets.addAll(newSubsets);

    //     return subsets;
    // }

    //8.4 Solution
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index){ // 초기 사례 - 공집합 추가
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // 공집합
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();

            for(ArrayList<Integer> subset : allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    // 8.5
    public int multipleTwoInt(int a, int b){
        int s = 1;
        int count=0;
        int bigger = a > b ? a : b;
        int smaller = a > b ? b : a;

        while(s*2 < smaller){
            s *= 2;
            ++count;
        }

        int result = bigger << count;
        int leftOver = smaller - s;
        System.out.println("result : " + result + " leftover : "  + leftOver);
        result += multipleTwoInt(bigger, leftOver, 0);

        return result;
    }

    public int multipleTwoInt(int bigger, int leftOver, int sum){
        if(leftOver == 0){
            return sum;
        }
        int result = multipleTwoInt(bigger, leftOver-1, sum+bigger);

        return result;
    }

    // 8.6
    public void towerOfHanoi(int n){
        Stack<Integer> column1 = new Stack<>();
        Stack<Integer> column2 = new Stack<>();
        Stack<Integer> column3 = new Stack<>();

        for(int i=n; i>0; --i){
            column1.push(i);
        }

        movePlate(column1, column2, column3, n-1);
        movePlate(column1, column3, column2, 1);
        movePlate(column2, column3, column1, n-1);

        for(int i : column3){
            System.out.println(i);
        }
    }

    private void movePlate(Stack<Integer> from, Stack<Integer> to, Stack<Integer> buffer, int n){
        if(n == 1){
            to.push(from.pop());
            return;
        }
        movePlate(from, buffer, to, n-1);
        movePlate(from, to, buffer, 1);
        movePlate(buffer, to, from, n-1);
    }

    // 8.7
    // ArrayList<String> getPermutaionNoDup(String str, int idx){
    //     ArrayList<String> perms;
    //     if(idx == 0){
    //         perms = new ArrayList<>();
    //         perms.add(str.charAt(idx)+"");
    //     }
    //     perms = getPermutaionNoDup(str, idx-1);

    //     for(String s : perms){

    //     }
    // }

    // 8.7 Solution #1
    // ArrayList<String> getPerms(String str){
    //     if(str == null) return null;

    //     ArrayList<String> permutations = new ArrayList<>();
    //     if(str.length() == 0){ // 초기 사례
    //         permutations.add("");
    //         return permutations;
    //     }

    //     char first = str.charAt(0);
    //     String remainder = str.substring(1); // 첫번째 문자를 지운다.
    //     ArrayList<String> words = getPerms(remainder);
    //     for(String word : words){
    //         for(int j=0; j<= word.length(); j++){
    //             String s = insertCharAt(word, first, j);
    //             permutations.add(s);
    //         }
    //     }
    //     return permutations;
    // }
    // private String insertCharAt(String word, char c, int i){
    //     String start = word.substring(0, i);
    //     String end = word.substring(i);
    //     return start + c + end;
    // }

    // 8.7 Solution #2
    // ArrayList<String> getPerms(String remainder){
    //     int len = remainder.length();
    //     ArrayList<String> result = new ArrayList<>();
    
    //     if(len == 0){
    //         result.add("");
    //         return result;
    //     }
    
    //     for(int i=0; i<remainder.length(); i++){
    //         String before = remainder.substring(0, i);
    //         String after = remainder.substring(i+1, len);
    //         ArrayList<String> partials = getPerms(before + after);
    //         for(String s : partials){
    //             result.add(remainder.charAt(i) + s);
    //         }
    //     }
    //     return result;
    // }

    // 8.7 Solution #3
    ArrayList<String> getPerms(String str){
        ArrayList<String> result = new ArrayList<>();
        getPerms("", str, result);
        return result;
    }

    void getPerms(String prefix, String remainder, ArrayList<String> result){
        if(remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for(int i=0; i<len; ++i){
            String before = remainder.substring(0, i);
            String after = remainder.substring(i+1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before+after, result);
        }
    }

    //8.9
    void parenthesesPairs(int n){
        parenthesesPairs(n, 1, 0, "(");
    }

    void parenthesesPairs(int n, int openCount, int closeCount, String prefix){
        if(openCount == n && closeCount == n){
            System.out.println(prefix);
            return;
        }

        if(openCount < n){
            parenthesesPairs(n, openCount+1, closeCount, prefix + "(");
        }

        if(closeCount < openCount && closeCount < n){
            parenthesesPairs(n, openCount, closeCount+1, prefix + ")");
        }
    }
    
    // 8.9 Solution
    void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
        if(leftRem < 0 || rightRem < leftRem) return; // 잘못된 상태

        if(leftRem == 0 && rightRem == 0){ // 남은 괄호가 없음
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, leftRem-1, rightRem, str, index+1);

            str[index] = ')';
            addParen(list, leftRem, rightRem-1, str, index+1);
        }
    }

    ArrayList<String> generateParens(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    //8.10
    public void paintArea(int[][] image, int row, int col, int org, int change, boolean[][] memo){
        if(row >= image.length || row < 0) return;
        if(col >= image[0].length || col < 0) return;
        
        if(memo[row][col] == true){
            return;
        }
        if(image[row][col] != org){
            return;
        }

        memo[row][col] = true;

        image[row][col] = change;
        paintArea(image, row+1, col, org, change, memo);
        paintArea(image, row, col+1, org, change, memo);
        paintArea(image, row-1, col, org, change, memo);
        paintArea(image, row, col-1, org, change, memo);
    }

    // 8.10 Solution
    enum Color {Black, White, Red, Yellow, Green}

    boolean PaintFill(Color[][] screen, int r, int c, Color ncolor){
        if(screen[r][c] == ncolor) return false;
        return PaintFill(screen, r, c, screen[r][c], ncolor);
    }

    boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor){
        if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length){
            return false;
        }

        if(screen[r][c] == ocolor){
            screen[r][c] = ncolor;
            PaintFill(screen, r-1, c, ocolor, ncolor);
            PaintFill(screen, r+1, c, ocolor, ncolor);
            PaintFill(screen, r, c-1, ocolor, ncolor);
            PaintFill(screen, r, c+1, ocolor, ncolor);
            
        }
        return true;
    }

    //8.11

    public void eightQueens(){
        int[][] board = new int[4][4];
        for(int i=0; i<board[0].length; ++i){
            eightQueens(board, 0, i);
        }
    }

    public void eightQueens(int[][] board, int row, int col){
        if(board[row][col] != 0){
            return;
        } else {
            putQueen(board, row, col);
            board[row][col] = 1;
        }

        if(row == board.length){
            for(int[] i : board){
                for(int j : i){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int i=0; i<board[0].length; ++i){
            eightQueens(board, row+1, i);
        }
    }

    private void putQueen(int[][] board, int row, int col){
        if(row < 0 || row >= board.length) return;
        if(col < 0 || col >= board[0].length) return;

        board[row][col] = -1;

        putQueen(board, row+1, col+1);
        putQueen(board, row+1, col);
        putQueen(board, row+1, col-1);
        putQueen(board, row, col+1);
        putQueen(board, row, col-1);
        putQueen(board, row-1, col+1);
        putQueen(board, row-1, col);
        putQueen(board, row-1, col-1);
    }

    //8.12 Solution
    int GRID_SIZE = 8;

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row == GRID_SIZE){ // 올바른 결과를 찾음
            results.add(columns.clone());
        } else{
            for(int col = 0; col < GRID_SIZE; col++){
                if(checkValid(columns, row, col)){
                    columns[row] = col;
                    placeQueens(row+1, columns, results);
                }
            }
        }
    }

    /* 
     * (row1, column1) 이 퀸을 놓기 좋은 자리인지 확인한다.
     * 현재와 같은 열 혹은 대각선에 다린 퀸이 있는지 확인한다. 퀸이 같은 행에 있는지는
     * 확인하지 안하도 된다. 왜냐하면 placeQueen은 한 번에 하나의 퀸만 배치하기 때문이다.
     * 따라서 현재 행은 언제나 비어 있다.
    */
    boolean checkValid(Integer[] columns, int row1, int column1){
        for(int row2 = 0; row2<row1; row2++){
            int column2 = columns[row2];
            // (row2, column2) 때문에 (row1, column1)에 퀸을 놓을 수 없는지 확인한다.
            //같은 열에 퀸이 있는지 확인한다.
            if(column1 == column2){
                return false;
            }

            /* 대각선 검사 : 열 사이의 거리 차이와 행 사이의 거리 차이가 같으면
             * 이들은 같은 대각선 상에 있다고 말할 수 있다.
             */
            int columnDistance = Math.abs(column2 - column1);
            // row1 > row2 라면 abs를 사용할 필요가 없다.
            int rowDistance = row1 - row2;
            if(columnDistance == rowDistance){
                return false;
            }
        }
        return true;
    }

    // 8.13 Solution
    class Box{
        int width;
        int height;
        int depth;

        boolean canBeAbove(Box bottom){
            if(bottom.width >= this.width && bottom.height >= this.height && 
                bottom.depth >= this.depth)
                return true;
            else
                return false;
        }
    }

    class BoxComparator implements Comparator<Box>{
        @Override
        public int compare(Box x, Box y){
            return y.height - x.height;
        }
    }

    // 8.13 Solution #1
    // int createStack(ArrayList<Box> boxes){
    //     // 높이를 기준으로 내림차순으로 정렬하기
    //     Collections.sort(boxes, new BoxComparator());
    //     int maxHeight = 0;
    //     int[] stackMap = new int[boxes.size()];
    //     for(int i=0; i<boxes.size(); i++){
    //         int height = createStack(boxes, i, stackMap);
    //         maxHeight = Math.max(maxHeight, height);
    //     }
    //     return maxHeight;
    // }
    
    // int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap){
    //     if(bottomIndex < boxes.size() && stackMap[bottomIndex] > 0){
    //         return stackMap[bottomIndex];
    //     }
    //     Box bottom = boxes.get(bottomIndex);
    //     int maxHeight = 0;
    //     for(int i=bottomIndex+1; i<boxes.size(); i++){
    //         if(boxes.get(i).canBeAbove(bottom)){
    //             int height = createStack(boxes,i, stackMap);
    //             maxHeight = Math.max(height, maxHeight);
    //         }
    //     }
    //     maxHeight += bottom.height;
    //     stackMap[bottomIndex] = maxHeight;
    //     return maxHeight;
    // }



    // 8.13 Solution #2
    int createStack(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack(boxes, null, 0, stackMap);
    }

    int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap){
        if(offset >= boxes.size()) return 0; // 초기 사례

        // 현재 상자가 바닥일 때의 높이
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if(bottom == null || newBottom.canBeAbove(bottom)){
            if(stackMap[offset] == 0){
                stackMap[offset] = createStack(boxes, newBottom, offset+1, stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }

        // 바닥이 아닐 때
        int heightWithoutBottom = createStack(boxes, bottom, offset+1, stackMap);
        
        //둘 중 더 나은 것을 반환
        return Math.max(heightWithBottom, heightWithoutBottom);
    }
}