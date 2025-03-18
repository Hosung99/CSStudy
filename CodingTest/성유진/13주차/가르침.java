import java.io.*;
import java.util.*;

// 1062
public class 가르침 {
  static int N, K;
  static ArrayList<Set<Character>> words = new ArrayList<>();
  static Set<Character> known = new HashSet<>();
  static int result = 0;

  public static void prepare(int n, char[] s) {
    Set<Character> wordSet = new HashSet<>();
    for (int i = 4; i < s.length - 4; i++) {
      if (s[i] == 'a' || s[i] == 'n' || s[i] == 't' || s[i] == 'i' || s[i] == 'c')
        continue;
      wordSet.add(s[i]);
    }
    words.add(wordSet);
  }

  public static int learnCnt() {
    int cnt = 0;
    for (Set<Character> wordSet : words) {
      if (known.containsAll(wordSet))
        cnt++;
    }
    return cnt;
  }

  public static void findMax(int cnt, char cur) {
    if (cnt == K) {
      result = Math.max(result, learnCnt());
      return;
    }

    for (char c = cur; c <= 'z'; c++) {
      if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c')
        continue;
      if (!known.contains(c)) {
        known.add(c);
        findMax(cnt + 1, (char)(c + 1));
        known.remove(c);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken()) - 5;
  
    for (int i = 0; i < N; i++) {
      char[] arr = br.readLine().toCharArray();
      prepare(i, arr);
    }

    if (K < 0) {
      System.out.println(0);
    } else if (K == 21) {
      System.out.println(N);
    } else {
      findMax(0, 'a');
      System.out.println(result);
    }
  }
}
