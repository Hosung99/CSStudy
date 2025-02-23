import java.io.*;
import java.util.*;

// 16926
public class 배열돌리기1 {
  static int N, M, R;
  static int[][] A = new int[301][301];
  static int[][] tmp = new int[301][301];

  public static void move(int si, int sj, int cnt) {
    // down
    for (int i = si + 1; i < N - cnt; i++) {
      tmp[i][sj] = A[i-1][sj];
    }
    // up
    for (int i = si; i < N - 1 - cnt; i++) {
      tmp[i][M-cnt-1] = A[i+1][M-cnt-1];
    }
    // right
    for (int j = sj + 1; j < M - cnt; j++) {
      tmp[N-cnt-1][j] = A[N-cnt-1][j-1];
    }
    // left
    for (int j = sj; j < M - cnt - 1; j++) {
      tmp[si][j] = A[si][j + 1];
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int r = 0; r < R; r++) {
      int si = 0;
      int sj = 0;
      int cnt = 0;
      while (true) {
        if (!(si < N / 2 && sj < M / 2))
          break;
        move(si++, sj++, cnt++);
      }
      // tmp를 A에 복사
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          A[i][j] = tmp[i][j];
        }
      }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          System.out.print(A[i][j] + " ");
        }
      System.out.println();
    }
  }
}
