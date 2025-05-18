class Solution {
  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    int[][] dp = new int[n+1][m+1];
    boolean[][] isPuddle = new boolean[n+1][m+1];
    for (int p = 0; p < puddles.length; p++) {
      int j = puddles[p][0];
      int i = puddles[p][1];
      isPuddle[i][j] = true; // 물이 잠긴 위치
    }
    
    dp[1][1] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (i == 1 && j == 1)
          continue;
        if (isPuddle[i][j])
          continue;
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
      }
    }

    return dp[n][m];
  }
}
