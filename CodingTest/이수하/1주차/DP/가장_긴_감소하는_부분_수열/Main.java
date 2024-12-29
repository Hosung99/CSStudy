import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] sequence = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] dp = Arrays.stream(new Integer[n]).map(i -> 1).toArray(Integer[]::new);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] > sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        List<Integer> dpArray = Arrays.asList(dp);
        bw.write(String.valueOf(Collections.max(dpArray)));
        bw.flush();
    }
}
