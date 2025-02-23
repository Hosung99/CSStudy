## 회전초밥

처음 구현했던 코드 \
문제를 제대로 읽고 풀지 않아서 1번 행사를 참가해야만 쿠폰을 주는지 몰라서 그냥 최대로 먹을 수 있는 가짓수를 고르는 방식으로 구현했다. \
예상외로 질문 게시판에 있는 반례들은 다 되어버려서 잘만든 코드인줄..알았습니다.
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, d, k, c;

    public static int max;
    public static int count;
    public static int[] sushi;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        sushi = new int[N];
        visited = new int[d + 1];
        Arrays.fill(visited, 0);

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k - 1;
        //초반 스시 방문처리
        int i = 0;
        int len = k;
        while (i < len) {
            if (sushi[i] == c)
                len++;
            if (visited[sushi[i]] == 0)
                count++;
            visited[sushi[i]]++;
            i++;
        }
        end = i;
        start++;

        while (true) {
            if (start >= N)
                break;
            max = Math.max(max, count);

            //요번에 추가된 애가 처음이다? 그럼 count++
            if (visited[sushi[end]] == 0 && sushi[end] != c && (sushi[end] != sushi[start - 1])) {
                count++;
            }
            //요번에 빠진애가 딱한번 쓰엿다 그럼 count--;
            if (visited[sushi[start - 1]] == 1 && sushi[start - 1] != c && (sushi[end] != sushi[start - 1])) {
                count--;
            }
            visited[sushi[end]]++;
            visited[sushi[start - 1]]--;

            if (sushi[end] == c) {
                end++;
                count++;
            }
            if (sushi[start - 1] == c) {
                start++;
                count--;
            }
            end++;
            end = end % N;
            start++;
        }
        System.out.println(max);
    }
}

```
문제를 제대로 읽고 윈도우는 무조건 고정시켜놓고 윈도우 안에 쿠폰이 있는지 없는지 유무에 따라 먹은 가짓수 카운트만 다르게 해주었습니다.
```java
// 쿠폰 초밥 고려
if (visited[c] == 0) {
        max = Math.max(max, count + 1); // 쿠폰 초밥을 추가로 먹을 수 있음
} else {
        max = Math.max(max, count); // 쿠폰 초밥이 이미 포함된 경우
}
```

## 가장 긴 짝수 연속한 부분 수열

이 문제는 그렇게 어렵지는 않았는데 인덱스 관리하느라 디버깅이 좀 어려웠다. \
end 인덱스를 밀면서 홀수 갯수를 세고, 짝수라면 계속 밀었고,
start는 가장 가까운 짝수까지만 밀고 시작했다.

다음 start를 한칸씩 밀면서 홀수를 만나면 count-- 해주고, end는 다음 홀수가 나올때 까지 쭉 밀게 구현하였다.
```java
while (end < arr.length || start != end) {
            while (end < arr.length && (count < M || arr[end] % 2 == 0)) {
                if (arr[end] % 2 == 1)
                    count++;
                end++;
            }

            //이거 땜에 좀 애먹었담
            if (start == 0 && end == arr.length && count == 0) {
                max = arr.length;
                break;
            }
            if (arr[start] % 2 == 1) {
                count--;
            }
            if (count <= M && (arr[start] % 2 == 0)) {
                res = end - start - count;
                max = Math.max(max, res);
            }
            start++;
        }
```
마지막에 전부 짝수일때 길이를 잘 못재서 예외적으로 조건문을 걸어주었다.
```java
//이거 땜에 좀 애먹었담
if (start == 0 && end == arr.length && count == 0) {
    max = arr.length;
    break;
}
```
