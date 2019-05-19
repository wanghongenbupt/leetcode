package pers.whe.code.leetcode.context;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Context_137 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        for (int stone : stones) {
            p.add(stone);
        }
        while (p.size() > 1) {
            int d = p.poll();
            int x = p.poll();
            if (d == x) continue;
            p.add(d - x);
        }
        return p.size() == 0 ? 0 : p.poll();
    }

    public String removeDuplicates(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length;) {
            int j = i;
            char c = arr[j];
            while (i < arr.length && arr[i] == c) {
                i++;
            }
            if ((i - j) % 2 == 0) {
                count++;
                continue;
            }
            else {
                sb.append(c);
            }
        }
        return count == 0 ? sb.toString() : removeDuplicates(sb.toString());
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length() - b.length());
        int max = 0;
        int[] dp = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (is(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean is(String word, String word1) {
        if (word.length() + 1 != word1.length()) return false;
        boolean notM = false;
        for (int i = 0, j = 0; i < word.length() && j < word1.length();) {
            if (word.charAt(i) == word1.charAt(j)) {
                i++; j++;
            } else {
                if (notM) return false;
                notM = true;
                j++;
            }
        }
        return true;
    }

    public int lastStoneWeightII(int[] a) {
        int sum = Arrays.stream(a).sum();
        int sub = sum / 2;
        boolean[][] dp = new boolean[sub + 1][a.length + 1];
        for (int i = 0; i <= a.length; i++) {
            dp[0][i] = true;
        }
        int max = 0;
        for (int i = 1; i <= sub; i++) {
            for (int j = 1; j <= a.length; j++) {
                if (dp[i][j - 1] || (i >= a[j - 1] && dp[i - a[j - 1]][j - 1])) {
                    dp[i][j] = true;
                    max = Math.max(max, i);
                }
            }
        }
        return sum - max * 2;
    }



        public static void main(String[] args) {
        int  A = new Context_137().longestStrChain(new String[]{
                "ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"
        });
        System.out.println();
    }
}
