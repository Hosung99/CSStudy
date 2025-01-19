import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //2230
    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        int sub = Integer.MAX_VALUE;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && arr[end] - arr[start] < M) {
                end++;
            }
            if (end < N && arr[end] - arr[start] >= M) {
                sub = Math.min(sub, arr[end] - arr[start]);
                if (sub == M) {
                    System.out.println(sub);
                    return ;
                }
            }
        }
        System.out.println(sub);

    }
}
