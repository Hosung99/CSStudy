import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2831 {
    public static int N;
    public static Queue<Integer> bigMen = new PriorityQueue<>();
    public static Queue<Integer> smallMen = new PriorityQueue<>();
    public static Queue<Integer> bigWomen = new PriorityQueue<>();
    public static Queue<Integer> smallWomen = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height < 0)
                smallMen.offer(height * -1);
            else
                bigMen.offer(height);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height < 0)
                smallWomen.offer(height * -1);
            else
                bigWomen.offer(height);
        }

        int count = 0;
        while (!smallMen.isEmpty() && !bigWomen.isEmpty()) {
            int man = smallMen.peek();
            int woman = bigWomen.peek();
            if (man > woman) {
                smallMen.poll();
                bigWomen.poll();
                count++;
            }
            else {
                smallMen.poll();
            }
        }

        while (!bigMen.isEmpty() && !smallWomen.isEmpty()) {
            int man = bigMen.peek();
            int woman = smallWomen.peek();
            if (man < woman) {
                bigMen.poll();
                smallWomen.poll();
                count++;
            }
            else {
                smallWomen.poll();
            }
        }
        System.out.println(count);
    }
}
