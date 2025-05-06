import java.util.*;
import java.io.*;

// 12919
public class A와B2 {
  static String S, T;
  public static boolean bfs() {
    Queue<String> Q = new LinkedList<>();
    Q.offer(T);
    while (!Q.isEmpty()) {
      String cur = Q.poll();
      if (cur.length() < S.length())
        continue;

      if (cur.equals(S))
        return true;

      if (cur.charAt(cur.length() - 1) == 'A')
        Q.offer(cur.substring(0, cur.length() - 1));

      if (cur.charAt(0) == 'B') {
        StringBuilder sb = new StringBuilder(cur.substring(1));
        sb.reverse();
        Q.offer(sb.toString());
      }
    }
    return false;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = br.readLine();
    T = br.readLine();
    
    System.out.println(bfs() ? 1 :0);
  }
}
