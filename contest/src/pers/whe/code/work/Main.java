package pers.whe.code.work;



public class Main {

    /*
    * 358 Rearrange String k Distance Apart
    * 用nextV 数组记录 对应字母出现的最早距离，贪心每次优先
    * 排列数量最大的字母。
    * */
   public static String rerange(String str, int k) {
        int[] count = new int[26];
        int[] nextV = new int[26];
        for (char c: str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int next = getNext(count, nextV, i);
            if (next == -1) return "";
            else {
                sb.append((char)('a' + next));
                count[next]--;
                nextV[next] += k;
            }
        }
        return sb.toString();
   }

    private static int getNext(int[] count, int[] nextV, int index) {
        int next = -1;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && index >= nextV[i]) {
                max = count[i];
                next = i;
            }
        }
        return next;
    }
}