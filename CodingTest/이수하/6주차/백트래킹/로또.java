import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(token.nextToken());

            if (k == 0) break;

            ArrayList<Integer> s = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                s.add(Integer.parseInt(token.nextToken()));
            }

            int[] combination = new int[6];
            backTracking(s, combination, 0, 0);
            System.out.println();
        }
    }

    static void backTracking(ArrayList<Integer> s, int[] combination, int start, int depth) {
        if (depth == 6) {
            // 조합 출력
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < s.size(); i++) {
            combination[depth] = s.get(i);
            backTracking(s, combination, i + 1, depth + 1);
        }
    }
}