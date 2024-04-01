package cn.under2.fastSlowPointer;

import cn.under2.common.ListNode;

import java.util.HashSet;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *  Created by HopeStation on 2021/5/24
 */
public class Code141 {

    public static void main(String[] args) {

//        HashSet<ListNode> seen = new HashSet<>();
//        ListNode listNode = new ListNode(1);
//        System.out.println("seen.add(new ListNode(1)) = " + seen.add(listNode));
//        System.out.println("seen.add(new ListNode(2)) = " + seen.add(new ListNode(2)));
//        System.out.println("seen.add(new ListNode(1)) = " + seen.add(listNode));
//        System.out.println( );

        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println("hasCycle_Ans1(listNode1) = " + hasCycle_Ans1(listNode1));
        System.out.println("hasCycle_Ans2(listNode1) = " + hasCycle_Ans2(listNode1));
        System.out.println("hasCycle_Ans3(listNode1) = " + hasCycle_Ans3(listNode1));
    }

    private static boolean hasCycle_Ans3(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * 哈希表法
     *      在每次遍历的过程中将节点放在哈希表中，若有环形，那么下次就会添加失败
     *      需要理解好引用（指针）的概念
     * @param head
     * @return
     */
    public static boolean hasCycle_Ans1(ListNode head) {

        HashSet<ListNode> seen = new HashSet<>();
        while (head!=null){
            if(!seen.add(head)){
                return true;
            }
            head= head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *      创建两个指针都指向头节点，一个指针每次一步，另一个每次走两步。如重合，就代表环形
     *      （由于2是1的倍数，所以一定）
     * @param head
     * @return
     */
    public static boolean hasCycle_Ans2(ListNode head) {


        if(head==null){
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1.next!=null && p2.next!=null && p2.next.next!=null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }

        return false;
    }
}
