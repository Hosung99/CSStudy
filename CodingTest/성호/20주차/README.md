# 문제 1 지게차와 크레인

## 문제 흐름

뭔가 딱봐도 구현느낌.. 인데 생각보다 복잡했다.

기본적으로 requests[i]의 length에 따라 분기를 나눴다. (지게차를 쓸지, 크레인을 쓸지)

크레인 구현은 간단하게 일치하는 문자라면 빈 문자열로 바꿔서 채웠다.

지게차 구현이 좀 어려웠는데 bfs를 응용했다. 범위를 벗어난다면? 외부창고랑 연결된 것이므로 빈문자열로 바꿔줬다.

처음에 틀렸던게, 4방향으로 주변만 체크해서 틀렸었다. bfs를 이용해서 반드시 인덱스를 탈출하는지 확인해야 했다.

근데 visited를 갱신해야해서 메모리적으론 비효율인 느낌.. 근데 다 이렇게 푸는듯?

## 코드 설명

```js
if (arr[i][j] === input) {
  let flag = true;
  let q = [{ curX: i, curY: j }];
  let visited = Array.from({ length: arr.length }, () =>
    Array(arr[i].length).fill(false)
  );
  visited[i][j] = true;
  while (q.length > 0) {
    const { curX, curY } = q.shift();
    for (let dir = 0; dir < 4; dir++) {
      let nx = curX + dx[dir];
      let ny = curY + dy[dir];
      if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[i].length) {
        flag = false;
        break;
      } else {
        if (arr[nx][ny] === " " && !visited[nx][ny]) {
          q.push({ curX: nx, curY: ny });
          visited[nx][ny] = true;
        }
      }
    }
  }
  if (flag) {
    tempStr += arr[i][j];
  } else {
    tempStr += " ";
  }
} else {
  tempStr += arr[i][j];
}
```

# 문제 2 네트워크

## 문제 흐름

딱봐도 bfs아님 dfs죠?

bfs가 구현이 편할것 같아서 bfs로 구현했습니다.

visited체크를하면서, bfs를 시작할지 체크했습니다. bfs를 시작한다면? 이어지지 않는 새 네트워크 이므로 answer++ 했슴다.

## 코드 설명

```js
function bfs(i) {
  answer++;
  let q = [i];
  visited[i] = true;
  while (q.length > 0) {
    const curr = q.shift();
    for (let temp of arr[curr]) {
      if (!visited[temp]) {
        q.push(temp);
        visited[temp] = true;
      }
    }
  }
}
```

# 문제 3 숫자게임

## 문제 흐름

문제를 읽고 처음 든 생각은 2개였다.

input이 100,000이니까 O(N^2)은 안되겠다. 어떻게 최적화하지?

1. 이분탐색
2. 투포인터

처음엔 이분탐색으로 하려고했다. 이분탐색하는 값은 인덱스라고 가정을하고, 하려고했는데.. 뭔가 잘 안됐다.

그래서 투포인터로 하려고했는데, A가 고정되어있다고 생각해서 안될거라고 생각했다.

40분지나고, 답을 찾아보았다.

WTF? A도 그냥 정렬해버리네;; 이게뭔... 쨌든 짜증이났다.

A,B를 둘다 정렬하고 투포인터를 이용해 값을 비교한다.

만약에 B값이 더 크다면 B값의 포인터를 증가한다. 진짜 개짜증..

## 코드 설명

```js
while (left < A.length) {
  if (A[left] < B[right]) {
    right++;
    answer++;
  }
  left++;
}
```

# 문제 4 인사고과

## 문제 흐름

처음에 구현한건, 코드가 너무 더러웠다.

첫 점수를 기준으로 정렬하고, Mx값들을 index와 함께 저장했다.

그래서 만약 두 점수가 mx값보다 작다면 인덱스를가지고 나머지값들을 비교했다.

그렇게 풀었는데.. 정답보니 훨씬 깔끔하게 푼게있어서 이걸로 냅니다. ㅎㅎ

## 코드 설명

```js
scores.sort((a, b) => {
  return a[0] === b[0] ? a[1] - b[1] : b[0] - a[0];
});
let max = scores[0][1];
for (let i = 0; i < scores.length; i++) {
  const score = scores[i];
  if (score[1] < max) {
    if (score[0] === wanho[0] && score[1] === wanho[1]) {
      return -1;
    }
  } else {
    max = Math.max(max, score[1]);
    if (score[0] + score[1] > wanho[0] + wanho[1]) {
      answer++;
    }
  }
}
```
