# 트리 순회
처음 트리를 어떤식으로 구현해야하는지 감이 오지 않아서 정답을 보고 트리를 구현했습니다. \
이진 트리를 구현하기 위해서 왼쪽, 오른쪽 노드를 가지는 노드 클래스를 만들었고, 
해당 클래스를 통해서 노드 배열을 만들어 입력을 저장하였다.

전위, 중위, 후위 탐색은 재귀를 빠져나와서 언제 출력문을 출력할지에 따라서 다르게 동작하도록 해주었다.

```java
public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
        }
```

# 트리의 지름
이번 문제의 경우 조금 다른 형태로 트리를 구현하였다.\
노드리스트 배열 통해 양방향 트리를 구현하여 각 노드가 연결되어있는 노드를 가지게끔 하였다.\

```java
static class Node {
        int num;
        int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

public static List<Node>[] tree;
```
이후 모든 노드를 돌면서 트리의 지름이 가장 긴 노드를 찾는 방식으로 구현하였다.

```java
for (int i = 1; i < N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i , 0);
        }
```
