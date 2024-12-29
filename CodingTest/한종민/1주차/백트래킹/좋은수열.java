import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        recur("");
    }

    private static void recur(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++ ) {
            if (isGoodNumbers(str + i))
                recur(str + i);
        }
    }

    private static boolean isGoodNumbers(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String back = str.substring(str.length() - i, str.length());
            String front = str.substring(str.length() - i * 2, str.length() - i);
            if (back.equals(front))
                return false;
        }
        return true;
    }
}
