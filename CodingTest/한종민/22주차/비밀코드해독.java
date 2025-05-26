import java.util.*;
class Solution {
    public static List<List<Integer>> nums = new ArrayList<>();
    public int solution(int n, int[][] q, int[] ans) {
        makeNums(0, new ArrayList<>(), n);
        for (int i = 0; i < q.length; i++) {
            Iterator<List<Integer>> it = nums.iterator();
            while (it.hasNext()) {
                List<Integer> lst = it.next();
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (lst.contains(q[i][j])) {
                        count++;
                    }
                }
                if (count != ans[i]) {
                    it.remove(); // 안전하게 제거
                }
            }

        }
        return nums.size();
    }

    void makeNums(int st, List<Integer> list, int max) {
        if (list.size() == 5) {
            nums.add(new ArrayList<>(list));
            return ;
        }
        for (int i = st + 1; i <= max; i++) {
            list.add(i);
            makeNums(i, list, max);
            list.remove(list.size() - 1);
        }
    }
}

