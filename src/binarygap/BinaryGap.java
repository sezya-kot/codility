package binarygap;

/**
 * Maximum Binary Gap
 * A binary gap within a positive integer N is any MAXIMAL sequence of consecutive zeros that is surrounded
 * by ones at both ends in the binary representation of N.
 */
public class BinaryGap {


    /**
     * Time is O(n)
     */
    public int solution1(int N) {
        int maxGap = 0;
        int count = -1;
        int rightIndex = 0;
        while (N > 0) {
            // get right most bit & shift right
            rightIndex = N & 1;
            N = N >> 1;
            if (rightIndex == 0 && count >= 0) {
                count++;
            }

            if (rightIndex == 1) {
                maxGap = (count > maxGap) ? count : maxGap;
                count = 0;
            }
        }
        return maxGap;
    }
    /**
     * Time is O(log(n))
     */
    public int solution2(int N) {
        int leftIndex = 0;
        int rightIndex = 0;
        int maxGap = 0;
        int x = 0;

        while (N > 0) {
            x = (N & -N);
            rightIndex = log2(x);
            maxGap = Math.max(maxGap, rightIndex - leftIndex - 1);
            leftIndex = rightIndex;
            N = N & (N - 1);
        }
        return maxGap;
    }

    private int log2(int x) {
        return (int) (Math.log10(x) / Math.log10(2));
    }

    /**
     * Time is O(n)
     */
    public int solution3(int N) {
        if (N < 1) throw new IllegalArgumentException();
        int gapMax = 0;
        int count = 0;
        boolean binGapStart = false;
        boolean gapZeroes = false;
        while (N >= 1) {
            if (N % 2 == 1) {
                binGapStart = binGapStart && gapZeroes;
                if (binGapStart) {
                    gapMax = (gapMax > count) ? gapMax : count;
                    gapZeroes = false;
                    count = 0;
                } else
                    binGapStart = true;
            } else {
                gapZeroes = binGapStart;
                if (gapZeroes)
                    count++;
            }
            N = N / 2;
        }
        return gapMax;
    }
}
