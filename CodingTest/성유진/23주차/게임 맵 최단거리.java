import java.util.*;

class Solution {
  public int solution(int[][] maps) {
    int n = maps.length;
    int m = maps[0].length;
    int[] di = {-1,1,0,0};
    int[] dj = {0,0,-1,1};
    
    int[][] dist = new int[n][m];
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[]{0, 0});
    dist[0][0] = 1;
    while(!Q.isEmpty()) {
      int[] cur = Q.poll();
      int curi = cur[0];
      int curj = cur[1];
      
      for (int dir = 0; dir < 4; dir++) {
        int ni = curi + di[dir];
        int nj = curj + dj[dir];
        if (ni < 0 || ni >= n || nj < 0 || nj >= m)
          continue;
        if (maps[ni][nj] == 0)
          continue;
        if (dist[ni][nj] != 0)
          continue;
        Q.offer(new int[]{ni, nj});
        dist[ni][nj] = dist[curi][curj] + 1;
      }
        
    }
    return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
  }
}
