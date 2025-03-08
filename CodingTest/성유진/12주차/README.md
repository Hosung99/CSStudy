## [이 구역의 승자는 누구야?!](https://www.acmicpc.net/problem/20154)
### 문제 풀이 방식
각 원소를 두 개씩 뽑아서 더한 값을 임시 배열에 담아 두었다가 그 값을 기존 배열에 다시 옮겨서 구현하였습니다.  
해당 로직을 `matchAndSum` 이라는 이름의 함수로 분리하여 구현하였습니다.  
원소를 자주 넣었다 빼야 하고 배열에서 빼낸 값을 다른 배열에 옮기기도 해야해서 Queue를 사용하였습니다.


## [지구 온난화](https://www.acmicpc.net/problem/5212)
### 문제 풀이 방식
이렇게 두 가지 문제를 해결하면 되었습니다.
1. 바다에 잠기는지 여부
2. 땅을 포함한 최소 범위만 출력

1번은 입력받은 지도의 가장자리를 모두 . 으로 채운 후에 네 방향을 확인해서 result 배열을 수정하여 해결하였습니다.

2번은 result배열을 갱신할 때마다 minI, maxI, minJ, maxJ를 확인하며 함께 갱신시켜주며 해당 범위만 출력되도록 하였습니다. 
```java
int minI = R, maxI = 1, minJ = C, maxJ = 1;
for (int i = 1; i <= R; i++) {
  for (int j = 1; j <= C; j++) {
    melt(i, j);
    if (result[i][j] == 'X') {
      minI = Math.min(minI, i);
      maxI = Math.max(maxI, i);
      minJ = Math.min(minJ, j);
      maxJ = Math.max(maxJ, j);
    }
  }
}
```
