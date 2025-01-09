const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
const arr = input[1].split(" ").map(Number);
let graph = Array.from({ length: N + 1 }, () => []);
let visited = Array(N + 1).fill(false);
let cnt = 0;

function dfs() {
  let stack = [];
  stack.push([1]);
  while (stack.length > 0) {
    const [cur] = stack.pop();
    if (visited[cur]) {
      continue;
    }
    visited[cur] = true;
    for (let next of graph[cur]) {
      if (!visited[next]) {
        if (arr[cur - 1] !== arr[next - 1]) {
          cnt++;
        }
        stack.push([next]);
      }
    }
  }
}

function solution() {
  for (let i = 0; i < N - 1; i++) {
    const [u, w] = input[i + 2].split(" ").map(Number);
    graph[u].push(w);
    graph[w].push(u);
  }
  dfs();
  if (arr[0] !== 0) {
    cnt++;
  }
  return cnt;
}

console.log(solution());
