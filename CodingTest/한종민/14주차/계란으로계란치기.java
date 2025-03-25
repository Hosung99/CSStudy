import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] eggs = new int[8][2];
    public static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        backtracking(0, 0);
        System.out.println(maxCount);
    }

    private static void backtracking(int index, int count) {
        if (index == N) {
            maxCount = Math.max(maxCount, count);
            return;
        }
        if (eggs[index][0] <= 0) {
            backtracking(index + 1, count);
            return;
        }

        boolean hit = false; // 하나라도 부딪힌 계란이 있는지 확인

        for (int i = 0; i < N; i++) {
            if (i == index || eggs[i][0] <= 0) continue; // 자기 자신이거나 이미 깨진 계란이면 skip

            // 현재 계란과 부딪히는 계란 충돌 처리
            eggs[index][0] -= eggs[i][1];
            eggs[i][0] -= eggs[index][1];

            // 깨어진 계란 개수 증가
            int brokenEggs = (eggs[index][0] <= 0 ? 1 : 0) + (eggs[i][0] <= 0 ? 1 : 0);

            // 백트래킹 진행
            backtracking(index + 1, count + brokenEggs);
            hit = true;

            // 상태 복구 (원래 상태로 되돌림)
            eggs[index][0] += eggs[i][1];
            eggs[i][0] += eggs[index][1];
        }

        // 부딪힐 수 있는 계란이 없었다면 그냥 다음 계란으로 이동
        if (!hit) {
            backtracking(index + 1, count);
        }
    }
}
