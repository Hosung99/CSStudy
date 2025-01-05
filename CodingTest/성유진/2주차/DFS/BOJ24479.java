import java.util.*;
import java.util.stream.*;

public class BOJ24479 {
  static LinkedList<Integer>[] nodes;
  static int[] visited;
  static int depth;

  public static void dfs(int cur) {
    if (visited[cur] != 0) {
      return;
    }
    visited[cur] = ++depth;
    for (int x: nodes[cur]) {
      dfs(x);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(); // 정점
    int M = scanner.nextInt(); // 간선
    int R = scanner.nextInt(); // 시작 정점

    visited = new int[N+1];
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
      visited[i] = 0;
    }

    visited = new int[N+1];
    depth = 0;
    dfs(R);

    for (int i = 1; i <= N; i++) {
      System.out.println(visited[i]);
    }

    scanner.close();
  }
}
