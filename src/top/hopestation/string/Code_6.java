package top.hopestation.string;


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

        String str = "123456789";
        int rows = 5;
        convert_Mine(str,rows);
    }

    /**
     * 我的解
     *  思路：按题中的描述，认为用数组来处理比较合适，
     *  先放进数组、然后横向读取
     * @param s
     * @param numRows
     * @return
     */
    public static String convert_Mine(String s, int numRows) {

        char[] chars = s.toCharArray();
//        int width = chars.length / numRows;
        int[][] map = new int[numRows][chars.length];

        int x=0,y = 0;
        boolean isForward = true;
        for (int idx = 0; idx < chars.length; idx++) {

            map[x][y] = chars[idx];
            if(x==0){
                isForward = true ;
            }else if(x==numRows){
                isForward = false;
            }
            x = isForward ? x+1 : x-1 ;

        }
        printIntMap(map);
        return "";
    }

    public static void printIntMap(int [][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(" " + map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
