import java.io.*;
import java.util.*;

// 6443
// 알파벳 개수로 백트래킹
public class 애너그램 {
  public static int[] initAlphaCnt(char[] arr) {
    int[] alphaCnt = new int[26];
    for (char c : arr) {
      alphaCnt[c - 'a']++;
    }
    return alphaCnt;
  }

  public static int sumCnt(int[] alphaCnt) {
    int cnt = 0;
    for (int count : alphaCnt) {
      cnt += count;
    }
    return cnt;
  }

  public static void anagram(int[] alphaCnt, Stack<Integer> result) {
    if (sumCnt(alphaCnt) == 0) {
      String resultS = "";
      for (int x : result) {
        resultS += (char) (x + 'a');
      }
      System.out.println(resultS);
      return;
    }

    for (int i = 0; i < 26; i++) {
      if (alphaCnt[i] > 0) {
        alphaCnt[i]--;
        result.push(i);
        anagram(alphaCnt, result);
        alphaCnt[i]++;
        result.pop();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      char[] arr = br.readLine().toCharArray();
      int[] alphaCnt = initAlphaCnt(arr);
      anagram(alphaCnt, new Stack<>());
    }
  }
}
