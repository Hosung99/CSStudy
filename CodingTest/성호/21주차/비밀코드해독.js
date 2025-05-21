function solution(n, q, ans) {
  let answer = 0;
  let queue = [];

  function isPossible() {
    for (let i = 0; i < q.length; i++) {
      let cnt = 0;
      for (let j = 0; j < 5; j++) {
        for (let k = 0; k < 5; k++) {
          if (q[i][j] === queue[k]) {
            cnt++;
          }
        }
      }
      if (ans[i] !== cnt) {
        return false;
      }
    }
    return true;
  }

  function dfs(depth, idx) {
    if (depth === 5) {
      if (isPossible()) {
        answer++;
      }
      return;
    }
    for (let i = idx; i <= n; i++) {
      queue.push(i);
      dfs(depth + 1, i + 1);
      queue.pop();
    }
  }

  dfs(0, 1);

  return answer;
}
