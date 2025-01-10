import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static Long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).map(num -> Long.parseLong(num)).toArray(size -> new Long[size]);
        Arrays.sort(numbers);
        int m = Integer.parseInt(br.readLine());
        Long[] findNumbers = Arrays.stream(br.readLine().split(" ")).map(num -> Long.parseLong(num)).toArray(size -> new Long[size]);

        for (int i = 0; i < m; i++) {
            int isExist = binarySearch(0, numbers.length - 1, findNumbers[i]);
            bw.write(isExist + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static int binarySearch(int start, int end, Long targetNum) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (numbers[mid].equals(targetNum)) {
            return 1;
        }

        if (numbers[mid] < targetNum) {
            return binarySearch(mid + 1, end, targetNum);
        } else {
            return binarySearch(start, mid - 1, targetNum);
        }
    }
}
