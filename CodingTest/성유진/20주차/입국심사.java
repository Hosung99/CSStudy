import java.util.*;
import java.io.*;

// 3079
public class 입국심사 {
  static int N, M;
  static int[] T;

  // 주어진 시간(time) 내에 심사 가능 여부 반환
  public static boolean possible(long time) {
    long cnt = 0;
    for (int i = 0; i < N; i++) {
      cnt += time / T[i];
      if (cnt >= M) // 오버플로우 방지
        return true;
    }
    return false;
  }

  public static long binarySearch(long maxTime) {
    long st = 0;
    long end = maxTime;
    while (st < end) {
      long mid = (st + end) / 2;
      if (possible(mid)) { // 가능하면 시간 줄이기
        end = mid;
      } else {
        st = mid + 1;
      }
    }
    return st;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 심사대 수
    M = Integer.parseInt(st.nextToken()); // 사람 수

    T = new int[N];
    long maxTime = 0;
    for (int i = 0; i < N; i++) {
      T[i] = Integer.parseInt(br.readLine());
      maxTime = Math.max(maxTime, T[i]);
    }
    System.out.println(binarySearch(maxTime * M));
  }
}
