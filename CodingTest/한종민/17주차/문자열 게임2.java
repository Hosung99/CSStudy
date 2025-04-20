import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static String input;
    public static int minLen;
    public static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            minLen = Integer.MAX_VALUE;
            maxLen = -1;

            // 'a' ~ 'z'까지 모두에 대해 검사
            for (char target = 'a'; target <= 'z'; target++) {
                int st = 0;
                int count = 0;

                for (int end = 0; end < input.length(); end++) {
                    if (input.charAt(end) == target) {
                        count++;

                        // 정확히 K개가 되었을 때 왼쪽부터 줄여가면서
                        if (count == K) {
                            while (input.charAt(st) != target) st++; // target이 나올 때까지 st 이동
                            int length = end - st + 1;

                            // 최소 길이 갱신
                            if (length < minLen) {
                                minLen = length;
                            }
                            // 최대 길이 갱신 (조건: 시작, 끝 문자가 같은 target이어야 함)
                            if (input.charAt(st) == input.charAt(end)) {
                                maxLen = Math.max(maxLen, length);
                            }

                            // 다음 후보를 위해 앞에 하나 빼고 이동
                            st++; // target을 하나 없애야 count가 다시 내려감
                            count--;
                        }
                    }
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
