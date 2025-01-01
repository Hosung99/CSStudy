import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, V;
    public static boolean visited[] = new boolean[1001];
    public static Queue<Integer> q = new LinkedList<>();
    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());
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
        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);
    }

    private static void bfs(int node) {
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int next = q.poll();
            System.out.print(next + " ");
            List<Integer> neighbors = graph.get(next);
            if (neighbors != null) {
                for (int neighbor : graph.get(next)) {
                    if (!visited[neighbor]) {
                        q.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        List<Integer> neighbors = graph.get(node);
        if (neighbors != null) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor);
                }
            }
        }
    }
}
