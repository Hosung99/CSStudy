import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
        static Integer[] numbers;
        static int m, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        numbers = Arrays.stream(br.readLine().split(" ")).map(num -> Integer.parseInt(num)).toArray(size -> new Integer[size]);

        binarySearch(0, Arrays.stream(numbers).max(Integer::compare).get());

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    static void binarySearch(int bottom, int top) {
        if (bottom > top) {
            return ;
        }

        int mid = (bottom + top) / 2;
        long leftWood = calculateSliceTree(mid);
        if (!(leftWood < m))
            res = mid;
        if (leftWood == m) {
            return;
        }

        if (leftWood < m ) {
            binarySearch(bottom, mid - 1);
        } else {
            binarySearch(mid + 1, top);
        }
    }

    private static long calculateSliceTree(int sliceHigh) {
        long allLeftWood = 0L;
        for (int i = 0; i < numbers.length; i++) {
            long leftWood = numbers[i] - sliceHigh;
            if (leftWood >= 0) {
                allLeftWood += leftWood;
            }
        }
        return allLeftWood;
    }
}
