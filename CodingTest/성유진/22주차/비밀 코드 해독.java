import java.util.*;

class Solution {
  TreeSet<Integer> code = new TreeSet<>();
  int N, M;
  int answer = 0;
  int[][] qq;
  int[] ansCnt;
      
  public boolean check() {
    for (int i = 0; i < M; i++) {
      int cnt = 0;
      for (int j = 0; j < 5; j++) {
        if (code.contains(qq[i][j]))
          cnt++;
      }
      if (cnt != ansCnt[i])
        return false;
    }
    return true;
  }
      
  public void comb() {
    if (code.size() == 5) {
      if (check())
        answer++;
      return;
    }
    
    for (int i = 1; i <= N; i++) {
      if (code.isEmpty() || (!code.contains(i) && i > code.last())) {
        code.add(i);
        comb();
        code.remove(i);
      }
    }
  }
      
  public int solution(int n, int[][] q, int[] ans) {
    N = n;
    M = q.length;
    qq = q;
    ansCnt = ans;
    comb();
    return answer;
  }
}