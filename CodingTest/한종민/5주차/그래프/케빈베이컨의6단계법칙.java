import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1389 {
    public static int N, M;
    public static List<Integer>[] arr;
    public static Long[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new Long[N + 1][N + 1];
        arr = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int node = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            arr[node].add(to);
            arr[to].add(node);
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j)
                    dist[i][j] = 0L;
                else if (arr[i].contains(j)){
                    dist[i][j] = 1L;
                }
                else
                    dist[i][j] = 2147483647L;
            }
        }
        int ans = 0;
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1;i++) {
            int res = 0;
            for (int j = 1; j < N + 1; j++ ) {
                res += dist[i][j];
            }
            if (min > res ){
                ans = i;
                min = res;
            }
        }
        System.out.println(ans);
    }
}
