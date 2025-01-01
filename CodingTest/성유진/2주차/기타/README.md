## [DFS와 BFS](https://www.acmicpc.net/problem/1260)


### 문제 풀이 방식
인접 행렬과 인접 리스트 두 가지 방식으로 각 정점들의 연결 정보를 저장할 수 있는데, 둘 중 인접 리스트 방식을 선택하였습니다.

애초에 N개의 정점이면 정점의 번호는 1~N이라고 문제에서 정의되어 있었기 때문에, N+1크기의 `nodes` 배열을 만들어서 정점들의 연결 정보를 저장하였습니다.
- nodes[x]의 값 : x 정점과 연결된 정점들의 리스트 (오름차순으로 정렬된)

**BFS**  
현재 정점과 연결된 정점 중 방문하지 않은 정점을 모두 큐에 넣고,  
큐가 비어있을 때까지 큐의 원소들은 확인하는 작업을 반복합니다.

**DFS**  
현재 정점과 연결된 정점 중 방문하지 않은 정점을 방문하고 출력합니다.  
그리고 그 정점과 연결된 또 따른 정점을 반복하는 작업을 재귀로 진행합니다.  

### Queue Method
추가로, BFS를 구현하며 Queue를 사용하기 위해서 자바의 Queue에 대해서 알아보았습니다.
| **Operation** | **Method**   |
|---------------|--------------|
| **원소 삽입**   | `add(e)`, `offer(e)`|
| **원소 제거**   | `remove()`, `poll()` |
| **원소 조회**   | `element()`, `peek()` |

`add`, `remove`, `element`는 동작에 실패하면 예외를 반환합니다.  
반면, `offer`, `poll`은 실패하는 경우에 false를 반환하고, `peek`은 NULL을 반환합니다.

- [Interface Queue<E>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)
- [자바 [JAVA] - 자바 컬렉션 프레임워크](https://st-lab.tistory.com/142)