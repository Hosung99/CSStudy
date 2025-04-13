import java.util.*;
import java.io.*;

public class 돌그룹 {
  static int [] arr = new int[3];
  static int sum = 0;
  static boolean[][] visited = new boolean[1501][1501];

  public static int bfs() {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(arr);
    visited[arr[0]][arr[2]] = true;

    while (!Q.isEmpty()) {
      int[] curArr = Q.poll();
      int a = curArr[0];
      int b = curArr[1];
      int c = curArr[2];
      // 세개 모두 같은지 확인
      if (a == b && b == c)
        return 1;

      if(a != b) {
        int na = a > b ? a - b : a + a;
        int nb = a > b ? b + b : b - a;
        
        if(!visited[na][nb]) {
          Q.offer(new int[] {na, nb, c});
          visited[na][nb] = true;
        }
      }
      
      if(b != c) {
        int nb = b > c ? b - c : b + b;
        int nc = b > c ? c + c : c - b;
        if(!visited[nb][nc]) {
          Q.offer(new int[] {a, nb, nc});
          visited[nb][nc] = true;
        }
      }
      
      if(a != c) {
        int na = a > c ? a - c : a + a;
        int nc = a > c ? c + c : c - a;
        if(!visited[na][nc]) {
          Q.offer(new int[] {na, b, nc});
          visited[na][nc] = true;
        }
      }
    }
    return 0;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
    }

    int result = 1;
    if (sum % 3 != 0) {
      result = 0;
    } else {
      result = bfs();
    }
    System.out.println(result);
  }
}
