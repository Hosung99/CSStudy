# 케빈 베이컨의 6단계 법칙
처음으로 플로이드-워셜이라는 알고리즘을 알게되었다.\
모든 최단 경로를 찾는 알고리즘으로 O(n^3)으로 동작한다.

케빈 베이컨의 문제와 딱 맞는 알고리즘인듯하다. \
플로이드 워셜을 사용하기 위해 2차원 인접배열을 만들었고, 입력을 저장해주고 비어있는 칸은 INT MAX로 할당해주었다.\
해당 인접배열을 모두 탐색하는 이중 포문을 반복하는 반복문을 만들어 최단거리를 갱신하는 방식으로 구현하였다.

```java
int ans = 0;
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
```
새로운 알고리즘은 언제봐도 신기하다 이걸 어떻게 생각해내는걸까?

