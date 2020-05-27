public class Main {
    public static void main(String[] args) {
        // CH16 obj = new CH16();

        // obj.swapWithNoBuffer(1223, 4516);
        int x = 5;
        int y = 6;
        
        x = x^y;
        System.out.println(Integer.toBinaryString(x));

        y = x^y;
        x = x^y;

        System.out.println(x + " " + y);
    }
}