import java.util.*;
import java.io.*;

public class 미로만들기 {
  static int N;
  static char[][] room;
  static int[][] memo;
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, -1, 1};

  public static void solve() {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[]{0, 0, 0});
    memo[0][0] = 0;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int i = cur[0];
      int j = cur[1];
      int cnt = memo[i][j];

      for (int dir = 0; dir < 4; dir++) {
        int ni = i + di[dir];
        int nj = j + dj[dir];
        if (ni < 0 || nj < 0 || ni >= N || nj >= N)
          continue;
        int ncnt = (room[ni][nj] == '0') ? cnt + 1 : cnt;
        
        if (memo[ni][nj] == -1 || memo[ni][nj] > ncnt) {
          Q.offer(new int[]{ni, nj});
          memo[ni][nj] = ncnt;
        }
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    room = new char[N][N];
    memo = new int[N][N];
    for (int i = 0; i < N; i++) {
      room[i] = br.readLine().toCharArray();
      Arrays.fill(memo[i], -1);
    }

    solve();
    System.out.println(memo[N-1][N-1]);
  }
}
