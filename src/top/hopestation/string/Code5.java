package top.hopestation.string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Code5 {

    public static void main(String[] args) {
        String s = replaceSpace(" ax xw ");
        System.out.println(s);
    }

    public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}
