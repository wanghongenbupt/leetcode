package pers.whe.code.leetcode.problem.twopoint;

public class P_76 {
    /*
     * 76. Minimum Window Substring
     * 追击型指针
     * */
    public String minWindow(String s, String t) {
        int[] target = new int[256];
        int[] source = new int[256];
        for (int i : t.toCharArray()) {
            target[i]++;
        }
        int len = s.length() + 1;
        String res = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j < s.length() && !ok(source, target)) {
                source[s.charAt(j)]++;
                j++;
            }
            if (ok(source, target)) {
                if (len > j - i) {
                    len = j - i;
                    res = s.substring(i, j);
                }
            }
            source[s.charAt(i)]--;
        }
        return res;
    }

    private boolean ok(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}
