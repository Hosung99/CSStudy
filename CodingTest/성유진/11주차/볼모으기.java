import java.io.*;
import java.util.*;

// 17615
public class 볼모으기 {
  static char[] arr;
  static int N;

  public static int move(char color) {
    Stack<Character> S = new Stack<>();
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i] == color) { // 이동시키려는 공을 스택에 담기
        S.push(arr[i]);
      } else {  // 다른 색깔 공 넘어가기
        while (!S.isEmpty()) { // 이동해야 했던 공을 이동 (이동 횟수 증가)
          S.pop();
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void reverseArr() {
    for (int i = 0; i < N / 2; i++) {
      char tmp = arr[i];
      arr[i] = arr[N - i - 1];
      arr[N - i - 1] = tmp;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new char[N];
    arr = br.readLine().toCharArray();

    int result = Integer.MAX_VALUE;
    // 오른쪽으로 이동시키기
    result = Math.min(result, move('B'));
    result = Math.min(result, move('R'));
    reverseArr();
    // 왼쪽으로 이동시키기
    result = Math.min(result, move('B'));
    result = Math.min(result, move('R'));
    
    System.out.println(result);
  }
}
