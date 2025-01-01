import java.util.*;
import java.util.stream.*;

public class BOJ1260 {
  static LinkedList<Integer>[] nodes;
  static int N;
  static int M;
  static int V;
  public static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    queue.add(V);
    visited[V] = true;
    while (!queue.isEmpty()) {
      int cur = queue.remove();
      System.out.print(cur + " ");
      for (int v: nodes[cur]) {
        if (!visited[v]) {
          queue.add(v);
          visited[v] = true;
        }
      }
    }
  }

  public static void dfs(int cur, boolean[] visitedDfs) {
    if (visitedDfs[cur])
      return;

    System.out.print(cur + " ");
    visitedDfs[cur] = true;

    for (int v: nodes[cur]) {
      dfs(v, visitedDfs);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt(); // 정점
    M = scanner.nextInt(); // 간선
    V = scanner.nextInt(); // 시작 정점

    nodes = new LinkedList[N+1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new LinkedList<>();
    }
    for (int i = 0; i < M; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      nodes[a].add(b);
      nodes[b].add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(nodes[i]);
    }

    boolean[] visitedDfs = new boolean[N+1];
    dfs(V, visitedDfs);
    System.out.println();
    bfs();

    scanner.close();
  }
}