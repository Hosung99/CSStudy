const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
let board = [];
let chicken = [];
let home = [];
let comb = [];
let visited = Array(N).fill(false);
for (let i = 0; i < N; i++) {
  board.push(input[i + 1].split(" ").map(Number));
}
let ans = Infinity;

function calcDelivery() {
  let sum = 0;
  for (let i = 0; i < home.length; i++) {
    let min = Infinity;
    for (let j = 0; j < M; j++) {
      let tmp =
        Math.abs(home[i].x - comb[j].x) + Math.abs(home[i].y - comb[j].y);
      min = Math.min(min, tmp);
    }
    sum += min;
  }
  return sum;
}

function dfs(depth, idx) {
  if (depth === M) {
    ans = Math.min(ans, calcDelivery());
    return;
  }
  for (let i = idx; i < chicken.length; i++) {
    if (!visited[i]) {
      visited[i] = true;
      comb.push(chicken[i]);
      dfs(depth + 1, i + 1);
      visited[i] = false;
      comb.pop();
    }
  }
}

function solution() {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (board[i][j] === 2) {
        chicken.push({ x: i, y: j });
      } else if (board[i][j] === 1) {
        home.push({ x: i, y: j });
      }
    }
  }
  dfs(0, 0);
  return ans;
}

console.log(solution());
