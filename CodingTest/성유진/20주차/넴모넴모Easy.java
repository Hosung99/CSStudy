import java.util.*;
import java.io.*;

// 14712
public class 넴모넴모Easy {
  static int N, M;
  static int[][] board;
  static int result = 0;

  public static boolean nemmo() {
    for (int i = 0; i < N-1; i++) {
      for (int j = 0; j < M-1; j++) {
        if (board[i][j] == 1 && board[i][j+1] == 1
          && board[i+1][j] == 1 && board[i+1][j+1] == 1) 
        return true;
      }
    }
    return false;
  }

  public static void bt(int d) {
    if (!nemmo())
      result++;

    if (d == N * M)
      return;

    for (int x = d; x < N * M; x++) {
      int i = x / M;
      int j = x % M;
      if (board[i][j] == 0) {
        board[i][j] = 1;
        bt(x);
        board[i][j] = 0;
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    bt(0);
    System.out.println(result);
  }
}
