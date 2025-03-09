import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _20154 {
    public static Map<String, Integer> alpha = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        alpha.put("A", 3);
        alpha.put("B", 2);
        alpha.put("C", 1);
        alpha.put("D", 2);
        alpha.put("E", 3);
        alpha.put("F", 3);
        alpha.put("G", 3);
        alpha.put("H", 3);
        alpha.put("I", 1);
        alpha.put("J", 1);
        alpha.put("K", 3);
        alpha.put("L", 1);
        alpha.put("M", 3);
        alpha.put("N", 3);
        alpha.put("O", 1);
        alpha.put("P", 2);
        alpha.put("Q", 2);
        alpha.put("R", 2);
        alpha.put("S", 1);
        alpha.put("T", 2);
        alpha.put("U", 1);
        alpha.put("V", 1);
        alpha.put("W", 2);
        alpha.put("X", 2);
        alpha.put("Y", 2);
        alpha.put("Z", 1);


        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += alpha.get(String.valueOf(input.charAt(i)));
        }

        if (sum % 2 == 1) System.out.println("I'm a winner!");
        else System.out.println("You're the winner?");
    }
}
