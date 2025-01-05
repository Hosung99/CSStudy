import java.io.*;
import java.util.*;

public class BOJ1926 {
  static int n, m;
  static int[][] board;
  static boolean[][] visited;

  public static int bfs(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    int[] di = { -1, 1, 0, 0 };
    int[] dj = { 0, 0, -1, 1 };

    Q.offer(new int[]{i, j});
    visited[i][j] = true;
    int size = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curi = cur[0];
      int curj = cur[1];

      size++;
      for (int dir = 0; dir < 4; dir++) {
        int ni = curi + di[dir];
        int nj = curj + dj[dir];
        if (ni < 0 || ni >= n || nj < 0 || nj >= m)
          continue;
        if (!visited[ni][nj] && board[curi][curj] == board[ni][nj]) {
          visited[ni][nj] = true;
          Q.offer(new int[]{ni, nj});
        }
      }
    }
    return size;
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
      Arrays.fill(visited[i], false);
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int maxSize = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && board[i][j] == 1) {
          maxSize = Math.max(bfs(i, j), maxSize);
          cnt++;
        }
      }
    }
    System.out.println(cnt + "\n" + maxSize);
  }
}