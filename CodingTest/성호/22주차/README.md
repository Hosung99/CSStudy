# 문제 1 더 맵게

## 문제 흐름

이제는 피하지 않는 우선순위 큐문제이다.

제일 작은걸 꺼내서 스코빌 지수를 체크해줬다.

## 코드 설명

```js
while (heap.size() >= 2) {
  let min = heap.pop();
  let secondMin = heap.pop();
  if (min >= K) {
    break;
  }
  let newMin = min + secondMin * 2;
  heap.push(newMin);
  answer++;
}
```

# 문제 2 타겟 넘버

## 문제 흐름

이 문제도는 전형적인 dfs문제라고 생각했다.

구현은 간단하게 더한 값 뺀 값을 재귀시켜주었다.

## 코드 설명

```js
function dfs(depth, sum) {
  if (depth === numbers.length) {
    if (sum === target) answer++;
    return;
  }
  dfs(depth + 1, sum + numbers[depth]);
  dfs(depth + 1, sum - numbers[depth]);
}
```

# 문제 3 게임 맵 최단거리

## 문제 흐름

아니 이번주 문제 왤케쉽지하고 봤더니 Lv2문제가 3개였다.

전형적인.. bfs문제. 설명할게없네유

# 문제 4 N으로 표현

## 문제 흐름

하.. 좀 어려웠따. 역시 쉽지않은 LV3

40분정도 시도하고 결론적으론 풀지못했다.

DP의 규칙을 찾는데 실패했기 때문이다.

이게 무슨 규칙인지.. 이해가 안되어서 답을 찾아보았다.

dp[i]에는 N i개로 만들 수 있는 수의 집합이 들어간다.

dp[i + 1]에는 dp[i]로 만들 수 있는 수의 집합이 들어간다.

부가로.. number가 N이 될 수 있는 경우도 고려해야한다.

마지막 테케가 해당 케이스였다. ㅠ(요것땜에 15분 더 걸림)

## 코드 설명

```js
for (let j = 1; j < i; j++) {
  const leftGroup = dp[j];
  const rightGroup = dp[i - j];

  for (const a of leftGroup) {
    for (const b of rightGroup) {
      const results = [
        a + b,
        a - b,
        b - a,
        a * b,
        Math.floor(a / b),
        Math.floor(b / a),
      ];

      for (const result of results) {
        if (result > 0) {
          dp[i].add(result);
        }
      }
    }
  }
}
```
