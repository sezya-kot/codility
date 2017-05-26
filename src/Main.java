import binarygap.BinaryGap;

/**
 * Run algorithm
 */
public class Main {
    public static void main(String... args) {
        int N = 51712;
        System.out.println("Binary representation: " + Integer.toBinaryString(N));
        System.out.println("max gaps is: " + new BinaryGap().solution1(N));
        System.out.println("max gaps is: " + new BinaryGap().solution2(N));
        System.out.println("max gaps is: " + new BinaryGap().solution3(N));
    }
}
