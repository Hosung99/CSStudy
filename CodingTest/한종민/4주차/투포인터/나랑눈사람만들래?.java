import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20366 {
    //20366
    public static int N;
    public static int[] arr;
    public static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        min = Integer.MAX_VALUE;

        for (int start1 = 0; start1 < N; start1++) {
            for (int end1 = start1 + 1; end1 < N; end1++) {
                int snowman1 = arr[end1] + arr[start1];
                int start2 = 0;
                int end2 = N - 1;
                while (start2 < end2) {
                    if (start2 == end1 || start2 == start1) {
                        start2++;
                        continue;
                    }
                    if (end2 == end1 || end2 == start1) {
                        end2--;
                        continue;
                    }
                    int snowman2 = arr[end2] + arr[start2];
                    min = Math.min(min, Math.abs(snowman2 - snowman1));

                    if (snowman1 > snowman2) {
                        start2++;
                    }
                    else if (snowman1 < snowman2) {
                        end2--;
                    }
                    else {
                        System.out.println(0);
                        return ;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
