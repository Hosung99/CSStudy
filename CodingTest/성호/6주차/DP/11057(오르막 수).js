const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
let dp = Array.from({ length: 1001 }, () => Array(10).fill(0));
let ans = 0;

function solution() {
  for (let i = 0; i < 10; i++) {
    dp[1][i] = 1;
  }
  for (let i = 2; i <= N; i++) {
    for (let j = 0; j < 10; j++) {
      if (j === 0) {
        dp[i][j] = 1;
      } else {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        dp[i][j] %= 10007;
      }
    }
  }
  for (let j = 0; j < 10; j++) {
    ans += dp[N][j];
  }
  return Math.floor(ans % 10007);
}

console.log(solution());
