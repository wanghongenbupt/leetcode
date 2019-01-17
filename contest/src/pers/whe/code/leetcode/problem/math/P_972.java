package pers.whe.code.leetcode.problem.math;


public class P_972 {

    /*
     * 972. Equal Rational Numbers
     * 括号内的数就是一个等比数列，等比数列的和为
     *  首项 - 末项
     *  ---------
     *  1 - 公比
     * */
    public boolean isRationalEqual(String S, String T) {
        Fraction f1 = cover(S);
        Fraction f2 = cover(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    private Fraction cover(String t) {
        int num = 0;
        Fraction f = new Fraction(0, 1);
        int twoSize = 0;
        for (String str : t.split("[.()]")) {
            num++;
            if (str.isEmpty()) continue;
            long val = Long.valueOf(str);
            int size = str.length();
            if (num == 1) {
                f.add(new Fraction(val, 1));
            } else if (num == 2) {
                f.add(new Fraction(val, (long) Math.pow(10, size)));
                twoSize = size;
            } else if (num == 3) {
                long temp = (long) Math.pow(10, twoSize);
                f.add(new Fraction(val, temp * ((long) Math.pow(10, size) - 1)));
            }
        }
        return f;
    }
}

class Fraction {
    long n, d;

    public Fraction(long n, long d) {
        long g = gcd(n, d);
        this.n = n / g;
        this.d = d / g;
    }

    public void add(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = gcd(numerator, denominator);
        this.n = numerator / g;
        this.d = denominator / g;
    }

    static long gcd(long n, long d) {
        return n != 0 ? gcd(d % n, n) : d;
    }
}
