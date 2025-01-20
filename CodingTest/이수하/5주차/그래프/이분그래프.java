import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int v, e;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(token.nextToken());
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine());
            v = Integer.parseInt(token.nextToken());
            e = Integer.parseInt(token.nextToken());


            graph = new ArrayList[v + 1];
            visited = new int[v + 1];
            for(int l = 0; l <= v; l++)
                graph[l] = new ArrayList<Integer>();

            for (int j = 0; j < e; j++) {
                token = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(token.nextToken());
                int child = Integer.parseInt(token.nextToken());

                graph[parent].add(child);
                graph[child].add(parent);
            }

            isBipartiteGraph();
        }
    }

    public static void isBipartiteGraph() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for (int j = 0; j < graph[now].size(); j++) {
                    if (visited[graph[now].get(j)] == 0) {
                        if (visited[now] == 1) {
                            visited[graph[now].get(j)] = 2;
                        } else if (visited[now] == 2) {
                            visited[graph[now].get(j)] = 1;
                        }
                        q.add(graph[now].get(j));
                    }

                    if (visited[now] == visited[graph[now].get(j)]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}