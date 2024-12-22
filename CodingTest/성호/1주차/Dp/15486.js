const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let N = +input[0];
let arr = new Array(N);
for (let i = 1; i <= N; i++) {
  arr[i] = input[i].split(" ").map(Number);
}
let dp = new Array(N + 2).fill(0);

function solution() {
  for (let i = 1; i <= N; i++) {
    dp[i] = Math.max(dp[i], dp[i - 1]);
    if (i + arr[i][0] <= N + 1) {
      dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
    }
  }
  let ans = 0;
  for (let i = 1; i <= N + 1; i++) {
    ans = Math.max(ans, dp[i]);
  }
  return ans;
}

console.log(solution());
