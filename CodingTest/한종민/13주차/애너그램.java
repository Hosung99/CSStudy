import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int N;
    public static String input;
    public static boolean[] visited;
    public static char[] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            input = br.readLine();
            arr = input.toCharArray();
            Arrays.sort(arr);
            visited = new boolean[input.length()];
            makePermutation(new ArrayList<>());
            System.out.println(sb.toString());
        }
    }

    private static void makePermutation(ArrayList<Integer> list) {
        if (list.size() == input.length()) {
            for (Integer s : list) {
                sb.append(arr[s]);
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                makePermutation(list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
