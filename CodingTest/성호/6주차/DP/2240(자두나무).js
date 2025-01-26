const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [T, W] = input.shift().split(" ").map(Number);
const arr = Array(T + 1).fill(0);
for (let i = 1; i <= T; i++) {
  arr[i] = +input[i - 1];
}
let dp = Array.from({ length: T + 1 }, () =>
  Array.from({ length: W + 1 }, () => Array(2).fill(0))
);

function solution() {
  for (let i = 1; i <= T; i++) {
    for (let j = 0; j <= W; j++) {
      if (j === 0) {
        dp[i][j][0] = dp[i - 1][j][0] + (arr[i] === 1 ? 1 : 0);
      } else {
        dp[i][j][0] = Math.max(
          dp[i - 1][j][0] + (arr[i] === 1 ? 1 : 0),
          dp[i - 1][j - 1][1] + (arr[i] === 1 ? 1 : 0)
        );

        dp[i][j][1] = Math.max(
          dp[i - 1][j][1] + (arr[i] === 2 ? 1 : 0),
          dp[i - 1][j - 1][0] + (arr[i] === 2 ? 1 : 0)
        );
      }
    }
  }

  let ans = 0;
  for (let j = 0; j <= W; j++) {
    for (let k = 0; k < 2; k++) {
      ans = Math.max(ans, dp[T][j][k]);
    }
  }

  return ans;
}

console.log(solution());
