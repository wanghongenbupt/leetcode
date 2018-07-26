package pers.whe.code.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Contest18A {
    500. Keyboard Row
    public String[] findWords(String[] words) {
        List<Character> row1 = Arrays.asList('q','w','e','r','t','y','u','i','o','p');
        List<Character> row2 = Arrays.asList('a','s','d','f','g','h','j','k','l');
        List<Character> row3 = Arrays.asList('z','x','c','v','b','n','m');
        List<String> list = new ArrayList<>();
        for (String str : words) {
            int row = -1;
            boolean flag = true;
            for (char c : str.toCharArray()) {
                char ch = Character.toLowerCase(c);
                if (row == -1) {
                    if(row1.contains(ch)) row = 1;
                    if(row2.contains(ch)) row = 2;
                    if(row3.contains(ch)) row = 3;
                }
                if(row1.contains(ch) && row == 1) {
                    continue;
                } else if(row2.contains(ch) && row == 2) {
                    continue;
                } else if(row3.contains(ch) && row == 3) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);   
    }
}
