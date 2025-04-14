import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean flag = false;
    static boolean[][] visit = new boolean[1501][1501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        int c = Integer.parseInt(tk.nextToken());

        if ((a + b + c) % 3 != 0) {
            System.out.println(0);
            return ;
        }
        reculsion(a, b, c);

        System.out.println(flag ? 1 : 0);
    }

    public static void reculsion(int a, int b, int c) {
        if (flag == true) {
            return;
        }

        if (a == b && b == c) {
            flag = true;
            return;
        }

        int[] arr = {a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        if (visit[a][b] == true) {
            return ;
        }
        visit[a][b] = true;

        if (a != b) {
            reculsion(a + a, b - a, c);
        }
        if (b != c) {
            reculsion(a, b + b, c - b);
        }
        if (a != c) {
            reculsion(a + a, b, c - a);
        }
    }
}