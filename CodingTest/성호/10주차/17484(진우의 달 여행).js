const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(input[i].split(" ").map(Number));
}
let dp = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => Array(3).fill(Infinity))
);
let ans = Infinity;

function solution() {
  for (let i = 0; i < M; i++) {
    dp[0][i][0] = arr[0][i];
    dp[0][i][1] = arr[0][i];
    dp[0][i][2] = arr[0][i];
  }
  for (let i = 1; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (i - 1 >= 0 && j + 1 < M) {
        dp[i][j][0] =
          Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
      }
      if (i - 1 >= 0) {
        dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
      }
      if (i - 1 >= 0 && j - 1 >= 0) {
        dp[i][j][2] =
          Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
      }
    }
  }
  for (let i = 0; i < M; i++) {
    ans = Math.min(dp[N - 1][i][0], dp[N - 1][i][1], dp[N - 1][i][2], ans);
  }
  return ans;
}

console.log(solution());
