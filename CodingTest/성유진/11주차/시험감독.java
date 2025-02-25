import java.io.*;
import java.util.*;

public class 시험감독 {
  static int N, B, C;
  static int[] A = new int[10000001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    long ans = 0;
    for (int i = 0; i < N; i++) {
      // 총감독관
      A[i] -= B;
      ans++;
      // 부감독관
      if (A[i] > 0) {
        ans += A[i] / C;
        if (A[i] % C > 0)
          ans++;
      }
    }
    System.out.println(ans);
  }
}
