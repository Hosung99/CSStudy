import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] room = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());
        long count = 0;
        for (int i = 0; i < N; i++) {
            int remaining = room[i] - B;
            count++;
            if (remaining > 0) {
                count += remaining / C;
                if (remaining % C != 0) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}