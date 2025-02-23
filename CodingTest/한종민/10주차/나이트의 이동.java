import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static boolean[][] visited;
    public static Queue<int[]> q;
    public static int min;

    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            min = 0;
            q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            q.add(new int[]{startX, startY, 0});
            visited[startX][startY] = true;

            st = new StringTokenizer(br.readLine(), " ");
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                int depth = cur[2];
                if (cx == destX && cy == destY) {
                    min = depth;
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                    if (visited[nx][ny]) continue;
                    q.offer(new int[]{nx, ny, depth + 1});
                    visited[nx][ny] = true;
                }
            }
            System.out.println(min);
        }
    }
}
