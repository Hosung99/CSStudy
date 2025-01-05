import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    //1477

    public static int N, M, L;
    public static int[] arr;
    public static int res;

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N + 2];
        M = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        arr[N] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);
        binarySearch(1, L);
        System.out.println(res);
    }
    public static void binarySearch(int left, int right) {
        if (left > right) {
            return;  // 종료 조건: 탐색 범위가 좁아짐
        }

        int mid = (left + right) / 2;
        int count = 0;

        // 현재 mid 값에 따라 필요한 추가 휴게소 개수 계산
        for (int i = 1; i < arr.length; i++) {
            count += (arr[i] - arr[i - 1] - 1) / mid;
        }

        if (count > M) {
            // 필요한 휴게소 수가 많다면 mid 값을 증가시켜 탐색
            binarySearch(mid + 1, right);
        } else {
            // 현재 mid 값이 유효하므로 결과값 갱신
            res = mid;
            // 더 작은 mid 값을 탐색
            binarySearch(left, mid - 1);
        }
    }
}
