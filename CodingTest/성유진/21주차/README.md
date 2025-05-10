## [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/388353)
### 문제 풀이 방식
각 컴퓨터를 순회하여 방문하지 않은 노드라면,
정답 수를 하나씩 증가하고 bfs로 순회하여 인접한 컴퓨터를 모두 방문하도록 하였습니다.


## [숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987)
### 문제 풀이 방식
처음엔 완전 탐색인가 했지만 역시나 시간초과가 나서, 그리디로 해결하였습니다.  
A팀을 이길 수 있는 가장 작은 점수를 찾아서 매칭해주었습니다.

`Collections.binarySearch`를 활용해서 A팀의 점수를 확인하면서 해당 점수보다 큰 B팀의 점수 인덱스를 찾고, 해당 점수는 리스트에서 제거해주었습니다.

- Collections.binarySearch의 반환값
  - key가 존재 O : key의 인덱스
  - key가 존재 X : -(삽입 위치) - 1 (index < 0)
  ![key가 존재하지 않는 경우](image.png)

중복되는 원소가 있는 경우는 인덱스가 랜덤으로 반환되지만 해당 문제에서는 위치가 중요한 것은 아니기 떄문에 찾은 값은 바로 삭제하는 방식으로 구현하였습니다.

```java
 // 점수보다 더 큰 수의 위치 찾기
int idx = Collections.binarySearch(listB, A[i] + 1);

// 정확한 값이 없는 경우, 더 큰 수의 위치로 설정
if (idx < 0) {
    idx = -idx - 1;
}
// 리스트에서 제거 및 점수 증가
if (idx < listB.size()) {
    listB.remove(idx);
    answer++;   
}
```