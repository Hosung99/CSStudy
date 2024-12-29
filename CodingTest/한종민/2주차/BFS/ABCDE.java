import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13023 {
    public static int N, M;
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static boolean[] visited = new boolean[2001];

    public static boolean flag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (flag) {
                System.out.println(1);
                return ;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int i, int depth) {
        if (depth == 5) {
            flag = true;
            return ;
        }
        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
            }
        }
        visited[i] = false;
    }
}
