import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N, M;
    public static boolean[][] visited = new boolean[301][301];
    public static int[][] arr = new int[301][301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int result = 0;
        while ((count = checkIceBreak()) < 2) {
            if (count == 0) {
                result = 0;
                break ;
            }
            Melt();
            result++;
        }
        System.out.println(result);
    }

    private static void Melt() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[] rangeX = {1, -1, 0, 0};
        int[] rangeY = {0, 0, 1, -1};

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 ){
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int dx, dy;
        while (!q.isEmpty()) {
            Pair ice = q.poll();

            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.
            for (int i = 0; i < 4; i++) {
                dx = ice.x + rangeX[i];
                dy = ice.y + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && arr[dx][dy] == 0) {
                    seaNum++;
                }
            }
            if (arr[ice.x][ice.y] - seaNum < 0) {
                arr[ice.x][ice.y] = 0;
            } else {
                arr[ice.x][ice.y] -= seaNum;
            }
        }
    }

    private static int checkIceBreak() {
        int count = 0;
        visited = new boolean[301][301];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }

}
