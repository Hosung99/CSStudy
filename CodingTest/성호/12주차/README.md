# 문제 1 쉽게 푸는 문제

## 문제 흐름

어렵게 고민하다가 문제 제목처럼 쉽게 풀었다.

문제에서 요구하는대로 배열을 만들고 slice로 부분을 자른다음에 합을 구했따.

수학적으로 배열을 안만들고 풀 수 있을거 같긴한데.. 누가 해주나?

## 코드 설명

```js
for (let i = 1; i <= 1000; i++) {
  for (let j = 0; j < i; j++) {
    arr.push(i);
  }
}
let tempArr = arr.slice(A - 1, B);
return tempArr.reduce((acc, cur) => acc + cur);
```

# 문제 2 애너그램

## 문제 흐름

백트래킹으로 5분 컸내고 바로 제출! (나좀 치는데? 라고생각했는데)

바로 메모리 초과가 났다.

엥 왜? 하고 문제를 읽어보니 '입력받은 단어내에 몇몇 철자가 중복될 수 있다. 이 경우 같은 단어가 여러 번 만들어 질 수 있는데' 라는 문구가 있었다.

그냥 넘어갔는데, 길이가 20글자인데 다 중복되면 문제가 될 거 같았다. 그래서 dfs단계에서 set을 이용해 글자 중복을 체크하고 배열을 만들었다!

## 코드 설명

```js
let usedChar = new Set();
for (let i = 0; i < str.length; i++) {
  if (!visited[i]) {
    if (usedChar.has(str[i])) {
      continue;
    }
    arr.push(i);
    usedChar.add(str[i]);
    visited[i] = true;
    dfs(depth + 1);
    arr.pop();
    visited[i] = false;
  }
}
```

# 문제 3 부분합

## 문제 흐름

보자마자 투포인터가 떠올랐다.

start와 end를 두고 end를 증가시키면서 합이 S보다 작으면 end를 증가시키고, S보다 크면 start를 증가시키는 방식으로 풀었다.

여담으로 0일때 잘못해서 틀렸따 ㅎㅎ;

## 코드 설명

```js
while (start < N) {
  if (sum < S && end < N) {
    sum += arr[end];
    end++;
  } else {
    if (sum >= S) {
      ans = Math.min(ans, end - start);
    }
    sum -= arr[start];
    start++;
  }
}
```
