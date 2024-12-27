const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");

let N = +input[0];
let arr = input[1].split(" ").map(Number);
let dp = new Array(1001).fill(0);

function solution() {
  for (let i = 1; i <= arr.length; i++) {
    dp[i] = 1;
    for (let j = i - 1; j >= 1; j--) {
      if (arr[i - 1] < arr[j - 1] && dp[i] < dp[j] + 1) {
        dp[i] = dp[j] + 1;
      }
    }
  }
  let ans = 0;
  for (let i = 0; i <= N; i++) {
    ans = Math.max(ans, dp[i]);
  }
  return ans;
}

console.log(solution());
