import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //2805
    public static int N;
    public static int M;
    public static int[] arr;
    public static int res;

    public static long checkTreeLength(long length) {
        long sum = Arrays.stream(arr)
                .mapToLong(num -> num - length)
                .filter(diff -> diff > 0)
                .sum();
        return sum - M;
    }


    public static void binarySearch(int min, int max) {
        int mid = (min + max) / 2;
        res = mid;
        if (min > max)
            return ;
        if (checkTreeLength(mid) == 0) {
            return ;
        }
        else if (checkTreeLength(mid) > 0)
            binarySearch(mid + 1, max);
        else if (checkTreeLength(mid) < 0)
            binarySearch(min, mid - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        binarySearch(0, Arrays.stream(arr).max().getAsInt());
        System.out.println(res);
    }
}
