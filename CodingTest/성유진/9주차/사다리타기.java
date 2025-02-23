import java.io.*;
import java.util.*;

// 2469
public class 사다리타기 {
  static int k, n;
  static char[][] ladder = new char[2000][60];
  static char[] ans = new char[30];
  static int[] tmp = new int[30];
  static int[] arrived = new int[30];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());
    n = Integer.parseInt(br.readLine());

    String s = br.readLine();
    for (int i = 0; i < k; i++) {
      arrived[(int)s.charAt(i) - 'A'] = i;
    }

    int blank = 0;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      if (s.charAt(0) == '?')
        blank = i;
      for (int j = 0; j < s.length(); j++) {
        ladder[i][j] = s.charAt(j);
      }
    }

    // topDown 좌우를 모두 확인해서 건너갈 다리가 있는지 확인하기
    // 좌 : j-1, 우 : j
    for (int p = 0; p < k; p++) {
      int i = 0;
      int j = p;
      while (i < blank) {
        if (j != 0 && ladder[i][j-1] == '-') { // 좌
          j--;
        }
        else if (ladder[i][j] == '-') { // 우
          j++;
        }
        i++;
      }
      tmp[p] = j;
    }
  

    Arrays.fill(ans, '*');
    String wrongAns = "x".repeat(k-1);
    // bottomUp
    for (int p = 0; p < k; p++) {
      int i = n - 1;
      int j = arrived[p];
      while (i > blank) {
        if (j != 0 && ladder[i][j-1] == '-') { // 좌
          j--;
        }
        else if (ladder[i][j] == '-') { // 우
          j++;
        }
        i--;
      }
      if (tmp[p] == j) {
        if (ans[j] == '-') {
          System.out.print(wrongAns);
          System.exit(0);
        }
      } else if (tmp[p] == j - 1) { // 왼쪽에 사다리
        ans[j-1] = '-';
      } else if (tmp[p] == j + 1) { // 오른쪽에 사다리
        ans[j] = '-';
      } else {
        System.out.print(wrongAns);
        System.exit(0);
      }
    }
    for (int i = 0; i < k-1; i++) {
      System.out.print(ans[i]);
    }
  }
}
