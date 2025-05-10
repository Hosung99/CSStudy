import java.util.*;
import java.io.*;

class Solution {
  boolean[] visited;
  int N;

  void bfs(int n, int[][] computers) {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(n);
    visited[n] = true;
    
    while (!Q.isEmpty()) {
      int cur = Q.poll();
      for (int i = 0; i < N; i++) {
        // 현재 노드와 인접하고 방문하지 않았는지 확인
        if (computers[cur][i] == 1 && !visited[i]) {
          visited[i] = true;
          Q.offer(i);
        }
      }
    }
  }
    
  public int solution(int n, int[][] computers) {
    N = n;
    visited = new boolean[n];
    int answer = 0;
    for (int i = 0; i < n; i++) {
       if (!visited[i]) {
         bfs(i, computers);
         answer++;
       }
    }
    return answer;
  }
}
