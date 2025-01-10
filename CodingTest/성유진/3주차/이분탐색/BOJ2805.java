import java.io.*;
import java.util.*;

public class BOJ2805 {
  static int[] trees;
  static int N, M;

  public static long calculateMeter(int h) {
    long result = 0;
    for (int i = 0; i < N; i++) {
      if (trees[i] > h)
        result += trees[i] - h;
    }
    return result;
  }

  public static int binarySearch(int x) {
    int s = 0;
    int e = x;
    int m = (s + e) / 2;
    long curM = calculateMeter(m);
    while (s <= e) {
      m = (s + e) / 2;
      curM = calculateMeter(m);

      if (curM == M) {
        return m;
      } else if (curM > M) {
        s = m + 1;
      } else if (curM < M) {
        e = m - 1;
      }
    }
    return m;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(trees);

    System.out.println(binarySearch(trees[N - 1]));
  }
}