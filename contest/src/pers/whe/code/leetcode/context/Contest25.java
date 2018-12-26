package pers.whe.code.leetcode.context;

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

    /*
     * 546. Remove Boxes
     * 这道题求最大，最小值问题，一般用dp来解，
     * 1 状态 dp[i][j][k] 区间i到j中左边有k个和arr[i]值一样最大值结果。
     * 2 状态转换  dp[i][j][k] = max(dp[l][m-1][0], dp[m][r][k+1])
     * 3 结果  dp[0][n-1][0]
     * */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return dfs(boxes, 0, n - 1, 0, dp);
    }

    private int dfs(int[] boxes, int l, int r, int k, int[][][] dp) {
        if (l > r) return 0;
        if (dp[l][r][k] > 0) return dp[l][r][k];
        int res = 0;
        //  找到左边有多少个相同的
        for (; l + 1 <= r && boxes[l] == boxes[l + 1]; l++, k++) ;
        // 释放这些相同的
        res += (k + 1) * (k + 1) + dfs(boxes, l + 1, r, 0, dp);
        // 状态转换方程
        for (int m = l + 1; m <= r; m++) {
            if (boxes[l] == boxes[m]) {
                res = Math.max(res, dfs(boxes, l + 1, m - 1, 0, dp) + dfs(boxes, m, r, k + 1, dp));
            }
        }
        dp[l][r][k] = res;
        return res;
    }
}