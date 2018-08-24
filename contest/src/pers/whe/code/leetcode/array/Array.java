package pers.whe.code.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Array {

    /*
    * 442. Find All Duplicates in an Array
    * 将值对应的索引变负，如果之前是负的话，就出现两次
    * */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }


}
