package pers.whe.code.work;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<List<String>> lists = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
            int m = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < m; j++) {
                lists.get(i).add(sc.nextLine());
            }
        }
        for (int i = 0; i < n; i++) {
            help(lists.get(i));
        }
    }

    private static void help(List<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            for (int j = 0; j < stringList.size(); j++) {
                if (i != j && can(stringList.get(i), stringList.get(j))) {
                    System.out.println("Yeah");
                }
            }
        }
        System.out.println("Sad");
    }

    private static boolean can(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        String s1r = new StringBuilder(s1).reverse().toString();
        if (s1r.equals(s2)) return true;
        String tar = s1 + s1;
        if (tar.indexOf(s2) != -1) {
            return true;
        }
        String tar1 = s1r + s1r;
        if (tar1.indexOf(s2) != -1) {
            return true;
        }
        return false;
    }
}
