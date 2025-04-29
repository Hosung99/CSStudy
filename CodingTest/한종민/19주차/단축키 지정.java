import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static int N;
    public static List<String> inputs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }
        StringBuilder builder = new StringBuilder();

        int idx1 = inputs.indexOf("KBS1");
        builder.append("1".repeat(idx1));
        builder.append("4".repeat(idx1));
        inputs.remove(idx1);
        inputs.add(0, "KBS1");

        int idx2 = inputs.indexOf("KBS2");
        builder.append("1".repeat(idx2));
        builder.append("4".repeat(idx2 - 1));
        inputs.remove(idx2);
        inputs.add(1, "KBS2");

        System.out.println(builder);
    }
}
