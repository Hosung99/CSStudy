# 문제 1 감시

## 문제 흐름

감시 되게 오랜만에 봤는데.. 여전히 못풀었습니다 ㅠ

기존에 cpp로 풀었는데 해당 풀이 참조했습니다.

원리 자체는 dfs를 이용해서 경우의 수를 다 따졌습니다. 이때 dir을 이용해서 상하좌우를 판별했습니다!

## 코드 설명

```
넘 길어서 패스
```

# 문제 2 미로 만들기

## 문제 흐름

한 20분? 만에 다풀었는데 답이 자꾸 생각과 다르게 나왔습니다...

딱봐도 bfs죠잉? 근데 visited를 무작정 갱신하면 최소 벽 부숨 회수를 못구합니다.

그래서 여기선 visited를 dist. 즉 거리라고 생각하고 갱신했습니다. 그런데도 틀렸다...

그래서 좀 찾아보니 0-1 bfs를 이용하면 된다고 하더라구요? 이게뭔데;;

대충 설명하자면 가중치를 고려해서 bfs를 하는거라고 합니다. 우선순위를 정해주는 느낌?

그래서 빈방을 큐에 먼저 넣고 (unshift), 벽을 나중에 넣습니다. (push)

## 코드 설명

```js
if (temp < visited[nx][ny]) {
  visited[nx][ny] = temp;
  if (arr[nx][ny] === "1") {
    q.unshift({ curX: nx, curY: ny, cnt: temp });
  } else {
    q.push({ curX: nx, curY: ny, cnt: temp });
  }
}
```

# 문제 3 트리의 부모 찾기

## 문제 흐름

bfs를 활용했다. 2차원배열처럼 간선을 저장했다.

트리의 부모는 바로 윗 단계이므로 더 타고갈 필요없이 바로 갱신만해주면 된다!

## 코드 설명

```js
for (let i = 0; i < arr[curr].length; i++) {
  let next = arr[curr][i];
  if (visited[curr] === next) {
    continue;
  }
  q.push(next);
  visited[next] = curr;
}
```

# 문제 4 효율적인 해킹

## 문제 흐름

바로 윗 문제 와 비슷하다. bfs를 활용했다.

다만 여기선 루트가 딱히 없다. 그래서 모든 정점에 대해 bfs를 돌려야 한다.

## 코드 설명

```js
for (let i = 0; i < arr[curr].length; i++) {
  const next = arr[curr][i];
  if (!visited[next]) {
    visited[next] = true;
    q.push(next);
    cnt++;
  }
}
```
