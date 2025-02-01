# 문제 1 로또

## 문제 흐름

전형적인 백트래킹 문제이다. 6개의 숫자를 뽑는 조합을 구하는 문제이다.

사실 N과 M시리즈와 거의 똑같아서.. 설명할게없다.

## 코드 설명

```js
for (let i = idx; i < k; i++) {
  if (!visited[i]) {
    visited[i] = true;
    arr.push(inputArr[i]);
    dfs(depth + 1, i + 1);
    arr.pop();
    visited[i] = false;
  }
}
```

# 문제 2 무기 공학

## 문제 흐름

dx,dy로 4가지 무기의 방향을 정하고, 재귀로 백트래킹을 해야한단건 알겠는데.. 구현방법이 떠오르지 않아 정답을 보았다.

특히, 종료조건을 어떻게 설정해야할지 감이 안잡혔는데 잘 푼 코드를 보니 가로 종료조건에서만 종료를 시키면 되었다.

왜냐면 y축 으로는 끝에도달하면, 시작점을 0행의 다음좌표로 지정해야하기 때문에, 첫행의 가로에 대해 종료조건만 달아주면 됐었다.

그리고 3점의 좌표가 필요하므로(부메랑의 모양) 3가지의 Visited를 True,false설정을 해주었다.

코드의 제일 핵심은 재귀호출하는 부분이라고 생각한다.

## 코드 설명

```js

//재귀를 계속호출하는 부분이다.
if (!visited[x][y]) {
  for (let i = 0; i < 4; i++) {
    const [x1, y1] = [x + dx[i][0], y + dy[i][0]];
    const [x2, y2] = [x + dx[i][1], y + dy[i][1]];
    if (
      x1 < 0 ||
      N <= x1 ||
      y1 < 0 ||
      M <= y1 ||
      x2 < 0 ||
      N <= x2 ||
      y2 < 0 ||
      M <= y2
    ) {
      continue;
    }
    if (visited[x1][y1] || visited[x2][y2]) {
      continue;
    }
    visited[x1][y1] = true;
    visited[x2][y2] = true;
    visited[x][y] = true;
    if (y === M - 1) {
      dfs(x + 1, 0, cnt + board[x][y] * 2 + board[x1][y1] + board[x2][y2]);
    } else {
      dfs(x, y + 1, cnt + board[x][y] * 2 + board[x1][y1] + board[x2][y2]);
    }
    visited[x1][y1] = false;
    visited[x2][y2] = false;
    visited[x][y] = false;
  }
}

//이 부분은 위에 for문에서 dfs로 쭉 타고들어가고 나오게되면 중점의 좌표를 옮기는 부분이다.
if (y === M - 1) {
  dfs(x + 1, 0, cnt);
} else {
  dfs(x, y + 1, cnt);
}
```
