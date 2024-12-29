import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929 {
    public static int N, M;

    public static int[][] arr = new int[501][501];
    public static int[][] visited = new int[501][501];

    public static int max;
    public static int count;
    public static int len = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    len = 0;
                    dfs(i , j);
                    if (max <= len)
                        max = len;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void dfs(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M)
            return ;
        if (arr[i][j] == 0 || visited[i][j] != 0)
            return ;
        len++;
        visited[i][j] = 1;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
//        visited[i][j] = 0;
    }
}
