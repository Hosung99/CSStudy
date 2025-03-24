const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, S] = input.shift().split(" ").map(Number);
let arr = input.shift().split(" ").map(Number);
let ans = Infinity;
function solution() {
  let start = 0,
    end = 0,
    sum = 0;
  while (start < N) {
    if (sum < S && end < N) {
      sum += arr[end];
      end++;
    } else {
      if (sum >= S) {
        ans = Math.min(ans, end - start);
      }
      sum -= arr[start];
      start++;
    }
  }
  return ans === Infinity ? 0 : ans;
}
console.log(solution());
