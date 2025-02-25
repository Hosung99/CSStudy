import java.io.*;
import java.util.*;

// 20058
public class 마법사상어와파이어스톰 {
  static int N, Q, size;
  static int[][] A = new int[66][66];
  static int[] L = new int[7];
  static int totalSum, maxSize;
  static boolean[][] visited = new boolean[66][66];

  public static void copy(int si, int sj, int s, int[][] tmp) {
    for (int i = si; i < si + s; i++) {
      for (int j = sj; j < sj + s; j++) {
        A[i][j] = tmp[i][j];
      }
    }
  }

  public static void turn(int si, int sj, int s, int[][] tmp) {
    int ei = si + s - 1;
    int ej = sj + s - 1;

    // 위쪽 가로에 왼쪽 세로 할당
    int idx = ej;
    for (int i = si; i <= ei; i++) {
      tmp[si][idx--] = A[i][sj];
    }
    // 왼쪽 세로에 아래쪽 가로 할당
    idx = si;
    for (int j = sj; j <= ej; j++) {
      tmp[idx++][sj] = A[ei][j];
    }
    // 아래쪽 가로에 오른쪽 세로 할당
    idx = sj;
    for (int i = ei; i >= si; i--) {
      tmp[ei][idx++] = A[i][ej];
    }
    // 오른쪽 세로에 위쪽 가로 할당
    idx = si;
    for (int j = sj; j <= ej; j++) {
      tmp[idx++][ej] = A[si][j];
    }
  }

  public static void fireStorm(int level) {
    if (level == 0)
      return;
    int s = (int) Math.pow(2, level);
    for (int i = 1; i <= size; i += s) {
      for (int j = 1; j <= size; j += s) {
        // 내부 사각형 회전 (시작점과 회전 크기를 변경하며 각각 회전)
        int[][] tmp = new int[66][66];
        int si = i;
        int sj = j;
        int ss = s;
        while (ss > 1) {
          turn(si, sj, ss, tmp);
          si++;
          sj++;
          ss -= 2;
        }
        // 내부 사각형 회전까지 모두 완료되면 tmp 배열 s x s 크기의 배열 모두 복사
        copy(i, j, s, tmp);
      }
    }
  }

  public static void reduceIce() {
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};
    int[][] tmp = new int[66][66];

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        int cnt = 0;
        for (int dir = 0; dir < 4; dir++) {
          int ni = i + di[dir];
          int nj = j + dj[dir];
          if (A[ni][nj] > 0)
            cnt++;
        }
        if (cnt < 3) {
          tmp[i][j] = A[i][j] - 1;
        } else {
          tmp[i][j] = A[i][j];
        }
      }
    }

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        A[i][j] = tmp[i][j];
      }
    }
  }

  public static int measuerSize(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};

    int cnt = 0;
    Q.offer(new int[]{i, j});
    visited[i][j] = true;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      cnt++;

      for (int dir = 0; dir < 4; dir++) {
        int ni = cur[0] + di[dir];
        int nj = cur[1] + dj[dir];
        if (ni < 1 || ni > size || nj < 1 || nj > size)
          continue;
        if (A[ni][nj] <= 0 || visited[ni][nj])
          continue;
        Q.offer(new int[]{ni, nj});
        visited[ni][nj] = true;
      }
    }
    return cnt;
  }

  public static void checkResult() {
    totalSum = 0;
    maxSize = 0;
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        if (A[i][j] > 0 && !visited[i][j])
          maxSize = Math.max(maxSize, measuerSize(i, j));
        if (A[i][j] > 0)
          totalSum += A[i][j];
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    size = (int) Math.pow(2, N);
    for (int i = 1; i <= size; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= size; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());

      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      int level = Integer.parseInt(st.nextToken());
      fireStorm(level);
      reduceIce();
    }
    checkResult();
    System.out.println(totalSum);
    System.out.println(maxSize);
  }
}
