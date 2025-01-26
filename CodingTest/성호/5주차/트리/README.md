# 문제 1 트리 순회

## 문제 흐름

이런 트리문제는 풀어본적이 없어서.. 답을 보고 구현해보았다.

찾아보니 일반적으로 트리 구현시엔 객체를 이용한 재귀형태로 구현하는것이 대부분이였다.

A부터시작해서, 순회를 시작했다.. 코드는 뭐 이하생략

## 코드 설명

```js
preorder("A");
ans += "\n";
inorder("A");
ans += "\n";
postorder("A");
```

# 문제 2 트리의 지름

## 문제 흐름

이게 어려워보이는데 참쉬웠다.

트리에서 어떤 두 노드를 선택해도 둘 사이에 경로하나가 존재한다. 이때 두 노드를 선택해서 가장 길게늘어나는 경로의 길이를 트리의 지름이라고 한다.

근데 시작이 루트노드이다.

그래서 생각한 것이 루트노드에서 dfs를 해서 가중치가 가장 긴 노드를 찾고 위에서 말한 어떤 노드를 선택해도 경로가있다는걸 이용해서, 가장 긴 노드에서 다시 dfs를 통해 트리의 지름을 구하였다.

이때 for of 랑 for in 차이가 궁금해서 찾아보았다.

for in 반복문은 객체의 속성들을 구분해서 반복문을 실행하는 친구이다. **객체의 키나 배열의 인덱스를 가져온다.**

for of 반복문은 Symbol.iterator 속성을 가지는 컬렉션에 사용하는 친구이다. **배열, 문자열, 맵, 셋 등의 실제 값을 가져온다.**

## 코드 설명

```js
let stack = [{ currNode: node, currDist: dist }];
visited[node] = true;
while (stack.length > 0) {
  const { currNode, currDist } = stack.pop();
  if (ans.dist < currDist) {
    ans = { node: currNode, dist: currDist };
  }
  for (let [nextNode, nextDist] of graph[currNode]) {
    if (!visited[nextNode]) {
      visited[nextNode] = true;
      stack.push({ currNode: nextNode, currDist: currDist + nextDist });
    }
  }
}

dfs(1, 0);
visited.fill(false);
dfs(ans.node, 0);
```
