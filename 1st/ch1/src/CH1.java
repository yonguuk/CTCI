import java.util.Arrays;
import java.lang.Math;

public class CH1{
    private static final int CHAR_SET_NUM = 128;
    public static void main(String[] args) {

        //1.1
        // String str = "abcdefghijklmna";

        // if(hasDuplicatedChar(str))
        //     System.out.println("Has Duplicated Char");
        // else
        //     System.out.println("No Duplicated Char");

        //1.3
        // String str = new String("Mr John Smith");

        // char[] strArr = new char[100];
        // // strArr = str.toCharArray();
        // System.arraycopy(str.toCharArray(), 0, strArr, 0, str.length());
        // // System.out.println("Length of strArr : " + strArr.length);
        // // System.out.println("strArr[0] : " + strArr[0] + "\nstrArr[1] : " + strArr[1]);
        // replaceBlankSpace(strArr, 13);

        //1.4
        // String str = "tacatcoapapa";
        // isPalindromePermutation(str);
        // System.out.println("getCharNumber A : " + getCharNumber('a'));

        // //1.5
        // if(isOneEditString("pale", "ple"))
        //     System.out.println("It's one Edit String!");
        // else
        //     System.out.println("It's not one Edit String...");

        //1.6
        // System.out.println(stringCompress("aabcccaaa"));

        //1.7
        // int[][] matrix = {
        //     {0,0,0,0,0,0,0,0,0,0},
        //     {1,1,1,1,1,1,1,1,1,1},
        //     {2,2,2,2,2,2,2,2,2,2},
        //     {3,3,3,3,3,3,3,3,3,3},
        //     {4,4,4,4,4,4,4,4,4,4},
        //     {5,5,5,5,5,5,5,5,5,5},
        //     {6,6,6,6,6,6,6,6,6,6},
        //     {7,7,7,7,7,7,7,7,7,7},
        //     {8,8,8,8,8,8,8,8,8,8},
        //     {9,9,9,9,9,9,9,9,9,9}

        // };
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        // rotateMatrix(matrix);
        
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        //1.8

            int[][] matrix = {
            {1,1,1,1,1,1,0,1,1,1},
            {2,2,2,2,2,2,2,2,2,2},
            {3,3,3,3,3,3,3,3,3,3},
            {4,4,4,4,4,4,4,4,4,4},
            {5,5,5,5,5,5,5,5,5,5},
            {6,6,6,6,6,6,6,6,6,6},
            {7,7,7,7,7,7,7,7,7,7},
            {8,8,8,8,8,8,8,8,8,8},
            {9,9,9,9,9,9,9,9,9,9}

        };

        setMatrixZero(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    //1.1
    static boolean hasDuplicatedChar(String str){
        
        // 1) boolean array
        // boolean charCount[] = new boolean[CHAR_SET_NUM];

        // for(int i=0; i<str.length(); ++i){
        //     // int numericValue = Character.getNumericValue(str.charAt(i));
        //     System.out.println(str.charAt(i) + " Numeric value is " + (int)str.charAt(i));
        //     if(charCount[str.charAt(i)] == true)
        //         return true;
        //     else
        //         charCount[str.charAt(i)] = true;
        // }
        // return false;

        // 2) Bit Vector
        int bitVector = 0; // 4byte bit vector(0000 0000 0000 0000 0000 0000 0000 0000)
        if(('z' - 'a' + 1) < str.length())
            return true;
            
        for(int i=0; i<str.length(); i++){
            int shiftVal = str.charAt(i) - 'a';
            if((bitVector & (1<<shiftVal)) > 0)
                return true;
            bitVector |= 1<<shiftVal;
        }

        return false;
    }

    //1.3
    static void replaceBlankSpace(char[] str, int len){
        char[] replaceToken = {'%', '2', '0'};
        int replaceTokenLen = replaceToken.length;
        int spaceCount = 0;


        //스페이스 개수 확인
        for(int i=0; i<len; i++){
           if(str[i] == ' ')
            spaceCount++;
        }

        int resultLen = len + (replaceTokenLen-1)*spaceCount;

        
        int index = resultLen; // 최종 문자열의 길이
        str[index] = '\0'; // 문자열 끝에 널 문자 삽입
        index--;

        // 스페이스 문자 대체
        for(int i=len-1; i>=0; i--){
            if(str[i] == ' '){
                str[index--] = replaceToken[2];
                str[index--] = replaceToken[1];
                str[index--] = replaceToken[0];
            } else{
                str[index--] = str[i];
            }
        }

        String result = new String(str);
        System.out.println(result);
    }

    //1.4
    static boolean isPalindromePermutation(String str){
        int[] charCount = new int[256];
        str = str.toLowerCase();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' ')
                continue;
            charCount[str.charAt(i)]++;
            System.out.println("Char ++ : " + str.charAt(i));
        }

        boolean checker = false;
        int sum = 0;
        for(int i=0; i<charCount.length; i++){
            if(charCount[i] != 0 && charCount[i]%2 != 0){
                System.out.println("char : " + (char)i);
                if(checker == true){
                    return false;
                }
                else
                    checker = true;
            } else{
                sum += charCount[i];
            }
        }
        if(sum%2 == 0)
            return true;
        else
            return false;
    }

