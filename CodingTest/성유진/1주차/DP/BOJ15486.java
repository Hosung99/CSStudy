import java.util.*;
import java.util.stream.*;

public class BOJ15486 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] T = new int[N+1];
    int[] P = new int[N+1];
    int[] dp = new int[N+1];

    for (int i = 0; i < N; i++) {
      int t = scanner.nextInt();
      int p = scanner.nextInt();
      T[i] = t;
      P[i] = p;
      dp[i] = 0;
    }

    int result = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (i + T[i] <= N) {
        dp[i] = Math.max(result, P[i] + dp[i + T[i]]);
        result = dp[i];
      } else {
        dp[i] = result;
      }
    }
    System.out.println(result);
  }
}
