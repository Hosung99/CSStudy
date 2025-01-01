# 그림
전형적인 bfs dfs문제라고 생각했다.

dfs 함수 호출이 될때마다 그림의 사이즈인 len을 ++ 해주었고, max값과 비교하여 max값을 갱신해주었다.
```java
public static void dfs(int i, int j) {
    if (i < 0 || i >= N || j < 0 || j >= M)
        return ;
    if (arr[i][j] == 0 || visited[i][j] != 0)
        return ;
    len++;
    visited[i][j] = 1;
    dfs(i + 1, j);
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i, j - 1);
}
```

# 빙산

예ㅖㅖㅅ날에 풀었던 문제여서 쉽게 풀수 있을 거라 생각했는데 좀 많이 어려웠다. 

먼저 빙산이 쪼개졌는지 확인하는 함수가 필요했다. 이 함수를 dfs를 통해서 배열 묶음 갯수를 카운트해서 빙산의 갯수를 확인했다. 
```java
private static int checkIceBreak() {
    int count = 0;
    visited = new boolean[301][301];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arr[i][j] != 0 && !visited[i][j]) {
                dfs(i, j);
                count++;
            }
        }
    }
    return count;
}
```

다음 매년 시간이 지날때마나 인접한 바다의 개수만큼 빙산을 녹이는 함수. \
이 함수는 dy, dx를 통해 해당 인덱스의 상하좌우를 확인하여 바다 갯수를 카운트 하고 갯수만큼 빙산의 수를 감소시켰다.\
이 함수에서 visited 함수가 필요한 이유는 바로 옆 인덱스가 같은 년도에 빙산으로 살아남아 있었는데, 방금 바다 숫자만큼 빼버려서 0이 되어 바다로 오해 받는 상황을 없애기 위해서 필요했다. \
```java
private static void Melt() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[] rangeX = {1, -1, 0, 0};
        int[] rangeY = {0, 0, 1, -1};

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 ){
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int dx, dy;
        while (!q.isEmpty()) {
            Pair ice = q.poll();

            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.
            for (int i = 0; i < 4; i++) {
                dx = ice.x + rangeX[i];
                dy = ice.y + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && arr[dx][dy] == 0) {
                    seaNum++;
                }
            }
            if (arr[ice.x][ice.y] - seaNum < 0) {
                arr[ice.x][ice.y] = 0;
            } else {
                arr[ice.x][ice.y] -= seaNum;
            }
        }
    }
```
