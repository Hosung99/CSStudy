package leesooha.week01.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] status = new int[10002];

    public void recursion(int M, List<Integer> input) {

    }

    public void solution(int N, int M, List<Integer> input) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

            }
        }
    }
}

public class _15666 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input.add(Integer.parseInt(bf.readLine()));
        }

        s.solution(N, M, input);

    }
}
