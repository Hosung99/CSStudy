import java.io.*;
import java.util.*;

public class Main {
    public static double[] dp;
    public static int N, K;
    public static int[] grade;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grade = new int[N + 1];
        dp = new double[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            grade[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        dp[1] = grade[1];
        sum = grade[1];

        for (int i = 2; i <= N; i++) {
            sum += grade[i];
            dp[i] = sum;
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            double avg = (double)(dp[end] - dp[start - 1]) / (end - start + 1);
            System.out.printf("%.2f\n", avg); // 소수점 두 자리 출력
        }
    }
}


// 10 50 20 70
// 0 10 60 80 150
