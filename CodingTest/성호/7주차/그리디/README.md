# 문제 1 택배

## 문제 흐름

첫 시도는 from을 기준으로 정렬을 해서 그리디하게 했었다. 제출해보니 틀렸다네.. 테케는 맞는데

그래서 질문게시판에서 예시들을 해보았는데? 안돌아가는 테케가 있었다.

나의 그리디가 정말 최적화된 방법이 아니었다.

1시간정도 고민을하고 답을 보았다.

정답은.. to를 기준으로 정렬을해서 먼저 뽑는 것이었다..

ㅠㅠ 거의 다풀었는데.. 아쉬었다.

그래서 박스들을 순회하면서 뽑는데, 각 마을마다 용량별로 채워넣는다. capacity배열에 저장!

## 코드 설명

```js
for (let box of arr) {
  let p = C;
  for (let i = box.from; i < box.to; i++) {
    p = Math.min(p, C - capacity[i]);
  }
  let mn = Math.min(p, box.cnt);
  if (mn > 0) {
    for (let i = box.from; i < box.to; i++) {
      capacity[i] += mn;
    }
    ans += mn;
  }
}
```
