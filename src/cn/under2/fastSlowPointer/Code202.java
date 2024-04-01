package cn.under2.fastSlowPointer;


/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * Created by HopeStation on 2021/6/18
 */
public class Code202 {

    public static void main(String[] args) {
        System.out.println("isHappy = " + isHappy_Office(29));
    }

    /**
     * 我的解
     * 求平方和后出现无限循环时，不清楚如何判断循环而返回false
     */
    public static boolean isHappy_Mine(int n) {
        return false;
    }


    /**
     * 官网解
     *     快慢指针
     *     思路：按题目中求平方和后一共有梁鸿志那个可能，第一种 = 1，第二种：无限循环
     *          而确定了在无限循环时出现了链表结构，在无限链表结构时候相当了用快慢指针来解决
     * @param n
     * @return
     */
    public static boolean isHappy_Office(int n) {

        int slow = n;
        int fast = getNext(n);
        while ( fast!=1 &&  slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;

    }

    public static int getNext(int n){
        int total = 0;
        while (n >0 ){
            int d = n%10;
            n = n/10;
            total += Math.pow(d,2);
        }
        return total;
    }



}
