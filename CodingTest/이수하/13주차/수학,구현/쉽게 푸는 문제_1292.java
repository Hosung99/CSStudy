import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(tk.nextToken());
        int end = Integer.parseInt(tk.nextToken());
        List<Integer> sequence = new ArrayList<>();

        int number = 1;
        while (sequence.size() < 1000) {
            for (int j = 0; j < number; j++) {
                sequence.add(number);
            }
            number++;
        }

        int res = 0;
        for (int i = start - 1; i <= end - 1; i++) {
            res += sequence.get(i);
        }

        System.out.print(res);
    }
}