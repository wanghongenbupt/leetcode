package pers.whe.code.leetcode.problem.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_315 {
    /*
    * 315. Count of Smaller Numbers After Self
     * */
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1);
        for (int i : count) res.add(i);
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        mergeSort(nums, index, l, mid);
        mergeSort(nums, index, mid + 1, r);
        merge(nums, index, l, r);
    }

    private void merge(int[] nums, int[] index, int start, int end) {
        int mid = (end - start) / 2 + start;
        int l = start, r = mid + 1, i = 0, r_c = 0;
        int[] new_index = new int[end - start + 1];
        while (l <= mid && r <= end) {
            if (nums[index[r]] < nums[index[l]]) {
                new_index[i] = index[r];
                r_c++;
                r++;
            } else {
                new_index[i] = index[l];
                count[index[l]] += r_c;
                l++;
            }
            i++;
        }
        while (l <= mid) {
            new_index[i] = index[l];
            count[index[l]] += r_c;
            l++;i++;
        }
        while (r <= end) {
            new_index[i] = index[r];
            r++;i++;
        }
        for (int j = start; j <= end; j++) {
            index[j] = new_index[j - start];
        }
    }

}