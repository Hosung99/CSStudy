import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit;
    static int visitCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int vertexCount = Integer.parseInt(input[0]);
        int edgeCount = Integer.parseInt(input[1]);
        int startVertex = Integer.parseInt(input[2]);

        visit = new int[vertexCount];
        graph = new ArrayList<>();
        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int startEdge = Integer.parseInt(edgeInput[0]);
            int endEdge = Integer.parseInt(edgeInput[1]);
            graph.get(startEdge - 1).add(endEdge);
            graph.get(endEdge - 1).add(startEdge);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(startVertex - 1);

        for (int i = 0; i < visit.length; i++) {
            bw.write(visit[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static private void dfs(int currentVertex)
    {
        visit[currentVertex] = visitCount++;
        for (int i = 0; i < graph.get(currentVertex).size(); i++) {
            int nextStartVertex = graph.get(currentVertex).get(i);
            if (visit[nextStartVertex - 1] == 0) {
                dfs(nextStartVertex - 1);
            }
        }
    }
}