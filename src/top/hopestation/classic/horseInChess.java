package top.hopestation.classic;

/**
 * 马踏棋盘
 * https://blog.csdn.net/A_Renaissance/article/details/122151855
 */
public class horseInChess {

    //    private static final int[][] move = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static final int[][] move = {
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1}
    };
    private static final int[][] chess = new int[8][8];

    public static void main(String[] args) {
        int x = 7, y = 7;
        chess[x][y] = 1;
        step(x, y, 1);
        print();
    }


    public static void print() {
        System.out.println("--------------------------");
        for (int[] its : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(its[j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean step(int x, int y, int step) {

        if (step == 64) {
            return true;
        }
//        print();
        // 落子
        for (int i = 0; i < 8; i++) {
            int xt = x + move[i][0];
            int yt = y + move[i][1];
            if (isAvailable(xt, yt)) {
                chess[xt][yt] = step + 1;
                if (step(xt, yt, step + 1)) {
                    print();
                    return true;
                } else {
                    chess[xt][yt] = 0;
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
        return chess[x][y] == 0;
    }

}
