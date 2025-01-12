

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Integer[] dx = new Integer[]{0, -1, 0, 1};
    static Integer[] dy = new Integer[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] originMap = new int[n][n];
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                originMap[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 섬 구분
        int landIdent = 1;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (originMap[y][x] == 1 && visited[y][x] == 0) {
                    markIsland(originMap, visited, n, x, y, landIdent++);
                }
            }
        }

        // 다리 길이 계산
        int min = Integer.MAX_VALUE;
        for (int landIdx = 1; landIdx < landIdent; landIdx++) {
            min = Math.min(min, findBridgeLength(originMap, n, landIdx));
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

    // 섬을 구분하는 BFS
    private static void markIsland(int[][] originMap, int[][] visited, int n, int startX, int startY, int landIdent) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        visited[startY][startX] = 1;
        originMap[startY][startX] = landIdent;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos[1] + dx[i];
                int ny = pos[0] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[ny][nx] == 0 && originMap[ny][nx] == 1) {
                    visited[ny][nx] = 1;
                    originMap[ny][nx] = landIdent;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    // 다리의 최소 길이를 찾는 BFS
    private static int findBridgeLength(int[][] originMap, int n, int landIdx) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] localVisited = new boolean[n][n];

        // 섬의 경계 찾기
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (originMap[y][x] == landIdx) {
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && originMap[ny][nx] == 0 && !localVisited[ny][nx]) {
                            q.add(new int[]{ny, nx, 1}); // {y, x, distance}
                            localVisited[ny][nx] = true;
                        }
                    }
                }
            }
        }

        // 다리 길이 계산
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0], x = pos[1], dist = pos[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (originMap[ny][nx] != 0 && originMap[ny][nx] != landIdx) {
                        return dist; // 다른 섬에 도달하면 거리 반환
                    }
                    if (originMap[ny][nx] == 0 && !localVisited[ny][nx]) {
                        q.add(new int[]{ny, nx, dist + 1});
                        localVisited[ny][nx] = true;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
