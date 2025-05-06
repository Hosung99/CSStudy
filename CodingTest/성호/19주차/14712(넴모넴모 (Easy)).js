const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = Array.from({ length: N }, () => Array(M).fill(false));
let ans = 0;

function isPossible() {
  for (let i = 0; i < N - 1; i++) {
    for (let j = 0; j < M - 1; j++) {
      if (arr[i][j] && arr[i][j + 1] && arr[i + 1][j] && arr[i + 1][j + 1]) {
        return false;
      }
    }
  }
  return true;
}

function dfs(depth) {
  if (depth === N * M) {
    if (isPossible()) {
      ans++;
    }
    return;
  }
  let x = Math.floor(depth / M);
  let y = depth % M;
  dfs(depth + 1);
  arr[x][y] = true;
  dfs(depth + 1);
  arr[x][y] = false;
}

function solution() {
  dfs(0);
  return ans;
}

console.log(solution());
