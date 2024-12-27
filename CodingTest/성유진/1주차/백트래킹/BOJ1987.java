import java.util.*;
import java.util.stream.*;

public class BOJ1987 {
  static int R, C;
  static int[][] board;
  static int result;
  static boolean[] visited;
  
  static void move (int i, int j, int cnt) {
    int[] di = { -1, 1, 0, 0 };
    int[] dj = { 0, 0, -1, 1 };
    if (cnt > result)
      result = cnt;
    for (int dir = 0; dir < 4; dir++) {
      int ni = i + di[dir];
      int nj = j + dj[dir];
      if (ni < 0 || ni >= R || nj < 0 || nj >= C)
        continue;
      int cur = board[ni][nj];
      if (!visited[cur]) {
        visited[cur] = true;
        move(ni, nj, cnt + 1);
        visited[cur] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    R = scanner.nextInt();
    C = scanner.nextInt();
    scanner.nextLine();
    board = new int[R][C];
    for (int i = 0; i < R; i++) {
      String input = scanner.nextLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = input.charAt(j) - 'A';
      }
    }
    visited = new boolean[26];
    visited[board[0][0]] = true;
    result = 1;
    move(0, 0, 1);
    System.out.println(result);
  }
}