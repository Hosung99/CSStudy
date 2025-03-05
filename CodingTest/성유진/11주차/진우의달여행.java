import java.io.*;
import java.util.*;

// 17484
public class 진우의달여행 {
  static int N, M;
  static int[][] space; // 입력받은 배열
  static int[][][] cost; // dp 배열

  // 3개의 이전 cost 값들 중에서 최솟값 반환
  public static int findMin(int[] prev, int dir) {
    int result = Integer.MAX_VALUE;
    for (int d = 0; d < 3; d++) {
      if (d != dir) // 이전과 같은 방향이었는지 확인
        result = Math.min(prev[d], result);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    space = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        space[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dp 배열 초기화 -> int 최댓값으로
    cost = new int[N][M][3];
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < M; j++) {
        Arrays.fill(cost[i][j], Integer.MAX_VALUE);
      }
    }
    // 첫번째 행 초기화
    for (int j = 0; j < M; j++) {
      cost[0][j][0] = space[0][j]; // 왼쪽 위
      cost[0][j][1] = space[0][j]; // 바로 위
      cost[0][j][2] = space[0][j]; // 오른쪽 위
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int d = 0; d < 3; d++) {
          int idx = j + d - 1;
          if (idx < 0 || idx >= M)
            continue;
          // 이전 이동 위치에서의 최소 비용 값 + 현재 위치의 비용
          cost[i][j][d] = findMin(cost[i-1][idx], d) + space[i][j];
        }
      }
    }
    // 마지막 행에서 최솟값 찾기
    int ans = Integer.MAX_VALUE;
    for (int j = 0; j < M; j++) {
      int minVal = findMin(cost[N-1][j], 3);
      ans = Math.min(ans, minVal);
    }
    System.out.println(ans);
  }
}
