package week01.BackTracking.알파벳;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

class Pair {
    public int x;
    public int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        Main.r = Integer.parseInt(input[0]);
        Main.c = Integer.parseInt(input[1]);

        Main.board = new Character[Main.r][Main.c];
        for (int i = 0; i < Main.r; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < Main.c; j++) {
                Main.board[i][j] = oneLine.charAt(j);
            }
        }

        backTracking(new Pair(0, 0), 1);
        bw.write(Main.maxDist + "");
        bw.flush();
    }

    public void backTracking(Pair cur, int curDist) {
        Main.alphabet.add(Main.board[cur.x][cur.y]);
        Main.maxDist = Math.max(Main.maxDist, curDist);

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + Main.dx[i];
            int ny = cur.y + Main.dy[i];
            if (nx < 0 || nx >= Main.r || ny < 0 || ny >= Main.c)
                continue;
            if (Main.alphabet.contains(Main.board[nx][ny]))
                continue;
            backTracking(new Pair(nx, ny), curDist + 1);
            Main.alphabet.remove(Main.board[nx][ny]);
        }
    }
}

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int r, c;
    public static Set<Character> alphabet = new HashSet<>();
    static Character[][] board;
    static Integer maxDist = 0;

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
