import java.io.*;
import java.util.*;

public class Main {
    public static int C,R,N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        C = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[C][R];

        for (int i = 0; i < C; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < R; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Math.min(C, R) / 2; j++) {
                int tmp = arr[j][j];
                for (int top = j; top < R - j - 1; top++) {
                    arr[j][top] = arr[j][top + 1];
                }
                for (int right = j; right < C - j - 1; right++) {
                    arr[right][R - j - 1] = arr[right + 1][R - j - 1];
                }

                for (int bottom = R - j - 1; bottom > j; bottom--) {
                    arr[C - j - 1][bottom] = arr[C - j - 1][bottom - 1];
                }

                for (int left = C - j - 1; left > j; left--) {
                    arr[left][j] = arr[left - 1][j];
                }
                arr[j + 1][j] = tmp;
            }
        }
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
