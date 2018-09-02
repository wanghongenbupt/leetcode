package pers.whe.code.leetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pers.whe.code.model.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Context100 {

    /*
    * 896. Monotonic Array
    * */
    public boolean isMonotonic(int[] a) {
        boolean zeng = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                zeng = false;
                break;
            }
        }
        boolean jian = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                jian = false;
                break;
            }
        }
        return zeng || jian;
    }

    /*
    * 897. Increasing Order Search Tree
    * */

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        cur = res;
        dfs(root);
        return res.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        dfs(root.right);
    }

    /*898. Bitwise ORs of Subarrays
    * */
    public int subarrayBitwiseORs(int[] a) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int i: a) {
            Set<Integer> next = new HashSet<>();
            for (int j : cur) {
                next.add(i | j);
            }
            next.add(i);
            cur = next;
            res.addAll(cur);
        }
        return res.size();
    }

    /*
    * 899. Orderly Queue
    * */
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] arr = S.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        } else {
            String res = S;
            for (int i = 1; i < S.length(); i++) {
                String tmp = S.substring(i) + S.substring(0, i);
                if (tmp.compareTo(res) < 0) {
                    res = tmp;
                }
            }
            return res;
        }
    }
}
