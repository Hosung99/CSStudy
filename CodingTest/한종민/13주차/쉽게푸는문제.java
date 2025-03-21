import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int start, end;
    public static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dp[0] = 0;
        int index = 1;
        int num = 1;
        while (index < 1001) {
            int count = 0;
            while (count < num && index + count < 1001) {
                int currentIndex = index + count;
                dp[currentIndex] = dp[currentIndex - 1] + num;
                count++;
            }
            index += count;
            num++;
        }

        System.out.println(dp[end]  - dp[start - 1]);
    }
}
