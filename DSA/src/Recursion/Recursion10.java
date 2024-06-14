package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recursion10 {
     public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < > ();
        boolean leftRow[] = new boolean[n];
        boolean upperDiagonal[] = new boolean[2 * n - 1];
        boolean lowerDiagonal[] = new boolean[2 * n - 1];
        solve(0,n, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }



    static void solve(int col, int n, char[][] board, List <List<String>> res, boolean  leftRow[], boolean lowerDiagonal[], boolean upperDiagonal[]) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] || lowerDiagonal[row + col] || upperDiagonal[n - 1 + col - row])
                continue;
            board[row][col] = 'Q';
            leftRow[row] = lowerDiagonal[row + col] = upperDiagonal[n - 1 + col - row] = true;
            solve(col + 1, n, board, res, leftRow, lowerDiagonal, upperDiagonal);
            board[row][col] = '.';
            leftRow[row] = lowerDiagonal[row + col] = upperDiagonal[n - 1 + col - row] = false;
        }
    }


    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList <> ();
         for (char[] board1 : board) {
             String s = new String(board1);
             res.add(s);
         }
        return res;
    }
    public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}