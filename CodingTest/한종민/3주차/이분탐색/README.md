# 수 찾기
전형적인 이분 탐색 문제


# 나무 자르기
이분 탐색을 조금 응용한 문제였던 것 같다. \
이 문제에서 캐치 못한 부분은 int 오버플로우 정도..? \
요거 때문에 2번 정도 틀렸었다.

***(배열에 들어 있는 각 나무들의 길이 - 현재 절단 높이)의 총 합이 상근이가 가져갈 나무의 총 길이와의 차이**가 
0보다 큰지 작은지에 따라 이분 탐색을 진행해주었다. \
아주 간단한 문제였다! 이지피지
```java
public static long checkTreeLength(long length) {
        long sum = Arrays.stream(arr)
                .mapToLong(num -> num - length)
                .filter(diff -> diff > 0)
                .sum();
        return sum - M;
    }


    public static void binarySearch(int min, int max) {
        int mid = (min + max) / 2;
        res = mid;
        if (min > max)
            return ;
        if (checkTreeLength(mid) == 0) {
            return ;
        }
        else if (checkTreeLength(mid) > 0)
            binarySearch(mid + 1, max);
        else if (checkTreeLength(mid) < 0)
            binarySearch(min, mid - 1);
    }
```

## 휴게소 세우기
아이디어를 떠올리기 굉장히 힘들어서 답지를 보았습니다.\
결국 휴게소의 간격을 이분탐색으로 찾는 문제였고, 해당 간격으로 M개를 더 놓을수 있는가? 가 요점이었다.\
해당 간격으로 M개를 놓을 수 있을때에도 더 최선의 거리를 찾기 위해 계속 이분 탐색을 들어가야 했고, \
결국 min > max 일때까지 계속 재귀를 들어가는 방식으로 구현했습니다.

```java
public static void binarySearch(int left, int right) {
        if (left > right) {
            return;  // 종료 조건: 탐색 범위가 좁아짐
        }

        int mid = (left + right) / 2;
        int count = 0;

        // 현재 mid 값에 따라 필요한 추가 휴게소 개수 계산
        for (int i = 1; i < arr.length; i++) {
            count += (arr[i] - arr[i - 1] - 1) / mid;
        }

        if (count > M) {
            // 필요한 휴게소 수가 많다면 mid 값을 증가시켜 탐색
            binarySearch(mid + 1, right);
        } else {
            // 현재 mid 값이 유효하므로 결과값 갱신
            res = mid;
            // 더 작은 mid 값을 탐색
            binarySearch(left, mid - 1);
        }
    }
```

