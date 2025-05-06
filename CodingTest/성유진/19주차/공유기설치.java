import java.util.*;
import java.io.*;

// 2110
public class 공유기설치 {
  static int N, C;
  static int[] house;

  // 최소 거리 d를 보장하면서 설치 가능한 공유기의 개수
  public static int countSet(int d) {
    int cnt = 1;
    int prev = 0;
    for (int i = 1; i < N; i++) {
      if (house[prev] + d <= house[i]) {
        cnt++;
        prev = i;
      }
    }
    return cnt;
  }

  public static int binarySearch(int l, int r) {
    int st = l;
    int end = r;
    while (st < end) {
      int mid = (st + end) / 2;
      int cnt = countSet(mid);
      if (cnt < C) { // 최소 거리 감소
        end = mid;
      } else {
        st = mid + 1;
      }
    }
    return st - 1;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    house = new int[N];
    for (int i = 0; i < N; i++) {
      house[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(house);

    // 최소 거리를 탐색
    int l = 1;
    int r = house[N-1] - house[0] + 1;
    System.out.println(binarySearch(l, r));
  }
}
