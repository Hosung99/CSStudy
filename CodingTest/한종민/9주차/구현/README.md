## 배열 돌리기

n번 회전 시켜야한다면 옆으로 n칸 한번에 움직여서 멋지게 계산하고 싶었지만, 수학 이슈로 구현하지 못하고 \
한칸씩 n번 움직이게 했습니다.

먼저 사각형의 맨 바깥 테두리부터 한겹씩 들어가면서 회전시켜주었고, 회전 시킬때 상,하,좌,우 따로 한칸씩 밀어주면서 회전시켜 주었다.\

```java
for (int i = 0; i < N; i++) {
    for (int j = 0; j < Math.min(C, R) / 2; j++) {
        int tmp = arr[j][j];
        for (int top = j; top < R - j - 1; top++) {
            arr[j][top] = arr[j][top + 1];
        }
        for (int right = j; right < C - j - 1; right++) {
            arr[right][R - j - 1] = arr[right + 1][R - j - 1];
        }

        for (int bottom = R - j - 1; bottom > j; bottom--) {
            arr[C - j - 1][bottom] = arr[C - j - 1][bottom - 1];
        }

        for (int left = C - j - 1; left > j; left--) {
            arr[left][j] = arr[left - 1][j];
        }
        arr[j + 1][j] = tmp;
    }
}
```
