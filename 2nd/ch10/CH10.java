import java.util.Arrays;
import java.util.Comparator;

public class CH10 {

    //10.1
    public void merseSortedArr(int[] a, int[] b, int aLen, int bLen){
        int idxA = aLen-1;
        int idxB = bLen-1;
        int idxEnd = aLen + bLen - 1;

        while(idxEnd >= 0){
            if(a[idxA] <= b[idxB]){
                a[idxEnd] = b[idxB];
                --idxEnd;
                --idxB;
            } else {
                a[idxEnd] = a[idxA];
                --idxEnd;
                --idxA;
            }
            
            if(idxA < 0){
                while(idxB >= 0 && idxEnd >= 0)
                    a[idxEnd--] = b[idxB--];
                break;
            }
            if(idxB < 0){
                while(idxA >= 0 && idxEnd >= 0 )
                    a[idxEnd--] = a[idxA--];
                break;
            }
        }
    }

    //10.1 Solution
    void merge(int[] a, int[] b, int lastA, int lastB){
        int indexA = lastA-1;
        int indexB = lastB-1;
        int indexMerged = lastB + lastA -1; //병합된 원소의 마지막 위치

        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    //10.2 
    public void anagramSort(String[] arr){
        // 새로운 정렬 기준에 따라 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] arr1 = o1.toCharArray();
                char[] arr2 = o2.toCharArray();

                Arrays.sort(arr1);
                Arrays.sort(arr2);
                String s1 = new String(arr1);
                String s2 = new String(arr2);

                return s1.compareTo(s2);
            }
        });

    }
    //10.2 Solution 2
    // void sort(String[] array){
    //     HashMapList<String, String> mapList = new HashMapList<>();

    //     /* anagram 단어 그룹 생성 */
    //     for(String s : array){
    //         String key = sortChars(s);
    //         mapList.put(key, s);
    //     }

    //     /* 해시테이블을 배열로 변환 */
    //     int index = 0;
    //     for(String key : mapList.keySet()){
    //         ArrayList<String> list = mapList.get(key);
    //         for(String t : list){
    //             array[index] = t;
    //             index++;
    //         }
    //     }
    // }

    //10.3
    public int searchRotatedArr(int[] arr, int n){
        //1. find pivot
        int pivot = findPivot(arr, 0, arr.length-1);

        if(n >= arr[0] && n <= arr[pivot]){
            return binarySearch(arr, 0, pivot, n);
        } else {
            return binarySearch(arr, pivot+1, arr.length-1, n);
        }

    }
    public int binarySearch(int[] arr, int start, int end, int n){
        if(start>end)
            return -1;
        int mid = (start + end)/2;

        if(arr[mid] == n){
            return mid;
        }
        else if(arr[mid] < n){
            return binarySearch(arr, mid+1, end, n);
        } else {
            return binarySearch(arr, start, mid-1, n);
        }
    }

    private int findPivot(int[] arr, int start, int end){
        int mid = (start + end)/2;
        if(mid == start)
            return mid;
        if(arr[mid] < arr[end]){
            return findPivot(arr, start, mid);
        } else {
            return findPivot(arr, mid, end);
        }
    }

    //10.3 Solution
    int search(int[] a, int left, int right, int x){
        int mid = (left + right) / 2;
        if(x == a[mid])
            return mid;
        if(right < left)
            return -1;

        /** 왼쪽 절반이나 오른쪽 절반 중 하나는 정상적으로 정렬된 상태여야 한다.
         * 어느 쪽이 정상적으로 정렬되어 있는지 확인하고, 정상적으로 정렬된 부분을 이용해서
         * 어느 쪽에서 x를 찾아야 하는지 알아낸다.
         */
        if(a[left] < a[mid]){ // 왼쪽이 정상적으로 정렬된 상태
            if(x >= a[left] && x < a[mid]){
                return search(a, left, mid-1, x);
            } else {
                return search(a, mid+1, right, x);
            }
        } else if(a[mid] < a[left]){ // 오른쪽이 정상적으로 정렬된 상태
            if(x > a[mid] && x <= a[right]){
                return search(a, mid+1, right, x);
            } else {
                return search(a, left, mid-1, x);
            }
        } else if(a[left] == a[mid]){ // 왼쪽 혹은 오른쪽 절반이 전부 반복된다.
            if(a[mid] != a[right]){ // 오른쪽이 다르다면 오른쪽 탐색
                return search(a, mid+1, right, x);
            } else { // 아니라면 양쪽 다 탐색
                int result = search(a, left, mid-1, x); // 왼쪽 탐색
                if(result == -1)
                    return search(a, mid+1, right, x);
                else
                    return result;
            }
        }
        return -1;
    }

    //10.11

}