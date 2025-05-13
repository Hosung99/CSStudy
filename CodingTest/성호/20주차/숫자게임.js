function solution(A, B) {
  let answer = 0;
  let visited = Array(A.length).fill(false);
  A.sort((a, b) => b - a);
  B.sort((a, b) => b - a);
  let left = 0,
    right = 0;
  while (left < A.length) {
    if (A[left] < B[right]) {
      right++;
      answer++;
    }
    left++;
  }
  return answer;
}
