package pers.whe.code.leetcode;

public class Contest25 {

    /*
     * 507. Perfect Number
     * 这道题定义了一个完全数，也就是它的除数的和等于自己，
     * 我们遍历每个数，如果余数为0，则可以找到两个，并且直到
     * 自己的开方
     * */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        sum++;
        return num == sum;
    }

    /*
     *537. Complex Number Multiplication
     *这个题让我们计算复述的结果，复数的结果可以表示为
     * (a + bi) * (c + di) =
     * (a * c - b * d) + (a * d + b * c)i
     * */
    public String complexNumberMultiply(String a, String b) {
        int[] arr = getParam(a);
        int[] brr = getParam(b);
        int ii = arr[0] * brr[0] - arr[1] * brr[1];
        int jj = arr[0] * brr[1] + arr[1] * brr[0];
        return ii + "+" + jj + "i";
    }

    private int[] getParam(String str) {
        int[] param = new int[2];
        int pos = str.indexOf("+");
        param[0] = Integer.parseInt(str.substring(0, pos));
        param[1] = Integer.parseInt(str.substring(pos + 1, str.length() - 1));
        return param;
    }
}