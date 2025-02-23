import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int res, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int end = 0;
        int start = 0;
        int count = 0;
        while (end < arr.length || start != end) {
            while (end < arr.length && (count < M || arr[end] % 2 == 0)) {
                if (arr[end] % 2 == 1)
                    count++;
                end++;
            }

            //이거 땜에 좀 애먹었담
            if (start == 0 && end == arr.length && count == 0) {
                max = arr.length;
                break;
            }
            if (arr[start] % 2 == 1) {
                count--;
            }
            if (count <= M && (arr[start] % 2 == 0)) {
                res = end - start - count;
                max = Math.max(max, res);
            }
            start++;
        }
        System.out.println(max);
    }
}
