
public class CH5 {

    //5.1
    public int bitInsert(int n, int m, int i, int j){
        System.out.println("N : " + Integer.toBinaryString(n));
        System.out.println("M : " + Integer.toBinaryString(m));

        // n의 j부터 i까지 비트 지우기(0으로)
        int mask = -1 << (j+1);
        mask = mask | (1 << i)-1;
        System.out.println("Mask : " + Integer.toBinaryString(mask));

        n = n & mask;
        System.out.println("N : " + Integer.toBinaryString(n));

        // i만큼 시프트한 m과 n or 연산.
        int result = n | (m << i);
        System.out.println(Integer.toBinaryString(result));
        return result;   
    }

    //5.1 Solution
    int updateBits(int n, int m, int i, int j){
        /* n의 i 부터 j 비트까지를 0으로 만들기 위한 마스크 생성 
         * EXAMPLE : i = 2, j = 4. 결과는 11100011.
         * 여기서는 8비트 마스크를 만드는 것으로 가정
        */
        int allOnes = ~0; // 모든 비트가 1이 된다. -1도 가능

        // j 앞에는 1을 두고 나머지는 0으로 설정. left = 11100000
        int left = allOnes << (j+1);

        // i 뒤에는 1을 두고 나머지는 0으로 설정. right = 00000011
        int right = ((1 << i) - 1);

        // i와 j 사이의 비트들을 제외한 나머지는 1. mask = 11100011
        int mask = left | right;

        /* j부터 i까지를 0으로 설정하고 m을 그 자리에 삽입 */
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

}