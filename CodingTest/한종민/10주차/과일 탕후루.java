import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tanghooroo = new int[N];
        int[] visited = new int[10]; // 과일 종류는 1부터 9까지
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tanghooroo[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, count = 0, max = 0;

        while (end < N) {
            if (count < 3) {
                if (visited[tanghooroo[end]] == 0) count++;
                visited[tanghooroo[end]]++;
                end++;
            }
            while (count == 3) {
                visited[tanghooroo[start]]--;
                if (visited[tanghooroo[start]] == 0) count--;
                start++;
            }
            max = Math.max(max, end - start);
        }

        System.out.println(max);
    }
}
