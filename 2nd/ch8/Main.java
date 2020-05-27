import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CH8 ch8 = new CH8();

        //8.1
        // int n = 20;
        // int[] memo = new int[n+1];
        // System.out.println(ch8.tripleStep(n, memo));
        // System.out.println(ch8.countWays(n));

        // 8.2
        // int[][] grid = {
        //                 {1,1,1,1,1,1},
        //                 {0,1,1,1,1,0},
        //                 {1,1,0,1,1,1},
        //                 {1,1,1,1,1,0},
        //                 {1,1,1,1,1,1},
        //                         };
        // ch8.findPath(grid, 0, 0, new String());

        // 8.3
        // int[] a = {-2, -1, 0, 2, 4, 5, 6, 7, 10, 11, 12};
        // for(int i : ch8.findMagicIndex(a)){
        //     System.out.print(i + " ");
        // }
        // System.out.println();


        // 8.4
        // char[] set = {'a', 'b', 'c', 'd', 'e'};
        // char[] set = {'a', 'b', 'c'};
        // ArrayList<HashSet<Character>> subsets = ch8.getSubsets(set, set.length-1);
        
        // for(HashSet<Character> subset : subsets){
        //     for(char c : subset){
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }

        //8.5
        // System.out.println(ch8.multipleTwoInt(854, 981));

        //8.6
        // ch8.towerOfHanoi(10);

        //8.7
        // ArrayList<String> perms = new ArrayList<>();
        // ch8.getPermutaionNoDup("abcd", "", 0, perms);
        // for(String s : perms)
        //     System.out.println(s);


        //8.9
        // ch8.parenthesesPairs(10);

        //8.10

        int[][] image = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        for(int[] i : image){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        ch8.paintArea(image, 3, 3, 1, 2, new boolean[image.length][image[0].length]);

        for(int[] i : image){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        ch8.eightQueens();
    } // main
}