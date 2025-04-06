import java.util.*;
import java.io.*;

public class 말이되고픈원숭이 {
  static int K, W, H;
  static int[][] board;
  static int[][][] move;
  // 원숭이의 이동 방법(0~3), 말의 이동 방법(4~11)
  static int[] di = {-1, 1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1};
  static int[] dj = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};

  public static void bfs() {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {0, 0, K});
    move[0][0][K] = 0;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curI = cur[0];
      int curJ = cur[1];
      int curK = cur[2];

      int maxD = curK > 0 ? 12 : 4; // 말이 될 수 있는지 확인
      for (int d = 0; d < maxD; d++) {
        int ni = curI + di[d];
        int nj = curJ + dj[d];
        int nk = d >= 4 ? curK -1 : curK; // 말이된 경우 변신횟수 줄이기

        if (ni < 0 || nj < 0 || ni >= H || nj >= W)
          continue;
        if (board[ni][nj] == 1) // 장애물인 경우
          continue;

        if (move[ni][nj][nk] > move[curI][curJ][curK] + 1) {
          move[ni][nj][nk] = move[curI][curJ][curK] + 1;
          Q.offer(new int[] {ni, nj, nk});
        }
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    K = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    board = new int[H][W];
    move = new int[H][W][K+1];
    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        Arrays.fill(move[i][j], Integer.MAX_VALUE);
      }
    }
    bfs();
    int ans = Integer.MAX_VALUE;
    for (int k = 0; k <= K; k++) {
      ans = Math.min(ans, move[H-1][W-1][k]);
    }
    if (ans == Integer.MAX_VALUE)
      ans = -1;
    System.out.println(ans);
  }
}
