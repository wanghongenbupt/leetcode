package pers.whe.code.util;

public class MathUtil {

    public static int findGCD(int a, int b) {
        return a != 0 ? findGCD(b % a, a) : b;
    }
}
