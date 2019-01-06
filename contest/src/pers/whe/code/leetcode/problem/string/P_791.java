package pers.whe.code.leetcode.problem.string;

public class P_791 {
    /*
     * 791. Custom Sort String
     * 计算T中字符个数，遍历S。
     * */
    public String customSortString(String S, String T) {
        int[] count = new int[256];
        for (char c : T.toCharArray()) {
            count[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int num = count[c];
            count[c] = 0;
            while (num-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            while (num-- > 0) {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }
}
