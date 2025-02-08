import java.io.*;
import java.util.*;

// 2667
public class 단지번호붙이기 {
  static int[][] board = new int[30][30];
  static int N;
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, -1, 1};

  public static int bfs(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {i, j});
    board[i][j] = -1;

    int cnt = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curI = cur[0];
      int curJ = cur[1];
      cnt++;

      for (int dir = 0; dir < 4; dir++) {
        int ni = curI + di[dir];
        int nj = curJ + dj[dir];

        if (ni < 0 || ni >= N || nj < 0 || nj >= N)
          continue;
        if (board[ni][nj] == 0 || board[ni][nj] == -1)
          continue;
        Q.offer(new int[] {ni, nj});
        board[ni][nj] = -1;
      }
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 0 || board[i][j] == -1)
          continue;
        result.add(bfs(i, j));
      }
    }
    System.out.println(result.size());
    Collections.sort(result);
    for (int x : result)
      System.out.println(x);
  }
}
