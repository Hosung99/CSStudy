# 치킨 배달

그냥 구현 + 완탐 + 이전에 해봣던 재귀, 백트래킹 이라 방법 구상은 어렵지 않았던것 같다.

배열 길이이에 비해 시간이 넉넉해서 완탐으로 해버리기로 결정했다.\
코드 진행 순서 
1. 망하지 않는 치킨집 목록 백트래킹으로 리스트로 만들어 놓기
```java
    private static void makeChickenPermutation(int length, List<Integer> tmpChicken) {
        if (length == M) {
            List<Integer[]> array = new ArrayList<>();
        for (Integer i : tmpChicken)
            array.add(chicken.get(i));
            chickenPermutation.add(array);
            return;
        }
        int start = 0;
        if (length != 0)
            start = tmpChicken.get(length - 1) + 1;
        for (int i = start; i < chicken.size(); i++) {
            tmpChicken.add(i);
            makeChickenPermutation(length + 1, tmpChicken);
            tmpChicken.remove(tmpChicken.size() - 1);
        }
    }
```
2. 치킨집 리스트로 도시의 치킨거리 계산하러 가기
3. 도시의 치킨 거리 계산은 일반 집 갯수로 for문 돌면서 젤 가까운 치킨집 찾으면서 sum 변수에 추가
```java
    public static int calculator(List<Integer[]> chickens, List<Integer[]> houses) {
        int sum = 0;
        for (Integer[] house : houses) {
            int minLength = Integer.MAX_VALUE;
            for (Integer[] chicken : chickens) {
                int min = Math.abs(house[1] - chicken[1]) + Math.abs(house[0] - chicken[0]);
                minLength = Math.min(minLength, min);
            }
            sum += minLength;
        }
        return sum;
    }
```
4. EASY

오랜만에 답 안보고 풀어버렸다. 골드5도 이제 시간만 주면 풀어버리는 나? 

