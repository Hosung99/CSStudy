import java.util.*;
import java.io.*;

public class 효율적인해킹 {
  static int N, M;
  static ArrayList<Integer>[] trust;
  static boolean[] visited;
  static int[] cnts;

  public static void countHacking(int num) {
    Queue<Integer> Q = new LinkedList<>();
    Arrays.fill(visited, false);
    Q.offer(num);
    visited[num] = true;

    int cnt = 0;
    while (!Q.isEmpty()) {
      int cur = Q.poll();
      cnts[num]++;
      for (int x : trust[cur]) {
        if (visited[x])
          continue;
        visited[x] = true;
        Q.offer(x);
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    trust = new ArrayList[N+1];
    visited = new boolean[N+1];
    cnts = new int[N+1];
    for (int i = 1; i <= N; i++) {
      trust[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      trust[b].add(a);
    }

    int maxCnt = 0;
    for (int i = 1; i <= N; i++) {
      countHacking(i);
      maxCnt = Math.max(maxCnt, cnts[i]);
    }

    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (maxCnt == cnts[i]) {
        result.append(i + " ");
      }
    }
    System.out.println(result.toString());
  }
}