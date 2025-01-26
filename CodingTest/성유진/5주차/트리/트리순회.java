import java.io.*;
import java.util.*;

// 1991
public class 트리순회 {
  static public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int x){
      left = null;
      right = null;
      val = x;
    }
  }
  static TreeNode [] tree = new TreeNode[30];
  static int N;

  // 전위순회
  static void preorderTraversal(TreeNode x) {
    if (x == null) return;
    System.out.print(intToString(x.val));
    preorderTraversal(x.left);
    preorderTraversal(x.right);
  }

  // 중위순회
  static void inorderTraversal(TreeNode x) {
    if (x == null) return;
    inorderTraversal(x.left);
    System.out.print(intToString(x.val));
    inorderTraversal(x.right);
  }

  // 후위순회
  static void postorderTraversal(TreeNode x) {
    if (x == null) return;
    postorderTraversal(x.left);
    postorderTraversal(x.right);
    System.out.print(intToString(x.val));
  }

  static TreeNode stringToNode(String s) {
    if (s.equals(".")) return null;
    int idx = (int) s.charAt(0) - 65;
    return tree[idx];
  }
  static int stringToInt(String s) {
    return (int) s.charAt(0) - 65;
  }

  static String intToString(int x) {
    if (x == -1) return "";
    return Character.toString((char) (x + 65));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      tree[i] = new TreeNode(i);
    }
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int root = stringToInt(st.nextToken());
      tree[root].left = stringToNode(st.nextToken());
      tree[root].right = stringToNode(st.nextToken());
    }
    preorderTraversal(tree[0]);
    System.out.println();
    inorderTraversal(tree[0]);
    System.out.println();
    postorderTraversal(tree[0]);
    System.out.println();
  }
}

