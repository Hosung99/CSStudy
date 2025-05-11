import java.util.*;

class Solution {
  int n, m;
  char[][] current;
  int[] di = {-1,1,0,0};
  int[] dj = {0,0,-1,1};
      
  void removeAll(char c) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (current[i][j] == c) {
          current[i][j] = 0;
        }
      }
    }
  }
      
  void removeEdge(char c) {
    boolean[][] visited = new boolean[n+2][m+2];
    Queue<int[]> Q = new LinkedList<>();
    
    Q.offer(new int[]{0, 0});
    visited[0][0] = true;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();
      int i = cur[0];
      int j = cur[1];
      for (int dir = 0; dir < 4; dir++) {
        int ni = i + di[dir];
        int nj = j + dj[dir];
        if (ni < 0 || ni > n + 1 || nj < 0 || nj > m + 1)
          continue;
        if (visited[ni][nj])
          continue;
        
        if (current[ni][nj] == 0) {
          visited[ni][nj] = true;
          Q.offer(new int[]{ni, nj});
        } else if (current[ni][nj] == c) {
          visited[ni][nj] = true;
          current[ni][nj] = 0;
        }
      }
    }
  }

  public int solution(String[] storage, String[] requests) {
    n = storage.length;
    m = storage[0].length();
    current = new char[n+2][m+2];
    for (int i = 1; i <= n; i++) {
      char[] tmp = storage[i-1].toCharArray();
      for (int j = 1; j <= m; j++) {
        current[i][j] = tmp[j - 1];
      }
    }

    for (int i = 0; i < requests.length; i++) {
      String req = requests[i];
      if (req.length() == 2)
        removeAll(req.charAt(0));
      else
        removeEdge(req.charAt(0));
    }

    int answer = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (current[i][j] != 0)
          answer++;
      }
    }   
    return answer;
  }
}
