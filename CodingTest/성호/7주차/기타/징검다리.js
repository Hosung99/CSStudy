const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines = [];

rl.on("line", (line) => {
  lines.push(line.split(" "));
}).on("close", () => {
  let N = +lines[0];
  let arr = lines[1].map(Number);
  let dp = Array(N).fill(1);
  let ans = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < i; j++) {
      if (arr[j] < arr[i]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
  }
  for (let i = 0; i < N; i++) {
    ans = Math.max(ans, dp[i]);
  }
  console.log(ans);
  process.exit(0);
});
