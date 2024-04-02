package cn.under2.动态规划;

import java.util.HashMap;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class Code70 {

    private static final HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("climb(25) = " + climbStairs(60));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            Integer res;
            if ((res = cache.get(n)) != null) {
                return res;
            } else {
                res = climbStairs(n - 1) + climbStairs(n - 2);
                cache.put(n, res);
                return res;
            }

        }
    }

}
