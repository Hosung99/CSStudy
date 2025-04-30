import java.util.*;
import java.io.*;

// 1174
public class 줄어드는수 {
  static int N;
  static Stack<Integer> num;
  static int cnt = 0;

  public static void makeNum(int len) {
    if (num.size() == len) {
      if (++cnt == N) {
        for (int x: num) {
          System.out.print(x);
        }
        System.out.println();
        System.exit(0);
      }
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (num.isEmpty() || i < num.peek()) {
        num.push(i);
        makeNum(len);
        num.pop();
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= 10; i++) {
      num = new Stack<>();
      makeNum(i);
    }
    System.out.println(-1);
  }
}
