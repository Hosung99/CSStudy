import java.util.*;
import java.io.*;

public class 부분수열의합 {
  static int N, S;
  static int[] arr;
  static boolean[] visited;
  static int result = 0;

  public static int calSum() {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      if (visited[i]) {
        sum += arr[i];
      }
    }
    return sum;
  }

  public static void solve(int curi, int d) {
    if (d == N + 1)
      return;

    if (d != 0 && calSum() == S)
      result++;

    for (int i = curi; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        solve(i, d+1);
        visited[i] = false;
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    visited = new boolean[N];
    solve(0, 0);
    System.out.println(result);
  }
}