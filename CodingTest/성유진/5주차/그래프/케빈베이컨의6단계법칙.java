import java.io.*;
import java.util.*;

// 1398
public class 케빈베이컨의6단계법칙 {
  static boolean[][] link = new boolean[5001][5001];
  static int[] kb = new int[5001];
  static int N, M;
  static boolean[] visited = new boolean[5001];

  static void bfs(int x) {
    Queue<int[]> Q = new LinkedList<>();

    kb[x] = 0;
    Q.offer(new int[]{x, 0});
    visited[x] = true;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int node = cur[0];
      int depth = cur[1];

      kb[x] += depth;
      for (int i = 1; i <= N; i++) {
        if (visited[i] || !link[node][i])
          continue;
        Q.offer(new int[]{i, depth + 1});
        visited[i] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 0; i <= N; i++) {
      Arrays.fill(link[i], false);
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      link[a][b] = true;
      link[b][a] = true;
    }
    Arrays.fill(kb, 0);
    for (int i = 1; i <= N; i++) {
      Arrays.fill(visited, false);
      bfs(i);
    }

    int minKb = kb[1];
    int result = 1;
    for (int i = 1; i <= N; i++) {
      if (minKb > kb[i]) {
        minKb = kb[i];
        result = i;
      }
    }
    System.out.println(result);
  }
}
