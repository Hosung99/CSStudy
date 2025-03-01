import java.io.*;
import java.util.*;

// 16139
public class 인간컴퓨터상호작용 {
  static String S;
  static int q;
  static Map<Character, int[]> count = new HashMap<>();

  // 해당 문자의 누적합 배열 구하기
  public static int[] noteCount(char a) {
    int[] arr = new int[200002];
    int cnt = 0;
    for (int i = 0; i < S.length(); i++) {
      char x = S.charAt(i);
      if (x == a)
        cnt++;
      arr[i] = cnt;
    }
    return arr;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder ans = new StringBuilder();
    S = br.readLine();
    q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char a = st.nextToken().charAt(0);
      // 처음 확인하는 문자열이라면 map에 등록
      if (!count.containsKey(a)) {
        int[] arr = noteCount(a);
        count.put(a, arr);
      }

      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int[] countA = count.get(a);
      int result = Math.max(countA[r] - countA[l], 0);
      if (S.charAt(l) == a)
        result++;
      ans.append(result + "\n");
    }
    System.out.println(ans);
  }
}
