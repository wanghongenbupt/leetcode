package pers.whe.code.lintcode;

import java.util.*;

public class Contest23 {

    /*
     * 1455. Valid Array
     * 这个题定义了一种有效数组，定义如下
     * 1 列表中只有一个元素的个数是奇数，才有效
     * */
    public int isValid(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : a) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                res.add(entry.getKey());
                if (res.size() > 1) {
                    return -1;
                }
            }
        }
        return res.isEmpty() ? -1 : res.get(0);
    }

    /*
     * 1038. Jewels and Stones
     * 这道题给我们两个字符串，一个代表宝石，一个代表我们有的石头，
     * 让我们找出，我们手中的石头多少是宝石。
     * */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                res++;
            }
        }
        return res;
    }

    /*
     * 1454. Word Frequency Count
     * 这道题让我们找到s包含的单词中，不再excludeList中的，频率最高的字符串
     * */
    public String[] getWords(String s, String[] excludeList) {
        Set<String> set = new HashSet<>();
        for (String str : excludeList) {
            set.add(str);
        }

        String[] arr = s.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String str : arr) {
            str = str.toLowerCase();
            str = str.replaceAll("[^a-z]", "");
            if (str.length() == 0) continue;
            if (!set.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
                max = Math.max(max, map.get(str));
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        String[] res = list.toArray(new String[list.size()]);
        Arrays.sort(res);
        return res;
    }

    /*
     * 1456. Word Synthesis Problem
     * 这道题用递归，递归的定义就是target中的字符是否能用words中没用到的表示。
     * 1 结束条件 target 中字符数为0，表示可以
     * 2 遍历过程， 每遍历一个减去target中的一个字符
     * */
    public boolean matchFunction(String target, String[] words) {
        return dfs(target, words, new boolean[words.length]);
    }

    private boolean dfs(String target, String[] words, boolean[] see) {
        if (target.length() == 0) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            if (see[i]) continue;
            if (words[i].indexOf(target.charAt(0)) != -1) {
                see[i] = true;
                if (dfs(target.substring(1), words, see)) {
                    return true;
                }
                see[i] = false;
            }
        }
        return false;
    }

}
