package org.opensource.leetcode;

import java.util.Arrays;

/**
 */
public class S37 {
    public  static void solveSudoku(char[][] board) {
        int colLength = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < colLength; j++) {
                if(board[i][j] == '.'){
//                    for (int k = '1'; k <= '9'; k++) {
//                        if (isValid((char) k, i, j, board)) {
//                            // 数字尝试
//                            board[i][j] = (char) k;
//                        }
//                    }
                    backTrack(i, j, board);
                }

            }
            
        }

    }

    public static void backTrack(int row,int col,char[][] board){
        if (row==board.length && col==board[0].length-1) {
            return;
        }
        for (int k = '1'; k <= '9'; k++) {
            if (isValid((char) k, row, col, board)) {
                // 数字尝试
                board[row][col] = (char) k;
//                if(col==board[0].length-1){
//                    backTrack(++row, 0, board);
//                    board[--row][col] = '.';
//                }else {
//                    backTrack(row, ++col, board);
//                    board[row][--col] = '.';
//                }
                // 最后一列移到下一行
                int nextRow = col == board[0].length - 1 ? row+1 : row;
                int nextCol = col == board[0].length - 1 ? 0 : col+1;

                while (nextRow< board.length && board[nextRow][nextCol] != '.'){
                    nextRow = nextCol == board[0].length - 1 ? nextRow+1 : nextRow;
                    nextCol = nextCol == board[0].length - 1 ? 0 : nextCol+1;
                }
                if (nextRow==9) {
                    printSudu(board);
                    break;
                }
                backTrack(nextRow, nextCol, board);
                board[row][col] = '.';
            }
        }

    }

    public static void printSudu(char[][] board){

        for (int i = 0; i < board.length; i++) {
            System.err.println(Arrays.toString(board[i]));

        }
        System.err.println();
    }

    public static boolean isValid(char val,int row,int col,char[][] board){
        int colLength = board[0].length;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]==val) {
                return false;
            }
        }
        for (int i = 0; i < colLength; i++) {
            if (board[row][i]==val) {
                return false;
            }
        }
        int rowIndex = row / 3;
        int colIndex = col / 3;
        for (int i = rowIndex*3; i <(rowIndex+1)*3; i++) {
            for (int j = colIndex*3; j <(colIndex+1)*3; j++) {
                if (board[i][j]==val) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        for (int k = '1'; k <= '9'; k++) {
//            System.err.println((char)k);
////                        board[i][j] == Character.getNumericValue('a');
//        }
//        int aa =(int)'9';
//        System.err.println(aa);
//
//        int a='1';
//        char b=(char)a;
//        System.err.println(b);
//        System.err.println(Character.getNumericValue('9'));
        char[][] input = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(input);
        for (int i = 0; i < input.length; i++) {
            System.err.println(Arrays.toString(input[i]));

        }
    }
}
