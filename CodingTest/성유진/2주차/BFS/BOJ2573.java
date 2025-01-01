import java.io.*;
import java.util.*;

public class BOJ2573 {
  static int n, m;
  static int[][] board;
  static boolean[][] visited;

  public static int countTotalIce() {
    int ice = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != 0)
          ice++;
      }
    }
    return ice;
  }

  public static void melt() {
    int[] di = { -1, 1, 0, 0 };
    int[] dj = { 0, 0, -1, 1 };
    int[][] tmp = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 0) {
          tmp[i][j] = 0;
          continue;
        }
        int ice = 0;
        for (int dir = 0; dir < 4; dir++) {
          int ni = i + di[dir];
          int nj = j + dj[dir];
          if (board[ni][nj] == 0)
            ice++;
        }
        tmp[i][j] = Math.max(board[i][j] - ice, 0);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        board[i][j] = tmp[i][j];
      }
    }
  }

  public static int countArea() {
    int starti = 0;
    int startj = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != 0) {
          starti = i;
          startj = j;
          break;
        }
      }
      if (starti != 0 && startj != 0) {
        break;
      }
    }

    Queue<int[]> Q = new LinkedList<>();
    int[] di = { -1, 1, 0, 0 };
    int[] dj = { 0, 0, -1, 1 };

    Q.offer(new int[]{starti, startj});
    visited[starti][startj] = true;
    int cnt = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curi = cur[0];
      int curj = cur[1];

      cnt++;
      for (int dir = 0; dir < 4; dir++) {
        int ni = curi + di[dir];
        int nj = curj + dj[dir];
        if (ni < 0 || ni >= n || nj < 0 || nj >= m)
          continue;
        if (board[ni][nj] != 0 && !visited[ni][nj]) {
          visited[ni][nj] = true;
          Q.offer(new int[]{ni, nj});
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int time = 0;
    while (true) {
      for (int i = 0; i < n; i++) {
        Arrays.fill(visited[i], false);
      }
      int totalIce = countTotalIce();

      if (totalIce == 0) {
        time = 0;
        break;
      }
      int countIce = countArea();
      if (countIce != totalIce) {
        break;
      }
      melt();
      
      time++;
    }

    System.out.println(time);
  }
}