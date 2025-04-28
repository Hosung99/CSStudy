# 문제 1 디지털 티비

## 문제 흐름

첨에 문제 읽고.. 이게 브론즈?? 인가 싶었다.

근데 예제보니, 최단 횟수를 찾는게 아닌걸 눈치챘다. 그래서 1번과 4번버튼만 가지고 구현을했다.

## 코드 설명

```js
for (let i = 0; i < N; i++) {
  if (arr[i] === "KBS1") {
    ans += "1".repeat(i) + "4".repeat(i);
    arr.splice(i, 1);
    arr.unshift("KBS1");
  }
}
for (let i = 0; i < N; i++) {
  if (arr[i] === "KBS2") {
    ans += "1".repeat(i) + "4".repeat(i - 1);
  }
}
```

# 문제 2 A와 B 2

## 문제 흐름

처음엔 막.. 그리디하게 구현하다가 예외상황이 생겨서 방법을 찾아보았다.

다른 사람들은 Dfs로 풀더라.. 이렇게하니 구현이 짱쉬웠다.

맨 뒤글자에 따라서 'A'라면 맨 뒤 글자 삭제.
'B'라면 맨 뒤 글자 삭제 후, 뒤집기. 이런식으로 구현했다.

글자수가 50자라 직접 reverse해도 괜찮았다.

## 코드 설명

```js
if (t[t.length - 1] === "A") {
  let temp = t;
  temp = temp.slice(0, -1);
  dfs(s, temp);
}

if (t[0] === "B") {
  let temp = t;
  temp = temp.slice(1);
  temp = temp.split("").reverse().join("");
  dfs(s, temp);
}
```

# 문제 3 공유기 설치

## 문제 흐름

뭐 전형적인.. 이분탐색이죠?

정렬하고 라우터수를 센다음에 갱신해주었다.

## 코드 설명

```js
while (start <= end) {
  let router = 1;
  let mid = Math.floor((start + end) / 2);
  let st = arr[0];

  for (let i = 1; i < N; i++) {
    if (arr[i] - st >= mid) {
      router++;
      st = arr[i];
    }
  }

  if (router >= C) {
    ans = Math.max(ans, mid);
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}
```

# 문제 4 내리막 길

## 문제 흐름

사실 이 문제 추천받은 문제입니다..

bfs + dp라는 정신나간 조합으로 푸는 문제입니다..


## 코드 설명

```js
for (let dir = 0; dir < 4; dir++) {
  let nx = x + dx[dir];
  let ny = y + dy[dir];
  if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
    continue;
  }
  if (arr[x][y] > arr[nx][ny]) {
    if (visited[nx][ny] === -1) {
      visited[nx][ny] = dfs(nx, ny);
    }
    cnt += visited[nx][ny];
  }
}
```
