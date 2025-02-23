# 문제 1 배열돌리기

## 문제 흐름

사실 예전에 c++로 풀어본 문제다..

음.. 상화좌우돌리는걸 for문으로 각각 구현을했다..

temp배열을 만들어서 값을 넣어주고 원래배열에 다시 넣어주는 방식으로 구현했다.

구현문제는 항상 리드미 쓸게없네

## 코드 설명

```js
for (let i = 0; i < Math.min(N, M) / 2; i++) {
  let x1 = i;
  let x2 = N - 1 - i;
  let y1 = i;
  let y2 = M - 1 - i;
  for (let j = x1 + 1; j <= x2; j++) {
    temp[j][y1] = arr[j - 1][y1];
  }
  for (let j = x2 - 1; j >= x1; j--) {
    temp[j][y2] = arr[j + 1][y2];
  }
  for (let j = y1 + 1; j <= y2; j++) {
    temp[x2][j] = arr[x2][j - 1];
  }
  for (let j = y2 - 1; j >= y1; j--) {
    temp[x1][j] = arr[x1][j + 1];
  }
}
```

# 문제 2 사다리타기

## 문제 흐름

배열을 이용해서 구현을 하려고했다.

물음표 라인을 저장을해놓고 '-'를 만나면 스왑을 하는식으로 구현했다.

js에선 repeat이란 문자열 관련 메소드가 있다.

이걸 이용하면 별찍기같은걸 쉽게 할 수 있다!

## 코드 설명

```js
for (let i = 0; i < k - 1; i++) {
  if (start[i] === result[i]) {
    ans += "*";
  } else if (start[i] === result[i + 1] && start[i + 1] === result[i]) {
    [start[i], start[i + 1]] = [start[i + 1], start[i]];
    ans += "-";
  } else {
    ans = "x".repeat(k - 1);
    break;
  }
}
```
