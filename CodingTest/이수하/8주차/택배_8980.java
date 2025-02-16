import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());

        int[][] receivePriority = new int[M][3];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int boxCnt = Integer.parseInt(token.nextToken());

            receivePriority[i][0] = start;
            receivePriority[i][1] = end;
            receivePriority[i][2] = boxCnt;
        }

        Arrays.sort(receivePriority, (a, b) -> {
            return a[1] - b[1];
        });

        int maxDeliverableBoxes = 0;
        int[] capacities = new int[N];
        Arrays.fill(capacities, C);
        for (int i = 0; i < M; i++) {
            int start = receivePriority[i][0];
            int end = receivePriority[i][1];
            int boxCnt = receivePriority[i][2];
            int capacity = Integer.MAX_VALUE;

            for (int j = start; j < end; j++) {
                capacity = Math.min(capacity, capacities[j]);
            }

            for (int j = start; j < end; j++) {
                capacities[j] -= Math.min(capacity, boxCnt);
            }

            maxDeliverableBoxes += Math.min(capacity, boxCnt);
        }

        System.out.println(maxDeliverableBoxes);
    }
}