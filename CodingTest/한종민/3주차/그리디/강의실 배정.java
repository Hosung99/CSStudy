import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //11000
    public static int N;

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] input = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        for (int i = 0; i < N; i++) {
            if (pq.peek() == null) {
                pq.add(input[i][1]);
                continue;
            }
            if (input[i][0] < pq.peek()) {
                pq.add(input[i][1]);
            }
            else {
                pq.poll();
                pq.add(input[i][1]);
            }
        }
        System.out.println(pq.size());
    }
}
