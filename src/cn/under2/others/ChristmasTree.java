package cn.under2.others;

/**
 * 按照1、3、5、7.. 的结构输出圣诞树的形状
 *   *         5 - 1 = 4
 *  ***        5 - 3 = 2
 * *****
 */
public class ChristmasTree {

    public static void main(String[] args) {
//        char[][] chars = starPrint(5);
//        for (char[] arr : chars) {
//            for (char c : arr) {
//                System.out.print(c);
//            }
//            System.out.println();
//        }

//        printChristmasTree(5);
        starPrint2(5);
    }

    public static void printChristmasTree(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 打印圣诞树的树干
        for (int i = 0; i < height - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static char[][] starPrint(int rows) {
        int maxLength = 1 + 2 * (rows - 1);
        char[][] arr = new char[rows][maxLength];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < maxLength; j++) {
                int len = 1 + 2 * (i);
                int blank = (maxLength - len) / 2;
                if (j < blank || j >= len + blank) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = '*';
                }
            }
        }
        return arr;
    }

    public static void starPrint2(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
