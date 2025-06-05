import java.util.*;

class Solution {
  int answer = 0;
  int N;
  int[] nums;
  int t;
  Stack<Integer> S = new Stack<>();
  
  boolean matchTarget() {
    List<Integer> op = new ArrayList<>(S);
    int result = 0;
    for (int i = 0; i < N; i++) {
      result += nums[i] * op.get(i);
    }
    return result == t;
  }
  
  void comb(int d) {
    if (d == N) {
      if (matchTarget())
        answer++;
      return;      
    }
    
    S.add(-1);
    comb(d + 1);
    S.pop();
    
    S.add(1);
    comb(d + 1);
    S.pop();
  }
  public int solution(int[] numbers, int target) {
    N = numbers.length;
    nums = numbers;
    t = target;
    comb(0);
    
    return answer;
  }
}