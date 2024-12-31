import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> games = new ArrayList<>();
        Stack<Integer> q = new Stack<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < n; i++) {
            games.add(q.pop());
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (games.get(i) <= games.get(i + 1)) {
                int changNumber = games.get(i) - 1;
                res += games.get(i + 1) - changNumber;
                games.set(i + 1, changNumber);
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}