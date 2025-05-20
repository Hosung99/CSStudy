import java.util.*;

class Solution {
  int answer;
  String targett;
  String[] wordList;
  boolean[] visited;
  int N;

  // 알파벳 하나만 다른지 확인
  boolean possibleChange(String s1, String s2) {
    int cnt = 0;
    for(int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i))
      cnt++;
    }
    if (cnt == 1)
      return true;
    return false;
  }

  void bt(String cur, int d) {
    // 타겟 찾은 경우, 정답 갱신
    if (targett.equals(cur)) {
      answer = Math.min(d, answer);
      return;
    }

    // 모든 words를 방문하는 경우
    if (d == N) {
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i] && possibleChange(wordList[i], cur)) {
        visited[i] = true;
        bt(wordList[i], d+1);
        visited[i] = false;
      }
    }
  }

  public int solution(String begin, String target, String[] words) {
    targett = target;
    N = words.length;
    answer = N + 1;
    wordList = new String[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      wordList[i] = words[i];
    }
    bt(begin, 0);
    // 못 찾은 경우, 0 반환
    if (answer == N+1)
      return 0;
    return answer;
  }
}
