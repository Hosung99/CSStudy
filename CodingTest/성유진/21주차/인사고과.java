import java.util.*;

class Solution {
  // 인센티브를 받을 수 있는지 여부
  boolean isPossible(int cur, int[][] scores) {
    for (int i = 0; i < scores.length; i++) {
      if (scores[cur][0] < scores[i][0] && scores[cur][1] < scores[i][1])
        return false;
    }
    return true;
  }

  public int solution(int[][] scores) {
    // 완호가 인센티브 못 받는 경우 미리 처리
    if (!isPossible(0, scores))
      return -1;
    
    int answer = 0;
    int wanhoTotal = scores[0][0] + scores[0][1];
    // 점수 합계 내림차순 정렬
    Arrays.sort(scores, (a, b) -> {
      return Integer.compare(b[0] + b[1], a[0] + a[1]);
    });
    for (int i = 0; i < scores.length; i++) {
      if (isPossible(i, scores)) {
        int curTotal = scores[i][0] + scores[i][1];
        if (wanhoTotal == curTotal)
          break;
        answer++; // 완호보다 높은 등수의 사람 수 세기
      }
    }
    return answer + 1;
  }
}