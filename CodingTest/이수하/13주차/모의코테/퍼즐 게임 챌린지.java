class Solution {
    static int result_level = Integer.MAX_VALUE;
    static int diffs_len;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        diffs_len = diffs.length;
        int times_len = times.length;

        binary_search(1, 100000, diffs, times, limit);

        return result_level;
    }

    static void binary_search(int left, int right, int[] diffs, int[] times, long limit) {
        if (left > right) {
            return ;
        }
        int mid =  ((right + left) / 2);
        if (calculate(mid, diffs, times, limit) == true) {
            result_level = Math.min(result_level, mid);
            binary_search(left, mid - 1, diffs, times, limit);
        } else {
            binary_search(mid + 1, right, diffs, times, limit);
        }
    }

    static boolean calculate (int level, int[] diffs, int[] times, long limit) {
        int time_prev = 0;
        long cur_result = 0;
        for (int i = 0; i < diffs_len; i++) {
            long retry_cnt = diffs[i] - level;
            //숙련도가 충분할때
            if (retry_cnt <= 0) {
                cur_result += times[i];
                time_prev = times[i];
            }
            else { //숙련도가 충분하지 않을때
                cur_result += ((times[i] + time_prev) * retry_cnt) + times[i];
                time_prev = times[i];
            }
            //제한시간을 넘겼을때 그만하기
            if (cur_result > limit) {
                return false;
            }
        }
        result_level = level;
        return true;
    }
}