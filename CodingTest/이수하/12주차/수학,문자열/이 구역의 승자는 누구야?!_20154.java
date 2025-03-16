import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] numberOfStrokes = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        char[] alphabet = tk.nextToken().toCharArray();
        int[] transAlpha = new int[alphabet.length];

        for (int i = 0; i < alphabet.length; i++) {
            transAlpha[i] = numberOfStrokes[alphabet[i] - 65];
        }

        while (transAlpha.length > 1) {
            int newSize = (transAlpha.length / 2) + transAlpha.length % 2;
            int[] tempAlphabet = new int[newSize];

            int j = 0;
            for (int i = 0; i < transAlpha.length - 1; i += 2, j++) {
                tempAlphabet[j] = (transAlpha[i] + transAlpha[i + 1]) % 10;
            }
            if (transAlpha.length % 2 == 1) {
                tempAlphabet[j] = transAlpha[transAlpha.length - 1];
            }
            transAlpha = tempAlphabet;
        }

        if (transAlpha[0] % 2 == 0) {
            System.out.print("You're the winner?");
        } else if (transAlpha[0] % 2 == 1) {
            System.out.print("I'm a winner!");
        }
    }
}