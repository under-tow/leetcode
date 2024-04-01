package cn.under2.classic;

/**
 * 马踏棋盘
 * https://blog.csdn.net/A_Renaissance/article/details/122151855
 */
public class horseInChess {

    //    private static final int[][] move = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static final int[][] HORSE_OFFSET = {
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1}
    };
    private static final int[][] CHESS = new int[8][8];

    public static void main(String[] args) {
        int x = 7, y = 7;
        CHESS[x][y] = 1;
        move(x, y, 1);
        print();
    }


    public static void print() {
        System.out.println("--------------------------");
        for (int[] its : CHESS) {
            for (int j = 0; j < CHESS[0].length; j++) {
                System.out.print(its[j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean move(int x, int y, int step) {

        if (step == 64) {
            return true;
        }
//        print();
        // 落子
        for (int i = 0; i < 8; i++) {
            int xt = x + HORSE_OFFSET[i][0];
            int yt = y + HORSE_OFFSET[i][1];
            if (isAvailable(xt, yt)) {
                CHESS[xt][yt] = step + 1;
                if (move(xt, yt, step + 1)) {
                    print();
                    return true;
                } else {
                    CHESS[xt][yt] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isAvailable(int x, int y) {
        return inChess(x, y) && iUnVisit(x, y);
    }

    public static boolean inChess(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    public static boolean iUnVisit(int x, int y) {
        return CHESS[x][y] == 0;
    }

}
