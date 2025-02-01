import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static boolean[] visited;
    public static int N;
    public static TreeSet<Integer> numbers;
    public static Integer[] copyNumbers;
    public static void main(String[] args) throws IOException {
        //6603
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            numbers = new TreeSet<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            N = Integer.parseInt(stringTokenizer.nextToken());
            visited = new boolean[N];
            if (N == 0)
                break ;
            for (int i = 0; i < N; i++) {
                numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            copyNumbers = numbers.toArray(new Integer[0]);
            List<Integer> numbers = new ArrayList<>();
            shallWeDance(numbers, 0, 1);
            System.out.println();
        }
    }
    public static void shallWeDance(List<Integer> indexs, int num, int len) {
        if (indexs.size() >= 6) {
            for (Integer i : indexs) {
                System.out.print(copyNumbers[i] + " ");
            }
            System.out.println();
            return ;
        }
        for (int i = num; i < numbers.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                indexs.add(i);
                shallWeDance(indexs, i + 1, len + 1);
                indexs.remove(indexs.size() - 1);
                visited[i] = false;
            }
        }
    }
}
