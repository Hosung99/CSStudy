import java.util.*;

class Solution {
  public long solution(int n, int[] works) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    for (int i = 0; i < works.length; i++) {
      pq.offer(works[i]);
    }
    while (n > 0) {
      int x = pq.poll();
      pq.offer(x - 1);
      n--;
    }
    
    long result = 0;
    while (!pq.isEmpty()) {
      int x = pq.poll();
      if (x > 0)
        result += Math.pow(x, 2);
    }
    return result;
  }
}
