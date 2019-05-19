package pers.whe.code.leetcode.problem.list;

import pers.whe.code.model.ListNode;

public class P_725 {

    /*
    * 725. Split Linked List in Parts
    * r = len % k n = len / k, 前r个有n + 1个节点。
    * */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next)
            len++;
        int n = len / k, r = len % k;
        ListNode node = root, pre = null;
        for (int i = 0; i < n && node != null; i++, r--) {
            res[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                pre = node;
                node = node.next;
            }
            pre.next = null;
        }
        return res;
    }
}
