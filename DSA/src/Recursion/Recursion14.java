package Recursion;

import java.util.*;

public class Recursion14 {

  // m is the given matrix and n is the order of matrix
  private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,
                            boolean vis[][], int di[], int dj[]) {
    if (i == n - 1 && j == n - 1) {
      ans.add(move);
      return;
    }
    String dir = "DLRU";
    for (int ind = 0; ind < 4; ind++) {
      int nexti = i + di[ind];
      int nextj = j + dj[ind];
      if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
          !vis[nexti][nextj] && a[nexti][nextj] == 1) {

        vis[i][j] = true;
        solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
        vis[i][j] = false;
      }
    }
  }

  public static ArrayList<String> findPath(int[][] m, int n) {
    boolean vis[][] = new boolean[n][n];
    int di[] = { +1, 0, 0, -1 };
    int dj[] = { 0, -1, 1, 0 };
    ArrayList<String> ans = new ArrayList<>();
    if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis, di, dj);
    return ans;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] a = { {1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1} };

    ArrayList<String> res = findPath(a, n);
    if (!res.isEmpty()) {
      for (String path : res) {
        System.out.print(path + " ");
      }
      System.out.println();
    } else {
      System.out.println(-1);
    }
  }
}
