package top.hopestation.hash;

import java.util.HashMap;

/**
 * 3.无重复字符的最长子串的长度
 */
public class Code_03 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap hashMap = new HashMap();
        //字符串长度
        int len = chars.length;
        //最长子串长度
        int max = 0;
        //每一次的最长子串长度
        int res = 0;
        //第一层循环 数组长度 减 上次的最大长度。避免多余的无效遍历
        for (int i = 0; i < len - max; i++) {
            //从第i个 获取最长子串长度
            for (int j = i; j < len; j++) {
                //若重复，则跳出当前循环。清空map和res
                if (hashMap.containsKey(chars[j])) {
                    hashMap.clear();
                    res = 0;
                    break;
                } else {
                    //不重复，放入map来方便下一次判断是否重复
                    hashMap.put(chars[j], null);
                    res++;
                    max = res > max ? res : max;//如果比max大就给max
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("RESULT==>" + lengthOfLongestSubstring("pwwkew"));
    }
}
