const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = Array.from({ length: N + 1 }, () => []);
let visited = Array(N + 1).fill(0);
let q = [];
let ans = "";

function bfs(idx) {
  q.push(idx);
  while (q.length > 0) {
    let curr = q.shift();
    for (let i = 0; i < arr[curr].length; i++) {
      let next = arr[curr][i];
      if (visited[curr] === next) {
        continue;
      }
      q.push(next);
      visited[next] = curr;
    }
  }
}

function solution() {
  for (let i = 0; i < N - 1; i++) {
    const [A, B] = input[i].split(" ").map(Number);
    arr[A].push(B);
    arr[B].push(A);
  }
  bfs(1);
  for (let i = 2; i <= N; i++) {
    ans += visited[i] + "\n";
  }
  return ans.trim();
}
console.log(solution());
