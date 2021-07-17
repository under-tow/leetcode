package top.hopestation.string;


import java.util.ArrayList;
import java.util.List;

/**
 *  Z 字形变换
 *  将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 */
public class Code_6 {

    public static void main(String[] args) {

        String str = "PAYPALISHIRING";
        String longStr = "hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhiixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbfcriqifpgynkrrefx";
        int rows = 3;
        System.out.println("convert_Mine(str,rows) = " + convert_Mine(str, rows));
        System.out.println("convert_Mine2(str,rows) = " + convert_Mine2(str, rows));
    }

    /**
     * 我的解
     *  思路：按题中的描述，认为用数组来处理比较合适，
     *  先放进数组、然后横向读取.
     *  提交LeetCode提示超出时间限制
     * @param s
     * @param numRows
     * @return
     */
    public static String convert_Mine(String s, int numRows) {


        if(numRows==1){
            return s;
        }

        char[] chars = s.toCharArray();
//        int width = chars.length / numRows;
        char[][] map = new char[numRows][chars.length];

        int x=0,y = 0;
        boolean isForward = true;
        boolean isNext =false;
        for (int idx = 0; idx < chars.length; idx++) {

            map[x][y] = chars[idx];
            //x
            if(x==0 && idx!=0){
                isForward = true ;
                isNext = !isNext;
            }else if(x==numRows-1){
                isForward = false;
                isNext = !isNext;
            }
            x = isForward ? x+1 : x-1 ;
            //y
            if(isNext){
                y++;
            }

        }
        printIntMap(map);
        return getZ(map);
    }



    /**
     * 我的解
     *  参考了官网的接替思路。再来自己写一遍
     *  思路是这样的：
     *      在我的解法一基础上，将二维数组变为了List<String>
     *      原来的二维数组形成后也需要再次遍历每行的字符然后拼接起来，还有空位的情况。
     *      而这种方式在遍历的时候确定每行字符的顺序后就直接形成的字符串，省去一步，简洁了一些
     * @param s
     * @param numRows
     * @return
     */
    private static String convert_Mine2(String s, int numRows){

        //如果行数为1，则字符串不会变化
        if(numRows == 1){
            return s;
        }
        //循环行数：如果输入的行数大于字符串的长度，则后面多余的遍历对于结果没有影响。 min(字符串的最大长度，输入的行数)。
        if(numRows>=s.length()){
            return s;
        }
        //初始化每行字符传为空
        List<StringBuilder> rowList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowList.add(new StringBuilder());
        }
        //整理每行的字符串
        int curRow = 0;
        boolean isGoDown = false;

        for(char c : s.toCharArray()){
            if(curRow == 0 || curRow == numRows-1){
                isGoDown = !isGoDown;
            }
            rowList.get(isGoDown?curRow++:curRow--).append(c);
        }

        //拼接每行的结果 返回
        StringBuilder res = new StringBuilder();
        for(StringBuilder b :rowList) {
            res.append(b);
        }

        return res.toString();
    }

    /**
     * 官方解法
     * @param s
     * @param numRows
     * @return
     */
    public String convert_Office(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }


    /**
     * 获取字符地图中的Z型结果集
     * @param map
     * @return
     */
    public static String getZ(char [][] map){
        String s = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                s+= map[i][j];
            }
        }
        return s.replaceAll(  "\u0000", ""  );
    }

    /**
     * 打印char数组
     * @param map
     */
    public static void printIntMap(char [][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print("-" + map[i][j]);
            }
            System.out.println();
        }
    }
}
