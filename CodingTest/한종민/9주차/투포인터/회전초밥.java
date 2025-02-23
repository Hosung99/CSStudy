import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 초밥 번호

        int[] sushi = new int[N]; // 벨트 위 초밥 배열
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d + 1]; // 초밥 종류별 방문 횟수
        int count = 0; // 현재 윈도우에서 먹을 수 있는 초밥 종류의 수
        int max = 0; // 최대 초밥 종류의 수

        // 초기 윈도우 설정 (0부터 k-1까지)
        for (int i = 0; i < k; i++) {
            if (visited[sushi[i]] == 0) count++; // 새로운 초밥 종류인 경우
            visited[sushi[i]]++; // 방문 횟수 증가
        }

        // 쿠폰 초밥이 현재 윈도우에 없는 경우 추가
        if (visited[c] == 0) {
            max = count + 1; // 쿠폰 초밥을 추가로 먹을 수 있음
        } else {
            max = count; // 쿠폰 초밥이 이미 포함된 경우
        }

        // 슬라이딩 윈도우 이동
        for (int i = 1; i < N; i++) {
            // 이전 초밥 제거 (윈도우에서 벗어난 초밥)
            visited[sushi[i - 1]]--;
            if (visited[sushi[i - 1]] == 0) count--; // 해당 초밥 종류가 더 이상 없는 경우

            // 새로운 초밥 추가 (윈도우에 들어온 초밥)
            int newSushi = sushi[(i + k - 1) % N]; // 원형 벨트이므로 % N 사용
            if (visited[newSushi] == 0) count++; // 새로운 초밥 종류인 경우
            visited[newSushi]++;

            // 쿠폰 초밥 고려
            if (visited[c] == 0) {
                max = Math.max(max, count + 1); // 쿠폰 초밥을 추가로 먹을 수 있음
            } else {
                max = Math.max(max, count); // 쿠폰 초밥이 이미 포함된 경우
            }
        }

        System.out.println(max);
    }
}
