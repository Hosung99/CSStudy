import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //2847

    public static int N;
    public static int result;
    public static int[] arr = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i + 1] <= arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1] - 1;
                result += (tmp - arr[i]);
            }
        }
        System.out.println(result);
    }
}
