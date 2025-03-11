import java.io.*;
import java.util.*;

// 5212
public class 지구온난화 {
  static int R, C;
  static char[][] board, result;

  public static void melt(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};

    int cnt = 0;
    for (int dir = 0; dir < 4; dir++) {
      int ni = i + di[dir];
      int nj = j + dj[dir];
      if (board[ni][nj] == '.')
        cnt++;
    }
    if (cnt >= 3) {
      result[i][j] = '.';
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    board = new char[R+2][C+2];
    result = new char[R+2][C+2];
    // 바다로 초기화
    for (int i = 0; i <= R+1; i++) {
      Arrays.fill(board[i], '.');
    }

    for (int i = 1; i <= R; i++) {
      char[] arr = br.readLine().toCharArray();
      for (int j = 1; j <= C; j++) {
        board[i][j] = arr[j-1];
      }
    }

    // result에 board 복사
    for (int i = 0; i <= R+1; i++) {
      for (int j = 1; j <= C; j++) {
        result[i][j] = board[i][j];
      }
    }

    int minI = R, maxI = 1, minJ = C, maxJ = 1;
    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        melt(i, j);
        if (result[i][j] == 'X') {
          minI = Math.min(minI, i);
          maxI = Math.max(maxI, i);
          minJ = Math.min(minJ, j);
          maxJ = Math.max(maxJ, j);
        }
      }
    }
    for (int i = minI; i <= maxI; i++) {
      for (int j = minJ; j <= maxJ; j++) {
        System.out.print(result[i][j]);
      }
      System.out.println();
    }
  }
}
