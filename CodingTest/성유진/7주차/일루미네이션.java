import java.io.*;
import java.util.*;

// 5547
public class 일루미네이션 {
  static int W, H;
  static int[][] board = new int[102][102];
  static boolean[][] visited = new boolean[102][102];
  static int[] dy = {-1, -1, 0, 0, 1, 1};
  static int[] dx = {0 , 1, -1, 1, 0, 1}; // y가 홀수
  static int[] dx2 = {-1 , 0, -1, 1, -1, 0}; // y가 짝수

  public static int countWallLen() {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {0, 0});
    visited[0][0] = true;
    int cnt = 0;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int y = cur[0];
      int x = cur[1];

      for (int dir = 0; dir < 6; dir++) {
        int ny = y + dy[dir];
        int nx = y % 2 != 0 ? x + dx[dir] : x + dx2[dir];

        if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2)
          continue;
        if (board[ny][nx] == 1)
          cnt++;
        if (visited[ny][nx] || board[ny][nx] == 1)
          continue;
        Q.offer(new int[] {ny, nx});
        visited[ny][nx] = true;
      }
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    // 테두리 따로 예외처리 하지 않기 위해 0으로 초기화
    for (int y = 0; y < H + 2; y++) {
      Arrays.fill(board[y], 0);
    }

    for (int y = 1; y <= H; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 1; x <= W; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(countWallLen());
  }
}