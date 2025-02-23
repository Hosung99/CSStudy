import java.io.*;
import java.util.*;

// 22862
public class 가장긴짝수연속한부분수열 {
  static int N, K;
  static int[] S = new int[1000001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    int r = 0;
    int l = 0;
    int result = 0;
    int rmv = 0;
    while (r < N) { 
      if (S[r] % 2 == 0) { // 짝수
        r++;
        result = Math.max(result, r - l - rmv);
      } else if (rmv == K) { // 홀수 & 기회 없음
        if (S[l] % 2 != 0) {
          rmv--;
        }
        l++;
      } else {  // 홀수 & 기회 있음
        rmv++;
        r++;
        result = Math.max(result, r - l - rmv);
      }
    }
    System.out.println(result);
  }
}
