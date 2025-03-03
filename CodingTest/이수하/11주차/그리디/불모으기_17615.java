import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        String ball = tk.nextToken();

        int redLeftCnt = 0;
        int redRightCnt = 0;
        int blueLeftCnt = 0;
        int blueRightCnt = 0;
        int min = Integer.MAX_VALUE;

        //red 정방향
        boolean flag = false;
        for (int i = 0; i < ball.length(); i++) {
            if (ball.charAt(i) == 'R' && flag == false) {
                continue;
            }
            if (ball.charAt(i) == 'B' && flag == false) {
                flag = true;
            }
            if (ball.charAt(i) == 'R' && flag == true) {
                redLeftCnt++;
            }
        }
        min = Math.min(min, redLeftCnt);

        //red 역방향
        flag = false;
        for (int i = ball.length() - 1; i >= 0; i--) {
            if (ball.charAt(i) == 'R' && flag == false) {
                continue;
            }
            if (ball.charAt(i) == 'B' && flag == false) {
                flag = true;
            }
            if (ball.charAt(i) == 'R' && flag == true) {
                redRightCnt++;
            }
        }
        min = Math.min(min, redRightCnt);

        //blue 정방향
        flag = false;
        for (int i = 0; i < ball.length(); i++) {
            if (ball.charAt(i) == 'B' && flag == false) {
                continue;
            }
            if (ball.charAt(i) == 'R' && flag == false) {
                flag = true;
            }
            if (ball.charAt(i) == 'B' && flag == true) {
                blueLeftCnt++;
            }
        }
        min = Math.min(min, blueLeftCnt);

        //blue 역방향
        flag = false;
        for (int i = ball.length() - 1; i >= 0; i--) {
            if (ball.charAt(i) == 'B' && flag == false) {
                continue;
            }
            if (ball.charAt(i) == 'R' && flag == false) {
                flag = true;
            }
            if (ball.charAt(i) == 'B' && flag == true) {
                blueRightCnt++;
            }
        }
        min = Math.min(min, blueRightCnt);

        System.out.print(min);
    }
}