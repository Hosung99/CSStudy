package leesooha.week01.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    BufferedWriter bw;

    Solution(BufferedWriter bw) {
        this.bw = bw;
    }

    public void solution(int k) throws IOException{
        if (k == Main.m) {
            String printedNumber = new String();
            for (int i = 0; i < Main.m; i++) {
                printedNumber += Integer.toString(Main.print_numbers[i]) + " ";
            }
            if (Main.printedNumbers.contains(printedNumber)) {
                return;
            }
            Main.printedNumbers.add(printedNumber);
            bw.write(printedNumber + "\n");
            return;
        }

        for (int i = 0; i < Main.n; i++) {
            if (k != 0) {
                if (Main.print_numbers[k - 1] > Main.input_numbers[i]) {
                    continue;
                }
            }
            Main.print_numbers[k] = Main.input_numbers[i];
            solution(k + 1);
        }
    }
}

public class Main {
    static int[] print_numbers = new int[8];
    static int[] input_numbers;
    static int n, m;
    static List<String> printedNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution(bw);

        String[] inputNAndM = bf.readLine().split(" ");
        n = Integer.parseInt(inputNAndM[0]);
        m = Integer.parseInt(inputNAndM[1]);

        input_numbers = new int[n];
        String[] inputNumbers = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            input_numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        Arrays.sort(input_numbers);

        s.solution(0);
        bw.flush();
        bw.close();
    }
}
