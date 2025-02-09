import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] origin = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = origin[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int range = end - start + 1;
            int total = prefixSum[end] - prefixSum[start - 1];
            double IntervalSum = (double)total / range;
            System.out.printf("%.2f%n", IntervalSum);
        }
    }
}
