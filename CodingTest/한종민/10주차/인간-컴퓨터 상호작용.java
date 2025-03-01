import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static String input;
    public static int N;
    public static int[][] dp = new int[26][200001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= input.length(); j++) {
                if (i == input.charAt(j - 1) - 'a') {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            String alpha = stringTokenizer.nextToken();
            int start = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            int end = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            stringBuilder.append(dp[alpha.charAt(0) - 'a'][end] - dp[alpha.charAt(0) - 'a'][start - 1] + "\n");
        }
        System.out.println(stringBuilder);
    }
}
