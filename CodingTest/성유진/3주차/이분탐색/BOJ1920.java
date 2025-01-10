import java.io.*;
import java.util.*;

public class BOJ1920 {
  static int[] A;
  static int N;

  public static int binarySearch(int x) {
    int s = 0;
    int e = N - 1;
    while (s <= e) {
      int m = (s + e) / 2;
      if (A[m] == x) {
        return 1;
      } else if (A[m] < x) {
        s = m + 1;
      } else if (A[m] > x) {
        e = m - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(A);

    int M = Integer.parseInt(br.readLine());
    String input = br.readLine();
    st = new StringTokenizer(input);
    for (int i = 0; i < M; i++) {
      int x = Integer.parseInt(st.nextToken());
      System.out.println(binarySearch(x));
    }
  }
}
