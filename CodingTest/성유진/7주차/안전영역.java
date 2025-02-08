import java.io.*;
import java.util.*;

// 2468
public class 안전영역 {
  static int N;
  static int[][] board = new int[101][101];
  static boolean[][] visited = new boolean[101][101];
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, -1, 1};

  public static void bfs(int i, int j, int h) {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {i, j});
    visited[i][j] = true;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curI = cur[0];
      int curJ = cur[1];

      for (int dir = 0; dir < 4; dir++) {
        int ni = curI + di[dir];
        int nj = curJ + dj[dir];

        if (ni < 0 || ni >= N || nj < 0 || nj >= N)
          continue;
        if (board[ni][nj] <= h || visited[ni][nj]) // 안전영역 여부 확인
          continue;
        Q.offer(new int[] {ni, nj});
        visited[ni][nj] = true;
      }
    }
  }

  public static int countSafe(int h) {
    for (int i = 0; i < N; i++) {
      Arrays.fill(visited[i], false);
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] <= h || visited[i][j]) continue;
        bfs(i, j, h);
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int maxH = 0;
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        maxH = Math.max(maxH, board[i][j]);
      }
    }

    int ans = 0;
    for (int i = 0; i < maxH; i++) {
      ans = Math.max(ans, countSafe(i));
    }
    System.out.println(ans);
  }
}
