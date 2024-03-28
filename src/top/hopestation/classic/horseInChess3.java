//package top.hopestation.classic;
//
///**
// * 马踏棋盘
// */
//public class horseInChess3 {
//
//
//    public static void main(String[] args) {
//        int[][] chess = new int[8][8];
//        horse(chess, 3, 3, 1);
//        print(chess);
//    }
//
//    public static void print(int[][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//
//    public static void horse(int[][] chess, int x, int y, int step,int choice) {
//        if(step ==64){
//            return ;
//        }
//
//
//        chess[x][y] = step++;
//        if(choice==1){
//            checkStep(chess, x - 1, y - 2, step);
//        }
//
//        if(choice==1){
//            horse(chess, x - 1, y - 2, step);
//        }
//
//        step++;
//        if (checkStep(chess, x - 1, y - 2, step)) {
//            return true;
//        }
//        if (checkStep(chess, x - 1, y + 2, step)) {
//            return true;
//        }
//        if (checkStep(chess, x + 1, y - 2, step)) {
//            return true;
//        }
//        if (checkStep(chess, x + 1, y + 2, step)) {
//            return true;
//        }
//        if (horse(chess, x - 2, y - 1, step)) {
//            return true;
//        }
//        if (horse(chess, x - 2, y + 1, step)) {
//            return true;
//        }
//        if (horse(chess, x + 2, y - 1, step)) {
//            return true;
//        }
//        if (horse(chess, x + 2, y + 1, step)) {
//            return true;
//        }
//        // 落子
//        chess[x][y] = 0;
//        return false;
//
//    }
//
//    private static boolean checkStep(int[][] chess, int x, int y) {
//        // 在棋盘内，并没有被踏过
//        return 0 <= x && x < 8 && 0 <= y && y < 8 && chess[x][y] > 0;
//    }
//
//
//}
