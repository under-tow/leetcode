package top.hopestation.classic;


import java.util.Arrays;

public class KnightTour {
    private static final int SIZE = 8;
    private static final int[][] MOVES = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];
        int startX = 4;
        int startY = 3;

        System.out.println("Knight's tour starting from position: (" + startX + ", " + startY + ")");
        System.out.println("-----------------------------");
        board[startX][startY] = 1;

        if (solveKnightTour(board, startX, startY, 1)) {
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean solveKnightTour(int[][] board, int x, int y, int moveCount) {
        if (moveCount == SIZE * SIZE) {
            return true; // 所有方格都已经访问
        }

        for (int[] move : MOVES) {
            int nextX = x + move[0];
            int nextY = y + move[1];

            if (isValidMove(board, nextX, nextY)) {
                board[nextX][nextY] = moveCount + 1;
                if (solveKnightTour(board, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = 0; // 回溯
                }
            }
        }

        return false;
    }

    private static boolean isValidMove(int[][] board, int x, int y) {
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

