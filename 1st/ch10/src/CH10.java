import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class CH10{

    //10.1
    public void mergeSortedArrays(int[] arrA, int[] arrB){
        int idxA = 0;
        int idxB = arrB.length-1;
        int idx = arrA.length-1;

        while(arrA[idxA] != 0)
            ++idxA;
        idxA -= 1;

        System.out.println("idx A : " + idxA + " idx B " + idxB);

        while(idxA < arrA.length && idxB < arrB.length){
            if(arrA[idxA] > arrB[idxB])
                arrA[idx--] = arrA[idxA--];
            else
                arrA[idx--] = arrB[idxB--];

        System.out.println("idx A : " + idxA + " idx B " + idxB);
            if(idxA < 0){
                while(idxB >= 0)
                    arrA[idx--] = arrB[idxB--];
                break;
            } else if(idxB < 0){
                break;
            }
        }
    }

    // 10.2
    public void sortAnagramStringArr(String[] arr){
        // HashSet<String> strSet = new HashSet<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        for(int i=0; i<arr.length; ++i){
            boolean isFound = false;

            for(ArrayList<String> anagrams : list){
                if(isAnagram(anagrams.get(0), arr[i])){
                    anagrams.add(arr[i]);
                    isFound = true;
                    break;
                }
            }

            if(isFound == false){
                ArrayList<String> nList = new ArrayList<>();
                nList.add(arr[i]);
                list.add(nList);
            }

        }

        //정렬
        for(ArrayList<String> anagrams : list){
            anagrams.sort(new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        list.sort(new Comparator<ArrayList<String>>(){
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        
        ArrayList<String> result = new ArrayList<>();

        for(ArrayList<String> anagrams : list){
            result.addAll(anagrams);
        }
        
        arr = result.toArray(new String[result.size()]);

        for(int i=0; i<arr.length; ++i){
            System.out.println(arr[i]);
        }
    }

    private boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); ++i){
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                map.get(c);
                map.replace(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for(int j=0; j<s2.length(); ++j){
            char c = s2.charAt(j);
            if(map.containsKey(c)){
                if(map.get(c) > 1){
                    map.replace(c, map.get(c)-1);
                } else {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        
        if(map.isEmpty())
            return true;
        else
            return false;
    }

    //10.2 solution (HashMapList not implemented)
    // public void anagramSort(String[] arrays){
    //     HashMapList<String, String> map = new HashMapList<>();

    //     for(String s : arrays){
    //         String key = sortChars(s);
    //         map.put(key, s);
    //     }

    //     int index = 0;
    //     for(String key : map.keySet()){
    //         ArrayList<String> list = map.get(key);
    //         for(String s : list){
    //             arrays[index++] = s;
    //         }
    //     }

    // }

    // private String sortChars(String s){
    //     char[] content = s.toCharArray();
    //     Arrays.sort(content);
    //     return new String(content);
    // }

    //10.3 -> 느림, logN 이 되도록 짜야지
    public int searchRotatedArray(int[] arr, int value){
        int boundary = 0;

        int prev = arr[0];
        for(int i=1; i<arr.length; ++i){
            if(prev > arr[i]){
                boundary = i;
                break;
            }
            prev = arr[i];
        }

        int result = -1;

        if(arr[arr.length-1] < value){
            result = binarySearch(arr, value, 0, boundary-1);
        } else {
            result = binarySearch(arr, value, boundary, arr.length-1);
        }

        return result;

        // int[] nArr = new int[arr.length];
            
        // for(int i=0; i<arr.length-boundary; ++i)
        //     nArr[i] = arr[i+boundary];
        // for(int i=0; i<boundary; ++i)
        //     nArr[arr.length-boundary+i] = arr[i];

        // for(int n:nArr)
        //     System.out.print(n + " ");

        // System.out.println();

        // int result = binarySearch(nArr, value);

        // if(result == -1)
        //     return result;
        // else
        //     return result+boundary;
    }

    public int binarySearch(int[] arr, int value, int start, int end){
        // int start = 0;
        // int end = arr.length-1;
        int mid;

        while(start<=end){
            mid = (start+end)/2;
            // System.out.println("mid : " + mid);
            if(arr[mid] == value){
                return mid;
            }
            else if(arr[mid] < value){
                start = mid+1;
            } else {
                end = mid-1;
            }        
        }

        //fail
        return -1;
    }

    //10.3 Solution
    public int searchRotatedArray2(int[] arr, int value, int start, int end){
        if(start > end)
            return -1;

        int mid = (start+end)/2;
        System.out.println("mid : " + mid);
        
        if(arr[mid] == value)
            return mid;


        if(arr[start] < arr[mid]){ // 왼쪽 정렬됨
            if(value >= arr[start] && value < arr[mid])
                return searchRotatedArray2(arr, value, start, mid-1);
            else
                return searchRotatedArray2(arr, value, mid+1, end);

        } else if(arr[start] > arr[mid]){ // 오른쪽 정렬됨
            if(value > arr[mid] && value < arr[end])
                return searchRotatedArray2(arr, value, mid+1, end);
            else
                return searchRotatedArray2(arr, value, start, mid-1);
        } else if(arr[start] == arr[mid]){ // 왼쪽이 다 똑같다
            if(arr[mid] != arr[end]){ // 오른쪽이 다르면 오른쪽 탐색
                return searchRotatedArray2(arr, value, mid+1, end);
            } else { // 아니면 양쪽 다 탐색
                int result = searchRotatedArray2(arr, value, start, mid-1);
                if(result == -1)
                    return searchRotatedArray2(arr, value, mid+1, end);
                else
                    return result;
            }
        }
        
        return -1;
    }

    //10.4
    public int sortedSearchNoSize(int[] arr, int value){
        if(value == arr[0])
            return 0;

        // find section
        int section = 1;

        while(arr[section] != -1){
            if(value > arr[section])
                section = section*2;
            else if(value == arr[section])
                return section;
            else
                break;
        }
        System.out.println("Section : " + section);

        return binarySearch(arr, value, section/2, section); // 값이 -1이 되는 경우를 생각해야함
    }

    //10.5
    public int sparseSearch(String[] arr, String value, int left, int right){
        
        if(left > right)
            return -1;
        
        int mid = (left+right)/2;

        if(arr[mid] == value)
            return mid;

        if(findLeft(arr, value, left, mid-1) == 1){
            return sparseSearch(arr, value, left, mid-1);
        } else if(findRight(arr, value, mid+1, right) == 1){
            return sparseSearch(arr, value, mid+1, right);
        }

        return -1;

    }

    private int findLeft(String[] arr, String value, int left, int right){
        if(left > right)
            return -1;

        for(int i=right; i>=left; --i){
            if(!arr[i].equals("")){
                if(arr[i].compareTo(value) >= 0){
                    System.out.println("Found : " + arr[i]);
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    private int findRight(String[] arr, String value, int left, int right){
        if(left > right)
            return -1;

        for(int i=left; i<right; ++i){
            if(!arr[i].equals("")){
                if(arr[i].compareTo(value) <= 0){
                    System.out.println("Found : " + arr[i]);
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    //10.6 10.7 안함

    // 10.8
    public void findDuplication(int[] arr){
        BitSet bitset = new BitSet(32000);

        for(int i=0; i<arr.length; ++i){
            int num = arr[i];
            int num0 = num-1;
            if(bitset.get(num0))
                System.out.println(num);
            else
                bitset.set(num0);
        }
    }

    class BitSet{
        int[] bitset;

        public BitSet(int bitSize){
            bitset = new int[bitSize/Integer.SIZE + 1];
        }

        public boolean get(int pos){
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos){
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }

    //10.9
    public void sortedMatrixSearch(int[][] matrix, int value){
        int result = -1;

        for(int i=0; i<matrix.length; ++i){
            if(matrix[i][matrix[0].length-1] < value){ // 각 row의 마지막 값
                continue;
            } else {
                result = binarySearch(matrix[i], value, 0, matrix[0].length - 1);
                if(result != -1){
                    System.out.println("Found : " + i + ", " + result);
                }
            }
        }
    }

    // 10.9 - Solution #1
    public void sortedMatrixSearch2(int [][] matrix, int value){
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == value){
                System.out.println("Found : " + row + " ," + col);
                ++row;
                --col;
            } else if(matrix[row][col] > value){
                --col;
            } else {
                ++row;
            }
        }
    }

    // 10.9 - Solution #2
    // public void sortedMatrixSearch3(int [][] matrix, int value){
    //     Coordinate origin = new Coordinate(0, 0);
    //     Coordinate dest = new Coordinate(matrix.length-1, matrix[0].length-1);
        
    //     Coordinate result = findElement(matrix, value, origin, dest);
    //     System.out.println("Found : " + result.row + ", " + result.col);
    // }

    // private Coordinate findElement(int[][] matrix, int value, Coordinate origin, Coordinate dest){
    //     if(!origin.inbounds(matrix) || !dest.inbounds(matrix));{
    //         return null;
    //     }

    //     if(matrix[origin.row][origin.col] == x){
    //         return origin;
    //     } else if (!origin.isBefore(dest)){
    //         return null;
    //     }

    //     Coordinate start = (Coordinate)origin.clone();
    //     int diagDist = Math.min(dest.row - origin.row, dest.col - origin.col);
    //     Coordinate end = new Coordinate(start.row + diagDist, start.col + diagDist);
    //     Coordinate p = new Coordinate(0, 0);

    //     //binary search
    //     while(start.isBefore(end)){
    //         p.setToAverage(start, end);
    //         if(x > matrix[p.row][p.col]){
    //             start.row = p.row + 1;
    //             start.col = p.col + 1;
    //         } else {
    //             end.row = p.row - 1;
    //             end.col = p.col - 1;
    //         }
    //     }

    //     return partitionAndSearch(matrix, origin, dest, start, x);
    // }

    // Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x){
    //     Coordinate lowerLeftOrigin = new Coordinate(pivot,row, origin.col);
    // }

    // class Coordinate implements Clonable{
    //     public int row, col;
    //     public Coordinate(int row, int col){
    //         this.row = row;
    //         this.col = col;
    //     }

    //     public boolean inbounds(int[][] matrix){
    //         return (row >= 0 && col >= 0) && (row < matrix.length && col < matrix[0].length);
    //     }

    //     public boolean isBefore(Coordinate p){
    //         return row <= p.row && col <= p.col;
    //     }

    //     @Override
    //     protected Object clone() throws CloneNotSupportedException {
    //         // TODO Auto-generated method stub
    //         return new Coordinate(row, col);
    //     }

    //     public void setToAverage(Coordinate min, Coordinate max){
    //         row = (min.row + max.row) / 2;
    //         col = (min.col + max.col) / 2;
    //     }
    // }


    //10.10
    public class RankNode{
        public int left_size = 0;
        public RankNode left, right;
        public int data = 0;
        public RankNode(int d){
            data = d;
        }

        public void insert(int d){
            if(d <= data){
                if(left != null) left.insert(d);
                else left = new RankNode(d);
                ++left_size;
            } else {
                if(right != null) right.insert(d);
                else right = new RankNode(d);
            }
        }

        public int getRank(int d){
            if(d == data)
                return left_size;
            else if(d < data){
                if(left == null)
                    return -1;
                else
                    return left.getRank(d);
            } else {
                int right_rank = right == null ? -1 : right.getRank(d);
                if(right_rank == -1)
                    return -1;
                else
                    return left_size + 1 + right_rank;
            }
        }
    }

    //10. 11
    public void sortPeaksAndValleys(int[] arr){
        if(arr.length < 2)
            return;
        
        boolean isInc = true;

        for(int i=0; i<arr.length; ++i){
            if(i==0){
                if(arr[i] > arr[i+1])
                    isInc = true;
                else
                    isInc = false;
                continue;
            }

            if(isInc == true){ // 증가중이었으면 감소
                if(arr[i-1] < arr[i]){ // swap
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
                isInc = false;
            } else {
                if(arr[i-1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
                isInc = true;
            }
        }
    }

    //10.11 - Solution
    public void sortValleyPeak(int[] arr){

        for(int i=1; i<arr.length; i+=2){
            int biggestIdx = maxIndex(arr, i-1, i, i+1);
            if(i != biggestIdx){
                int temp = arr[i];
                arr[i] = arr[biggestIdx];
                arr[biggestIdx] = temp;
            }
        }
    }

    public int maxIndex(int[] arr, int a, int b, int c){
        int len = arr.length;
        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if(max == aValue) return a;
        else if(max == bValue) return b;
        else return c;
    }
}