const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines =[];
let ans = "";

rl.on('line', (line) => {
    lines.push(line.split(" "));
}).on('close', () => {
    let [N,K] = lines[0].map(Number);
    let arr = lines[1].map(Number);
    let dp = Array(N).fill(0);
    dp[0] = arr[0];
    for(let i = 1; i < N; i++) {
        dp[i] = dp[i - 1] + arr[i];
    }
    for(let i = 0; i < K; i++) {
        let [A, B] = lines[i + 2].map(Number);
        ans += ((dp[B - 1] - dp[A - 1] + arr[A - 1]) / (B - A + 1)).toFixed(2);
        if (i !== K - 1) {
         ans += "\n";
        }
    }
    console.log(ans);
  process.exit(0);
});