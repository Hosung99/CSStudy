import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int[] array = new int[n + 1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(tk.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];

        //1개짜리 true로 변경, ex) s = 1, e = 1
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        //2개짜리 true로 변경, i가 start, i + 1이 end
        for (int i = 1; i < n; i++) {
            if (array[i] == array[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        //3개짜리 ~ n개짜리를 true로 변경
        for (int subLen = 3; subLen <= n; subLen++) {
            for (int s = 1; s <= n - subLen + 1; s++) {
                int e = s + subLen - 1;
                if (array[s] == array[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }

        tk = new StringTokenizer(br.readLine());
        int question_num = Integer.parseInt(tk.nextToken());
        while (question_num-- > 0) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());

            bw.write(dp[start][end] ? "1\n" : "0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}