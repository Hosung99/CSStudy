import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static final List<Integer> nums = new ArrayList<>();
    private static int[] length = new int[1001];


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(length, 1);
        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) < nums.get(j)) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            max = Math.max(length[i], max);
        }
        System.out.println(max);
    }
}
