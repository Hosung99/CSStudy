# 문제 1 과일탕후루

## 문제 흐름

처음엔, 바보처럼 단순 구현으로 풀려고했다.

앞에서 하나 빼고 뒤에서 하나빼고 이런식으로.. 근데 최적해가 아니라고 생각이 들었다.

그래서 다음 구현으로, 앞, 뒤에서 다른 개수의 최대 수를 구해서 그리디하게 하려고했다.

예를들면 1 1 1 5 2 2

이런식이면 앞에서 다른수를 만날때까지 개수를세고 뒤에서 만날때까지 개수를 세고 더 적은 걸 빼려고했다.

저기선 앞의 1은 3개 2는 2개이므로 2를 빼서

1 1 1 5 이런식으로 된다. 하지만 이건 최적해가 아니다.

이 문제는 부분수열에서 최대 개수를 구하는 식으로 정답이 아닌 케이스가 있게된다.

16
1 2 2 2 1 2 3 2 2 2 2 2 2 1 1 2

난 이 케이스에서 실패했다.. 그래서 다른 답을 찾아보았고 부분수열을 구하는식으로 구현을 하였다.

투포인터를 이용했고, start, end를 이용한다.

숫자의 개수를 셀 배열을 만들어서, end를 하나씩 움직이고 개수를 갱신해준다.

그러다 다른 숫자가 3개 이상이라면, start를 옮긴다.

end를 옮길때마다 max를 갱신해주면, 그때그때 부분수열의 개수를 세는셈이다!

## 코드 설명

```js
cntArr[arr[st]]++; // 처음 인덱스는 따로 빼준다. while문 안에서 갱신하면 여러번 갱신된다. end로만 갱신하다고 생각하면 된다.
while (st < N) {
  while (end < N) {
    end++;
    cntArr[arr[end]]++;
    if (checkCnt() > 2) {
      cntArr[arr[end]]--;
      ans = Math.max(ans, end - st);
      end--;
      break;
    } else {
      ans = Math.max(ans, end - st);
    }
  }
  cntArr[arr[st]]--;
  st++;
}
```

# 문제 2 인간-컴퓨터 상호작용

## 문제 흐름

일단 크기가 200,000 200,000이라 O(N^2)으로 문제를 해결할 수 없다.

그래서 누적합 느낌으로 풀이를 생각해보았다.

소프티어 풀어본 느낌의 누적합? 그때 보다 어려운느낌..? 2차원 배열을 이용해, 개수를 저장해주었다.

문자열의 크기만큼 빈 배열을 만들고 거기에 알파벳의 개수를 셀 배열을 넣어주었다.

만약 0이라면

0번째 인덱스까지의 해당 알파벳의 개수를 넣어주었다.

그럼 6은?

6까지의 개수를 센 샘이다.

그래서 구간이 1,4 라면?

1,4는 각각 0~1 , 0~4가 된다.

이걸 빼주게 되면 1~4까지의 구간의 알파벳 개수가된다~

type ERROR나서 왜그런건지 l,r이 string이였다. 자스 퉤.

## 코드 설명

```js
for (let i = 0; i < q; i++) {
  let [a, l, r] = input[i].split(" ");
  l = +l;
  r = +r;
  let charIndex = a.charCodeAt() - 97;
  let count =
    l === 0 ? arr[r][charIndex] : arr[r][charIndex] - arr[l - 1][charIndex]; // 0이면 r구간만 있으면 된다~
  ans += count.toString() + "\n";
}
```

# 문제 3 나이트의 이동

## 문제 흐름

그냥 뭐 딱봐도 Bfs죠?

나이트는 8군데 이동할 수 있으니, dx, dy를 잘 계산해서 설정해주면 됩니다~

예전에 c++로 풀어서 보니, Depth를 visited로 계산했더군요 int로. 예전에 나 좀 치네;

## 코드 설명

```js
//그냥 Bfs라 코드 생략~
```

# 문제 4 마법사 상어와 파이어스톰

## 문제 흐름

하 진짜 힘들었다..

돌리는 것만 답을 보고 나머지를 구현했다.

돌리는거 꿀팁찾았는데, 돌리는 네모의 개수를 구하면 좋다고 한다..!

다른사람들은 어떻게 돌리나 구글검색해봤는데 퍼킹 자바스크립트론 풀이가 없다.. 개화남그냥

여튼.. 돌리는 네모의 개수를 구해서 돌리는 영역을 구해준후 돌려줬다. 배열 저장해서 돌리기!

그리고 나머지는 뭐.. 그냥 bfs로 쉽게했다. 이렇게 보면 쉬워보이는데, 구현은 죽을맛.. 150줄이네

## 코드 설명

```js
const square = len / 2;
for (let number = 0; number < square; number++) {
  const startX = a + number;
  const startY = b + number;
  const endX = a + len - number - 1;
  const endY = b + len - number - 1;

  let xIdx = endX;
  let yIdx = startY;
  let idx = 0;
  const temp = [];

  // 왼쪽 저장
  for (let i = startX; i < endX; i++) {
    temp.push(arr[i][startY]);
  }

  // 위 이동
  for (let i = startX; i < endX; i++) {
    arr[i][startY] = arr[endX][yIdx++];
  }

  // 오른쪽 이동
  for (let i = startY; i < endY; i++) {
    arr[endX][i] = arr[xIdx--][endY];
  }

  // 아래 이동
  for (let i = endX; i > startX; i--) {
    arr[i][endY] = arr[startX][yIdx--];
  }

  // 임시 저장 이동
  for (let i = endY; i > startY; i--) {
    arr[startX][i] = temp[idx++];
  }
}
```
