import java.util.*;
import java.io.*;

// 11725
public class 트리의부모찾기 {
  static int N;
  static ArrayList<Integer>[] tree;
  static int[] parents;

  public static void findParents() {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(1);
    parents[1] = 0;
    while (!Q.isEmpty()) {
      int cur = Q.poll();
      for (int x : tree[cur]) {
        if (parents[x] != -1)
          continue;
        Q.offer(x);
        parents[x] = cur;
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    tree = new ArrayList[N+1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }
    parents = new int[N+1];
    Arrays.fill(parents, -1);
    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      tree[a].add(b);
      tree[b].add(a);
    }

    findParents();

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(parents[i] + "\n");
    }
    System.out.println(sb.toString());
  }
}
