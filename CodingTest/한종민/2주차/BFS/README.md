# 알고리즘 수업
문제 카테고리는 BFS이던데 풀다보니 DFS로 풀었습니다. 
먼저 정점과 간선을 입력 받고 map을 통해 그래프를 만들어 주었습니다.
정점의 수로 키로 가지고, 연결된 간선을 list형태로 value에 넣어주었습니다.
그 후 연결된 간선들을 오름차순으로 방문하기 위해 정렬 시켜 주었습니다.
```java
for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
}
for (List<Integer> neighbors : graph.values()) {
    Collections.sort(neighbors);
}
```
평소에는 visited배열을 방문 유무만을 기록하였지만 이 문제에서는 만들어진 그래프를 visted 배열에 몇번째로 방문되었는지 기록해두었습니다.


## ABCDE

해당 문제도 마찬가지로 알고리즘 수업과 같이 그래프를 만들어 dfs를 했습니다. \
다른 점은 각 노드마다 방문 순서를 기록할 필요가 없다는 것이다. \
따라서 일정 깊이 이상만 dfs가 진행된다면 ABCDE가 존재한다고 생각하고 출력을 해주었다. 

근데 이해가 잘 안되는 부분은 깊이가 노드 개수만큼 들어가야한다고 생각하고 구현을 했는데 계속 틀려서 답을 보니 5까지만 들어가면 된다라는 내용이었다.

```java
if (depth == 5) {
    flag = true;
    return ;
}
```
문제가 ABCDE 라서 5까지만 들어가면 되는가보다라고 납득만 하고 넘어갔는데 확실한지는 잘 모르겠담..


