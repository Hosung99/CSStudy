import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];

        // 물웅덩이 위치 표시
        for (int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            isPuddle[y][x] = true;
        }

        dp[0][0] = 1; // 시작점

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];

                dp[i][j] %= 1_000_000_007;
            }
        }

        return dp[n - 1][m - 1];
    }
}
