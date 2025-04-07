# 문제 1 팰린드롬?

## 문제 흐름

dp를 이용하여 푼다는 것 까지 체크하고, 점화식도 찾았다!

근데.. 생각보다 초기화해주는 부분이 어려웠다. 한 30분정도 고민하다가 코드를 찾아보았다.

다들 길이 1,2를 하드코딩하고 3의 경우를 이중반복으로 돌면서 체크해주는걸 알게되었다.

점화식의 경우 길이가 1(대각선)을 초기화하고 2,3을 초기화해주면? 오른쪽 위 대각선으로는 다 팰린드롬이다!

## 코드 설명

```js
for (let i = 1; i <= N; i++) {
  dp[i][i] = true;
}
for (let i = 1; i <= N - 1; i++) {
  if (arr[i] === arr[i + 1]) {
    dp[i][i + 1] = true;
  }
}
for (let len = 3; len <= N; len++) {
  for (let i = 1; i <= N - len + 1; i++) {
    let j = i + len - 1;
    if (arr[i] === arr[j] && dp[i + 1][j - 1]) {
      dp[i][j] = true;
    }
  }
}
```

# 문제 2 돌 그룹

## 문제 흐름

이 문제를 풀 때 쯤.. '아 문제 개어렵게 냈네' 라고 느꼈다.

이게 bfs인지도 몰랐었다.. (dfs도 풀 수 있을것 같기도하고?)

완탐으로 하려다가.. 정확히 45분 고민하고 찾아보았다.

근데 찾아보아도 이해가 힘들었다.

이해한 바로는 돌 선택을 bfs로 하고, visited를 갱신한다.

이 때 sort를 해서 가지치기를 해준다.

참고로 나머지가 3이 아니라면 3의배수가 아니므로 처음에 cut해줬다.

막상 코드 보니, 짧고 이해가 쉽다.. 아이디어가 어려웠던 문제.

## 코드 설명

```js
for (const [x, y] of pairs) {
  if (x === y) {
    continue;
  }

  const small = Math.min(x, y);
  const large = Math.max(x, y);
  const newSmall = small * 2;
  const newLarge = large - small;

  const newThird = sum - newSmall - newLarge;
  const stones = [newSmall, newLarge, newThird].sort((a, b) => a - b);

  if (!visited[stones[0]][stones[1]]) {
    visited[stones[0]][stones[1]] = true;
    queue.push([stones[0], stones[1]]);
  }
}
```

# 문제 3 댄스파티

## 문제 흐름

쉬운듯 어려운 문제이다.

정렬 해주고, 투포인터로 체크해주면 끝!

(진짜 이러면 끝)

## 코드 설명

```js
while (i < male_pos.length && j < female_neg.length) {
  if (male_pos[i] < female_neg[j]) {
    ans++;
    i++;
    j++;
  } else {
    i++;
  }
}
```

# 문제 4 움직이는 미로 탈출

## 문제 흐름

## 코드 설명

```js

```
