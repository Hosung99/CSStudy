import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = 0;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // dfs 호출
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int curStrength) {
        if (x == N) { // 모든 칸 순회 완료
            max = Math.max(max, curStrength);
            return;
        }

        int nextX = x;
        int nextY = y + 1;
        if (nextY == M) { // 열이 끝났으면 다음 행으로 이동
            nextX++;
            nextY = 0;
        }

        // 현재 칸을 포함한 부메랑 모양 확인
        int[][] directions = {
                {0, -1, 1, 0},  // ㄱ 모양 (오른쪽 아래)
                {0, -1, -1, 0}, // ㄴ 모양 (왼쪽 아래)
                {0, 1, -1, 0},  // ㄴ 모양 (왼쪽 위)
                {0, 1, 1, 0}    // ㄱ 모양 (오른쪽 위)
        };

        for (int[] dir : directions) {
            int nx1 = x + dir[0];
            int ny1 = y + dir[1];
            int nx2 = x + dir[2];
            int ny2 = y + dir[3];

            if (isValid(x, y) && isValid(nx1, ny1) && isValid(nx2, ny2)) {
                if (!visited[x][y] && !visited[nx1][ny1] && !visited[nx2][ny2]) {
                    visited[x][y] = visited[nx1][ny1] = visited[nx2][ny2] = true;
                    int strength = board[x][y] * 2 + board[nx1][ny1] + board[nx2][ny2];

                    dfs(nextX, nextY, curStrength + strength);

                    visited[x][y] = visited[nx1][ny1] = visited[nx2][ny2] = false;
                }
            }
        }

        // 현재 칸을 사용하지 않고 다음 칸으로 이동
        dfs(nextX, nextY, curStrength);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
