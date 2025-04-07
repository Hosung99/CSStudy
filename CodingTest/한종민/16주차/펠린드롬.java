import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static ArrayList<Integer> nums = new ArrayList<>();
    public static int M;
    public static int S, E;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1; // 한 글자는 무조건 팰린드롬
        }

        for (int i = 0; i < N - 1; i++) {
            if (nums.get(i).equals(nums.get(i + 1))) {
                dp[i][i + 1] = 1; // 두 글자 팰린드롬
            }
        }

        // 길이가 3 이상인 부분
        for (int len = 3; len <= N; len++) {
            for (int start = 0; start <= N - len; start++) {
                int end = start + len - 1;
                if (nums.get(start).equals(nums.get(end)) && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            sb.append(dp[S - 1][E - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
