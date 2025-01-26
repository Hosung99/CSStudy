import java.io.*;
import java.util.*;

// 1967
public class 트리의지름 {
  static ArrayList<int[]>[] tree;
  static boolean[] visited;
  static int lastNode;

  static int bfs(int start) {
    int dist = 0;
    Queue<int []> Q = new LinkedList<>();
    Q.offer(new int[]{start, 0});
    visited[start] = true;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curN = cur[0];
      int curD = cur[1];

      if (curD > dist) {
        dist = curD;
        lastNode = curN;
      }
      dist = Math.max(dist, curD);
      for (int[] x: tree[curN]) {
        int child = x[0];
        int weight = x[1];
        if (visited[child]) continue;
        Q.offer(new int[]{child, curD + weight});
        visited[child] = true;
      }
    }
    return dist;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    tree = new ArrayList[N+1];
    visited = new boolean[N+1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      tree[a].add(new int[]{b, weight});
      tree[b].add(new int[]{a, weight});
    }

    Arrays.fill(visited, false);
    int result = 0;
    bfs(1);
    Arrays.fill(visited, false);
    if (lastNode != 0)
      result = bfs(lastNode);
    System.out.println(result);
  }
}
