# 문제 1 랭킹전 대기열

## 문제 흐름

문제를 읽고나서 input을 보았다.

읽고 든 생각은 '이거 구현이네.' 였다.

일단 방이 없으면 방을 만들어준다. 이때 배열형태로 기준이 되는 레벨과 사용자 배열을 만들어서 넣어준다.

방이 있다면 모든 방을 돌면서 기준 레벨 +-10이 되는지 확인한다.

기준 레벨이 된다면 인원수를 체크해준다.

방에 들어가면 flag를 키고 아무행동도 하지 않는다.

방에 안들어가면(flag가 꺼짐) 새로운 방을 만든다.

## 코드 설명

```js
let flag = true;
for (let j = 0; j < arr.length; j++) {
  if (Math.abs(arr[j].level - l) <= 10) {
    if (arr[j].player.length < m) {
      arr[j].player.push({ l, n });
      flag = false;
      break;
    }
  }
}
if (flag) {
  arr.push({ level: l, player: [{ l, n }] });
}
```

# 문제 2 문자열 교환

## 문제 흐름

간단해 보였는데 해결 못한 문제다.

투포인터로 이렇게 저렇게 잘해보려다가.. 실패했다. 찾아보니 슬라이딩 윈도우라는 개념이라고 한다.

슬라이딩 윈도우는 연속된 부분 배열을 다룰 때 유용한 기법이다.

이 문제에서는 문자열의 연속된 부분을 교환하는 것이기 때문에 슬라이딩 윈도우를 사용하여 해결할 수 있다.

윈도우사이즈를 우리가 원하는 a의 개수만큼 지정하고, 처음부터 부분수열의 개수를 세준다.

주의할점은 원형큐처럼 문자열이 이루어져있기에 인덱스 계산을 나머지연산을통해 잘해주었다.

## 코드 설명

```js
for (let i = 0; i < str.length; i++) {
  let temp = 0;
  let idx = 0;
  while (idx < windowSize) {
    let tempIdx = (i + idx) % str.length;
    if (str[tempIdx] === "b") temp++;
    idx++;
  }
  ans = Math.min(ans, temp);
}
```

# 문제 3 단축키 지정

## 문제 흐름

1번과 마찬가지로 input을 보고 무작정 구현을 했다.

우선 첫번째 알파벳을 확인해준다.

그 뒤 첫번째 단어부터 훑어보며 알파벳이 지정되었는지 체크해준다.

substring을 이용하여 대문자를 넣어주었다.

## 코드 설명

```js
for (let j = 0; j < str.length; j++) {
  if (flag2) {
    for (let k = 0; k < str[j].length; k++) {
      let idx = str[j][k].toLowerCase().charCodeAt() - 97;
      if (!arr[idx]) {
        str[j] =
          str[j].substring(0, k) + `[${str[j][k]}]` + str[j].substring(k + 1);
        arr[idx] = true;
        flag2 = false;
        break;
      }
    }
  }
}
```

# 문제 4 문자열 게임 2

## 문제 흐름

어쩌다보니 슬라이딩 윈도우가 또 나왔다.

여기선 문자 개수를 다 세어주고 세어준 개수를 바탕으로 윈도우 사이즈를 정해 개수를 세어주었다!

이번주는 문자열 관련 문제들이다보니 출력들이 하나같이 귀찮았다..

## 코드 설명

```js
for (let j = 0; j < W.length; j++) {
  const charIndex = W.charCodeAt(j) - 97;
  if (count[charIndex] < K) continue;

  let cnt = 0;
  for (let k = j; k < W.length; k++) {
    if (W[j] === W[k]) cnt++;

    if (cnt === K) {
      minLength = Math.min(minLength, k - j + 1);
      maxLength = Math.max(maxLength, k - j + 1);
      break;
    }
  }
}
```
