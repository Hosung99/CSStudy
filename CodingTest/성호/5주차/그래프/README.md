# 문제 1 케빈 베이컨의 6단계 법칙

## 문제 흐름

문제를 자세히 읽어보자.

사람을 통해 사람을 찾아가는 문제이다.

근데 이때? 단계별로 케빈베이컨 수가 다르다.

다른사람을 통해갈수록 베이컨수가 올라가게된다. 그래서 bfs를 통해 사람을 통해갈수록 depth를 올려서 값을 더해주었다.

## 코드 설명

```js
queue.push({ idx: idx, depth: 1 });
visited[idx] = true;
while (queue.length > 0) {
  const { idx, depth } = queue.shift();
  kNum += depth;
  for (let next of graph[idx]) {
    if (!visited[next]) {
      visited[next] = true;
      queue.push({ idx: next, depth: depth + 1 });
    }
  }
}
```

# 문제 2 이분 그래프

## 문제 흐름

처음에 문제를 잘 이해하지 못했다.

집합을 둘로 나누라길래.. 진짜 두개로 나눠야하나 생각했는데, 그런 의미가 아니였다.

단순히 부모노드와 자식노드라는 두개의 집합으로 생각해보면 된다.

그래서 자식노드들끼리 만약 인접할 경우 이분그래프가 아니라고 판단하면 된다.

일반적으로 visited배열을 true, false로 사용하지만, 여기선 인접한 노드인지 판단하기 위해 1,-1을 이용했다.

그래서 해당 부모의 모든 자식들을 1로 둔다면, bfs중에 1이 나오면 인접하다고 판단하는 로직을 짰다.

## 코드 설명

```js
while (q.length > 0) {
  const curr = q.shift();
  for (let next of graph[curr]) {
    if (visited[next] === 0) {
      visited[next] = visited[curr] * -1;
      q.push(next);
    } else if (visited[next] === visited[curr]) {
      return false;
    }
  }
}
```
