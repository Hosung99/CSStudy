import java.util.*;
import java.io.*;

public class 선발명단 {
  static int[][] s;
  static boolean[] visited;
  static int ans;

  public static void maxAbility(int depth, int ability) {
    if (depth == 11) {
      ans = Math.max(ans, ability);
      return;
    }

    for (int i = 0; i < 11; i++) {
      if (visited[i] || s[i][depth] == 0)
        continue;
      visited[i] = true;
      ability += s[i][depth];
      maxAbility(depth + 1, ability);
      visited[i] = false;
      ability -= s[i][depth];
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int C = Integer.parseInt(br.readLine());
    for (int c = 0; c < C; c++) {
      ans = 0;
      s = new int[11][11];
      visited = new boolean[11];
      for (int i = 0; i < 11; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          s[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      maxAbility(0, 0);
      System.out.println(ans);
    }
  }
}
