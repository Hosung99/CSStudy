import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, S;
    public static long[] dp;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= N && end <= N) {
            if(total >= S && min > end - start) min = end - start ;

            if(total < S) total += dp[end++];
            else total -= dp[start++];
        }
        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
