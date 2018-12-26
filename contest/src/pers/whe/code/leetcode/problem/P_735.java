package pers.whe.code.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class P_735 {
    /*
     * 735. Asteroid Collision
     * 用list保存最后剩下的星星，其中list左边是负（向左），list右边是正（向右）
     * 从而保证左右两边的不会碰撞。
     * 遍历的是正：加入
     * 遍历的负：如果list都是负，加入
     *          否则，查看list最右与所遍历的大小，如果
     *          比list中的大，则不用考虑遍历到的，如果
     *          遍历的大，要去掉list中的
     * */
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                list.add(asteroids[i]);
            } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                list.add(asteroids[i]);
            } else if (list.get(list.size() - 1) <= -asteroids[i]) {
                if (list.get(list.size() - 1) < -asteroids[i]) {
                    i--;
                }
                list.remove(list.size() - 1);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
