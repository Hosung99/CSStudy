import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1967 {
    public static int N;
    static class Node {
        int num;
        int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public static List<Node>[] tree;
    public static boolean[] visited;

    public static int res;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int value = Integer.parseInt(stringTokenizer.nextToken());
            int child = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            tree[value].add(new Node(child, weight));
            tree[child].add(new Node(value, weight));
        }
        for (int i = 1; i < N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i , 0);
        }
        System.out.println(res);
    }

    public static void dfs(int index, int len) {
        for (Node node : tree[index]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, len + node.len);
            }
        }
        res = Math.max(res, len);
    }
}
