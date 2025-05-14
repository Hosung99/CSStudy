## [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)
### 문제 풀이 방식
백트래킹으로 한 단어만 차이가 나는지를 `possibleChange` 함수로 확인하며 방문하였습니다.  
타겟 단어를 찾은 경우 최솟값을 갱신하여 정답을 확인하도록 하였습니다.  
처음엔 answer값을 N으로 초기화해서 틀렸어가지고,, N+1로 초기화하여 찾지 못한 경우를 따로 분기해주었습니다
