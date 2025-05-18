import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        List<Integer> listB = new ArrayList<>();
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            listB.add(B[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(listB, A[i] + 1);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx < listB.size()) {
                listB.remove(idx);
                answer++;   
            }
        }
        return answer;
    }
}