    static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        System.out.println(""+c + " : " + val);
        if(a <= val && val <= z){
            return val-a;
        }
        return -1;
    }

    //1.5
    static boolean isOneEditString(String str1, String str2){

        // // 길이 차이가 1이 넘으면 false
        // if(Math.abs(str1.length() - str2.length()) > 1)
        //     return false;

        // //문자열의 길이가 같다면, 하나씩 비교해서 다른문자가 1개 이하인지 확인
        // if(str1.length() == str2.length()){
        //     boolean checker = false;
        //     for(int i=0; i<str1.length(); i++){
        //         if(str1.charAt(i) != str2.charAt(i)){
        //             if(checker == true)
        //                 return false;
        //             else
        //                 checker = true;
        //         }
        //     }
        //     return true;
        // } else { // 문자열 길이가 다르다면
        //     //긴 문자열과 짧은 문자열을 확인
        //     String lString = (str1.length() > str2.length()) ? str1:str2;
        //     String sString = (str1.length() > str2.length()) ? str2:str1;
        //     int index=0;
        //     int offset = 0;

        //     while(index<sString.length()){
        //         if(lString.charAt(index+offset) != sString.charAt(index)){
        //             offset++;
        //             if(offset > 1)
        //                 return false;
        //         } else {
        //             index++;
        //         }
        //     }
        //     return true;
        // }

                // 길이 차이가 1이 넘으면 false
        if(Math.abs(str1.length() - str2.length()) > 1)
            return false;

        String lStr = str1.length() > str2.length() ? str1:str2;
        String sStr = str1.length() > str2.length() ? str2:str1;
        int lIndex = 0;
        int sIndex = 0;
        boolean foundDifference = false;

        while(lIndex<lStr.length() && sIndex<sStr.length()){
            if(lStr.charAt(lIndex) != sStr.charAt(sIndex)){
                if(foundDifference == true)
                    return false;
                foundDifference = true;

                if(lStr.length() == sStr.length())
                    sIndex++;

                lIndex++;
            } else {
                lIndex++;
                sIndex++;
            }
        }
        return true;
    }

    //1.6
    static String stringCompress(String str){
        // 1) prev 문자를 유지하며 동일한 문자가 몇 번 연속해서 나오는지 확인
        // 2) 새로운 문자열에 추가(StringBuilder)

        /*
        // Solution #1
        StringBuilder resultStr = new StringBuilder("");
        char prev = 0;
        int count = 1;

        for(int i=0; i<str.length(); i++){
            if(i == 0){
                prev = str.charAt(i);
            } else if(prev == str.charAt(i)){
                count++;                
            } else {
                resultStr.append(""+prev+count);
                count = 1;
                prev = str.charAt(i);
            }
        }
        if(count>1)
            resultStr.append(""+prev+count);

        // if(str.length() < resultStr.length())
        //     return str;
        // else
        //     return new String(resultStr);
        return str.length() < resultStr.length() ? str:resultStr;
        */

        //solution #2
        StringBuilder resultStr = new StringBuilder("");
        int count = 0;

        for(int i=0; i<str.length(); i++){
            count++;
            if( (i+1 == str.length()) || (str.charAt(i) != str.charAt(i+1))){
                resultStr.append("" + str.charAt(i) + count);
                count = 0;
            }
        }

        return str.length() > resultStr.length() ? new String(resultStr):str;
    }

    //1.7
    static void rotateMatrix(int[][] matrix){
        // int temp;
        // int n = matrix.length;
        // int layer = 1;

        // System.out.println(n+" x " + n + " Matrix");
        // while(layer <= (n/2)){
        //     System.out.println("Layer : " + layer);
        //     for(int i=layer-1; i<n-layer; i++){
        //         // System.out.println("i : " + i);
        //         for(int j=layer-1; j < n-layer; j++){
        //             // System.out.println("j : " + j);
        //             temp = matrix[i][j];
        //             matrix[i][j] = matrix[n-i-1][j];
        //             matrix[n-i-1][j] = matrix[n-i-1][n-j-1];
        //             matrix[n-i-1][n-j-1] = matrix[i][n-j-1];
        //             matrix[i][n-j-1] = temp;
        //         }
        //     }
        //     layer++;
        // }
        
        int temp;
        int n = matrix.length;
        int layer = 1;

        System.out.println(n+" x " + n + " Matrix");
        while(layer <= (n/2)){
            // System.out.println("Layer : " + layer);
            for(int i=layer-1; i<n-layer; i++){
                // System.out.println("i : " + i);
                    // System.out.println("j : " + j);
                    temp = matrix[layer-1][i];
                    matrix[layer-1][i] = matrix[n-i-1][layer-1];
                    matrix[n-i-1][layer-1] = matrix[n-layer][n-i-1];
                    matrix[n-layer][n-i-1] = matrix[i][n-layer];
                    matrix[i][n-layer] = temp;
            }
            layer++;
        }
        
    }

    //1.8
    static void setMatrixZero(int[][] matrix){
        // 0의 위치를 미리 확인 후 최종적으로 변경
        // 좌표를 어따 저장할까나 > layer 1에 값을 0으로 변경
        // 원래 0 이었다면? -> boolean값으로 기억해놨다가 마지막에 layer 1 0으로 바꿔주면됨
        // 어짜피 그 줄에 하나라도 0이 있으면 0으로 바꿔주는거니까

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean rowHasZero = false;
        boolean colHasZero = false;

        //0 체크
        for(int i=0; i<rowLen; i++){
            for(int j=0; j<colLen; j++){
                if(matrix[i][j] == 0){
                    if(matrix[i][0] == 0)
                        colHasZero = true;
                    matrix[i][0] = 0;

                    if(matrix[0][j] == 0)
                        rowHasZero = true;
                    matrix[0][j] = 0;
                }
            }
        }

        //0 으로 변경
        // 1) layer 1은 건너뛰고 변경(이미 변경되어 있음)
        // 2) boolean값 확인해서 layer 1 변경
        for(int i=1; i<rowLen; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<colLen; j++)
                    matrix[i][j] = 0;
            }
        }

        for(int i=1; i<colLen; i++){
            if(matrix[0][i] == 0){
                for(int j=1; j<rowLen; j++)
                    matrix[j][i] = 0;
            }
        }

        if(rowHasZero == true){
            for(int i=0; i<colLen; i++){
                matrix[0][i] = 0;
            }
        }

        if(colHasZero == true){
            for(int i=0; i<rowLen; i++){
                matrix[i][0] = 0;
            }
        }
    }

    //1.9
    // static boolean isLotatedString(String str1, String str2){
    //     String doubleStr = str1 + str1;
    //     if(isSubstring(doubleStr, str2))
    //         return true;
    //     else
    //         return false;
    // }
}

