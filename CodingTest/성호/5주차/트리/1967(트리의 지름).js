const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
let graph = Array.from({ length: n + 1 }, () => []);
let visited = Array(n + 1).fill(false);
for (let i = 0; i < n - 1; i++) {
  const [parent, child, w] = input[i + 1].split(" ").map(Number);
  graph[parent].push([child, w]);
  graph[child].push([parent, w]);
}
let ans = { node: 0, dist: 0 };

function dfs(node, dist) {
  let stack = [{ currNode: node, currDist: dist }];
  visited[node] = true;
  while (stack.length > 0) {
    const { currNode, currDist } = stack.pop();
    if (ans.dist < currDist) {
      ans = { node: currNode, dist: currDist };
    }
    for (let [nextNode, nextDist] of graph[currNode]) {
      if (!visited[nextNode]) {
        visited[nextNode] = true;
        stack.push({ currNode: nextNode, currDist: currDist + nextDist });
      }
    }
  }
}

function solution() {
  dfs(1, 0);
  visited.fill(false);
  dfs(ans.node, 0);
  return ans.dist;
}

console.log(solution());
