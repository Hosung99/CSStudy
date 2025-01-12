const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
let arr = input[1].split(" ").map(Number);
let ans = Infinity;

function solution() {
  arr.sort((a, b) => a - b);
  for (let i = 0; i < N; i++) {
    for (let j = i + 1; j < N; j++) {
      let height = arr[i] + arr[j];
      let left = 0;
      let right = N - 1;
      while (left < right) {
        if (left === i || left === j) {
          left++;
          continue;
        }
        if (right === i || right === j) {
          right--;
          continue;
        }
        let sum = arr[left] + arr[right];
        ans = Math.min(Math.abs(height - sum), ans);
        if (height > sum) {
          left++;
        } else if (height < sum) {
          right--;
        } else {
          return 0;
        }
      }
    }
  }
  return ans;
}

console.log(solution());
