## [가르침](https://www.acmicpc.net/problem/1062)
인내의 가르침을 선사해준 문제.........

### 문제 풀이 방식
처음에는 그리디라고 생각하고 문자 집합을 key, 빈도수를 value로 해서 정렬해서 했는데 1퍼도 못가서 틀리더군요

백트래킹으로 풀어야 한다는걸 (알고리즘 분류를 보고) 깨달았는데,  
단어를 기준으로 백트래킹하는 기행을 펼치다가 바보짓을 했단걸 깨닫고 알파벳 기준으로 다시 풀었습니다...

근데 이제 단어가 포함된 알파벳을 저장할 때에 이렇게 해당 알파벳 개수를 저장해주었는데,  
이렇게 저장하면 학습한 단어개수를 확인할 때에 시간 초과가 납니다... 그래서 알고리즘 분류에 비트마스킹이 있나봐여
```java
static boolean[][] words = new boolean[50][26];
static boolean[] known = new boolean[26];
```

근데 비트마스킹은 모르겠고 어차피 써먹지도 못할 것 같아서 그냥 다시 문자열이 포함한 문자를 Set으로 저장해서 풀었습니다.  
(+ Set에 containsAll의 시간복잡도는 O(기준 문자열 길이))

실험 결과... 제 경우는 이 두 가지를 모두 해줘야 하는데 이걸 안해줘서 계속 시간초과가 났더라고여..~
- 백트래킹할 때 인자로 시작 알파벳 넘겨주기
- 학습한 단어 개수 확인할 때, 알파벳(26개)을 전체 탐색하면 안되고 문자열 길이(앞뒤 자르면 7개)로 탐색하기


### 학습 내용
그리디로 첨에 풀 때 Map을 쓰고 싶은데 잘 몰라가지고 이것저것 검색하며 풀어서 나중에 보고 써먹을라고 정리하였습니다.

* TreeMap 오름차순/내림차순 정렬
  ```java
  // 기본이 오름차순
  TreeMap<String, Integer> map = new TreeMap<>();
  // 내림차순
  TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
  ```

* Map 순회
  1. iterator 사용
      ```java
      Iterator<String> keys = map.keySet().iterator();
      while (keys.hasNext()) {
          String key = keys.next();
          map.get(key);
      }
      ```
  2. entrySet 사용
      ```java
      for (Map.Entry<String, String> entry : map.entrySet()) {
          String key = entry.getKey();
          String value = entry.getValue();
      }
      ```
  3. keySet사용
      ```java
      for (String key : map.keySet()) {
          map.get(key);
      }
      ```


## [부분합](https://www.acmicpc.net/problem/1806)
### 문제 풀이 방식
누적합을 구해서 투포인터로 구하면 되었던 문제
투포인터에 이제 익숙해진 것 같아서 기쁘다~


## [쉽게 푸는 문제](https://www.acmicpc.net/problem/1292)
### 문제 풀이 방식
진짜 그냥 풀면 되는 문제..!  
배열을 만들어놓고 A부터 B까지 더해주었습니다.


## [애너그램](https://www.acmicpc.net/problem/6443)
이미 사용한 알파벳인지 확인하면서 백트래킹하면 되겠다고 생각했는데 어떻게 구현해야 할지 모르겠더라고요... 이전에 제출한 코드를 참고하였습니다 ~~어째 실력이 더 퇴화하는 느낌~~

### 문제 풀이 방식
전에 풀었던 방식인 1번 방식으로 풀고, 원래 풀고 싶었던 풀이를 gpt에게 물어보아서 2번 방식으로도 풀어보았습니다.
1. 알파벳 개수를 저장하고 그 개수를 기준으로 백트래킹 -> 애너그램.java

    alphaCnt 배열을 만들어서 각 알파벳 개수를 저장하고 사용하면 개수를 줄이면서 알파벳 개수가 0이 되었는지를 확인

2. 이미 사용한 알파벳인지 확인하여 백트래킹 -> 애너그램2.java

    prev 변수를 만들어서 같은 깊이에서 이미 해당 알파벳을 사용한적이 있는지를 확인
