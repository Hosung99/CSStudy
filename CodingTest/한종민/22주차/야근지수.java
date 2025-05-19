import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0) {
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max - 1);
            n--;
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            int w = pq.poll();
            sum += (long) w * w;
        }
        return sum;
    }
}
