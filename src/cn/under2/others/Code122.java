package cn.under2.others;


/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author HopeStation
 */
public class Code122 {

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println("maxProfit_Mine(prices) = " + maxProfit_Mine(prices));
        System.out.println("maxProfit_Office(prices) = " + maxProfit_Office(prices));
    }


    /**
     * 官方解
     * 这个就是简单的累加，我理解这个是不安套路出牌啊，没有按照规则交易。
     * 但是这种的结果的确时正确的
     * @param prices
     * @return
     */
    public static int maxProfit_Office(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }



    /**
     * 我的解
     * 思路：
     *  - 首先若数组只有一天直接返回 0
     *  - 否则，度过每天
     *      - 若后一天的价格 > 前一天的价格就进行交易 （利用循环直接找到最大的价格差）
     *      - 若后一天的价格 <= 前一天的价格 则日期加1，返回1进行查找
     * @param prices
     * @return
     */
    public static int maxProfit_Mine(int[] prices) {

        //初始利润
        int profit = 0;
        //交易天数
        int len = prices.length;
        //只有一天，则不用交易 直接返回
        if(len < 2 ){
            return 0;
        }
        //度过每一天来进行交易
        for (int i = 1, pricePre = prices[0] ; i < len; i++) {
            int t = i;
            int max = pricePre;
            while ( i < len && max < prices[i] && pricePre < prices[i] ){
                max = prices[i++];
            }
            if( t == i ){
                pricePre = prices[ i ];
                continue;
            }
            profit += prices[ i-1 ] -  pricePre;
            if( i>=len){
                break;
            }
            pricePre = prices[ i ];
        }
        return profit;
    }
}


/**
 *122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: prices = [7,1,2,5,1,10,18,19]  4 + 14  18
 * 输出: 7
 *
 * 示例 1:
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */