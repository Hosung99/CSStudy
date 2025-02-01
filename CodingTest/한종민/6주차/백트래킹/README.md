# 로또
이전에 풀어봣던 문제였는데 시간이 좀 걸렸다 \
N과 M문제랑 완전히 똑같았는데 휴먼에러때문에 좀 오래걸렸다.\
중복없는 정렬된 리스트를 만들기위해 TreeSet을 사용했고, 이 set을 Int[]로 복사해주었다.

그리고 숫자 6자리 조합을 뽑을 수 있는 shallWeDance() 메서드를 만들고 6자리 조합이 만들어 졌다면 
숫자를 출력해 주었다!

```java
public static void shallWeDance(List<Integer> indexs, int num, int len) {
        if (indexs.size() >= 6) {
            for (Integer i : indexs) {
                System.out.print(copyNumbers[i] + " ");
            }
            System.out.println();
            return ;
        }
        for (int i = num; i < numbers.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                indexs.add(i);
                shallWeDance(indexs, i + 1, len + 1);
                indexs.remove(indexs.size() - 1);
                visited[i] = false;
            }
        }
    }
```

# 무기공학
방법은 대충 맞췃지만 출력이 제대로 안되어서 답을 찾아보았다.

3차원 dfs는 처음 해봐서 디버깅이 좀 힘들었던 것 같다. 
블로그를 찾아보니 6개 경우의 모든 예외처리를 일일히 해주는 사람들이 좀 있었는데 한번에 처리하기 위해서 조건을 좀 생각하느라 좀 어려웠다.

```java
private static boolean isPossible(int i1, int i2, int j1, int j2) {
        if (i1 < 0 || i2 < 0 || i1 >= N || i2 >= N) {
            return false;
        }
        if (j1 < 0 || j2 < 0 || j1 >= M || j2 >= M) {
            return false;
        }
        if (visited[i1][j1]) return false;
        if (visited[i2][j2]) return false;
        return true;
    }
```
