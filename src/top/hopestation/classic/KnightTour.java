package top.hopestation.classic;


import java.util.Arrays;

public class KnightTour {
    private static final int SIZE = 8;
    private static int TRY_COUNT = 0;
    private static final int[][] MOVES = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];
        int startX = 0;
        int startY = 0;

        System.out.println("Knight's tour starting from position: (" + startX + ", " + startY + ")");
        System.out.println("-------------------------");
        board[startX][startY] = 1;

        if (solveKnightTour(board, startX, startY, 1)) {
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

   /**
 * 在棋盘上寻找马的旅游路径问题的解。
 * 马每次移动必须是规定的几种步法之一。
 *
 * @param board 表示棋盘的二维数组，每个元素代表一个方格的状态。
 * @param x 当前马所在的横坐标。
 * @param y 当前马所在的纵坐标。
 * @param step 当前已经移动的步数。
 * @return 如果找到一条满足条件的路径返回true，否则返回false。
 */
private static boolean solveKnightTour(int[][] board, int x, int y, int step) {
    if (TRY_COUNT++ > Math.pow(8, 8)) {
        return false;
    }

    // 所有方格都已经访问
    if (step == SIZE * SIZE) {
        return true;
    }

    // 尝试每一种可能的移动
    for (int[] move : MOVES) {
        int nextX = x + move[0];
        int nextY = y + move[1];


        // 判断移动是否有效
        if (isValidMove(board, nextX, nextY)) {
            board[nextX][nextY] = step + 1;
//            System.out.println("-------------------------");
//            printBoard(board);
            // 递归尝试下一步
            if (solveKnightTour(board, nextX, nextY, step + 1)) {
                return true; // 找到解
            } else {
                board[nextX][nextY] = 0; // 回溯，撤销之前的移动
            }
        }
    }

    return false; // 无解
}


    /**
     * 判断在国际象棋棋盘上指定位置的移动是否有效。
     *
     * @param board 表示国际象棋棋盘的二维整数数组。
     * @param x 指定移动的横坐标。
     * @param y 指定移动的纵坐标。
     * @return 如果移动有效，则返回true；否则返回false。
     */
    private static boolean isValidMove(int[][] board, int x, int y) {
        // 判断位置是否在棋盘范围内且当前位置没有棋子
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == 0;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}

