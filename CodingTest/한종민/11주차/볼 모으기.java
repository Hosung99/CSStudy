import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static char[] balls;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        balls = new char[N];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            balls[i] = input.charAt(i);
        }
        //red
        //앞
        int redMax = 0;
        int flag = 0;
        int count = 0;
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] == 'B') flag = 1;
            if (flag == 1 && balls[i] == 'R') count++;
        }
        redMax = count;
        flag = 0;
        count = 0;
        for (int i = balls.length - 1; i >= 0; i--) {
            if (balls[i] == 'B') flag = 1;
            if (flag == 1 && balls[i] == 'R') count++;
        }
        redMax = Math.min(count, redMax);

        //blue
        int blueMax = 0;
        flag = 0;
        count = 0;
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] == 'R') flag = 1;
            if (flag == 1 && balls[i] == 'B') count++;
        }
        blueMax = count;
        flag = 0;
        count = 0;
        for (int i = balls.length - 1; i >= 0; i--) {
            if (balls[i] == 'R') flag = 1;
            if (flag == 1 && balls[i] == 'B') count++;
        }
        blueMax = Math.min(count, blueMax);

        System.out.println(Math.min(blueMax, redMax));
    }
}
