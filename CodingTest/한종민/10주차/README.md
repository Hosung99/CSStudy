## 과일 탕탕 후루후루 탕탕 후루루루루

실버 2 주제에 꽤 많이 시간을 썻다.. \
처음 짠 코드는 최적해를 구할 수 없는 코드였다. \
맨앞과 맨뒤를 비교해서 어느 과일이 더 많이 쓰이는지 비교해서 더 적게 쓰는 과일 빼기 \
뭔가 안될거 같았는데 역시 안되는 코드 엿다. 
```
반례
5 5 5 1 1 1 1 2 1

정답 : 5 5 5 1 1 1 1

오답 : 1 1 1 1 2 1
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int count;
    public static Deque<Integer> tanghooroo = new LinkedList<>();
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            tanghooroo.add(num);
            if (visited[num] == 0)
                count++;
            visited[num]++;
        }

        while (count > 2) {
            int front = tanghooroo.getFirst();
            int end = tanghooroo.getLast();
            if (visited[front] < visited[end]) {
                tanghooroo.pollFirst();
                visited[front]--;
                if (visited[front] == 0)
                    count--;
            } else {
                tanghooroo.pollLast();
                visited[end]--;
                if (visited[end] == 0)
                    count--;
            }
        }
        System.out.println(tanghooroo.size());
    }
}

```
바로 살짝 힌트만 보고 다시 구현했다.. 투포인터로 인덱스를 밀고 가면서 두 인덱스 사이에는 두 종류의 과일만 남도록 밀고 가기\
그중에 max값을 갱신해가면서 하면 성공이다.

## 인간-컴퓨터 상호작용

이 친구는 문자열의 알파벳 횟수 카운터 하는거 보니 딱봐도 누적합이다.
바로 알파벳별로 배열 한줄씩 할당해주고 해당 인덱스까지 몇번 출력되었는지 기록해주었다.

출력할때는 dp[end] - dp[start - 1]

근데 이렇게 햇는데도? 50점으로 시간초과가 나더라 이말입니다.\
유진님의 세시간 삽질의 힘을 빌려... 출력을 몰아서 해보았더니 성공\
킹갓 유진

## 나이트의 이동
이건 뭐 bfs 기본이라 로직은 쉽게 짰는데... \
누군지 모르겟는데 휴면 에러 이슈로 dx, dy 배열을 이상하게 만들어서 계속 16퍼센트에서 틀리더라는 이야기가 들리더라구요 ..\
![스크린샷 2025-02-24 오전 1.27.16.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202025-02-24%20%EC%98%A4%EC%A0%84%201.27.16.png)
