import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Character> input = new ArrayList<>();
    public static int count = 0;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == 'a')
                count++;
            input.add(c);
        }
        int end = 0;
        int bcount = 0;
        while (end < count) {
            if (input.get(end) == 'b') bcount++;
            end++;
        }
        min = Math.min(bcount, min);
        for (int start = 0; start < input.size(); start++) {
            if (input.get(start) == 'b') bcount--;
            if (input.get(end % input.size())== 'b') bcount++;
            end++;
            min = Math.min(bcount, min);
        }
        System.out.println(min);
    }
}
