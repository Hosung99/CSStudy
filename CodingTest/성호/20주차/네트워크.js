function solution(n, computers) {
  let answer = 0;
  let arr = [];
  let visited = Array(n).fill(false);

  for (let i = 0; i < computers.length; i++) {
    const input = computers[i];
    let temp = [];
    for (let j = 0; j < input.length; j++) {
      if (i === j) {
        continue;
      } else {
        if (input[j] === 1) {
          temp.push(j);
        }
      }
    }
    arr.push(temp);
  }

  for (let i = 0; i < n; i++) {
    if (!visited[i]) {
      bfs(i);
    }
  }

  function bfs(i) {
    answer++;
    let q = [i];
    visited[i] = true;
    while (q.length > 0) {
      const curr = q.shift();
      for (let temp of arr[curr]) {
        if (!visited[temp]) {
          q.push(temp);
          visited[temp] = true;
        }
      }
    }
  }
  return answer;
}
