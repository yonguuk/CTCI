import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        CH8 ch8 = new CH8();
        // System.out.println("Fibo 10 : " + fibonacciDynamicBtmUp(10));

        //8.1 Triple Step
        // System.out.println("Step : " + countWays(3));

        //8.2
        // int[][] maze = {
        //     {1,1,1,1,0,1,1,1,1,1},
        //     {1,1,1,1,0,1,1,1,1,1},
        //     {1,1,1,1,0,1,1,1,1,1},
        //     {1,1,1,1,1,1,1,1,1,1},
        //     {1,1,1,1,0,1,1,1,1,1}
        // };

        // ArrayList<Point> result = findPath(maze);

        // for(int i=0; i<result.size(); ++i){
        //     System.out.println("(" + result.get(i).getX() + "," + result.get(i).getY() + ")");
        // }

        //8.3
        // int[] arr = {0,1,2,5,6,7};
        // int[] arr = {0,1,2,3,4,5};
        // int[] arr = {2,2,2,3,3,5};
        // ArrayList<Integer> list= findMagicIndex(arr);
        // for(int num : list)
        //     System.out.println(num);

        //8.4
        // int arr[] = {1,2,3,4,5,6};
        // ArrayList<String> resultList = findSubSet(arr);
        
        // for(int i=0; i<resultList.size(); ++i){
        //     System.out.println((i+1) + " : " + resultList.get(i));
        // }

        ////////////////////////////////////////////////////////

        // ArrayList<Integer> set = new ArrayList<>();
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // set.add(4);

        // ArrayList<ArrayList<Integer>> allSubsets = getSubsetCom(set);
        
        // System.out.println("Result : ");
        // int i=0;
        // for(ArrayList<Integer> subset : allSubsets){
        //     System.out.print((i+1) + " : ");
        //     for(int n : subset){
        //         System.out.print(n + " ");
        //     }
        //     System.out.println();
        //     ++i;
        // }

        //8.5
        // System.out.println(reculsiveMultiplication(9, 9));

        // System.out.println(minProductS2(8, 12));

        //8.6
        // towerOfHanoi(5);

        //8.7
        // ArrayList<String> allPermutations = getPermutationWithNoDuplication("abcde");
        // for(String s : allPermutations)
        //     System.out.println(s);

        // String s = "a";
        // System.out.println(s.substring(2));

        // HashSet<String> allPermutations = getPermsWithDuplication("aab");
        // for(String s : allPermutations)
        //     System.out.println(s);

        // ArrayList<String> allPermutations = printPerms("aabbbbc");
        // for(String s : allPermutations)
        //     System.out.println(s);

        //8.9
        // ArrayList<String> allParenthesesSet = makeParenthesesSet(3);
        // for(String set : allParenthesesSet)
        //     System.out.println(set);


        // 8.10
        // HashSet<Point> set = new HashSet<>();
        // Point p1 = new Point(23, 3);
        // Point p2 = new Point(2, 33);
        // Point p3 = new Point(23, 3);
        // set.add(p1);
        // set.add(p2);
        
        // if(set.contains(p3))
        //     System.out.println("Already Exist Point");

        // for(Point p : set){
        //     System.out.println(p.getX() + "," + p.getY());
        // }

        // int[][] image = {
        //     {1,1,1,1,1,1,1,1,1,1},
        //     {1,1,2,1,3,1,1,1,1,1},
        //     {1,1,3,3,3,2,1,3,3,1},
        //     {1,1,4,3,3,3,1,1,1,1},
        //     {1,1,1,1,1,1,1,1,1,1}
        // };

        // for(int i=0; i<image.length; ++i){
        //     for(int j=0; j<image[0].length; ++j){
        //         System.out.print(image[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // paintFill(image, 0, 0, 7);

        // for(int i=0; i<image.length; ++i){
        //     for(int j=0; j<image[0].length; ++j){
        //         System.out.print(image[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //8.11
        // HashSet<String> list = coins(60);
        // for(String s : list){
        //     System.out.println(s);
        // }
        
        // System.out.println(makeChange(10));

        //8.12
        // ch8.eightQueens(new int[4][4]);

        //8.13
        ArrayList<Box> boxes = new ArrayList<>();
        Box b1 = new Box(1,2,3);
        Box b2 = new Box(2,4,6);
        Box b3 = new Box(1,2,5);
        Box b4 = new Box(3,2,4);
        Box b5 = new Box(1,2,1);
        Box b6 = new Box(5,3,7);
        Box b7 = new Box(4,1,3);

        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);
        boxes.add(b4);
        boxes.add(b5);
        boxes.add(b6);
        boxes.add(b7);

        // Box b1 = new Box(1,2,3);
        // Box b2 = new Box(2,4,6);
        // Box b3 = new Box(3,5,9);

        // boxes.add(b1);
        // boxes.add(b2);
        // boxes.add(b3);


        System.out.println(ch8.createStack(boxes));
    }
}