import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _24497 {

    public static int N, M, R;
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static int[] visited = new int[100001];
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }
        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int node) {
        count++;
        visited[node] = count;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor] == 0) {
                    dfs(neighbor);
                }
            }
        }
    }
}
