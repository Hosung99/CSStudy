const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M, R] = input[0].split(" ").map(Number);
let arr = Array.from({ length: N + 1 }, () => []);
const visited = Array(N + 1).fill(0);
let cnt = 1;

function dfs(depth) {
  if (visited[depth] === 0) {
    visited[depth] = cnt++;
    for (let next of arr[depth]) {
      dfs(next);
    }
  }
}

function solution() {
  for (let i = 0; i < M; i++) {
    const [u, v] = input[i + 1].split(" ").map(Number);
    arr[u].push(v);
    arr[v].push(u);
  }
  arr.forEach((item) => {
    item.sort((a, b) => a - b);
  });
  dfs(R);
  visited.shift();
  return visited.join("\n");
}

console.log(solution());
