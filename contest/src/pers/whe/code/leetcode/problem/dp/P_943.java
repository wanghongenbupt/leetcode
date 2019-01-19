package pers.whe.code.leetcode.problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_943 {


    /*
     * 943. Find the Shortest Superstring
     * 把字母当作一个节点，画有向图，求从仁一个节点遍历全部节点的最短路径。
     * */
    List<Integer> path = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    boolean[] see;
    int[][] i2jLen;

    public String shortestSuperstring1(String[] arr) {
        i2jLen = new int[arr.length][arr.length];
        see = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                i2jLen[i][j] = arr[j].length();
                for (int k = 1; k < Math.min(arr[i].length(), arr[j].length()); k++) {
                    if (arr[i].substring(arr[i].length() - k).equals(arr[j].substring(0, k)))
                        i2jLen[i][j] = arr[j].length() - k;
                }
            }
        }
        dfs(arr, 0, 0);
        StringBuilder sb = new StringBuilder(arr[res.get(0)]);
        for (int i = 1; i < arr.length; i++) {
            String item = arr[res.get(i)];
            sb.append(item.substring(item.length() - i2jLen[res.get(i - 1)][res.get(i)]));
        }
        return sb.toString();
    }

    private void dfs(String[] arr, int d, int len) {
        if (len > min) return;
        if (d == arr.length) {
            if (len < min) {
                res = new ArrayList<>(path);
                min = len;
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (see[i]) continue;
            see[i] = true;
            path.add(i);
            dfs(arr, d + 1, d == 0 ? arr[i].length() : len + i2jLen[path.get(d - 1)][i]);
            see[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        new P_943().shortestSuperstring(new String[]{"alex", "loves", "leetcode"});
    }

    int dest(String a, String b) {
        int d = b.length();
        for (int k = 1; k < Math.min(a.length(), b.length()); k++) {
            if (a.substring(a.length() - k).equals(b.substring(0, k)))
                d = b.length() - k;
        }
        return d;
    }

    public String shortestSuperstring(String[] arr) {
        int n = arr.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = dest(arr[i], arr[j]);
                g[j][i] = dest(arr[j], arr[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] par = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            Arrays.fill(par[i], -1);
        }
        for (int i = 0; i < n; i++) dp[1 << i][i] = arr[i].length();
        for (int s = 1; s < (1 << n); s++) {
            for (int i = 0; i < n; i++) {
                if ((s & (i << 1)) == 0) continue;
                int pare = s - (i << 1);
                for (int j = 0; j < n; j++) {
                    if (dp[pare][j] + g[j][i] < dp[s][i]) {
                        dp[s][i] = dp[pare][j] + g[j][i];
                        par[s][i] = j;
                    }
                }
            }
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (dp[1 << n][i] < dp[1 << n][cur]) {
                cur = i;
            }
        }
        String res = "";
        int s = (1 << n) - 1;
        while (s > 0) {
            int pare = par[s][cur];
            if (pare < 0) res = arr[cur] + res;
            else res = arr[cur].substring(arr[cur].length() - g[pare][cur]) + res;
            s -= (1 << cur);
            cur = pare;
        }
        return res;
    }

}
