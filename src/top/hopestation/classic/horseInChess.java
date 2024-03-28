package top.hopestation.classic;

/**
 * 马踏棋盘
 * https://blog.csdn.net/A_Renaissance/article/details/122151855
 */
public class horseInChess {

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
    private static final boolean[][] visit = new boolean[8][8];
    private static boolean find = false;

    public static void main(String[] args) {
        step( 0, 0, 1);
    }


    public static void print() {
        for (int[] its : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(its[j] + "  ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void step( int x, int y, int step) {


        if ( find || step == 64  ) {
            find = true;
            return;
        }
        print();

        visit[x][y] = true;
        // 落子
        chess[x][y] = step;
        for (int i = 0; i < 8; i++) {
            int xt = x + move[i][0];
            int yt = y + move[i][1];
            if (available(xt, yt)) {
                step( xt, yt, step + 1);
            }
        }
        // 落子
        chess[x][y] = 0;
        visit[x][y] = false;
    }

    public static boolean available(int x, int y) {
        return inChess(x, y) && isVisit(x, y);
    }

    public static boolean inChess(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    public static boolean isVisit(int x, int y) {
        return !visit[x][y];
    }

}
