const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
for (let i = 0; i < M; i++) {
  const [u, v] = input[i + 1].split(" ").map(Number);
  graph[u].push(v);
  graph[v].push(u);
}
let kValue = Infinity;
let kIdx = 0;

function bfs(idx) {
  let visited = Array(N + 1).fill(false);
  let queue = [];
  let kNum = 0;
  queue.push({ idx: idx, depth: 1 });
  visited[idx] = true;
  while (queue.length > 0) {
    const { idx, depth } = queue.shift();
    kNum += depth;
    for (let next of graph[idx]) {
      if (!visited[next]) {
        visited[next] = true;
        queue.push({ idx: next, depth: depth + 1 });
      }
    }
  }
  return kNum;
}

function solution() {
  for (let i = 1; i <= N; i++) {
    const kevinNum = bfs(i);
    if (kValue > kevinNum) {
      kValue = kevinNum;
      kIdx = i;
    }
  }
  return kIdx;
}

console.log(solution());
