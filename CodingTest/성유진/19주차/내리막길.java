import java.util.*;
import java.io.*;

// 1520
public class 내리막길 {
  static int N, M;
  static int[][] board;
  static int[][] memo;
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, -1, 1};

  public static int dfs(int i, int j) {
    // 도착 지점에 방문하면 탐색을 진행하지 않는다
    if (i == M-1 && j == N-1)
      return 1;
    
    // 이미 방문한 경우
    if (memo[i][j] != -1)
      return memo[i][j];

    memo[i][j] = 0;
    for (int dir = 0; dir < 4; dir++) {
      int ni = i + di[dir];
      int nj = j + dj[dir];
      if (ni < 0 || ni >= M || nj < 0 || nj >= N)
        continue;

      if (board[ni][nj] < board[i][j]) {
        memo[i][j] += dfs(ni, nj);
      }
    }
    return memo[i][j];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    board = new int[M][N];
    memo = new int[M][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
      Arrays.fill(memo[i], -1);
    }
    System.out.println(dfs(0, 0));
  }
}
