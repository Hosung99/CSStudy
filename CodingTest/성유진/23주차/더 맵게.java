import java.util.*;

class Solution {
  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> PQ = new PriorityQueue<>();
    for (int i = 0; i < scoville.length; i++){
      PQ.offer(scoville[i]);
    }
    
    int cnt = 0;
    while (PQ.size() >= 2) {
      int first = PQ.poll();
      if (first >= K)
        return cnt;
      int second = PQ.poll();
      int newScoville = first + second * 2;
      PQ.offer(newScoville);
      cnt++;
    }
    if (PQ.peek() >= K)
      return cnt;
    return -1;
  }
}