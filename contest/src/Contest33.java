import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest33 {

    /*
     *594. Longest Harmonious Subsequence
     *这是一道模拟题，模拟条件是找一个数的集合，集合中最大和最小相差1，
     *这样的集合可能有多个，我们找元素最多的集合。
     * 我们遍历整个数组，并用map记录元素在数组中出现的个数，并再次遍历
     * 找到符合条件的每个集合，为了避免重复计算，用set记录已经遍历过的元素
     * */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                continue;
            }
            set.add(n);
            if (map.containsKey(n - 1)) {
                res = Math.max(map.get(n) + map.get(n - 1), res);
            }
            if (map.containsKey(n + 1)) {
                res = Math.max(map.get(n) + map.get(n + 1), res);
            }
        }
        return res;
    }

    /*
     * 593. Valid Square
     * 这是一道模拟题，让我们自己找模拟条件，就是找四个点能组成正方形的模拟条件
     * 四个能组成正方形的点，那么这四点之间的连线一定只有两个，并且不能为0
     * */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distence(p1, p2));
        set.add(distence(p1, p3));
        set.add(distence(p1, p4));
        set.add(distence(p2, p3));
        set.add(distence(p2, p4));
        set.add(distence(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }

    private int distence(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }


}
