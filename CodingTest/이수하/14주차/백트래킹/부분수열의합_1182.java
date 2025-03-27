import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n, s, cnt;
    static int[] sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tk.nextToken());
        s = Integer.parseInt(tk.nextToken());

        sequence = new int[n];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(tk.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(cnt);
    }

    static void dfs(int idx, int sum, int selected) {
        if (idx == n) {
            if (s == sum && selected > 0) {
                cnt++;
            }
            return ;
        }

        // 현재 인덱스를 포함한다.
        dfs (idx + 1, sum + sequence[idx], selected + 1);

        // 현재 인덱스를 포함하지 않는다.
        dfs (idx + 1, sum, selected);
    }
}