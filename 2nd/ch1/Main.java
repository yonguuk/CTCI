public class Main{
    public static void main(String[] args) {
        CH1 ch1 = new CH1();

        //1.1
        // String str = "adbqwrknmlo";
        // if(ch1.hasDuplicateChar2(str))
        //     System.out.println("Dup!");
        // else
        //     System.out.println("Nope!");

        //1.2
        // String str1 = "applecccqr";
        // String str2 = "ppleaccqcr";
        // if(ch1.permutation(str1, str2))
        //     System.out.println("True");
        // else
        //     System.out.println("False");

        //1.3
        // String str = "Mr John Smith";
        // char[] strArr = str.toCharArray();
        // System.out.println(strArr.length);
        // char[] arr = new char[100];
        // System.arraycopy(str.toCharArray(), 0, arr, 0, strArr.length);
        // ch1.replaceSpace(arr, strArr.length);
        // for(int i=0; i<arr.length; ++i){
        //     System.out.print(arr[i]);
        // }
        // System.out.println();

        // 1.4
        // String str = "Tact cCoa";
        // if(ch1.isPermutationOfPalindrome(str))
        //     System.out.println("true");
        // else
        //     System.out.println(false);

        //1.5
        // String str1 = "pale";
        // String str2 = "pales";
        // if(ch1.oneEditAway2(str1, str2))
        //     System.out.println("True");
        // else
        //     System.out.println("False");

        //1.6
        // String str = "aabcccccaaad";
        // System.out.println(ch1.compress2(str));

        //1.7
        // int[][] matrix = {
        //     {1,1,1,1,1,1,1},
        //     {2,2,2,2,2,2,2},
        //     {3,3,3,3,3,3,3},
        //     {4,4,4,4,4,4,4},
        //     {5,5,5,5,5,5,5},
        //     {6,6,6,6,6,6,6},
        //     {7,7,7,7,7,7,7}
        // };
        // int[][] matrix = {
        //     {1,1,1,1,1},
        //     {2,2,2,2,2},
        //     {3,3,3,3,3},
        //     {4,4,4,4,4},
        //     {5,5,5,5,5}
        // };
        // int[][] matrix = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9}
        // };
        // ch1.rotateMatrix(matrix);
        // for(int i=0; i<matrix.length; ++i){
        //     for(int j=0; j<matrix[0].length; ++j){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int[][] matrix = {
            {1,1,1,1,0},
            {1,1,1,1,1},
            {1,1,0,1,1},
            {1,1,0,1,1}
        };
        ch1.setZeros3(matrix);
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}