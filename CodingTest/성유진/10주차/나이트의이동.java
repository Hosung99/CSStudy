import java.io.*;
import java.util.*;

public class 나이트의이동 {
  static int l;
  static int curI, curJ, goalI, goalJ;
  static int[][] dist = new int[301][301];

  public static void move() {
    int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dj = {-1, 1, -2, 2, -2, 2, -1, 1};

    for (int i = 0; i < l; i++) {
      Arrays.fill(dist[i], -1);
    }
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[] {curI, curJ});
    dist[curI][curJ] = 0;

    int cnt = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curI = cur[0];
      int curJ = cur[1];
      int curD = dist[curI][curJ];

      for (int dir = 0; dir < 8; dir++) {
        int ni = curI + di[dir];
        int nj = curJ + dj[dir];
        if (ni < 0 || ni >= l || nj < 0 || nj >= l)
          continue;
        if (dist[ni][nj] != -1)
          continue;
        dist[ni][nj] = curD + 1;
        Q.offer(new int[] {ni, nj});
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      l = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      curI = Integer.parseInt(st.nextToken());
      curJ = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      goalI = Integer.parseInt(st.nextToken());
      goalJ = Integer.parseInt(st.nextToken());
      move();
      System.out.println(dist[goalI][goalJ]);
    }

  }
}