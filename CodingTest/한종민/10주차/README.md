## 과일 탕후루

처음 짠 코드 최적해를 구할 수 없는 코드였다.
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
