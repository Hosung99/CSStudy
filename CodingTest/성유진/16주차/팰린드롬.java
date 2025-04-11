import java.util.*;
import java.io.*;

public class 팰린드롬 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N+1];
    int[][] dp = new int[N+1][N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int len = 1; len <= N; len++) {
      for (int s = 1; s <= N - len + 1; s++) {
        int e = s + len - 1;
        if (arr[s] == arr[e]) {
          if (len <= 2 || dp[s+1][e-1] == 1) 
            dp[s][e] = 1;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      sb.append(dp[S][E]+ "\n");
    }
    System.out.println(sb.toString());
  }
}
