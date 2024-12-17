import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static int maxlen;
    public static int[] isVisited = new int[30];
    public static char [][] arr = new char[21][21];

    private static void recur(int i, int j, int len){
        if (i < 0 || i >= R || j < 0 || j >= C) {
            return ;
        }
        if (isVisited[arr[i][j] - 'A'] == 0) {
            isVisited[arr[i][j] - 'A'] = 1;
            if (len > maxlen)
                maxlen = len;
            recur(i + 1, j, len + 1);
            recur(i - 1, j, len + 1);
            recur(i, j + 1, len + 1);
            recur(i, j - 1, len + 1);
            isVisited[arr[i][j] - 'A'] = 0;
        }
        return ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        recur(0, 0, 1);
        System.out.println(maxlen);
    }
}
