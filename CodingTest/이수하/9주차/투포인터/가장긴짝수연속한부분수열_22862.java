import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        // N : 수열 사이즈
        int N = Integer.parseInt(token.nextToken());
        // K : 삭제가능한 원소 개수
        int K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(token.nextToken());
        }

        int left = 0, right = 0, oddCnt = 0, evenCnt = 0, max = 0;
        while (right < N) {
            if (sequence[right] % 2 == 0) {
                evenCnt++;
            } else if (sequence[right] % 2 == 1) {
                oddCnt++;
            }

            if (oddCnt > K) {
                max = Math.max(max, evenCnt);

                while(sequence[left] % 2 == 0) {
                    left++;
                    evenCnt--;
                }
                left++;
                oddCnt--;
            }
            right++;
        }

        if (evenCnt + oddCnt == N) {
            max = evenCnt;
        }
        System.out.print(max);
    }
}