import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dy = {-1, 0 ,1};
    public static int[] dx = {1, 1, 1};
    public static int min = Integer.MAX_VALUE;
    public static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            visited = new boolean[N][M];
            stack.clear();
            stack.add(new int[]{0, i, -1, map[0][i]});
            visited[0][i] = true;
            dfs();
        }
        System.out.println(min);
    }

    private static void dfs() {
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];
            visited[cx][cy] = false;
            int count = cur[3];
            if (cx == N - 1) {
                min = Math.min(count, min);
            }
            int direc = cur[2];
            for (int j = 0; j < 3; j++) {
                if (j == direc) continue;
                int nx = cx + dx[j];
                int ny = cy + dy[j];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                stack.add(new int[]{nx, ny, j, count + map[nx][ny]});
                visited[nx][ny] = true;
            }
        }
    }
}
