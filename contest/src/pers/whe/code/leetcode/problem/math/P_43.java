package pers.whe.code.leetcode.problem.math;

public class P_43 {

    /*
    * 43. Multiply Strings
     * */
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] res = new int[n1.length() + n2.length()];
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                int l = i + j, r = i + j + 1;
                res[l] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                res[r] += res[l] / 10;
                res[l] %= 10;
            }
        }
        String resString = "";
        boolean is = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (is && res[i] == 0) {
                continue;
            } else {
                is = false;
                resString += res[i];
            }
        }
        return resString.length() == 0 ? "0" : resString;
    }
}
