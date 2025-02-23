import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        // 순환배열처럼 사용 위해 벨트 끝에 벨트 앞부분을 붙여줄 배열 생성
        int[] belt = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            belt[i] = Integer.parseInt(token.nextToken());
        }

        // 순환을 위한 스시 추가
        for (int i = 0; i < k - 1; i++) {
            belt[N + i] = belt[i];
        }

        int[] sushi = new int[d + 1];
        sushi[c]++;
        int curMaxKind = 1;

        // 슬라이딩 윈도우 기법사용할것임. 고정된 윈도우 생성
        for (int i = 0; i < k; i++) {
            if (sushi[belt[i]] == 0) {
                curMaxKind++;
            }
            sushi[belt[i]]++;
        }

        int start = 0;
        int end = k - 1;
        int maxKind = curMaxKind;
        // 슬라이딩 윈도우를 통한 전체 배열 검사.
        // 전체배열사이즈(N + k -1) 에서 -1을 한이유 : 첫번재 while문은 첫번째 슬라이딩 윈도우가 아닌 다음 슬라이딩 윈도우를 검사하기 때문이다.
        while (end < (N + k - 1) - 1) {
            sushi[belt[start]]--;
            if (sushi[belt[start]] == 0) {
                curMaxKind--;
            }
            start++;

            end++;
            if (sushi[belt[end]] == 0) {
                curMaxKind++;
            }
            sushi[belt[end]]++;
            maxKind = Math.max(maxKind, curMaxKind);
        }

        System.out.print(maxKind);
    }
}