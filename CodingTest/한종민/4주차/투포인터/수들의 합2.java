import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //2003
    public static int N, M;
    public static int sum;
    public static int count;

    public static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int end = 0;
        for (int i = 0; i < N; i++) {
            while (sum < M && end < N) {
                sum += arr[end];
                end++;
            }
            if (sum == M) {
                count++;
            }
            sum -= arr[i];
        }
        System.out.println(count);
    }
}
