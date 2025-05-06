# 문제 1 연산자 끼워넣기

## 문제 흐름

딱봐도 dfs같았다.

그래서 dfs로 조합을 만들고, 조합에 따라 연산자를 넣어서 계산했다.

여기서 핵심은 중복이 안되도록 Visited를 썼다는거.

## 코드 설명

```js
for (let i = 0; i < N - 1; i++) {
  if (!visited[i]) {
    visited[i] = true;
    tempArr.push(idxArr[i]);
    dfs(depth + 1);
    visited[i] = false;
    tempArr.pop();
  }
}
```

# 문제 2 넴모넴모

## 문제 흐름

이 문제 또한 dfs같았는데.. 좌표를 어떻게 계산해야할지 모르겠었다 ㅠ

답을 찾아보니 나머지 연산으로... 깔끔하게 푸는 걸 확인했다. 내 머리론.. 안나와.. ㅠㅠ 많이배워갑니다.

## 코드 설명

```js
let x = Math.floor(depth / M);
let y = depth % M;
dfs(depth + 1);
arr[x][y] = true;
dfs(depth + 1);
arr[x][y] = false;
```

# 문제 3 줄어드는 수

## 문제 흐름

첨에 완탐으로하다가.. 시간초과나서 (c++은 안날듯) 다른방법을 찾아보았다.

Dfs로 조합을 미리 만들어서 (dp마냥) 배열의 해당 인덱스를 출력했다!

## 코드 설명

```js
function dfs(num) {
  arr.push(num);

  let digit = num % 10;
  for (let i = 0; i < digit; i++) {
    dfs(num * 10 + i);
  }
}
```

# 문제 4 입국심사

## 문제 흐름

N이 100,000이라서 O(N^2)으로는 못풀겠다 싶었다.

이분탐색을 이용해서 풀려고했다. 그럼 어떤걸 이분탐색하느냐.. 시간 T를 이분탐색했다.

아니 근데 다 풀었는데 틀리길래 정답 게시판봤는데, 노드뭔가 이슈가있는듯..? 자꾸 틀리대요.. 뭐가틀림?;

## 코드 설명

```js
while (left <= right) {
  let count = 0;
  for (let i = 0; i < N; i++) {
    count += Math.floor(mid / arr[i]);
    if (count >= M) {
      break;
    }
  }

  if (count >= M) {
    answer = mid;
    right = mid - 1;
  } else {
    left = mid + 1;
  }
}
```
