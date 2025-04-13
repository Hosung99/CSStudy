import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<List<String>> strings;
    public static List<List<String>> results = new ArrayList<>();
    public static int N;
    public static List<Character> options = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            List<String> list = new ArrayList<>();
            for (int j = 0; j < inputs.length; j++) {
                list.add(inputs[j]);
            }
            strings.add(list);
        }

        for (List<String> list : strings) {
            int checkFlag = 0;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (!options.contains(Character.toUpperCase(s.charAt(0)))){
                    options.add(Character.toUpperCase(s.charAt(0)));
                    StringBuilder sb = new StringBuilder().append("[");
                    sb.append(s.charAt(0));
                    sb.append("]");
                    for (int j = 1; j < s.length(); j++) {
                        sb.append(s.charAt(j));
                    }
                    list.set(i, sb.toString());
                    checkFlag = 1;
                    break;
                }
            }
            if (checkFlag == 1) continue;

            for(int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                for (int j = 0; j < s.length(); j++) {
                    if (!options.contains(Character.toUpperCase(s.charAt(j)))){
                        options.add(Character.toUpperCase(s.charAt(j)));
                        StringBuilder sb = new StringBuilder().append(s, 0, j);
                        sb.append("[");
                        sb.append(s.charAt(j));
                        sb.append("]");
                        sb.append(s.substring(j + 1));
                        list.set(i, sb.toString());
                        checkFlag = 1;
                        break;
                    }
                }
                if (checkFlag == 1) break;
            }
        }

        for (List<String> list : strings) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
