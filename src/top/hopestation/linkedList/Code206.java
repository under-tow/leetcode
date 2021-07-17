package top.hopestation.linkedList;

import top.hopestation.common.ListNode;
import top.hopestation.common.Tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * Created by HopeStation on 2021/6/8
 */

public class Code206 {


    /**
     * 测试类
     * @param args
     */
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode head = new ListNode(1,n2);


     Tool.printNodes(reverseList_Mine01(head));
     Tool.printNodes(reverseList_Mine02(head));
     Tool.printNodes(reverseList_Office(head));

    }

    /**
     * 解法 1
     * 使用比较笨的方法，先将每一个节点的值记录在list中。然后反转后重新创建节点
     * @param head
     * @return
     */
    public static ListNode reverseList_Mine01(ListNode head) {
        //遍历存储每个节点的值
        List<Integer> nodes = new ArrayList<>() ;
        while (head!=null){
            nodes.add(head.val);
            head = head.next;
        }
        //反转
        Collections.reverse(nodes);
        //根据反转后的值 重新创建链表
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        for(Integer item : nodes){
            ListNode node = new ListNode();
            node.val = item;
            current.next = node;
            current = node;
        }
        return newHead.next;
    }

    /**
     * 解法 2
     * 双指针，没解出来 ×
     * @param head
     * @return
     */
    public static ListNode reverseList_Mine02(ListNode head) {

        ListNode cur = null;
        ListNode pre = head;
        while (pre!=null){
            ListNode tmp = new ListNode(pre.val,pre.next);
           pre.next = cur;
           cur = tmp;
           pre = tmp.next;

        }
        return cur;
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur!=null){
//            ListNode tmp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tmp;
//
//        }
//        return pre;
    }

    /**
     * 官方解
     * 双指针
     * @param head
     * @return
     */
    public static ListNode reverseList_Office(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }




}


