import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    //2812
    private static int N;
    private static int K;
    private static Stack<Integer> stack = new Stack<>();
    private static int[] nums = new int[500001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        String num = st.nextToken();
        for (int i = 0; i < N; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i < N; i++) {
            while (K > 0 && !stack.empty() && stack.peek() < nums[i]) {
                stack.pop();
                K--;
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < stack.size() - K; i++) {
            System.out.print(stack.get(i));
        }
    }
}
