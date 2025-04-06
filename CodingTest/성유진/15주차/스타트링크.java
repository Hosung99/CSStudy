import java.util.*;
import java.io.*;

public class 스타트링크 {
  static int F, S, G, U, D;
  static int[] button;

  public static int move() {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(S);
    button[S] = 0;

    while (!Q.isEmpty()) {
      int cur = Q.poll();
      if (cur == G)
        return button[G];

      for (int i = 0; i < 2; i++) {
        int next = i == 0 ? cur + U : cur - D;
        if (next < 1 || next > F)
          continue;
        if (button[next] > button[cur] + 1) {
          button[next] = button[cur] + 1;
          Q.offer(next);
        }
      }
    }
    return -1;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    F = Integer.parseInt(st.nextToken()); // floor
    S = Integer.parseInt(st.nextToken()); // start
    G = Integer.parseInt(st.nextToken()); // goal
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    button = new int[F+1];
    Arrays.fill(button, Integer.MAX_VALUE);
    int result = move();
    if (result == -1) {
      System.out.println("use the stairs");
    } else {
      System.out.println(result);
    }
  }
}
