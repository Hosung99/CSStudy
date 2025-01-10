import java.io.*;
import java.util.*;

public class BOJ2847 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] score = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      score[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    for (int i = N-1; i > 0; i--) {
      int cur = i;
      int lower = i - 1;
      if (score[lower] >= score[cur]) {
        int diff = score[lower] - score[cur] + 1;
        score[lower] -= diff;
        result += diff;
      }
    }
    System.out.println(result);
  }
}
