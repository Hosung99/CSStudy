## 야근 지수
#### 1트 (테케는 맞는데, 채점 다틀리고 2개 맞음..)
```java
class Solution {
    public long solution(int n, int[] works) {
        int sum = 0;
        for (int i = 0; i < works.length; i++) {
            sum += works[i];
        }
        sum -= n;
        int div = sum % works.length;
        for (int i = 0; i < works.length; i++) {
            works[i] = sum / works.length;
            if (div > 0) 
                works[i] += 1 ;
            div--;
        }
        sum = 0;
        for (int i = 0; i < works.length; i++) {
            sum += works[i] * works[i];
        }

        return sum;
    }
}
```
#### 2트 (정확도 o, 효율성 x)
```java
import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        int loopCount = n;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (loopCount > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            if (num == 0) continue;
            num--;
            loopCount--;
            pq.add(num);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            sum +=  num * num;
        }
        return sum;
    }
}
```

#### 3트 (정확도o, 효율성x) \
음..효율성이 시간문제가 아닌가보다 시간은 더짧게 나오는데; 왜 틀리지? \
테스트 1 〉	실패 (17.57ms, 55.1MB) \
테스트 2 〉	실패 (24.83ms, 53.5MB)
```java
import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        int s = 0;
        for (int i = 0; i < works.length; i++)
            s += works[i];
        if (s <= n) return 0;
        Arrays.sort(works);
        
        while (n > 0) {
            int max_num = works[works.length - 1];
            if (max_num == 0) break;
            for (int i = works.length - 1; i >= 0; i--) {
                if (works[i] >= max_num) {
                    works[i] -= 1;
                    n--;
                }
                if (n == 0) break;
            }   
        }
        
        int sum = 0;
        for (int i = 0; i < works.length; i++) {
            sum +=  works[i] * works[i];
        }
        return sum;
    }
}
```
#### 4트 (정확도 o, 효율성 o) \
2트 방법이 큰 흐름은 맞는데 좀 틀린부분이 있엇나봐욥 수정해서 통과하긴 함.. \
테스트 1 〉	통과 (121.35ms, 70.8MB) \
테스트 2 〉	통과 (105.56ms, 70.4MB)
```java
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0) {
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max - 1);
            n--;
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            int w = pq.poll();
            sum += (long) w * w;
        }
        return sum;
    }
}

```
## 비밀코드해독


## 단어변환
방법은 맞췃는데 bfs에서 depth 길이 구하는 방법을 까먹어서 해당 방법만 찾아봣다.. 보통 큐에 depth도 같이 넣으려고 그냥 커스텀 클래스 만들거나 햇던 거 같은데.. 너무 귀찮아서 map을 만들어버렷다

## 등굣길
1트 \
처음 작성한 코드는 점화식은 제대로 세웠지만, \
첫째 열이나 행에 웅덩이가 있을경우 그 뒤로 등장하는 칸은 모두 가지 못하는 경로인데 갈수 있다고 판단하여 틀림.

```java
import java.util.*;

class Solution {
    public static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int answer = 0;
        for (int i = 0; i < puddles.length; i++) {
            if (puddles[0].length == 0) break;
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = 0;
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                
                if (dp[i][j] == 0) {
                    continue;
                }
                
                if (i == 0 || j == 0) {
                    dp[i][j] = (dp[i][j] == 0) ? 0 : 1;
                    continue;
                }
                if (dp[i][j] == -1) {
                    if (i - 1 >= 0) 
                        value += (dp[i - 1][j] % 1000000007);
                    if (j - 1 >= 0) 
                       value += (dp[i][j - 1] % 1000000007);
                    dp[i][j] = value % 1000000007;
                }
                
            }
        }

        
        return dp[n - 1][m - 1];
    }
}
```
2트
dp 배열 만드는 방법은 해당 dp 칸에 도달하기 바로 전의 위치(현재의 왼쪽, 위쪽) 두칸의 합을 현재 dp칸에 기록하는 방식 
```java
        // 물웅덩이 위치 표시
        for (int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            isPuddle[y][x] = true;
        }

        dp[0][0] = 1; // 시작점

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];

                dp[i][j] %= 1_000_000_007;
            }
        }

```
