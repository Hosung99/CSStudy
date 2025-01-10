import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //1920
    public static int N;
    public static int[] A;
    public static int M;

    private static int binarySearch(int min, int max, int num) {
        if (min > max) {
            return 0; // 찾지 못했을 경우
        }
        int mid = (min + max) / 2;
        if (A[mid] == num) {
            return 1;
        }
        else if (A[mid] < num) {
            return binarySearch(mid + 1, max, num);
        }
        else {
            return binarySearch(min, mid - 1, num);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        st = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(0, N - 1, num));
        }
    }
}
