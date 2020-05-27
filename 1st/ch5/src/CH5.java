public class CH5{
    public static void main(String[] args) {
        
        //5.1
        // String n = "11111111111";
        // String m = "10011";

        // bitInsert(n, m, 2, 6);

        //5.2
        // System.out.println(printBinary(0.72));
        // System.out.println(Double.toBinaryString(0.72));

        //5.3
        // System.out.println("Find ones : " + findOnes(1775));

        //5.4
        // getNext(13948);
        // getPrev(13948);

        //5.6
        // flipCount(1234, 1321);

        //5.7
        // swapBit(1973);

        //5.8
        byte[] screen = new byte[4*8];
        drawLine(screen, 32, 22, 31, 5);
    }

    public static void bitInsert(String n, String m, int i, int j){
        int integerN = Integer.parseInt(n,2);
        int integerM = Integer.parseInt(m,2);
        System.out.println("n : "+integerN + " m : " + integerM);
        int mLength = m.length();

        // int mask =0;
        // for(int k=i; k<mLength+i; ++k){
        //     mask = mask | (1 << k);
        // }
        // mask = ~mask;
        // System.out.println("mask : " + Integer.toBinaryString(mask));
        // integerN = integerN & mask;
        // System.out.println("Integer N : " + Integer.toBinaryString(integerN));
        // integerM = integerM << i;
        // integerN = integerN | integerM;
        // System.out.println("Integer N : " + Integer.toBinaryString(integerN));

        int allOnes = ~0;
        int left = allOnes << j+1;
        int right = (1 << i) -1;
        System.out.println(Integer.toBinaryString(left));
        System.out.println(Integer.toBinaryString(right));
        int mask = left|right;

        System.out.println(Integer.toBinaryString(mask));

        integerN = integerN & mask;
        System.out.println(Integer.toBinaryString(integerN));
        integerN = integerN | integerM;
        System.out.println(Integer.toBinaryString(integerN));

    }

    public static String printBinary(double num){
        StringBuilder binaryString = new StringBuilder("0.");

        while(num > 0){
            if(binaryString.length()>32){
                System.out.println(binaryString);
                return "ERROR - too long";
            }

            num = 2*num;
            if(num >= 1){
                binaryString.append('1');
                num -= 1;
            }
            else{
                binaryString.append('0');
            }
        }

        return binaryString.toString();
    }

    public static int findOnes(int num){

        //3) 풀이
        //전 부 1
        if(~num == 0)
            return Integer.BYTES * 8;

        int currLength = 0;
        int prevLength = 0;
        int maxLength = 0;

        while(num != 0){
            System.out.println(Integer.toBinaryString(num));
            System.out.println("currLength : " + currLength + " prevLength : " + prevLength + " maxLength : " + maxLength);
            if((num & 1) == 1){ // 현재 비트가 1인 경우
                ++currLength;
            } else {
                prevLength = (num & 2) != 0 ? currLength : 0;
                currLength = 0;
            }
            
            int length = currLength + prevLength + 1;
            maxLength = length > maxLength ? length : maxLength;
            num = num>>>1;
        }
        
        return maxLength;

        // 2) 근데 이렇게 문자열로 변환하고 푸는건 좀 아닌듯
        // char[] binaryCharArr = Integer.toBinaryString(num).toCharArray();
        
        // int before = 0;
        // int curr = 0;
        // int after = 0;
        // int count = 0;
        // int maxCount = 0;
        // boolean findZeroFlag = false;
        
        // System.out.println(Integer.toBinaryString(num));

        // for(int i=0; i<binaryCharArr.length; ++i){
        //     System.out.println("Before : " + before + " After : " + after + " Count : " + count + " MaxCount : " + maxCount);
        //     // 1을 만난 경우
        //     if(binaryCharArr[i] == '1'){
        //         //0을 만나기 전이라면,
        //         if(findZeroFlag == false)
        //             ++before;
        //         else
        //             ++after;
        //     } else { // 0을 만난 경우
        //         if(findZeroFlag == false){
        //             findZeroFlag = true;
        //         } else {
        //             count = before + after + 1;
        //             if(count > maxCount)
        //                 maxCount = count;
        //             before = after;
        //             after = 0;
        //             count = 0;
        //         }
        //     }

        // }
        // count = before + after + +1;
        // return count > maxCount ? count : maxCount;

        //1) 무식하게
        // String binaryString = Integer.toBinaryString(num);
        // char[] binaryCharArr;
        // int maxCount = 0;
        // System.out.println("num : " + Integer.toBinaryString(num));

        // for(int i=0; i<binaryString.length(); ++i){
        //     if(binaryString.charAt(i) == '0'){
        //         binaryCharArr = binaryString.toCharArray();
        //         binaryCharArr[i] = '1';
        //         System.out.println("Index i : " + i);
        //         int count = 0;
        //         for(int j=0; j<binaryCharArr.length; ++j){
        //             if(binaryCharArr[j] == '0'){
        //                 if(maxCount < count)
        //                     maxCount = count;
        //                 count = 0;
        //             } else{
        //                 ++count;
        //             }
        //         } // End od inner for
        //         if(maxCount < count)
        //             maxCount = count;
        //     }
        // } // End of outer for

        // return maxCount;
    }

    public static int getNext(int n){
        int copyN = n;
        int p = 0;
        int c0Count = 0;
        int c1Count = 0;

        System.out.println("N : " + Integer.toBinaryString(n));
        // p 찾기
        // for(int i=0; i<Integer.BYTES*8; ++i){
        //     if((copyN & 1) == 0){
        //         if(i == 0){
        //             rightZeroCheck = true;
        //         } else {
        //             if(rightZeroCheck == false){ // 첫번째 원소가 0이 아니었다면,
        //                 p = i;
        //                 break;
        //             }
        //         }
        //         ++c0Count;
        //     } else {
        //         rightZeroCheck = false;
        //         ++c1Count;
        //     }
        //     copyN = copyN >> 1;
        // }

        while((copyN & 1)==0 && copyN != 0){
            ++c0Count;
            copyN  >>= 1;
        }
        while((copyN & 1) == 1){
            ++c1Count;
            copyN >>= 1;
        }

        if(c0Count + c1Count == 0 || c0Count + c1Count == 31)
            return -1;

        p = c0Count + c1Count;
        System.out.println("P : " + p + "  C0 : " + c0Count + "  C1 : " + c1Count);
        copyN = n;


        //p 아래쪽 0으로 마스킹. p는 1로 바꿈
        int mask = ~((1 << p) - 1);
        copyN = copyN & mask;
        copyN |= 1 << p;
        System.out.println("Masked N : " + Integer.toBinaryString(copyN));

        mask = (1 << (c1Count-1)) - 1;
        copyN |= mask;
        System.out.println("Masked N : " + Integer.toBinaryString(copyN));

        return 0;
    }

    public static int getPrev(int n){
        int copyN = n;
        int c1 = 0;
        int c0 = 0;
        int p = 0;

        System.out.println("n : " + Integer.toBinaryString(n));

        while((copyN & 1) == 1){
            ++c1;
            copyN >>= 1;
        }

        if(copyN == 0) return -1;

        while((copyN & 1) == 0 && copyN != 0){
            ++c0;
            copyN >>= 1;
        }

        p = c0 + c1;
        System.out.println("C1 : " + c1 + " C0 : " + c0 + " p : " + p);

        copyN = n;
        // int mask = ~((1<<p+1)-1);
        int mask = (~(0)<<p+1);
        copyN &= mask;
        System.out.println("prev n : " + Integer.toBinaryString(copyN));
        mask = ((1<<c1+1)-1) << (c0-1);
        copyN |= mask;
        System.out.println("prev n : " + Integer.toBinaryString(copyN));
        return copyN;
    }

    //5.6
    public static int flipCount(int a, int b){
        System.out.println("a : " + Integer.toBinaryString(a) + "\nb : " + Integer.toBinaryString(b));
        int count = 0;

        //1)
        // for(int c = a^b; c!=0; c>>=1){
        //     // if((c & 1) == 1)
        //     //     ++count;
        //     count += (c & 1);
        // }

        //2)

        for(int c = a^b; c!=0; c &=(c-1)){
            ++count;
        }
        System.out.println("Count : " + count);
        return count;
    }

    //5.7
    public static int swapBit(int a){
        int copyA = a;
        System.out.println("a : " + Integer.toBinaryString(a));
        
        //1)
        // for(int i=0; i<Integer.BYTES*8; i += 2){
        //     //1) 바꿀 비트 2개 클리어
        //     // int even = (copyA & (int)Math.pow(2, i)) == 0 ? 0 : 1;
        //     // int odd = (copyA & (int)Math.pow(2,i+1)) == 0 ? 0 : 1;

        //     int even = (copyA >> i) & 1;
        //     int odd = (copyA >> i+1) & 1;
        //     // System.out.println("Even : " + even + " ODD : " + odd + " i : " + i);
        //     copyA &= ~(1 << i);
        //     copyA &= ~(1 << (i+1));
        //     // System.out.println("copy a : " + Integer.toBinaryString(copyA));
        //     //2) 비트 바꿔서 마스킹
        //     copyA |= (odd << i);
        //     copyA |= (even << i+1);
        //     // System.out.println("copy a after : " + Integer.toBinaryString(copyA));


        // }
        //2)
        System.out.println("Result : " + Integer.toBinaryString((((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1))));
        return ((a & 0xaaaaaaaa >>> 1) | ((a & 0x55555555) << 1));

    }

    //5.8
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        //1) 이건 바이트로 하는거고 비트로 해야지
        //print byte []
        // for(int i=0; i<screen.length; ++i){
        //     if(i%32 == 0)
        //         System.out.println();
        //     System.out.print(""+screen[i]);
        // }
        // System.out.println();

        // for(int i=x1; i<=x2; ++i){
        //     screen[y*width+i] = 1;
        // }

        // for(int i=0; i<screen.length; ++i){
        //     if(i%32 == 0)
        //         System.out.println();
        //     System.out.print(""+screen[i]);
        // }
        // System.out.println();

        //2)
        // System.out.println("x1 : " + x1 + " x2 : " + x2 + " width : " + width + " y : " + y);
        // int startIdx = y*(width/8) + (x1/8);
        // int endIdx = y*(width/8) + (x2/8);
        // System.out.println("Start Idx : " + startIdx + " End Idx : " + endIdx);

        // for(int i=startIdx; i<=endIdx; ++i){
        //     if((x2/8) > i%(width/8)){
        //         System.out.println("if - i : " + i + " x1: " + x1 + " x2: " +x2);
        //         int mask = (1<<(8-(x1%8)))-1;
        //         System.out.println("mask : " + Integer.toBinaryString(mask));
        //         screen[i] |= mask;
        //         x1 = 8*(i%(width/8)+1);
        //     } else {
        //         System.out.println("else - i : " + i + " x1: " + x1 + " x2: " +x2);
        //         int mask = (1<<(x2-x1+1))-1;
        //         System.out.println("mask : " + Integer.toBinaryString(mask));

        //         mask <<= (8-(x2-x1+1));
        //         System.out.println("mask : " + Integer.toBinaryString(mask));
        //         screen[i] |= mask;
        //     }
        // }

        // for(int i=0; i<screen.length; ++i){
        //     if(i%(width/8) == 0)
        //         System.out.println();
        //     System.out.print(""+byteToBinaryString(screen[i]));
        // }

        // System.out.println();

        //3) 해법
        int start_offset = x1%8;
        int first_full_byte = x1/8;
        if(start_offset != 0){
            ++first_full_byte;
        }

        int end_offset = x2%8;
        int last_full_byte = x2/8;
        if(end_offset != 7){
            --last_full_byte;
        }

        //모든 비트가 1인 바이트
        for(int b=first_full_byte; b<=last_full_byte; ++b){
            screen[(width/8)*y + b] = (byte) 0xFF;
        }

        //시작 부분과 끝 부분 비트 설정
        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> end_offset+1);

        if((x1/8) == (x2/8)){
            byte mask = (byte) (start_mask & end_mask);
            screen[(width/8)*y + (x1/8)] |= mask;
        } else {
            if(start_offset != 0){
                int byte_number = (width/8) * y + first_full_byte -1;
                screen[byte_number] |= start_mask;
            }
            if(end_offset != 7){
                int byte_number = (width/8) * y + last_full_byte+1;
                screen[byte_number] |= end_mask;
            }
        }

        for(int i=0; i<screen.length; ++i){
            if(i%(width/8) == 0)
                System.out.println();
            System.out.print(""+byteToBinaryString(screen[i]));
        }
    }

    public static String byteToBinaryString(byte b){
        byte[] masks = {-128, 64, 32, 16, 8, 4, 2, 1};
        StringBuilder builder = new StringBuilder();
        
        for(byte m : masks){
            if((b & m) == m)
                builder.append('1');
            else
                builder.append('0');
        }

        return builder.toString();
    }
}