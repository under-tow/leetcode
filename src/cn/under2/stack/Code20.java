package cn.under2.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号（简单）
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *  
 * Created by HopeStation on 2021/7/17
 */
public class Code20 {

    public static void main(String[] args) {
        String str = "([)]";
        System.out.println("isValid(str) = " + isValid(str));
    }

    /**
     * 利用栈 代码简洁效率不低，就不复制官方的了
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character,Character> brackets = new HashMap<>() ;
        brackets.put('{','}');
        brackets.put('(',')');
        brackets.put('[',']');


        Stack stack = new Stack();
       for(char c : s.toCharArray()){
           if(stack.empty()){
               stack.push(c);
           }else {
               Character t = brackets.get(stack.peek());
               if (t!=null && t==c){
                   stack.pop();
               }else {
                   stack.push(c);
               }

           }
       }
       return stack.empty();
    }


}
