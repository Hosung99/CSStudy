import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
    public char name;
    public Node left;
    public Node right;

    public Node(char name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            char parents = token.nextToken().charAt(0);
            char left = token.nextToken().charAt(0);
            char right = token.nextToken().charAt(0);

            if (tree[parents - 'A'] == null) {
                tree[parents - 'A'] = new Node(parents);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parents - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parents - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }

    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%c", node.name);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.printf("%c", node.name);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.printf("%c", node.name);
    }
}