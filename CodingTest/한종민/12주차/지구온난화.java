import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5212 {
    public static int N, M;
    public static int[][] map;
    public static int[][] copyMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0 ;i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '.') {
                    map[i][j] = 0;
                    copyMap[i][j] = 0;
                }
                else {
                    map[i][j] = 1;
                    copyMap[i][j] = 1;
                }
            }
        }

        //50년 뒤 지도 만들기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int count = 0;
                if (map[i][j] == 1) {
                    if ((i + 1 >= N) || (i + 1 < N) && map[i + 1][j] == 0) count++;
                    if ((i - 1 < 0) || (i - 1 >= 0) && map[i - 1][j] == 0) count++;
                    if ((j + 1 >= M) || (j + 1 < M) && map[i][j + 1] == 0) count++;
                    if ((j - 1 < 0) || (j - 1 >= 0) && map[i][j - 1] == 0) count++;
                    if (count >= 3) copyMap[i][j] = 0;
                }
            }
        }

        // 가장 작은 지도 크기 찾기
        int minRow = N, maxRow = 0, minCol = M, maxCol = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 1) { // 섬이 존재하는 경우
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                System.out.print(copyMap[i][j] == 1 ? 'X' : '.'); // '1' 대신 'X'로 표시
            }
            System.out.println();
        }
    }
}
