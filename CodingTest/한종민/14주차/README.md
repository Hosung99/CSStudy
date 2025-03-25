## 계란으로 계란치기
처음엔 문제를 잘못이해해서 그냥 완탐으로 계란이 입력으로 들어온 계란 순서대로 몇개가 깨지는지 완탐으로 체크하는 코드를 만들었다. 
당연히 틀렸고, 재귀로 처음부터 어느 계란 부터 깨야 최대로 깰 수 있는지 확인해 주었다.
```
private static void backtracking(int index, int count) {
    if (index == N) {
        maxCount = Math.max(maxCount, count);
        return;
    }
    if (eggs[index][0] <= 0) {
        backtracking(index + 1, count);
        return;
    }

    boolean hit = false; // 하나라도 부딪힌 계란이 있는지 확인

    for (int i = 0; i < N; i++) {
        if (i == index || eggs[i][0] <= 0) continue; // 자기 자신이거나 이미 깨진 계란이면 skip

        // 현재 계란과 부딪히는 계란 충돌 처리
        eggs[index][0] -= eggs[i][1];
        eggs[i][0] -= eggs[index][1];

        // 깨어진 계란 개수 증가
        int brokenEggs = (eggs[index][0] <= 0 ? 1 : 0) + (eggs[i][0] <= 0 ? 1 : 0);

        // 백트래킹 진행
        backtracking(index + 1, count + brokenEggs);
        hit = true;

        // 상태 복구 (원래 상태로 되돌림)
        eggs[index][0] += eggs[i][1];
        eggs[i][0] += eggs[index][1];
    }

    // 부딪힐 수 있는 계란이 없었다면 그냥 다음 계란으로 이동
    if (!hit) {
        backtracking(index + 1, count);
    }
}
```

## 부분수열의 합
이문제또한 재귀로 모든 부분수열을 찾아내고 부분수열의 합이 S가 될때 count++해주었다. 
```
private static void backTracking(int i, int sum, int maxLen) {
    if (i == maxLen) {
        if (sum == S) {
            count++;
        }
        return;
    }
    for (int idx = 0; idx < N; idx++) {
        if (visited[idx] == 1) continue;
        visited[idx] = 1;
        backTracking(i + 1, sum + array[idx], maxLen);
        visited[idx] = 0;
    }
}
```
