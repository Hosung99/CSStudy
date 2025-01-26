import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18430 {

    public static int[][] arr = new int[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int N, M;
    public static int res = 0;
    public static int[][] di = {{0,1}, {0,1}, {-1,0}, {-1,0}};
    public static int[][] dj = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int tmp, int sum) {
        if (tmp == N*M) {
            res = Math.max(sum, res);
            return ;
        }
        int ti = tmp / M;
        int tj = tmp % M;
        if (!visited[ti][tj]) {
            for (int i = 0; i < 4; i++) {
                int i1 = ti + di[i][0];
                int i2 = ti + di[i][1];
                int j1 = tj + dj[i][0];
                int j2 = tj + dj[i][1];
                if (isPossible(i1, i2, j1, j2)) {
                    visited[ti][tj] = true;
                    visited[i1][j1] = true;
                    visited[i2][j2] = true;
                    dfs(tmp+1, sum+(arr[ti][tj]*2)+arr[i1][j1]+arr[i2][j2]);
                    visited[ti][tj] = false;
                    visited[i1][j1] = false;
                    visited[i2][j2] = false;
                }
            }
        }
        dfs(tmp+1, sum);
    }
    private static boolean isPossible(int i1, int i2, int j1, int j2) {
        if (i1 < 0 || i2 < 0 || i1 >= N || i2 >= N) {
            return false;
        }
        if (j1 < 0 || j2 < 0 || j1 >= M || j2 >= M) {
            return false;
        }
        if (visited[i1][j1]) return false;
        if (visited[i2][j2]) return false;
        return true;
    }
}
