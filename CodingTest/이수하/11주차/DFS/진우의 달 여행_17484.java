import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dy = new int[]{1, 1, 1};
    static int[] dx = new int[]{-1, 0, 1};
    static int[][] map;
    static int N, M, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(i, 0, -1, 0);
        }

        System.out.print(min);
    }

    static void dfs(int x, int y, int dir, int fuel) {
        if (y >= N) {
            min = Math.min(min, fuel);
            return ;
        }

        for (int j = 0; j < 3; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            if (nx < 0 || nx >= M || dir == j) {
                continue ;
            }
            dfs(nx, ny, j, fuel + map[y][x]);
        }
    }
}