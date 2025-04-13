import java.util.*;
import java.io.*;

public class 댄스파티 {
  public static int countMatch(Integer[] plus, Integer[] minus) {
    // plus에서 제일 큰 양수부터 확인 minus에서 제일 큰 수 확인하면서 매칭하기
    int p = 0;
    int m = 0;
    int cnt = 0;
    while (p < plus.length && m < minus.length) {
      if (plus[p] < minus[m]) { // plus의 값이 더 작아야함
        cnt++;
        p++;
        m++;
      } else {
        p++;
      }
    }
    return cnt;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    List<Integer> minusM = new ArrayList<>();
    List<Integer> plusM = new ArrayList<>();
    List<Integer> minusF = new ArrayList<>();
    List<Integer> plusF = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (x < 0) {
        minusM.add(-x);
      } else {
        plusM.add(x);
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (x < 0) {
        minusF.add(-x);
      } else {
        plusF.add(x);
      }
    }
    Collections.sort(minusM, Collections.reverseOrder());
    Collections.sort(plusM, Collections.reverseOrder());
    Collections.sort(minusF, Collections.reverseOrder());
    Collections.sort(plusF, Collections.reverseOrder());

    // 둘이 부호가 다름
    int a = countMatch(plusM.toArray(new Integer[0]), minusF.toArray(new Integer[0]));
    int b = countMatch(plusF.toArray(new Integer[0]), minusM.toArray(new Integer[0]));
    System.out.println(a + b);
  }
}
