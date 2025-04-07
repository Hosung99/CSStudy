# 문제 1 N과 M(11)

## 문제 흐름

이번주는 스스로 다 풀어서 기분이 좋다 ㅎㅎ

백트래킹이죠?

핵심은 본인의 index를 포함한다는거~

## 코드 설명

```js
for (let i = 0; i < arr.length; i++) {
  temp.push(arr[i]);
  dfs(depth + 1);
  temp.pop();
}
```

# 문제 2 스타트링크

## 문제 흐름

얼핏보면? Bfs같지가 않다.

하지만 자세히보면? 일차원 bfs라는 사실. U,D를 이용해 앞뒤로 이동한다고 생각하자.

## 코드 설명

```js
const dx = [U, -D];
while (q.length > 0) {
  const { curr } = q.shift();
  if (curr === G) {
    return;
  }
  for (let dir = 0; dir < 2; dir++) {
    const nX = curr + dx[dir];
    if (nX <= 0 || nX > F) {
      continue;
    }
    if (visited[nX] !== 0) {
      continue;
    }
    visited[nX] = visited[curr] + 1;
    q.push({ curr: nX });
  }
}
```

# 문제 3 선발명단

## 문제 흐름

쪼끔? 꼬은 백트래킹이다.

선발 조합을 구하고 구한 조합을 바탕으로 2차원배열의 값을 넣어서 최대값을 구했다.

생각보다 이지.

다만 첨에 시간초과가 났는데, Depth가 11이 되서 그런 것 같다. 그래서 값이 0이 아니라면 가지치기하여 통과했다.

## 코드 설명

```js
if (depth === 11) {
  mx = Math.max(mx, calc());
  return;
}
for (let i = 0; i < 11; i++) {
  if (!visited[i] && arr[depth][i] !== 0) {
    q.push(i);
    visited[i] = true;
    dfs(depth + 1);
    q.pop();
    visited[i] = false;
  }
}
```

# 문제 4 말이 되고픈

## 문제 흐름

bfs같긴한데 어떻게 구현할지 많이 고민했따..

일단 처음 생각난건 3차원으로 말 이동을 했는지를 기록하려고했다.

처음엔 0,1의 3차원배열을 생각했는데 아예 말 이동전체를 기록하려고 K개만큼 3차원 배열을 만들었다.

다행히 풀었따~

## 코드 설명

```js
while (q.length > 0) {
  let { curX, curY, kCnt, move } = q.shift();
  if (curX === H - 1 && curY === W - 1) {
    return move;
  }
  if (kCnt > 0) {
    for (let dir = 0; dir < 8; dir++) {
      let nX = curX + kdx[dir];
      let nY = curY + kdy[dir];
      if (nX < 0 || nY < 0 || nX >= H || nY >= W) {
        continue;
      }
      if (visited[nX][nY][kCnt - 1] !== -1 || arr[nX][nY] === 1) {
        continue;
      }
      visited[nX][nY][kCnt - 1] = move + 1;
      q.push({ curX: nX, curY: nY, kCnt: kCnt - 1, move: move + 1 });
    }
  }
  for (let dir = 0; dir < 4; dir++) {
    let nX = curX + dx[dir];
    let nY = curY + dy[dir];
    if (nX < 0 || nY < 0 || nX >= H || nY >= W) {
      continue;
    }
    if (visited[nX][nY][kCnt] !== -1 || arr[nX][nY] === 1) {
      continue;
    }
    visited[nX][nY][kCnt] = move + 1;
    q.push({ curX: nX, curY: nY, kCnt: kCnt, move: move + 1 });
  }
}
```
