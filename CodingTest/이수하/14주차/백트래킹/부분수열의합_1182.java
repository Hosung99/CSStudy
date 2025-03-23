import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n, max;
    static List<int[]> eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        eggs = new LinkedList<>();
        n = Integer.parseInt(tk.nextToken());
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            int life = Integer.parseInt(tk.nextToken());
            int weight = Integer.parseInt(tk.nextToken());
            eggs.add(new int[]{life, weight});
        }

        dfs(0);

        System.out.print(max);
    }

    static void dfs(int attack) {
        if (attack == n) {
            max = Math.max(cntBrokenEggs(), max);
            return;
        }

        for (int defense = 0; defense < n; defense++) {
            //공격할 계란과 맞아주는 계란이 같은 계란일 수는 없다.
            if (defense == attack) continue;
            //공격할 계란과 맞아주는 계란 중 하나라도 깨져있으면 아무것도 하지 않고 다음으로 넘어간다.
            if (eggs.get(attack)[0] <= 0 || eggs.get(defense)[0] <= 0) {
                dfs(attack + 1);
                continue;
            }

            eggs.get(attack)[0] -= eggs.get(defense)[1];
            eggs.get(defense)[0] -= eggs.get(attack)[1];
            dfs(attack + 1);
            eggs.get(attack)[0] += eggs.get(defense)[1];
            eggs.get(defense)[0] += eggs.get(attack)[1];

        }
    }

    static int cntBrokenEggs() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (eggs.get(i)[0] <= 0) {
                res++;
            }
        }

        return res;
    }
}