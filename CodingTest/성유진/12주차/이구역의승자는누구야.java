import java.io.*;
import java.util.*;

// 20154
public class 이구역의승자는누구야 {
  static int[] alpha = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
  static Queue<Integer> Q = new LinkedList<>();

  public static void matchAndSum() {
    Queue<Integer> tmp = new LinkedList<>();
    while (!Q.isEmpty()) {
      if (Q.size() == 1) {
        tmp.offer(Q.poll());
        break;
      }
      int a = Q.poll();
      int b = Q.poll();
      tmp.offer((a + b) % 10);
    }

    // tmp -> Q 옮기기
    while (!tmp.isEmpty()) {
      Q.offer(tmp.poll());
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    for (char c : S.toCharArray()) {
      Q.add(alpha[(int)(c - 'A')]);
    }

    while (Q.size() > 1) {
      matchAndSum();
    }

    int result = Q.poll();
    if (result % 2 != 0) {
      System.out.println("I'm a winner!");
    } else {
      System.out.println("You're the winner?");
    }
  }
}
