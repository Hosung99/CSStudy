import java.util.*;
import java.util.stream.*;

public class BOJ13023 {
  static boolean[] visited;
  static LinkedList<Integer>[] friends;
  static int maxDepth = 0;
  static int result = 0;

  static void checkfriend(int n, int d) {
    if (d >= 4) {
      result = 1;
      return;
    }
    if (visited[n])
      return;
    visited[n] = true;
    if (d > maxDepth)
      maxDepth = d;
    for (int friend: friends[n]) {
      if (!visited[friend]) {
        checkfriend(friend, d + 1);
        visited[friend] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();

    visited = new boolean[N];
    friends = new LinkedList[N];
    for (int i = 0; i < N; i++) {
      friends[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      friends[a].add(b);
      friends[b].add(a);
    }

    for (int i = 0; i < N; i++) {
      Arrays.fill(visited, false);
      checkfriend(i, 0);
      if (result == 1)
        break;
    }

    System.out.println(result);
    scanner.close();
  }
}
