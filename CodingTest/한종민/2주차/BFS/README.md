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

