const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(+input[i + 1]);
}
let ans = Infinity;

function solution() {
  arr.sort((a, b) => a - b);
  let start = 0,
    end = 0;
  let diff;
  while (end < N) {
    diff = arr[end] - arr[start];
    if (diff >= M) {
      ans = Math.min(ans, diff);
      start++;
    } else {
      end++;
    }
  }
  return ans;
}

console.log(solution());
