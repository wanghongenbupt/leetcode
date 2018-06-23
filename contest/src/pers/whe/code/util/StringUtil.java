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
}
