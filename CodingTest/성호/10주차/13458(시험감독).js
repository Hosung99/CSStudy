const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
const arr = input.shift().split(" ").map(Number);
const [B, C] = input.shift().split(" ").map(Number);
let ans = 0;

function solution() {
  for (let i = 0; i < N; i++) {
    let total = arr[i];
    total -= B;
    ans++;
    if (total > 0) {
      let sub = Math.ceil(total / C);
      ans += sub;
    }
  }
  return ans;
}

console.log(solution());
