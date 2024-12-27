import java.util.*;
import java.util.stream.*;

public class BOJ12865 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int K = scanner.nextInt();
    int[] W = new int[N+1];
    int[] V = new int[N+1];
    int[][] dp = new int[N+1][K+1];

    for (int i = 1; i <= N; i++) {
      int w = scanner.nextInt();
      int v = scanner.nextInt();
      W[i] = w;
      V[i] = v;
    }

    for (int i = 1; i <= N; i++) {
      int weight = W[i];
      int value = V[i];
      for (int j = 1; j <= K; j++) {
        if (weight <= j) {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    System.out.println(dp[N][K]);
  }
}
