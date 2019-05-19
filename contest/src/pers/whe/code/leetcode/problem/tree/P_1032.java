package pers.whe.code.leetcode.problem.tree;

public class P_1032 {
}

class StreamChecker {

    public class TriNode {
        public class TrieNode {
            boolean is = false;
            TrieNode[] next = new TrieNode[26];
        }


        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        public void StreamChecker(String[] words) {
            for (String str : words) {
                insert(str);
            }
        }

        private void insert(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(str.length() - 1 - i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.is = true;
        }

        public boolean query(char letter) {
            sb.insert(0, letter);
            TrieNode cur = root;
            for (char c : sb.toString().toCharArray()) {
                cur = cur.next[c - 'a'];
                if (cur == null) return false;
                if (cur.is == true) return true;
            }
            return false;
        }
    }
}