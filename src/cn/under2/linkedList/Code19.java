package cn.under2.linkedList;

import cn.under2.common.ListNode;
import cn.under2.common.Tool;


/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * Created by HopeStation on 2021/5/26
 */

public class Code19 {


    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        ListNode head = removeNthFromEnd_Main(node0, 5);
        ListNode head = removeNthFromEnd_Office02(node0, 5);
//        ListNode head = removeNthFromEnd_Office01(node0, 5);
        Tool.printNodes(head);

    }


    /**
     * 我的解
     * - 思路 两次遍历实现
     *  第一次遍历： 获取链表size
     *  第二次遍历，删除第二个
     *
     *  答案在特殊情况错误，没有解出来
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_Main(ListNode head, int n) {
        ListNode headBefore = new ListNode();
        headBefore.next = head;
        if(n<=0){
            return head;
        }
        int size = 0;
        ListNode headTemp =headBefore;
        while (head!=null){
            head = head.next ;
            size ++ ;
        }
//        if(size == n && n == 1){
//            return null;
//        }
        for (int i = 0; i < size - n  ; size--) {
            headTemp = headTemp.next;
        }
        if(headTemp.next!=null){
           headTemp.next = headTemp.next.next;
        }
        return headBefore.next;
    }



    /**
     * 官方解 - 暴力破解法
     * 两次遍历
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_Office01(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 官方解 - 双指针（快慢指针）
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_Office02(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }




}
