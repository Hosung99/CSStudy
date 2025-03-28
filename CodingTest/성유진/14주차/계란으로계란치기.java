import java.util.*;
import java.io.*;

public class 계란으로계란치기 {
  static int N;
  static int[] S, W;
  static int result = 0;

  public static int countBrokenEggs() {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if (S[i] <= 0)
        cnt++;
    }
    return cnt;
  }

  public static void solve(int hold) {
    // 모든 계란 확인했으면 결과값 갱신
    if (hold == N) {
      result = Math.max(result, countBrokenEggs());
      return;
    }

    // 들고 있는 계란이 깨져있으면 넘어가기
    if (S[hold] <= 0) {
      solve(hold + 1);
      return;
    }

    boolean broke = false; // 계란을 깼는지 안 깼는지 확인
    for (int i = 0; i < N; i++) {
      if (i != hold && S[i] > 0) {
        S[i] -= W[hold];
        S[hold] -= W[i];
        broke = true;
        solve(hold + 1);
        S[i] += W[hold];
        S[hold] += W[i];
      }
    }
    // 계란을 깨지 못한 경우, 다음 계란 잡기
    if (!broke)
      solve(hold + 1);
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    S = new int[N];
    W = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      S[i] = Integer.parseInt(st.nextToken());
      W[i] = Integer.parseInt(st.nextToken());
    }

    solve(0);
    System.out.println(result);
  }
}
