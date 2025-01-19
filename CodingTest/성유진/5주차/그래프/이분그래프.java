import java.io.*;
import java.util.*;

// 1707
public class 이분그래프 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int V, E;
  static LinkedList<Integer>[] nodes;
  static int[] visited;

  static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    nodes = new LinkedList[V + 1];
    for (int i = 1; i <= V; i++) {
      nodes[i] = new LinkedList<>();
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      nodes[a].add(b);
      nodes[b].add(a);
    }

    visited = new int[V+1];
  }

  static boolean bfs(int start) {
    Queue<int[]> Q = new LinkedList<>();

    Q.offer(new int[]{start, 0});
    visited[start] = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int node = cur[0];
      int type = cur[1];
      for (int x : nodes[node]) {
        if (visited[x] == -1) {
          Q.offer(new int[]{x, (type + 1) % 2});
          visited[x] = (type + 1) % 2;
        } else {
          if (visited[x] == type)
            return false;
        }
      }
    }
    return true;
  }

  static int allVisited() {
    for (int i = 1; i<=V;i++) {
      if (visited[i] == -1)
        return i;
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    int K = Integer.parseInt(br.readLine());
    while (K-- > 0) {
      input();
      Arrays.fill(visited, -1);
      while (true) {
        int start = allVisited();
        if (start == 0){
          System.out.println("YES");
          break;
        }
        if (bfs(start) == false) {
          System.out.println("NO");
          break;
        }
      }
    }
  }
}
