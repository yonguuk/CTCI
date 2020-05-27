public class CH16{

    // 16.1
    public void swapWithNoBuffer(int a, int b){
        System.out.println("a : " + a + " b : " + b);
        for(int i=0; i<Integer.SIZE; ++i){
            if((a&(1<<i)) != (b&(1<<i))){
                a = reverseBit(a, i);
                b = reverseBit(b, i);
            }
        }
        System.out.println("a : " + a + " b : " + b);
    }

    private int reverseBit(int val, int i){
        if(((val>>i) & 1) == 0){ // 0->1
            int mask = ~(1<<i);
            return (val&mask) | (1<<i);
        } else { // 1->0
            int mask = ~(1<<i);
            return (val&mask);
        }
    }
}