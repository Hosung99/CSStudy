import java.util.*;
import java.io.*;

// 15683
public class 감시 {
  static int N, M;
  static int[][] office;
  static int[][] memo;
  static ArrayList<int[]> cctv = new ArrayList<>();
  static Stack<Integer> dir = new Stack<>();
  static int result = Integer.MAX_VALUE;
  
  // 인자로 받은 위치와 방향에 따라, 감시 가능한 영역을 memo 배열에 -1로 표시
  public static void check(int i, int j, int d) {
    // 오른쪽(0), 아래(1), 왼쪽(2), 위(3)
    int[] di = {0, 1, 0, -1};
    int[] dj = {1, 0, -1, 0};

    while (0 <= i && i < N && 0 <= j && j < M) {
      if (office[i][j] == 6)  // 벽 만나면 종료
        break;
      memo[i][j] = -1;
      i += di[d];
      j += dj[d];
    }
  }

  public static int checkArea() {
    // 감시 가능 영역을 표시할 memo 배열
    memo = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        memo[i][j] = office[i][j];
      }
    }

    for (int i = 0; i < cctv.size(); i++) {
      int[] c = cctv.get(i);
      int loci = c[0]; // cctv 위치
      int locj = c[1]; // cctv 위치
      int num = c[2];  // cctv 번호
      int d = dir.get(i); // 백트래킹으로 만든 cctv 방향

      // cctv 번호별 확인해야 하는 방향 분기
      if (num == 1) {
        check(loci, locj, d);
      } else if (num == 2) {
        check(loci, locj, d % 4);
        check(loci, locj, (d + 2) % 4);
      } else if (num == 3) {
        check(loci, locj, d % 4);
        check(loci, locj, (d + 1) % 4);
      } else if (num == 4) {
        check(loci, locj, d % 4);
        check(loci, locj, (d + 1) % 4);
        check(loci, locj, (d + 2) % 4);
      } else if (num == 5) {
        check(loci, locj, 0);
        check(loci, locj, 1);
        check(loci, locj, 2);
        check(loci, locj, 3);
      }
    }

    // 사각지대(0) 개수 세기
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (memo[i][j] == 0)
          cnt++;
      }
    }
    return cnt;
  }

  // cctv들의 방향 배열 만들기
  public static void solve(int d) {
    if (d == cctv.size()) {
      // 방향에 따른 감시 영역 확인
      result = Math.min(result, checkArea());
      return;
    }

    for (int i = 0; i < 4; i++) {
      dir.push(i);
      solve(d + 1);
      dir.pop();
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    office = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int n = Integer.parseInt(st.nextToken());
        office[i][j] = n;
        if (1 <= n && n <= 5)  // cctv이면 배열에 넣어서 정보 저장
          cctv.add(new int[]{i, j, n});
      }
    }

    solve(0);
    System.out.println(result);
  }
}
