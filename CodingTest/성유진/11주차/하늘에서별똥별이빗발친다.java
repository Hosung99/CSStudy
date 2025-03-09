import java.io.*;
import java.util.*;

// 14658
public class 하늘에서별똥별이빗발친다 {
  static int N, M, L, K;
  static ArrayList<int[]> star = new ArrayList<>();

  public static int countStarInTp(int i, int j) {
    int cnt = 0;
    for (int[] s : star) {
      if (i <= s[0] && s[0] <= i + L && j <= s[1] && s[1] <= j + L)
        cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 가로
    M = Integer.parseInt(st.nextToken()); // 세로
    L = Integer.parseInt(st.nextToken()); // 트램펄린 한변길이
    K = Integer.parseInt(st.nextToken()); // 별똥별 수

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      star.add(new int[] {y, x});
    }

    long ans = K;
    for (int star1[] : star) {
      for (int star2[] : star) {
        ans = Math.min(ans, K - countStarInTp(star1[0], star2[1]));
      }
    }
    System.out.println(ans);
  }
}
