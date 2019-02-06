package pers.whe.code.leetcode.problem.math.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P_843 {

    /*
    * 843. Guess the Word
     * */
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> cur = Arrays.stream(wordlist).collect(Collectors.toList());
        while (true) {
            Collections.shuffle(cur);
            String item = cur.get(cur.size() - 1);
            cur.remove(cur.size() - 1);
            int match = master.guess(item);
            if (match == 6) return;
            cur = cur.stream().filter((String cur2) -> (mm(cur2, item) == match)).collect(Collectors.toList());
        }
    }
    public int mm(String s, String t) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) n++;
        }
        return n;
    }
}

class Master {
    int guess(String str) {
        return 0;
    }
}