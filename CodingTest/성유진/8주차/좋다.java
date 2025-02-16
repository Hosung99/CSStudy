import java.io.*;
import java.util.*;

// 1253
public class 좋다 {
  static int N;
  static int[] A = new int[2001];
  static Map<Integer, Integer> M = new HashMap<>();

  public static boolean isSelf(int a, int b) {
    int sumVal = a + b;
    if (a == sumVal && M.get(a) == 1)
      return true;
    if (b == sumVal && M.get(b) == 1)
      return true;
    if (a == b && a == sumVal && M.get(a) == 2)
      return true;
    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(st.nextToken());
      A[i] = n;
      M.put(n, M.getOrDefault(n, 0) + 1);
    }

    int cnt = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        int sumVal = A[i] + A[j];
        if (M.containsKey(sumVal) && !isSelf(A[i], A[j])) {
          cnt += M.get(sumVal);
          M.remove(sumVal);
        }
      }
    }
    System.out.println(cnt);
  }
}
