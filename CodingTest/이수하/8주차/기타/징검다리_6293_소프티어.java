//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(token.nextToken());
//        token = new StringTokenizer(br.readLine());
//        int[] stones = new int[N];
//        for (int i = 0; i < N; i++) {
//            stones[i] = Integer.parseInt(token.nextToken());
//        }
//
//        int[] dp = new int[N];
//        Arrays.fill(dp, 1);
//
//        for (int i = 0; i < N; i++) {
//            int subMax = 0;
//            for (int j = 0; j < i; j++) {
//                if (stones[i] > stones[j]) {
//                    subMax = Math.max(subMax, dp[j]);
//                }
//            }
//            dp[i] = subMax + 1;
//        }
//        int max = Arrays.stream(dp).max().orElse(0);
//        System.out.printf("%d", max);
//    }
//}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 돌 개수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. 돌들의 높이를 배열로 입력받기
        int[] stones = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 3. LIS(최장 증가 부분 수열)를 저장할 리스트
        List<Integer> lis = new ArrayList<>();

        // 4. 주어진 돌 높이들을 하나씩 확인
        for (int stone : stones) {
            // 5. 현재 돌의 높이가 lis 리스트에서 어디에 들어갈지 찾음 (이진 탐색)
            int pos = Collections.binarySearch(lis, stone);

            // 6. binarySearch()는 값이 없으면 -(삽입 위치 + 1)을 반환하므로, 양수로 변환
            if (pos < 0) {
                pos = -(pos + 1); // 삽입해야 할 위치로 변환
            }

            // 7. 찾은 위치가 lis의 끝이면 새 원소 추가 (LIS 길이 증가)
            if (pos == lis.size()) {
                lis.add(stone);
            }
            // 8. 찾은 위치에 기존 원소 대체 (LIS 유지)
            else {
                lis.set(pos, stone);
            }
        }

        // 9. 최장 증가 부분 수열(LIS)의 길이 출력
        System.out.println(lis.size());
    }
}

