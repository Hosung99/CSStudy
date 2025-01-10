# 문제 1 다리 만들기

## 문제 흐름

일단 섬을 구분할 필요가 있다.

왜냐면, 다리로 이을 때, 출발 섬과 도착섬을 비교해야하기 때문이다.

그래서 bfs를 이용해서 섬을 구분했다. 2부터!

섬을 구분한 뒤, 2차원 배열을 돌면서, 다리라면? bfs를 시작해서 시작섬을 기록하고, 도착섬을 만나면, 거리를 비교해서 최소값을 갱신한다.

## 코드 설명

```js
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (visited[i][j] === false && arr[i][j] === 1) {
      fillLand(i, j);
    }
  }
}
```

```js
if (arr[curX][curY] !== 0 && arr[curX][curY] !== land) {
  return cnt - 1;
}
```

# 문제 2 트리 색칠하기

## 문제 흐름

문제가 길게 되어있지만, 핵심만 보자면 굉장히 쉽다.

답은, 부모와 자식의 색이 다르면? 그때 색칠하면 된다!

그래서, dfs를 돌면서, 부모와 자식의 색이 다르면, 색칠하면 된다.

## 코드 설명

```js
for (let next of graph[cur]) {
  if (!visited[next]) {
    if (arr[cur - 1] !== arr[next - 1]) {
      cnt++;
    }
    stack.push([next]);
  }
}

//1인덱스를 이용해서, -1을 해줬다.
```
