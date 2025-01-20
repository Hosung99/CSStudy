const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let tc = +input[0];
let ans = "";
let graph;
let V, E;

function bfs(visited, idx) {
  visited[idx] = 1;
  let q = [idx];
  while (q.length > 0) {
    const curr = q.shift();
    for (let next of graph[curr]) {
      if (visited[next] === 0) {
        visited[next] = visited[curr] * -1;
        q.push(next);
      } else if (visited[next] === visited[curr]) {
        return false;
      }
    }
  }
  return true;
}

function solution() {
  let inputIdx = 1;
  for (let i = 0; i < tc; i++) {
    [V, E] = input[inputIdx].split(" ").map(Number);
    graph = Array.from({ length: V + 1 }, () => []);
    let flag = true;
    inputIdx++;
    for (let j = 0; j < E; j++) {
      const [u, v] = input[inputIdx].split(" ").map(Number);
      graph[u].push(v);
      graph[v].push(u);
      inputIdx++;
    }
    let visited = Array(V + 1).fill(0);
    for (let j = 1; j <= V; j++) {
      if (visited[j] === 0) {
        if (!bfs(visited, j)) {
          flag = false;
          break;
        }
      }
    }
    if (flag) {
      ans += "YES\n";
    } else {
      ans += "NO\n";
    }
  }
  return ans;
}

console.log(solution());
