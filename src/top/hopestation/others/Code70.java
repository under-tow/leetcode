package top.hopestation.others;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * @author HopeStation
 */
public class Code70 {

    public static void main(String[] args) {
        System.out.println("climbStairs_Office(2) = " + climbStairs_Office(2));
    }

    /**
     * 官方解：
     * 利用动态规划
     * @param n
     * @return
     */
    public static int climbStairs_Office(int n) {
        int a=0,b=0,r=1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = r;
            r = a + b;
        }
        return r;
    }

}
