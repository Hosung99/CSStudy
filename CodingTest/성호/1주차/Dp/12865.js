const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, K] = input[0].split(" ").map(Number);
const dp = Array.from({ length: N + 1 }, () => Array(K + 1).fill(0));

function solution() {
  for (let i = 1; i < N + 1; i++) {
    const [W, V] = input[i].split(" ").map(Number);
    for (let j = 1; j <= K; j++) {
      if (j - W >= 0) dp[i][j] = Math.max(dp[i - 1][j - W] + V, dp[i - 1][j]);
      else dp[i][j] = dp[i - 1][j];
    }
  }
  return dp[N][K];
}

console.log(solution());
