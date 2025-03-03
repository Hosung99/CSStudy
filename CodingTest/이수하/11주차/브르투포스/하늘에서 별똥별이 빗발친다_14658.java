import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<int[]> stars = new ArrayList<>();;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        L = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < K; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            stars.add(new int[]{x, y});
        }

        int max = 0;
        for (int[] starX : stars) {
            for (int [] starY : stars) {
                max = Math.max(max, counter(starX[0], starY[1]));
            }
        }

        System.out.print(K - max);
    }

    static int counter(int x, int y) {
        int count = 0;

        for (int[] star: stars) {
            if (x <= star[0] && star[0] <= x + L && y <= star[1] && star[1] <= y + L) {
                count++;
            }
        }
        return count;
    }
}