package cn.under2.动态规划;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Code121 {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,6,4,3,1};
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("maxProfit(prices) = " + maxProfit(prices));
        System.out.println("maxProfit2(prices) = " + maxProfit2(prices));
    }

    /**
     * 我的解法 超时
     * 2024年4月2日17:01:51
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]) {
                    int res = prices[i] - prices[j];
                    if (res > max) max = res;
                }
            }
        }
        return max;
    }




    /**
     * 官方解
     */
    public static int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}
