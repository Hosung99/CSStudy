# 문제 1 부분수열의 합

## 문제 흐름

수열특 정렬하면 안됨.

정렬 대신 조합을 짜서 조건에 만족하는지 계속 count해주었다.

중복이안되는 조합을 짰다.

## 코드 설명

```js
for (let i = depth; i < N; i++) {
  if (!visited[i]) {
    visited[i] = true;
    q.push(arr[i]);
    dfs(i + 1);
    visited[i] = false;
    q.pop();
  }
}
```

# 문제 2 계란으로 바위치기

## 문제 흐름

백트래킹을 할때 visited를 이용해서 체크해서 코드를 자주 짜곤했다.

근데 이건 방법이 안떠올라서.. 그냥 실제 배열에 값을 이용해서 백트래킹을 해주었다. 다음계란을 이용해서 깨고, 다시 돌려놓았다. 첨에 틀렸는데, dfs함수 밑에서 값을 체크하는 부분을 추가해서 맞았다. depth에 도달하지 않아도 답이 있을 수 있기때문에~

## 코드 설명

```js
for (let i = 0; i < N; i++) {
  if (arr[depth][0] <= 0) {
    dfs(depth + 1);
  } else if (depth === i || arr[i][0] <= 0) {
    continue;
  } else {
    arr[depth][0] -= arr[i][1];
    arr[i][0] -= arr[depth][1];
    dfs(depth + 1);
    arr[depth][0] += arr[i][1];
    arr[i][0] += arr[depth][1];
  }
}
```

# 문제 3 스도쿠

## 문제 흐름

문제는 어려워보이는데..? 생각보다 쏘이지 여기서도 마찬가지로 visited대신 실제값을 이용하여 백트래킹을 하였다.

0인 좌표들을 배열에 담아놓고 depth를 이용해서 좌표들에 값을 넣어주었다.

설명할게 없다. 그냥 문제대로 품~

## 코드 설명

```js
for (let num = 1; num <= 9; num++) {
  if (isPossible(x, y, num)) {
    arr[x][y] = num;
    dfs(depth + 1);
    arr[x][y] = 0;
  }
}
```

# 문제 4 죽음의 비

## 문제 흐름

사실 이번주 백트래킹만 조지려고했는데.. 문제 딱보니 bfs일 것 같았다. 일반적인 bfs인데 우산과 체력이 추가된 버전이다. 계속 틀려서 뭐가 문제인가 싶었는데.. 문제를 잘못읽었다. 일단 도착하고 우산이 있으면 우산으로 막고, 종료면 종료하는 것이었다. (체력이 0이여도)

## 코드 설명

```js
      if (arr[nx][ny] === "E") {
        ans = Math.min(ans, moves + 1);
        continue;
      }

      if (arr[nx][ny] === "U") {
        newUmbrella = D;
      }

      if (newUmbrella > 0) {
        newUmbrella--;
      } else {
        newHealth--;
      }

      if (newHealth <= 0) {
        continue;
      }

      if (visited[nx][ny] < newHealth + newUmbrella) {
        visited[nx][ny] = newHealth + newUmbrella;
        queue.push([nx, ny, newHealth, newUmbrella, moves + 1]);
      }
```
