import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Character> stack = new Stack<>();
    private static LinkedList<Character> numbers = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        String[] inputNAndM = br.readLine().split(" ");
        int n = Integer.parseInt(inputNAndM[0]);
        int k = Integer.parseInt(inputNAndM[1]);

        numbers = br.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && k > 0 && stack.peek() < numbers.getFirst()) {
                stack.pop();
                k--;
            }
            stack.push(numbers.poll());
        }
        while (k-- > 0) {
            stack.pop();
        }

        for (char num : stack) {
            bw.write(num);
        }
        bw.flush();
        bw.close();
    }
}