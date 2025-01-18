import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int child;
    int weight;

    public Node (int child, int weight) {
        this.child = child;
        this.weight = weight;
    }
}

public class Main {

    static ArrayList<Node>[] undirectedGraph;
    static boolean[] visited;
    static int maxLength = 0, maxNode = 1;
    static int ROOT_NODE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        undirectedGraph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            undirectedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine());
            int parents = Integer.parseInt(token.nextToken());
            int child = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            undirectedGraph[parents].add(new Node(child, weight));
            undirectedGraph[child].add(new Node(parents, weight));
        }

        visited = new boolean[n + 1];
        visited[ROOT_NODE] = true;
        dfs(1, 0);
        visited = new boolean[n + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);

        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }

    static public void dfs(int currentNode, int currentLength) {
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxNode = currentNode;
        }

        for (Node childNode : undirectedGraph[currentNode]) {
            if (visited[childNode.child] == false) {
                visited[childNode.child] = true;
                dfs(childNode.child, childNode.weight + currentLength);
            }
        }
    }

}