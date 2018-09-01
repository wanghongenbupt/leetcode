package pers.whe.code.util;

public class StringUtil {

    //  match one or more space
    public static String[] matchSpace(String str) {
        return str.split("\\s+");
    }

    //  match -  + formula
    public static String[] matchAD(String str) {
        return str.split("(?=[+,-])");
    }

    //  remove not letter  like 00aaa00AA to aaaAA
    public static String removeNotLetter(String str) {
        return str.replaceAll("[^a-zA-Z]", "");
    }


    // 失配之前最长公共前后缀，前缀后一位地方 kmp 算法
    public static int[] next(String str) {
        int[] next = new int[str.length()];
        char[] strs = str.toCharArray();
        next[0] = -1;
        int j = 0;
        int k = -1; // 以j结尾的最长公共前后缀，前缀最后位置。
        while (j < strs.length - 1) {
            if (k == -1 || strs[j] == strs[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int findIndex(String source, String target) {
        char[] ss = source.toCharArray();
        char[] tt = target.toCharArray();
        int i = 0, j = 0;
        int[] next = next(source);
        while (j < ss.length && i < tt.length) {
            if (j == -1 || ss[j] == tt[i]) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        return j == ss.length ? i - j : -1;
    }

    public static void main(String[] args) {
        int i = findIndex("abc", "aaabbbabc");
        System.out.println(i);
    }


}
