package cn.under2.others;

/**
 * 2810. 故障键盘
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * 返回最终笔记本屏幕上输出的字符串。
 *
 * 示例 2：
 *
 * 输入：s = "poiinter"
 * 输出："ponter"
 * 解释：
 * 输入第 1 个字符后，屏幕上的文本是："p" 。
 * 输入第 2 个字符后，屏幕上的文本是："po" 。
 * 因为第 3 个字符是 'i' ，屏幕上的文本被反转，变成 "op" 。
 * 因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "po" 。
 * 输入第 5 个字符后，屏幕上的文本是："pon" 。
 * 输入第 6 个字符后，屏幕上的文本是："pont" 。
 * 输入第 7 个字符后，屏幕上的文本是："ponte" 。
 * 输入第 8 个字符后，屏幕上的文本是："ponter" 。
 * 因此，返回 "ponter" 。
 *
 */
public class Code2810 {

    public static void main(String[] args) {
        System.out.println("faultyKeyBoard(\"poiinter\") = " + faultyKeyBoard("poiinter"));
    }

    public static String faultyKeyBoard(String s) {
        StringBuilder sf = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c != 'i'){
                sf.append(c);
            }else {
                sf.reverse();
            }
        }
        return sf.toString();
    }

}
