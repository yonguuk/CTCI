public class Main{
    public static void main(String[] args) {
        CH10 obj = new CH10();
        //10.1
        // int lenA = 100;
        // int lenB = 10;
        // int[] a = new int[lenA];
        // int[] b = new int[lenB];

        // for(int i=1; i<=15; ++i){
        //     a[i-1] = i*2 - 1;
        // }
        // for(int i=0; i<10; ++i){
        //     b[i] = i*2;
        // }

        // for(int i=0; i<15; ++i)
        //     System.out.print(a[i] + " ");
        // System.out.println();
        // for(int i=0; i<10; ++i)
        //     System.out.print(b[i] + " ");
        // System.out.println();

        // obj.merseSortedArr(a, b, 15, 10);

        // for(int i=0; i<26; ++i){
        //     System.out.print(a[i] + " ");
        // }
        // System.out.println();

        // 10.2
        // String[] arr = {"aabb", "abba", "acca", "abcd", "bbaa", "adsd", "baba", "caac"};
        // obj.anagramSort(arr);
        // for(String s : arr)
        //     System.out.print(s + " ");
        
        // System.out.println();

        // 10.3
        // int arr[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        // System.out.println(obj.searchRotatedArr(arr, 14));

        //10.11
        int[] arr = {5,3,1,2,3};
        obj.peakAndValley(arr);
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    } // main
}