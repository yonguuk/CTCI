public class Main{
    public static void main(String[] args) {
        
        CH10 ch10 = new CH10();

        //10.1
        // int[] arrA = {2,3,5,6,7,0,0,0,0,0};
        // int[] arrB = {1,4,8,9,10};

        // ch10.mergeSortedArrays(arrA, arrB);


        // for(int i=0; i<arrA.length; ++i)
        //     System.out.print(arrA[i] + " ");


        //10.2 - Sort Anagram
        // String[] strings = {"apple", "cider", "pplae", "abc", "abcd", "banana", "redic", "cab", "nanaba"};
        // // ch10.sortAnagramStringArr(strings);

        // ch10.sortAnaram(strings);
        // for(int i=0; i<strings.length; ++i){
        //     System.out.println(strings[i]);
        // }

        // 10.3 - Search in Rotated Array
        // int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        // for(int i=0; i<arr.length; ++i)
        //     System.out.print(i+ "\t");
        // System.out.println();
        // for(int n : arr)
        //     System.out.print(n + "\t");
        
        //     System.out.println();

        // int value = 16;
        // System.out.println("value : " + value);
        // System.out.println(ch10.searchRotatedArray2(arr,value, 0, arr.length-1));


        //10.4 - Sorted Search, No size
        // int[] arr = new int[1025];
        // for(int i=0; i<arr.length; ++i)
        //     arr[i] = i;
        // arr[1024] = -1;

        // System.out.println(ch10.sortedSearchNoSize(arr, 782));

        // 10.5 - Sparse Search
        // String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        // for(int i=0; i<arr.length; ++i)
        //     System.out.print(i+"\t");
        // System.out.println();
        // for(String s : arr)
        //     System.out.print(s + "\t");
        // System.out.println();

        // String value = "dad";
        // System.out.println("Found Index : " + ch10.sparseSearch(arr, value, 0, arr.length-1));

        //10.9
    //     int[][] matrix = {
    //         {1,3,5,7,9},
    //         {2,4,6,8,10},
    //         {3,6,9,12,15},
    //         {4,8,12,16,20},
    //         {5,10,15,20,25}
    //     };
    //     ch10.sortedMatrixSearch2(matrix, 5);

        //10.11
        int[] arr = {1,2,3,4,5,6,7,8};
        // int[] arr = {5,3,1,2,3};

        // ch10.sortPeaksAndValleys(arr);
        ch10.sortValleyPeak(arr);
        for(int i : arr)
            System.out.print(i);
        System.out.println();
    }
}