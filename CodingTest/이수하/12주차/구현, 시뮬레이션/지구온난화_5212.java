import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());
        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            tk = new StringTokenizer(br.readLine());
            map[i] = tk.nextToken().toCharArray();
        }
        List<int[]> transPoint = new ArrayList<>();

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                int flag = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
                        flag++;
                        continue;
                    }
                    if (map[ny][nx] == '.') {
                        flag++;
                    }
                }

                if (flag >= 3) {
                    transPoint.add(new int[]{y, x});
                }
            }
        }

        for (int[] pos : transPoint) {
            map[pos[0]][pos[1]] = '.';
        }

        int x_start = C;
        int y_start = R;
        int x_end = 0;
        int y_end = 0;

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] == 'X') {
                    x_start = Math.min(x_start, x);
                    y_start = Math.min(y_start, y);
                    x_end = Math.max(x_end, x);
                    y_end = Math.max(y_end, y);
                }
            }
        }

        for (int y = y_start; y <= y_end; y++) {
            for (int x = x_start; x <= x_end; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }
}