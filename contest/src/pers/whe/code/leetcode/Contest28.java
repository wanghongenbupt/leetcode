package pers.whe.code.leetcode;

public class Contest28 {

    /*
     * 551. Student Attendance Record I
     * 这道题将一个字符串中如果出现a道个数大于1， 或连续L的个数大于2，就不给奖励
     * 1 用aLen 记录A的个数
     * 2 用lLen 记录连续L个数，当出现其他字符时为0
     * time o(n)  space o(1)
     * */
    public boolean checkRecord(String s) {
        int aLen = 0;
        int lLen = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                aLen++;
            } else if (c == 'L') {
                lLen++;
            }
            if (c != 'L') {
                lLen = 0;
            }
            if (aLen > 1 || lLen > 2) {
                return false;
            }
        }
        return true;
    }

    /*
     * 553. Optimal Division
     * 为了得到最大值，我们让分子最大，分母最小，一种情况如下
     *  X1/(X2/X3/X4/X5...)
     * */
    public String optimalDivision(int[] nums) {
        if (nums.length == 0) return "";
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append("" + nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/");
            sb.append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    /*
     * 552. Student Attendance Record II
     * 这道题是一个动态规划题目，
     * 1 状态 像 a0l0 a的个数为0，连续l的个数为0
     * 2 转移方程 从 a0l0, a0l1, a0l2 加 p 就可以变为a0l0;
     * 3 初始条件， 一个字符串的时候， a0l0 = 1, a0l1 = 1, a0l2 = 0, a1l0 = 1, a1l1 = 0, a1l2 = 0;
     * 4 结果为这几个值的和
     * */
    public int checkRecord(int n) {
        long M = 1000000007;
        long a0l0 = 1, a0l1 = 1, a0l2 = 0, a1l0 = 1, a1l1 = 0, a1l2 = 0;
        for (int i = 2; i <= n; i++) {
            long a0l0v = (a0l0 + a0l1 + a0l2) % M;
            long a0l1v = a0l0;
            long a0l2v = a0l1;
            long a1l0v = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long a1l1v = a1l0;
            long a1l2v = a1l1;
            a0l0 = a0l0v;
            a0l1 = a0l1v;
            a0l2 = a0l2v;
            a1l0 = a1l0v;
            a1l1 = a1l1v;
            a1l2 = a1l2v;
        }
        long res = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
        return (int) res;
    }
}
