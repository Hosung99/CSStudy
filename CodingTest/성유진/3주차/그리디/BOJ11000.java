import java.io.*;
import java.util.*;

public class BOJ11000 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[][] classes = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      classes[i] = new int[]{s, t};
    }

    Arrays.sort(classes, (a, b) -> a[0] - b[0]);

    PriorityQueue<Integer> result = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int s = classes[i][0];
      int t = classes[i][1];
      if (!result.isEmpty() && result.peek() <= s) {
        result.poll();
      }
      result.add(t);
    }

    System.out.println(result.size());
  }
}
