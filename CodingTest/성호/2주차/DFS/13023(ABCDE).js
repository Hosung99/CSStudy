const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
const arr = Array.from({ length: N }, () => []);
let visited = Array(N ).fill(false);
for (let i = 0; i < M; i++) {
  const [a, b] = input[i + 1].split(" ").map(Number);
  arr[a].push(b);
  arr[b].push(a);
}

function dfs(idx, depth) {
  if (depth === 4) {
    console.log("1");
    process.exit();
  }
  for (let next of arr[idx]) {
    if (!visited[next]) {
      visited[next] = true;
      dfs(next, depth + 1);
      visited[next] = false;
    }
  }
}

function solution() {
  for (let i = 0; i < N; i++) {
	visited[i] = true;
    dfs(i, 0);
	visited[i] = false;
  }
  return 0;
}

console.log(solution());
