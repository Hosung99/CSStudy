import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2146 {
    //2146

    public static int N;

    public static int[][] arr;

    public static boolean[][] visited;

    public static int[][] idArr;
    public static int id = 1;

    public static int minLength = Integer.MAX_VALUE;

    public static Queue<int[]> q = new LinkedList<>();

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void markId(int i, int j) {
        visited[i][j] = true;
        idArr[i][j] = id;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (!visited[nx][ny] && arr[nx][ny] != 0) {
                markId(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N =  Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        idArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    markId(i, j);
                    id++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false; // 모든 요소를 0으로 설정
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited = new boolean[N][N];
                q.clear();
                if (!visited[i][j] && arr[i][j] != 0) {
                    q.add(new int[]{i, j, 0});
                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0];
                    int cy = cur[1];
                    int length = cur[2];
                    visited[cx][cy] = true;
                    if (arr[cx][cy] != 0 && idArr[i][j] != idArr[cx][cy])
                        minLength = Math.min(minLength, length);
                    for (int k = 0; k < 4; k++) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N )
                            continue;
                        if (visited[nx][ny] )
                            continue;
                        if (idArr[nx][ny] == idArr[i][j])
                            continue;
                        q.add(new int[]{nx, ny, length + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(minLength - 1);
    }

    public static void print (int[][] arry) {
        for (int i = 0; i < N; i++ ){
            for(int j = 0; j < N; j++) {
                System.out.print(arry[i][j] + " ");
            }
            System.out.println();
        }
    }
}
