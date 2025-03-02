## 시험 감독
브론즈3이 원래 이렇게 어려웠나 싶었다. \
생각보다 어려워서 당황을 살짝 했지만 바로 컷 \
나누기 바로 해줬습니다.

## 볼 모으기
답은 안보고 풀어버렸다. 어캐햇누 \
빨간 공을 기준으로 뽑아야 한다면 \
앞에서 부터 공을 뽑다가 파란공이 나오면 flag를 1로 올리고 그 뒤로 빨간공이 나올때 마다 count++을 해줬다.\
이미 앞에는 파란공은 파란공끼리 빨간공은 빨강공끼리 뭉쳐있기때문이다.

```java
for (int i = 0; i < balls.length; i++) {
    if (balls[i] == 'B') flag = 1;
    if (flag == 1 && balls[i] == 'R') count++;
}
```
이런 방식으로 빨간공 기준 앞에서부터 한번, 뒤에서부터 한번\
파란공 기준 앞에서부터 한번, 뒤에서부터 한번 총 네번 구해서 min값을 출력했다. 


## 진우의 달 여행
전형적인 dfs인데 조금 다른건 이전 방향은 못간다는 점\
이전에 갔던 방향을 같이 담아서 stack에 넣어줬다.
```java
private static void dfs() {
    while (!stack.isEmpty()) {
        int[] cur = stack.pop();
        int cx = cur[0];
        int cy = cur[1];
        visited[cx][cy] = false;
        int count = cur[3];
        if (cx == N - 1) {
            min = Math.min(count, min);
        }
        int direc = cur[2];
        for (int j = 0; j < 3; j++) {
            if (j == direc) continue;
            int nx = cx + dx[j];
            int ny = cy + dy[j];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny]) continue;
            stack.add(new int[]{nx, ny, j, count + map[nx][ny]});
            visited[nx][ny] = true;
        }
    }
}
```

## 하늘에서 별똥별이 빗발친다
어려워서 답을 보았다.\
배열크기 때문에, 별똥별 기준으로 어떻게어떻게 해야하는거 까진 알겠는데, 그 어떻게어떻게가 어려웠다.\
풀이는 별 두개를 뽑아 그중 하나의 x와 다른 하나의 y를 통해 트램펄린 사각형을 만들고 그 안에 포함된 별이 최대가 되는 별의 수를 구했다.

```java
for(int[] s1: stars){
    for(int[] s2: stars){
        res = Math.max(res, countStar(s1[0], s2[1]));
    }
}
```
