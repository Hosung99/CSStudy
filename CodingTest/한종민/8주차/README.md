## 좋다

전형적인 투포인터 문제라고 생각하고 기계처럼 구현했다.
하지만 그 코드는 양수일 때만 잘 돌아가는 코드로 만들어 버렸다.

그래서 양수와 음수일 때를 구별해서 start를 ++ 할지 end를-- 할지 분기해서 구분하려고했다. 
그래서 탄생한 아래 코드, 처음 생각했던 아주 단단히 틀린 코드 구멍 천국 말도안되는 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] num;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedreader.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(bufferedreader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                while ((start < end) && num[start] + num[end] > num[i]) {
                    if (num[start] >= 0 && num[end] >= 0)
                        end--;
                    else if (num[start] < 0 && num[end] >= 0) {
                        if (Math.abs(num[start]) >= Math.abs(num[end])) {
                            start++;
                        }
                        else
                            end--;
                    }
                    else { //둘다 음수일 경우
                        start++;
                    }
                }
                if ((start < end) && (num[start] + num[end] == num[i]) && (num[end] > 0)) {
                    count++;
                    break;
                }
                if (num[start] >= 0 && num[end] >= 0)
                    start++;
                else if (num[start] < 0 && num[end] >= 0) {
                    if (Math.abs(num[start]) >= Math.abs(num[end])) {
                        end--;
                    }
                    else
                        start++;
                }
                else {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}

```

이렇게 생각했던 이유는 투포인터를 제대로 완벽하게 이해하지 못하고 있었기 때문이었던 것 같다.
이제는 마스터 했겟지..? 

그냥 투포인터를 제대로 구현하고, 자기 자신만 패스하게끔 구현하면 통과했다. 풀지는 못했지만 골드4 치고는 쉬운 문제였던 것 같다



## 성적평균

시간을 봣을 때 n^2으로는 절대로 풀수 없을 거라 생각해 dp처럼 뭔가 값을 저장해서 사용해야할거라 생각했다. 
처음 부터 각자 인덱스 까지의 합만 가지고 있으면 특정 인덱스부터 특정 인덱스 까지의 합을 알 수 있을 것이라 생각했다. 

```java
    for (int i = 2; i <= N; i++) {
        sum += grade[i];
        dp[i] = sum;
    }
```

거의 다 풀어갈때쯤 이게 누적합이라는 것을 깨달아버렸다. 홀리 몰리~

