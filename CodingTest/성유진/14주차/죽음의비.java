import java.util.*;
import java.io.*;

public class 죽음의비 {
  static int N, H, D;
  static char[][] board;
  static int[][] totalHp;
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, -1, 1};

  public static int bfs(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {i, j, H, 0, 0});
    totalHp[i][j] = H;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curi = cur[0];
      int curj = cur[1];
      int curH = cur[2]; // 체력
      int curD = cur[3]; // 우산 내구도
      int curT = cur[4]; // 방문 시각

      for (int dir = 0; dir < 4; dir++) {
        int ni = curi + di[dir];
        int nj = curj + dj[dir];
        if (ni < 0 || ni >= N || nj < 0 || nj >= N)
          continue;

        // 종료 지점에 도착하면 이동시간 반환
        if (board[ni][nj] == 'E')
          return curT + 1;

        // 체력, 내구도, 이동시간 갱신
        int nH = curH;
        int nD = curD;
        if (board[ni][nj] == 'U') 
          nD = D;
        if (nD > 0)
          nD -= 1;
        else
          nH -= 1;
        int nT = curT + 1;
        
        // 체력 확인
        if (nH == 0)
          continue;

        // 방문하는게 이득인지 확인
        if (nH > totalHp[ni][nj]) {
          totalHp[ni][nj] = nH;
          Q.offer(new int[] {ni, nj, nH, nD, nT});
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken()); // 체력
    D = Integer.parseInt(st.nextToken()); // 우산 내구도

    board = new char[N][N];
    totalHp = new int[N][N];
    int startI=0, startJ=0;
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
      Arrays.fill(totalHp[i], -1);
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 'S') {
          startI = i;
          startJ = j;
        }
      }
    }
    System.out.println(bfs(startI, startJ));
  }
}

