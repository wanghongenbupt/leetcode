package pers.whe.code.util;

public class MathUtil {

    public static final int ODD = 1;
    public static final int EVEN = 2;

    public static int findGCD(int a, int b) {
        return a != 0 ? findGCD(b % a, a) : b;
    }

    /*
     * %  (a - b) % k = n
     *    (a + k - (b + k)) % b = n
     * */
}
