import java.util.*;
import java.io.*;

// 14888
public class 연산자끼워넣기 {
  static int N;
  static int[] A;
  static int[] opCnt = new int[4];
  static int maxResult = Integer.MIN_VALUE;
  static int minResult = Integer.MAX_VALUE;
  static ArrayList<Integer> operators = new ArrayList<>();

  public static int calculate() {
    int result = A[0];
    for (int i = 1; i < N; i++) {
      int op = operators.get(i-1);
      if (op == 0) {
        result += A[i];
      } else if (op == 1) {
        result -= A[i];
      } else if (op == 2) {
        result *= A[i];
      } else if (op == 3) {
        result /= A[i];
      }
    }
    return result;
  }

  public static void bt(int d) {
    if (d == N - 1) {
      int result = calculate();
      maxResult = Math.max(maxResult, result);
      minResult = Math.min(minResult, result);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (opCnt[i] > 0) {
        opCnt[i] -= 1;
        operators.add(i);
        bt(d + 1);
        opCnt[i] += 1;
        operators.remove(operators.size() - 1);
      }
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    int totalSum = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      opCnt[i] = Integer.parseInt(st.nextToken());
      totalSum += opCnt[i];
    }
    bt(0);
    System.out.println(maxResult);
    System.out.println(minResult);
  }
}
