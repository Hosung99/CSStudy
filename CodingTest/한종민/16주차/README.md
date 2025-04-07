## 팰린드롬?

문제를 보았을 때는 dp를 쓰는게 맞아 보이는데,,, 어떻게 식을 세울지 몰라 일단 n^3으로 dp 배열을 완성하여 제출해 보았다.
```java
dp = new int[N][N];
for (int i = 0; i < N; i++) {
    for (int j = i; j < N; j++) {
        boolean isPalindrome = true;
        int left = i;
        int right = j;
        while (left < right) {
            if (!nums.get(left).equals(nums.get(right))) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        dp[i][j] = isPalindrome ? 1 : 2;
    }
}
```
당연히 시간초과가 발생했고, 지피티와의 합작으로 n^2으로 dp배열을 완성하는 코드를 만들수 있었다.
```java
dp = new int[N][N];
for (int i = 0; i < N; i++) {
    dp[i][i] = 1; // 한 글자는 무조건 팰린드롬
}

for (int i = 0; i < N - 1; i++) {
    if (nums.get(i).equals(nums.get(i + 1))) {
        dp[i][i + 1] = 1; // 두 글자 팰린드롬
    }
}

// 길이가 3 이상인 부분
for (int len = 3; len <= N; len++) {
    for (int start = 0; start <= N - len; start++) {
        int end = start + len - 1;
        if (nums.get(start).equals(nums.get(end)) && dp[start + 1][end - 1] == 1) {
            dp[start][end] = 1;
        }
    }
}
```
먼저 한글자, 두글자는 팰린드롬인지 확인하기 쉬우니 먼저 결과를 dp배열에 저장해 놓고, 그 다음 3글자 이상 부터는 **마지막 글자와 첫글자가 같고**, **중간에 끼인 문자열이 팰린드롬인가** 를 확인하여 결과를 저장하였다.\
중간에 끼인 문자열은 이미 나보다 글자수가 짧은 문자열이기 때문에 이전 반복문에서 결과를 구해놓았을 것이라는 가정 하에 dp 배열을 완성할 수 있다.

**너무 어렵다 데이네믹 프로그루ㅐ밍!**


## 돌그룹
이 문제가 bfs로 푸는건지도 감을 못잡았는데.. 답을 보고나니 bfs로 풀수 밖에 없는 문제엿다. \
그룹이 가질 수 있는 돌의 갯수를 visited 배열로 저장해 놓는다..라는 생각을 전혀 못했던 것 같다..\
또 3차원 배열로 다 저장해 놓으면 메모리 초과가 나므로 2차원 배열로 두개 의 그룹만 저장해 놓는 것도 전혀 생각 못했다. \
홀리 몰리


## 댄스파티
이건 왜 골드 4인가..? 실버 2쯤 될거같은데...?

이 문제는 크게 고민 하지 않고 그냥 키큰 사람원하는 pq, 키 작은사람 원하는 pq 이렇게 두 개씩 성별마다 만들어주었다.\
그리고 절댓값이 작은 순서대로 정렬 되었으니 두 pq에서 여자 한명, 남자 한명 뽑아서 서로 조건이 충족되면, 둘다 빼주고, 조건이 안되면 조건에 미달된 사람 한명만 뻬주었다.
```java
while (!smallMen.isEmpty() && !bigWomen.isEmpty()) {
    int man = smallMen.peek();
    int woman = bigWomen.peek();
    if (man > woman) {
        smallMen.poll();
        bigWomen.poll();
        count++;
    }
    else {
        smallMen.poll();
    }
}

while (!bigMen.isEmpty() && !smallWomen.isEmpty()) {
    int man = bigMen.peek();
    int woman = smallWomen.peek();
    if (man < woman) {
        bigMen.poll();
        smallWomen.poll();
        count++;
    }
    else {
        smallWomen.poll();
    }
}
```
