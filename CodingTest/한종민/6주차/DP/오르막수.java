import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057 {
    public static int N;
    public static int[][] dp = new int[1001][10];

    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < 1001; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = j; k < 10; k++)
                    sum += dp[i - 1][k];
                dp[i][j] = sum % 10007;
            }
        }
        System.out.println(dp[N][0]);
    }
}
