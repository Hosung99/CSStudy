import java.io.*;
import java.util.*;

// 8980
public class 택배 {
  static int N, C, M;
  static List<int[]> infoList = new ArrayList<>();
  static int[] possible = new int[2001]; // 마을별 트럭 용량

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int send = Integer.parseInt(st.nextToken());
      int dest = Integer.parseInt(st.nextToken());
      int box = Integer.parseInt(st.nextToken());
      infoList.add(new int[] {send, dest, box});
    }
    // 도착지 기준 정렬
    Collections.sort(infoList, (a, b) -> Integer.compare(a[1], b[1]));

    Arrays.fill(possible, C);
    long result = 0;
    for (int[] info : infoList) {
      int send = info[0];
      int dest = info[1];
      int box = info[2];

      // 이동경로를 확인하여 실을 수 있는 무게 확인
      int carry = box;
      for (int x = send; x < dest; x++) {
        carry = Math.min(carry, possible[x]);
      }
      // 이동경로에서 무게 빼기
      for (int x = send; x < dest; x++) {
        possible[x] -= carry;
      }
      // 배송결과에 반영
      result += carry;
      System.out.println(send + " " + dest + " " + carry);
    }
    System.out.println(result);
  }
}
