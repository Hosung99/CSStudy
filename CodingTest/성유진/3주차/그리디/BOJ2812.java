import java.io.*;
import java.util.*;

public class BOJ2812 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String input = br.readLine();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
    }

    Stack<Integer> result = new Stack<>();
    for (int i = 0; i < N; i++) {
      while (!result.isEmpty() && result.peek() < nums[i] && K > 0) {
        result.pop();
        K--;
      }
      result.push(nums[i]);
    }
    while (K > 0) {
      result.pop();
      K--;
    }

    for (int x : result) {
      System.out.print(x);
    }
  }
}
