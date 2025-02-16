import java.io.*;
import java.util.*;

public class 징검다리 {
  static int N;
  static int[] A = new int[3001];
  static int[] dp = new int[3001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < N; i++) {
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}
