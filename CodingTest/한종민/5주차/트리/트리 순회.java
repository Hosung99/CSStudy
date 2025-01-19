import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {

    public char value;
    public Node left;
    public Node right;
    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    //1991
    public static int N;
    public static Node[] nodes;

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        nodes = new Node[N + 1];

        for (int i = 0; i < N; i++ ){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char value = stringTokenizer.nextToken().charAt(0);
            char left = stringTokenizer.nextToken().charAt(0);
            char right = stringTokenizer.nextToken().charAt(0);

            if (nodes[value - 'A'] == null) {
                nodes[value - 'A'] = new Node(value);
            }
            if (left != '.') {
                nodes[left - 'A'] = new Node(left);
                nodes[value - 'A'].left = nodes[left - 'A'];
            }
            if (right != '.') {
                nodes[right - 'A'] = new Node(right);
                nodes[value - 'A'].right = nodes[right - 'A'];
            }
        }
        preorder(nodes[0]);
        System.out.println();
        inorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);
        System.out.println();

    }
}
