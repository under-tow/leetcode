package top.hopestation.hash;


import java.lang.reflect.Array;
import java.util.*;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * Created by HopeStation on 2021/5/24
 */
public class Code387 {
    public static void main(String[] args) {
        int firstIdx_mine = firstUniqChar_Mine("aabb");
        int firstIdx_office = firstUniqChar_Office("aabb");
        System.out.println("firstIdx_mine = " + firstIdx_mine);
        System.out.println("firstIdx_office = " + firstIdx_office);
    }

    /**
     * 我的解
     *  - 第一次遍历 存放 {字母 索引}
     *  - 第二次遍历
     *      - 首先移除当前索引的值
     *      - 然后判断 hash里是否存在
     *      - 存在就在放回取hash，进行下一次查询
     */
    private static int firstUniqChar_Mine(String str){

        char[] chars = str.toCharArray();
        HashMap hash = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            hash.put(i,chars[i]);
        }
        for (int i = 0; i < chars.length; i++) {
            hash.remove(i,chars[i]);
            if(!hash.containsValue(chars[i])){
                return i;
            }
            hash.put(i,chars[i]);
        }

        return -1;
    }

    /**
     * 官网题解
     * - 第一次遍历：在Hash中存放 {字母，出现次数}
     *   - 在第一次存放的时候就判断 是否存在，存在就+1 再次放入
     * - 第二次遍历
     *   - 根据字母的顺序找到第一个 出现次数为 1 的
     */
    public static int firstUniqChar_Office(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 优解
     * 判断首次出现的位置 是否等于 最后一次出现的位置
     */
    public static int firstUniqChar_Nice(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

}
