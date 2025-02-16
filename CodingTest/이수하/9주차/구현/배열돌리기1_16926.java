import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        int[][] array = new int[N][M];
        int[][] resultArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            int curYLength = N;
            int curXLength = M;
            int depth = 0;
            while (!(curYLength < 2 || curXLength < 2)) {
                int startX = depth;
                int startY = depth;
                int endX = M - depth - 1;
                int endY = N - depth - 1;

                //왼쪽
                for (int ny = startY; ny < endY; ny++) {
                    resultArray[ny + 1][startX] = array[ny][startX];
                }
                resultArray[endY][startX + 1] = array[endY][startX];

                //하단
                for (int nx = startX; nx < endX; nx++) {
                    resultArray[endY][nx + 1] = array[endY][nx];
                }
                resultArray[endY - 1][endX] = array[endY][endX];

                //오른쪽
                for (int ny = endY; ny > startY; ny--) {
                    resultArray[ny - 1][endX] = array[ny][endX];
                }
                resultArray[startY][endX - 1] = array[startY][endX];

                //상단
                for (int nx = endX; nx > startX; nx--) {
                    resultArray[startY][nx - 1] = array[startY][nx];
                }
                resultArray[startY + 1][startX] = array[startY][startX];

                curYLength -= 2;
                curXLength -= 2;
                depth++;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    array[j][k] = resultArray[j][k];
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}