import java.io.*;
import java.util.*;

public class 성적평균 {
    static int[] sumS = new int[1000001];

    public static double calAvg(int a, int b) {
        int _sum = sumS[b] - sumS[a - 1];
        return (double)_sum / (b - a + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sumS[0] = 0;
        for (int i = 1; i <= N; i++) {
            sumS[i] += sumS[i-1] + Integer.parseInt(st.nextToken());;
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(String.format("%.2f", calAvg(a, b)));
        }
    }
}
