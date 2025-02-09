# 문제 1 택배

## 문제 흐름

사실 왜 이분탐색해야하나싶다.

O(N^2)까지 될거같은데.. 이분탐색안한사람?

그냥 간단하게 이분탐색했다.

수를 하나 선택하고 해당 수를 없앤 배열을 만들어 해당배열에서 이분탐색을했다~

## 코드 설명

```js
function binarySearch(findNum) {
  const list = [...arr.slice(0, findNum), ...arr.slice(findNum + 1)];
  let [left, right] = [0, N - 1];
  while (left < right) {
    const mid = list[left] + list[right];
    if (mid === arr[findNum]) {
      return 1;
    }
    if (arr[findNum] > mid) {
      left++;
    } else {
      right--;
    }
  }
  return 0;
}
```
