## [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)
### 문제 풀이 방식
백트래킹으로 한 단어만 차이가 나는지를 `possibleChange` 함수로 확인하며 방문하였습니다.  
타겟 단어를 찾은 경우 최솟값을 갱신하여 정답을 확인하도록 하였습니다.  
처음엔 answer값을 N으로 초기화해서 틀렸어가지고,, N+1로 초기화하여 찾지 못한 경우를 따로 분기해주었습니다


## [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898)
### 문제 풀이 방식
사실 문제 분류가 보여버려서,,, DP인지 몰랐으면 좀 더 헤메었을 것 같습니다.  
아무튼, DP인걸 알아서 현재위치의 위와 왼쪽의 값을 더해서 구하면 된다는 점화식은 금방 떠올릴 수 있었습니다.

인자로 들어오는 웅덩이 위치 좌표를 주의하고, 시간 초과를 해결하는게 점화식을 구하는 것보다 어려웠던 문제,,,  
모든 좌표를 확인했더니 시간 초과가 발생해서 웅덩이인 경우에는 continue로 미리 처리해주었습니다.


## [비밀 코드 해독](https://school.programmers.co.kr/learn/courses/30/lessons/388352)
### 문제 풀이 방식
너무 비효율적으로 푼 것 같긴 하지만,  
문제에서 주어진 비밀코드의 최대숫자 n으로 만들 수 있는 5개짜리 숫자조합을 모두 만들었습니다.  
만든 숫자조합과 시도한 암호인 q를 비교해서 일치하는 개수가 ans와 일치하는지 확인해서 암호 후보가 가능한지 확인하였습니다.

```java
public boolean check() {
  for (int i = 0; i < M; i++) {
    // 만든 숫자 조합인 code와 시도한 암호로 주어진 qq 비교
    int cnt = 0;
    for (int j = 0; j < 5; j++) {
      if (code.contains(qq[i][j])) 
        cnt++;
    }
    // 비교해서 일치하는 개수와 입력받은 ansCnt 일치여부 확인
    if (cnt != ansCnt[i])
      return false;
  }
  return true;
}
```

## [야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927)
### 문제 풀이 방식
기존에는 남는 시간을 모두 더해서 분배하는 방식으로 구현하려 하였으나, 기존 작업량보다 더 많은 시간으로 분배할 수 없다는 점을 주의해야하는 문제였습니다  

그래서 가장 시간이 오래걸리는 작업부터 해결하는 방식(works에서 가장 큰 수부터 줄여나가는 방식)으로 해결하였습니다.  
가장 큰 수를 빠르게 찾아내기 위해서 PriorityQueue를 활용해서 가장 큰 수를 뽑고, 하나 줄이는 것을 반복하였습니다.
