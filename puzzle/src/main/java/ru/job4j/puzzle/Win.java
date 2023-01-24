package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1) {
                rsl = (horizontal(board, index) || vertical(board, index));
            }
        }
        return rsl;
    }

    public static boolean horizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int index = 0; index < board[row].length; index++) {
            if (board[row][index] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean vertical(int[][]  board, int colum) {
        boolean rsl = true;
        for (int[] index : board) {
            if (index[colum] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
