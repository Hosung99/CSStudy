import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15666 {
    public static int N;
    public static int M;
    public static Set<Integer> setArr = new TreeSet<>();
    public static Integer[] arr;
    public static int[] answer = new int[10001];

    private static void recul(int num) {
        if (num == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                stringBuilder.append(arr[answer[i]]).append(" ");
            }
            System.out.println(stringBuilder);
            return;
        }

        int start = (num == 0) ? 0 : answer[num - 1];
        for (int i = start; i < N; i++) {
            answer[num] = i;
            recul(num + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            setArr.add(Integer.parseInt(st.nextToken())); // TreeSet에 값 추가
        }

        arr = setArr.toArray(new Integer[0]);
        N = arr.length;

        recul(0);
    }
}
