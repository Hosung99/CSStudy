import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int a,b,c;
    public static boolean[][] visited = new boolean[1501][1501];
    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited[a][b] = true;
        visited[b][a] = true;
        visited[c][a] = true;
        visited[a][c] = true;
        visited[b][c] = true;
        visited[c][b] = true;


        queue.add(new int[]{a, b, c});
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int aa = head[0];
            int bb = head[1];
            int cc = head[2];

            if (aa == bb && bb == cc) {
                System.out.println(1);
                return;
            }
            if (aa != bb && aa <= 1000 && bb <= 1000) {
                int na = Math.min(aa, bb);
                int nb = Math.max(aa, bb);
                nb -= na;
                na += na;
                if (!visited[na][nb] && !visited[nb][na]) {
                    queue.add(new int[]{na, nb, cc});
                    visited[na][nb] = true;
                    visited[nb][na] = true;
                }
            }

            if (aa != cc && aa <= 1000 && cc <= 1000) {
                int na = Math.min(aa, cc);
                int nc = Math.max(aa, cc);
                nc -= na;
                na += na;
                if (!visited[na][nc] && !visited[nc][na]) {
                    queue.add(new int[]{na, bb ,nc});
                    visited[na][nc] = true;
                    visited[nc][na] = true;
                }
            }
            if (bb != cc && bb <= 1000 && cc <= 1000) {
                int nb = Math.min(bb, cc);
                int nc = Math.max(bb, cc);
                nc -= nb;
                nb += nb;
                if (!visited[nb][nc] && !visited[nc][nb]) {
                    queue.add(new int[]{aa, nb, nc});
                    visited[nb][nc] = true;
                    visited[nc][nb] = true;
                }
            }

        }
        System.out.println(0);
    }
}
