package top.hopestation.common;


import java.util.ArrayList;
import java.util.List;

/**
 * @author HopeStation
 */
public class Tool {

    /**
     * 打印链表数据
     * @param head
     */
    public static void printNodes(ListNode head){
        List arr = new ArrayList<>();
        while (head!=null){
            arr.add(head.val);
            head = head.next ;
        }
        System.out.println("arr = " + arr);
    }

    /**
     * 数组->二叉树
     * @param array
     * @return
     */
    public static TreeNode arr2Tree(Integer[] array) {
        int floor = 0, count = 0;
        TreeNode[] treeNodes = new TreeNode[array.length];
        while (array != null && count < array.length) {
            int start = (int) Math.pow(2, floor) - 1;
            int end = (int) Math.pow(2, floor + 1) - 1;
            if (end > array.length) {
                end = array.length;
            }
            for (int i = start; i < end; i++) {
                if (array[i] != null) {
                    treeNodes[i] = new TreeNode(array[i]);
                } else {
                    treeNodes[i] = null;
                }
                if (i > 0) {
                    int parent = (i - 1) / 2;
                    if (parent >= 0) {
                        TreeNode pNode = treeNodes[parent];
                        if (pNode != null) {
                            if (i % 2 == 1) {
                                pNode.left = treeNodes[i];
                            } else {
                                pNode.right = treeNodes[i];
                            }
                        }
                    }
                }
                count++;
            }
            floor++;
        }
        return treeNodes[0];
    }

}
