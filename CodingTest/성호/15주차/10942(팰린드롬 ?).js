const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = [0, ...input.shift().split(" ").map(Number)];
let dp = Array.from({ length: N + 1 }, () => Array(N + 1).fill(false));
const M = +input.shift();
let ans = "";

function solution() {
  for (let i = 1; i <= N; i++) {
    dp[i][i] = true;
  }
  for (let i = 1; i <= N - 1; i++) {
    if (arr[i] === arr[i + 1]) {
      dp[i][i + 1] = true;
    }
  }
  for (let len = 3; len <= N; len++) {
    for (let i = 1; i <= N - len + 1; i++) {
      let j = i + len - 1;
      if (arr[i] === arr[j] && dp[i + 1][j - 1]) {
        dp[i][j] = true;
      }
    }
  }
  for (let i = 0; i < M; i++) {
    const [S, E] = input[i].split(" ").map(Number);
    ans += +dp[S][E] + "\n";
  }
  return ans;
}
console.log(solution());
