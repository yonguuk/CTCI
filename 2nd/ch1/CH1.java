import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CH1{
    //1.1
    // 1)
    public boolean hasDuplicateChar(String str){

        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<str.length(); ++i){
            char c = str.charAt(i);
            if(set.contains(c))
                return true;
            set.add(str.charAt(i));
        }

        return false;
    }

    // 2)
    public boolean hasDuplicateChar2(String str){
        long bitVector = 0;
        for(int i=0; i<str.length(); ++i){
            int n = charToIndex(str.charAt(i));
            System.out.println("char : " + str.charAt(i) + ", n : " + n);
            if((bitVector & (1<<n)) != 0)
                return true;
            else
                bitVector = bitVector|(1<<n);
        }
        return false;
    }

    private int charToIndex(char c){
        if(c < 'A' || c > 'z')
            return -1;
        
        return (int)((int)c-'A');
    }
    // 1.1 Solution
    //1) boolean array
    public boolean isUniqueChars(String str){
        if(str.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }
    //2) bit vector
    public boolean isUniqueChars2(String str){
        int checker = 0;
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
    
    //1.2
    public boolean isPermutationEach(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str1.length(); ++i){
            char c = str1.charAt(i);
            if(map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        // Set<Character> keySet = map.keySet();
        // for(char c : keySet){
        //     System.out.println("key : " + c + ", val : " + map.get(c));
        // }

        for(int i=0; i<str2.length(); ++i){
            char c = str2.charAt(i);
            if(!map.containsKey(c))
                return false;
            else
                map.replace(c, map.get(c)-1);

            if(map.get(c) == 0)
                map.remove(c);
        }

        return map.isEmpty();
    }

    public boolean isPermutationEach2(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        // ASCII
        int[] freqArr = new int[128];
        for(int i=0; i<str1.length(); ++i){
            int idx1 = str1.charAt(i);
            int idx2 = str2.charAt(i);

            ++freqArr[idx1];
            --freqArr[idx2];
        }

        for(int i=0; i<freqArr.length; ++i){
            if(freqArr[i] != 0)
                return false;
        }

        return true;
    }

    //1.2 Solution
    // 1)
    public String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
      }
      
      public boolean permutation(String s, String t){
        if(s.length() != t.length())
          return false;
           return sort(s).equals(sort(t));
      }

      //2
    public boolean permutation2(String s, String t){
    if(s.length() != t.length())
        return false;

    int[] letters = new int[128];
    char[] s_array = s.toCharArray();

    for(char c : s_array){
        letters[c]++;
    }
    for(int i=0; i<t.length(); i++){
        int c = (int) t.charAt(i);
        letters[c]++;
        if(letters[c] < 0)
            return false;
    }
    return true;
    }

    public void replaceSpace(char[] str, int len){
        int spaceCount = 0;
        char[] rep = {'%', '2', '0'};
        for(int i=0; i<len; ++i){
            if(str[i] == ' ')
                ++spaceCount;
        }

        int resultLen = len + spaceCount*3 - spaceCount;
        int idx = resultLen - 1;
        for(int i=len-1; i>=0; --i){
            if(str[i] == ' '){
                str[idx] = rep[2];
                str[idx-1] = rep[1];
                str[idx-2] = rep[0];
                idx -= 3;
            } else {
                str[idx--] = str[i];
            }
        }
    }

    //1.3 Solution
    public void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0;
        int index = 0;

        for(int i=0; i<trueLength; i++){
            if(str[i] == ' ')
                spaceCount++;
        }
        index = trueLength + spaceCount*2;
        if(trueLength < str.length) str[trueLength] = '\0';
        for(int i=trueLength-1; i>=0; i--){
            if(str[i] == ' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index-3;
            } else {
                str[index-1] = str[i];
                index--;
            }
        }
    }

    //1.4
    // 1)
    public boolean isPalindrome(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int spaceCount = 0;
        for(int i=0; i<str.length(); ++i){
            char c = toLowerCase(str.charAt(i));
            if(map.containsKey(c))
                map.replace(c, map.get(c)+1);
            else if(c != ' ')
                map.put(c, 1);
            else
                ++spaceCount;
        }

        Set<Character> set = map.keySet();
        boolean oddNumCheck = false;
        int trueLen = str.length()-spaceCount;
        for(Character c : set){
            if(c == ' ')
                continue;

            int val = map.get(c);
            if(trueLen%2 == 0){
                if(val%2 == 1)
                    return false;
            } else {
                if(val%2 == 1)
                {
                    if(oddNumCheck == false)
                        oddNumCheck = true;
                    else
                        return false;
                }
            }
        }

        return true;
    }

    private char toLowerCase(char c){
        if(c < 'A' || c > 'Z')
            return c;
        else
            return (char) (c + ('a'-'A'));
        
    }

    //Solution #1
    public boolean isPermutationOfPalindrome(String phrase){
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    boolean checkMaxOneOdd(int[] table){
        boolean foundOdd = false;
        for(int count : table){
            if(count%2 == 1){
                if(foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    //대소문자 구분 x, 문자가 아니면 -1로 대응
    int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z){
            return val-a;
        }
        return -1;
    }

    int[] buildCharFrequencyTable(String phrase){
        int[] table = new int[Character.getNumericValue('z') - 
                                Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
    }

    // Solution #2
    boolean isPermutationOfPalindrome2(String phrase){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - 
                                Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
    // Solution #3
    boolean isPermutationOfPalindrome3(String phrase){
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    public int createBitVector(String phrase){
        int bitVector = 0;
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }
    int toggle(int bitVector, int index){
        if(index < 0) return bitVector;
        int mask = 1 << index;
        if((bitVector & mask) == 0)
            bitVector |= mask;
        else
            bitVector &= ~mask;
        
        return bitVector;
    }
    boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector-1)) == 0;
    }
    
    //1.5
    boolean oneEditEqualString(String str1, String str2){
        if(str1.length() == str2.length()){
            boolean edited = false;
            for(int i=0; i<str1.length(); ++i){
                if(str1.charAt(i) != str2.charAt(i)){
                    if(edited == true)
                        return false;
                    else
                        edited = true;
                }
            }
        } else if(Math.abs(str1.length()-str2.length()) == 1){
            String lStr = str1.length()>str2.length() ? str1 : str2;
            String sStr = str1.length()<str2.length() ? str1 : str2;
            int offset = 0;
            for(int i=0; i<sStr.length(); ++i){
                if(lStr.charAt(i) != sStr.charAt(i-offset)){
                    ++offset;
                    if(offset > 1)
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    //1.5 Solution
    boolean oneEditAway(String first, String second){
        if(first.length() == second.length()){
            return oneEditReplace(first, second);
        } else if(first.length() + 1 ==  second.length()){
            return oneEditInsert(first, second);
        } else if(first.length() - 1 == second.length()){
            return oneEditInsert(second, first);
        }
        return false;
    }

    boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
    boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while(index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    boolean oneEditAway2(String first, String second){
        if(Math.abs(first.length() - second.length()) > 1)
            return false;
        
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while(index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(foundDifference)
                    return false;
                foundDifference = true;
                if(s1.length() == s2.length()){
                    index1++;
                }
            } else{
                index1++;
            }
            index2++;
        }
        return true;
    }

    String compressString(String str){
        StringBuilder result = new StringBuilder();
        int count = 0;
        char prev = ' ';
        for(int i=0; i<str.length(); ++i){
            char cur = str.charAt(i);
            if(i == 0){
                prev = cur;
                ++count;
            }
            else if(cur == prev){
                ++count;
            }
            else {
                result.append("" + prev + count);
                prev = cur;
                count = 1;
            }
        }
        result.append("" + prev + count);

        return result.length() < str.length() ? result.toString() : str;
    }

    // 1.6 Solution
    // #1
    String compress(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i=0; i<str.length(); ++i){
          countConsecutive++;
          if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
          }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
      }

      // #2
    String compress2(String str){
        int finalLength = countCompression(str);
        if(finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for(int i=0; i<str.length(); ++i){
        countConsecutive++;
        if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
        }
        return compressed.toString();
    }

    int countCompression(String str){
        int compressedLength = 0;
        int countConsecutive = 0;

        for(int i=0; i<str.length(); ++i){
            countConsecutive++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    //1.7
    void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        for(int layer=0; layer<(n/2); ++layer){
            int first = layer;
            int last = n-layer-1;
            for(int i=0; i<(last-first); ++i){
                int buffer = matrix[first][first+i];
                matrix[first][first+i] = matrix[last-i][first];
                matrix[last-i][first] = matrix[last][last-i];
                matrix[last][last-i] = matrix[first+i][last];
                matrix[first+i][last] = buffer;
            }
        }
    }

    boolean rotate(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length)
            return false;
        int n = matrix.length;

        for(int layer=0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;

            for(int i=first; i<last; i++){
                int offset = i-first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }

        return true;
    }

    //1.8
    void setZeros(int[][] matrix){
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int r : row){
            for(int i=0; i<matrix[0].length; ++i)
                matrix[r][i] = 0;
        }
        for(int c : col){
            for(int i=0; i<matrix.length; ++i)
                matrix[i][c] = 0;
        }

    }

    // 1.8 Solution
    void setZeros2(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
    }

    void nullifyRow(int[][] matrix, int row){
        for(int j=0; j<matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    void nullifyCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    void setZeros3(int[][] matrix){
        boolean rowHasZero = false;
        boolean colHasZero = false;

        for(int j=0; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                rowHasZero = true;
                break;
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    //위에 for문 없이 여기서 체크도 가능
                    // if(i == 0)
                    //     rowHasZero = true;
                    // if(j == 0)
                    //     colHasZero = true;
                    
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<matrix[0].length; i++){
            if(matrix[0][i] == 0)
                nullifyCol(matrix, i);
        }
        
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }

        if(rowHasZero)
            nullifyRow(matrix, 0);
        if(colHasZero)
            nullifyCol(matrix, 0);
    }

    // 1.9 Solution
    // boolean isRotation(String s1, String s2){
    //     int len = s1.length();
    //     if(len == s2.length() && len > 0){
    //         String s1s1 = s1+s1;
    //         return isSubstring(s1s1, s2);
    //     }
    //     return false;
    // }
}
