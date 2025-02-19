import java.io.*;
import java.util.*;

// 30804
public class 과일탕후루 {
  static int[] S = new int[200001];
  static int[] fruits = new int[10];

  public static int checkCount() {
    int cnt = 0;
    for (int i = 1; i < 10; i++) {
      if (fruits[i] != 0)
        cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      S[i] = num;
    }

    Arrays.fill(fruits, 0);
    int result = 0;
    int l = 0;
    int r = 0;
    while (r < N) {
      fruits[S[r]]++;
      while (checkCount() > 2)  {
        fruits[S[l]]--;
        l++;
      }
      result = Math.max(result, r - l + 1);
      r++;
    }
    System.out.println(result);
  }
}

