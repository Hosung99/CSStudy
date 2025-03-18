import java.io.*;
import java.util.*;

// 6443
// 같은 깊이에서 중복이 있는지 확인하면서 백트래킹
public class 애너그램2 {
  public static void anagram(char[] arr, boolean[] visited, StringBuilder result) {
    if (result.length() == arr.length) {
      System.out.println(result.toString());
      return;
    }

    char prev = '\0';
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i] && arr[i] != prev) {
        visited[i] = true;
        result.append(arr[i]);
        anagram(arr, visited, result);
        result.deleteCharAt(result.length() - 1);
        visited[i] = false;
        // 같은 깊이에서 중복된 문자 스킵
        prev = arr[i];
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      char[] arr = br.readLine().toCharArray();
      Arrays.sort(arr);
      boolean[] visited = new boolean[arr.length];
      anagram(arr, visited, new StringBuilder());
    }
  }
}
