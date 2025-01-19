# 문제 1 치킨 배달

## 문제 흐름

문제를 잘 요약해서 정리하자면...? 치킨 집들 중에서 M개를 골라서 치킨거리를 구하고 최소값을 출력하는 것이다!

그래서 nCm 조합을 만들고 조합에 따른 치킨거리를 갱신했다.

## 코드 설명

조합같은경우엔 중복이 안되도록 dfs를 이용해 구현했다.

```js
if (depth === M) {
  ans = Math.min(ans, calcDelivery());
  return;
}
for (let i = idx; i < chicken.length; i++) {
  if (!visited[i]) {
    visited[i] = true;
    comb.push(chicken[i]);
    dfs(depth + 1, i + 1);
    visited[i] = false;
    comb.pop();
  }
}
```

dfs로 depth가 M이 되면 치킨거리를 구하고 최소값을 갱신한다.

```js
for (let i = 0; i < home.length; i++) {
  let min = Infinity;
  for (let j = 0; j < M; j++) {
    let tmp = Math.abs(home[i].x - comb[j].x) + Math.abs(home[i].y - comb[j].y);
    min = Math.min(min, tmp);
  }
  sum += min;
}
```

# 문제 2 미세먼지 안녕!

## 문제 흐름

재밌게 푼 구현문제이다!

문제는 미세먼지 확산과 공기청정기 작동으로 나눠서 구현할 수 있다.

미세먼지 확산의 경우 dx dy를 이용해 상하좌우로 확산시킨다.

이때 포인트는 빙산문제처럼 임시 배열을 만들어서 확산 시키는 것이다. 그렇지 않으면 확산된 미세먼지를 가지고 다시확산을하기때문에 문제가 생긴다.

공기청정기 작동의 경우는 위쪽과 아래쪽을 나눠서 구현했다.

이렇게보니 더러운데.. 구현문제니까..! 어떻게든 구현했다.

## 코드 설명

확산

```js
function diffuse() {
  const tempBoard = board.map((row) => [...row]);

  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (tempBoard[i][j] > 0) {
        let dirCnt = 0;
        let amount = Math.floor(tempBoard[i][j] / 5);

        for (let dir = 0; dir < 4; dir++) {
          let nx = i + dx[dir];
          let ny = j + dy[dir];
          if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
            continue;
          }
          if (tempBoard[nx][ny] === -1) {
            continue;
          }
          board[nx][ny] += amount;
          dirCnt++;
        }
        board[i][j] -= amount * dirCnt;
      }
    }
  }
}
```

공기청정기 작동

```js
function doAirCondition() {
  let airPos = -1;
  for (let i = 0; i < R; i++) {
    if (board[i][0] === -1) {
      airPos = i;
      break;
    }
  }
  for (let i = airPos - 1; i > 0; i--) {
    board[i][0] = board[i - 1][0];
  }
  for (let j = 0; j < C - 1; j++) {
    board[0][j] = board[0][j + 1];
  }
  for (let i = 0; i < airPos; i++) {
    board[i][C - 1] = board[i + 1][C - 1];
  }
  for (let j = C - 1; j > 1; j--) {
    board[airPos][j] = board[airPos][j - 1];
  }
  board[airPos][1] = 0;
  for (let i = airPos + 2; i < R - 1; i++) {
    board[i][0] = board[i + 1][0];
  }
  for (let j = 0; j < C - 1; j++) {
    board[R - 1][j] = board[R - 1][j + 1];
  }
  for (let i = R - 1; i > airPos + 1; i--) {
    board[i][C - 1] = board[i - 1][C - 1];
  }
  for (let j = C - 1; j > 1; j--) {
    board[airPos + 1][j] = board[airPos + 1][j - 1];
  }
  board[airPos + 1][1] = 0;
}
```
