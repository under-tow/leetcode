package top.hopestation.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *  
 * Created by HopeStation on 2021/7/18
 */
public class Code32 {

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println("longestValidParentheses(str) = " + longestValidParentheses(str));


    }

    /**
     * 我的解
     * 琢磨了两小时，写出来的方法。效率很低
     * 思路：
     *   例如字符串为：“（）（（（）（）”
     *  进出栈，匹对正常的括号出栈。栈中剩余的符号为 “（（”
     *  记录他们的索引位置，将原字符串分为了 （） 和 （）（） 两个部分
     *  长度最长的即是结果
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Map<String,Object>> stack = new Stack();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!stack.empty() && stack.peek().get("char").toString().equals( "" + '(')  && chars[i] == ')'){
                stack.pop();
            }else {
                HashMap m = new HashMap();
                m.put("char",chars[i]);
                m.put("idx",i);
                stack.push(m);
            }
        }
        while (!stack.empty()){
            int idx = Integer.parseInt(stack.pop().get("idx").toString()) ;
            chars[idx] = 'a';
        }
        String[] arr = String.valueOf(chars).split("a");
        for(String str :  arr){
            max = Math.max(str.length(),max);
        }
        return  max;
    }


}
