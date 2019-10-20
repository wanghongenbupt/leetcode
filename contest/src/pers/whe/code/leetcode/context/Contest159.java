package pers.whe.code.leetcode.context;

import java.util.*;

public class Contest159 {

    /*
    * 1232. Check If It Is a Straight Line
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
    * */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        if (coordinates[1][0] - coordinates[0][0] == 0) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] - coordinates[0][0] != 0) {
                    return false;
                }
            }
            return true;
        }
        double d = (coordinates[1][1] - coordinates[0][1]) / ((coordinates[1][0] - coordinates[0][0]) + 0.0);
        for (int i = 2; i < coordinates.length; i++) {
            if (d != (coordinates[i][1] - coordinates[0][1]) / ((coordinates[i][0] - coordinates[0][0]) + 0.0)) {
                return false;
            }
        }
        return true;
    }


    /*
    * 1233. Remove Sub-Folders from the Filesystem
    Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.

If a folder[i] is located within another folder[j], it is called a sub-folder of it.

The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
    * */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String str : folder) {
            boolean is = false;
            String[] strs = str.split("/");
            StringBuilder sb = new StringBuilder();
            for (String cur : strs) {
                if (cur.equals("")) continue;
                sb.append("/");
                sb.append(cur);
                if (set.contains(sb.toString())) {
                    is = true;
                    break;
                }
            }
            if (!is) set.add(str);
        }
        return new ArrayList<>(set);
    }

    /*
    * 1234. Replace the Substring for Balanced String
    * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

Return 0 if the string is already balanced.
    * */
    public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length();
        int res = n;
        for (char c : s.toCharArray()) count[c]++;
        for (int i = 0, j = 0; i < n; i++) {
            count[s.charAt(i)]--;
            while (j < s.length() && count['Q'] <= n / 4 && count['W'] <= n / 4 && count['E'] <= n / 4 && count['R'] <= n / 4) {
                res = Math.min(res, i - j + 1);
                count[s.charAt(j)]++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Contest159().removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"});
    }

    /*
    * 1235. Maximum Profit in Job Scheduling
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take such that there are no 2 jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.
     * */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[profit.length][3];
        for (int i = 0; i < profit.length; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        int max = 0;
        Arrays.sort(arr, (a,b)->a[1] - b[1]);
        int[] dp = new int[profit.length];
        for (int i = 0; i < profit.length; i++) {
            dp[i] = Math.max(i == 0 ? 0 : dp[i - 1], arr[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][1] <= arr[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
                    break;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}