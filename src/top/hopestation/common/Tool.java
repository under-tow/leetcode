package top.hopestation.common;


import java.util.ArrayList;
import java.util.List;

/**
 * @author HopeStation
 */
public class Tool {
    public static void printNodes(ListNode head){
        List arr = new ArrayList<>();
        while (head!=null){
            arr.add(head.val);
            head = head.next ;
        }
        System.out.println("arr = " + arr);
    }
}
