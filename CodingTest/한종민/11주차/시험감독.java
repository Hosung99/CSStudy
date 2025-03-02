import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13458 {
    public static int N;
    public static int[] members = new int[1000001];
    public static int b, c;
    public static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] inputMembers = br.readLine().split(" ");
        for (int i = 0 ; i < N; i++) {
            members[i] = Integer.parseInt(inputMembers[i]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int res = 1;
            members[i] = members[i] - b;
            if (members[i] > 0) {
                res += members[i] / c;
                if (members[i] % c > 0)
                    res++;
            }
            count += res;
        }
        System.out.println(count);
    }
}
