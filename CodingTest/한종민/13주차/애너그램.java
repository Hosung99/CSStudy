import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int N;
    public static String input;
    public static int[] visited = new int[26];
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
            Arrays.fill(visited, 0); // visited 배열 초기화
            for (char c : arr) {
                visited[c - 'a']++;
            }
            makePermutation(new ArrayList<>());
            System.out.print(sb.toString());
        }
    }

    private static void makePermutation(ArrayList<Character> list) {
        if (list.size() == arr.length) {
            for (char s : list) {
                sb.append(s);
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 이전 문자와 같고, 이전 문자가 아직 처리되지 않았다면 건너뛰기
            if (i > 0 && arr[i] == arr[i - 1] && visited[arr[i - 1] - 'a'] > 0) {
                continue;
            }
            if (visited[arr[i] - 'a'] > 0) {
                visited[arr[i] - 'a']--;
                list.add(arr[i]);
                makePermutation(list);
                list.remove(list.size() - 1);
                visited[arr[i] - 'a']++;
            }
        }
    }
}
