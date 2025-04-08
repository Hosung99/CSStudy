import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[][] map = new int[8][8];
    public static boolean[][] visited = new boolean[8][8];
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0 ,1};
    public static int[] dy = {1, 1, 1, 0, 0, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (input.charAt(j) == '.')
                    map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        queue.add(new int[] {7, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            visited = new boolean[8][8];

            for (int loop = 0; loop < size; loop++) {
                int[] poll = queue.poll();
                int cx = poll[0];
                int cy = poll[1];

                if (map[cx][cy] == 1) continue;
                if (cx == 0 && cy == 7) {
                    System.out.println(1);
                    return ;
                }
                for (int i = 0; i < dx.length; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
                    if (map[nx][ny] == 1) continue;
                    if (visited[nx][ny]) continue;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

            for (int i = 7; i > 0; i--) {
                for (int j = 0; j < 8; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
            for (int j = 0; j < 8; j++) map[0][j] = 0;
        }
        System.out.println(0);
    }
}
