import java.util.*;
import java.util.stream.*;

public class BOJ11722 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] A = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
      dp[i] = 0;
    }


    for (int i = N - 1; i >= 0; i--) {
      for (int j = i; j < N; j++) {
        if (A[i] > A[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    System.out.println(Arrays.stream(dp).max().getAsInt() + 1);
  }
}
