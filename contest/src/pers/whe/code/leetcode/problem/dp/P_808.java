package pers.whe.code.leetcode.problem.dp;

public class P_808 {

    /*
     * 808. Soup Servings
     * 由于service中都是25倍数，除以25减小memo数组大小
     * 由于大于0，都可以service，所以N+24。
     * */
    double[][] memo = new double[200][200];

    public double soupServings(int N) {
        return N >= 4800 ? 1 : dp((N + 24) / 25, (N + 24) / 25);
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (memo[a][b] > 0) return memo[a][b];
        memo[a][b] = 0.25 * (dp(a - 4, b) + dp(a - 3, b - 1) + dp(a - 2, b - 2) + dp(a - 1, b - 3));
        return memo[a][b];
    }
}
