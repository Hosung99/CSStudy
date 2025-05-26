# 문제 1 비밀 코드 해독

## 문제 흐름

중복이 안되는 조합을 만들어서, 해당 조합이 시스템응답수와 맞는지 체크했다. (3중 반복문)

## 코드 설명

```js
function isPossible() {
  for (let i = 0; i < q.length; i++) {
    let cnt = 0;
    for (let j = 0; j < 5; j++) {
      for (let k = 0; k < 5; k++) {
        if (q[i][j] === queue[k]) {
          cnt++;
        }
      }
    }
    if (ans[i] !== cnt) {
      return false;
    }
  }
  return true;
}
```

# 문제 2 야근 지수

## 문제 흐름

후.. 첨에 정렬하고 그리디하게 하다가.. 잘 안풀렸다. 정답을 찾아보니.. 엥? 우선순위큐네

패스.

하려다가? 그래도 이젠 피하기 싫었다. 그래서 우선순위큐 코드를 외워버렸다.

여기선 최대힙을 이용해서 맨앞에 항상 높은 값을 두고 값을 1 깎고 다시 Push하는 식으로 문제를 풀었다.

## 코드 설명

```js
class minHeap {
  constructor() {
    this.heap = [null];
  }
  size() {
    return this.heap.length - 1;
  }
  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
  push(value) {
    this.heap.push(value);

    let curIdx = this.heap.length - 1;
    let parIdx = (curIdx / 2) >> 0;

    while (curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]) {
      this.swap(parIdx, curIdx);
      curIdx = parIdx;
      parIdx = (curIdx / 2) >> 0;
    }
  }
  pop() {
    let min = this.heap[1];

    if (this.heap.length <= 2) this.heap = [null];
    else this.heap[1] = this.heap.pop();

    let curIdx = 1;
    let leftIdx = curIdx * 2;
    let rightIdx = curIdx * 2 + 1;

    if (!this.heap[leftIdx]) return min;
    if (!this.heap[rightIdx]) {
      if (this.heap[leftIdx] < this.heap[curIdx]) {
        this.swap(leftIdx, curIdx);
      }
      return min;
    }

    while (
      this.heap[leftIdx] < this.heap[curIdx] ||
      this.heap[rightIdx] < this.heap[curIdx]
    ) {
      const minIdx =
        this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx;
      this.swap(minIdx, curIdx);
      curIdx = minIdx;
      leftIdx = curIdx * 2;
      rightIdx = curIdx * 2 + 1;
    }
    return min;
  }
}
```

# 문제 3 단어변환

## 문제 흐름

각 단어를 노드라고생각하고 bfs로 탐색했다.

근데 min을 갱신하는 과정에서 우리가 찾는 단어가 없다면? Infinity가 갱신되지 않는다.

그래서 return문에서 삼항연산자로 한번 더 체크해주었다.

## 코드 설명

```js
let visited = { begin: true };
let q = [{ str: begin, depth: 0 }];
while (q.length > 0) {
  const { str, depth } = q.shift();
  if (str === target) {
    answer = Math.min(answer, depth);
  }
  for (let word of words)
    if (!visited[word] && isPossible(word, str)) {
      visited[word] = true;
      q.push({ str: word, depth: depth + 1 });
    }
}
```

# 문제 4 등굣길

## 문제 흐름

첨에 bfs로 하다가.. 이게 가지수를 체크하는거여서 실패했다.

그래서 답을 찾아보니.. dp라고 하네요? 엥? 왜 dp지.. 고민하다가 문제를 다시 읽어보니 오른쪽과 아래쪽으로만 이동에서 힌트를 찾았다.

이전 열과 이전행을 이용해 값을 저장하는식으로 dp를 구현할 수 있겠다 싶었다.

처음에 잘못한건, 첫행 첫열을 1로 초기화한거였다. 근데 만약에 [0][1]이 웅덩이라면? [0][2]로는 갈 수 없다.

그래서 첫 시작점만 1로 초기화하고 dp를 갱신했다.

## 코드 설명

```js
for (let [x, y] of puddles) {
  dp[y - 1][x - 1] = -1;
}
dp[0][0] = 1;
for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (dp[i][j] === -1) {
      dp[i][j] = 0;
      continue;
    }
    if (i !== 0) {
      dp[i][j] += dp[i - 1][j] % 1000000007;
    }
    if (j !== 0) {
      dp[i][j] += dp[i][j - 1] % 1000000007;
    }
  }
}
```
