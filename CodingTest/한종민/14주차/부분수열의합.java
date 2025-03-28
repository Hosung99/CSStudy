import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1182 {
    public static int N, S;
    public static int[] array;
    public static int[] visited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        visited = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            backTracking(0, 0, i);
        }
        System.out.println(count);

    }

    private static void backTracking(int i, int sum, int maxLen) {
        if (i == maxLen) {
            if (sum == S) {
                count++;
            }
            return;
        }
        for (int idx = 0; idx < N; idx++) {
            if (visited[idx] == 1) continue;
            visited[idx] = 1;
            backTracking(i + 1, sum + array[idx], maxLen);
            visited[idx] = 0;
        }
    }
}
