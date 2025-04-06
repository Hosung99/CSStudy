import java.util.*;
import java.io.*;

public class N과M11 {
  static int M, size;
  static StringBuilder answer = new StringBuilder();
  static Integer[] S;
  static Stack<Integer> stack = new Stack<>();

  public static void comb(int depth, StringBuilder result) {
    if (depth == M) {
      for (int x : stack) {
        answer.append(x + " ");
      }
      answer.append("\n");
      return;
    }

    for (int i = 0; i < size; i++) {
      stack.push(S[i]);
      comb(depth + 1, result);
      stack.pop();
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < N; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }
    S = set.toArray(new Integer[0]);
    size = set.size();
    comb(0, new StringBuilder());
    System.out.println(answer.toString());
  }
}
