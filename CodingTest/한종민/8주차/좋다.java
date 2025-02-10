import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] num;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedreader.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(bufferedreader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i){
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                if (num[start] + num[end] > num[i]) {
                    end--;
                }
                else if (num[start] + num[end] == num[i]) {
                    count++;
                    break;
                }
                else
                    start++;
            }
        }
        System.out.println(count);
    }
}
