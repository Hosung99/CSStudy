import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static int START_TIME = 0;
    private static int END_TIME = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] lesson = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            lesson[i][START_TIME] = s;
            lesson[i][END_TIME] = t;
        }

        Arrays.sort(lesson, (a, b) -> Integer.compare(a[START_TIME], b[START_TIME]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lesson[0][END_TIME]);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lesson[i][START_TIME]) {
                pq.poll();
            }
            pq.add(lesson[i][END_TIME]);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
    }
}