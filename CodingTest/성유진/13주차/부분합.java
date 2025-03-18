import java.io.*;
import java.util.*;

public class 부분합 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] sum = new int[N+1]; // 인덱스 : 1 ~ N 
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      int x = Integer.parseInt(st.nextToken());
      sum[i] = sum[i-1] + x;
    }

    // l + 1부터, r까지의 합
    int result = Integer.MAX_VALUE;
    int l = 0;
    int r = 1;
    while (r <= N) { 
      int curSum = sum[r] - sum[l];
      if (curSum >= S) {
        result = Math.min(result, r - l);
        l++;
      } else {
        r++;
      }
    }
    if (result == Integer.MAX_VALUE)
      result = 0;
    System.out.println(result);
  }
}

