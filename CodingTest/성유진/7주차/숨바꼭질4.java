import java.io.*;
import java.util.*;

// 13913
public class 숨바꼭질4 {
  static int[] time = new int[2000005];
  static int[] before = new int[1000001];
  static ArrayList<Integer> ans = new ArrayList<>();
  static int[] dx = {-1, 1, 2};
  static int N, K;

  public static void bfs() {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(N);
    time[N] = 0;

    while (!Q.isEmpty()) {
      int x = Q.poll();
      if (x == K) return;

      for (int dir = 0; dir < 3; dir++) {
        int nx;
        if (dir == 2) nx = x * dx[dir];
        else nx = x + dx[dir];

        if (nx < 0 || nx >= Math.max(N, K) * 2 || time[nx] != -1)
          continue;
        Q.offer(nx);
        time[nx] = time[x] + 1;
        before[nx] = x;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    Arrays.fill(time, -1);
    Arrays.fill(before, -1);
    bfs();
    System.out.println(time[K]);

    int x = K;
    while (x != -1) {
      ans.add(x);
      x = before[x];
    }
    Collections.reverse(ans);
    for (int a : ans)
      System.out.print(a + " ");
  }
}
