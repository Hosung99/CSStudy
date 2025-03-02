import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _14658 {

    public static int N, M, L, K;
    public static List<int[]> stars = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        int res = Integer.MIN_VALUE;
        for(int[] s1: stars){
            for(int[] s2: stars){
                res = Math.max(res, countStar(s1[0], s2[1]));
            }
        }
        System.out.println(K - res);
    }

    private static int countStar(int x, int y) {
        int count = 0;
        for (int[] star : stars) {
            if (x <= star[0] && star[0] <= x+L && y <= star[1] && y + L >= star[1]) count++;
        }
        return count;
    }
}
