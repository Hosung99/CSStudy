const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M, V] = input[0].split(" ").map(Number);
let arr = Array.from({ length: N + 1 }, () => []);
let visited_BFS = [];
let visited_DFS = Array(N + 1).fill(0);
let ans_DFS = [];
let cnt_DFS = 1;

function bfs(start) {
  let queue = [];
  visited_BFS.push(start);
  queue.push(start);
  while (queue.length > 0) {
    let n = queue.shift();
    while (arr[n].length > 0) {
      let next = arr[n].shift();
      if (visited_BFS.includes(next)) {
        continue;
      }
      visited_BFS.push(next);
      queue.push(next);
    }
  }
}

function dfs(depth) {
  if (visited_DFS[depth] === 0) {
    visited_DFS[depth] = cnt_DFS++;
    ans_DFS.push(depth);
    for (let next of arr[depth]) {
      dfs(next);
    }
  }
}

function solution() {
  for (let i = 0; i < M; i++) {
    const [u, w] = input[i + 1].split(" ").map(Number);
    arr[u].push(w);
    arr[w].push(u);
  }
  arr.forEach((item) => {
    item.sort((a, b) => a - b);
  });
  dfs(V);
  bfs(V);
  return [ans_DFS.join(" "), visited_BFS.join(" ")].join("\n");
}

console.log(solution());
