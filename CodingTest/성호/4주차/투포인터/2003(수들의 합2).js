const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number);
let ans = 0;

function solution() {
  for (let start = 0; start < N; start++) {
    let sum = arr[start];
    let idx = start;
    while (sum < M && idx < N - 1) {
      idx++;
      sum += arr[idx];
    }
    if (sum === M) {
      ans++;
    }
  }
  return ans;
}

console.log(solution());
