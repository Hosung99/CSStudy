const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = [];
let answer = 0;
for (let i = 0; i < N; i++) {
  arr.push(+input[i]);
}
function solution() {
  arr.sort((a, b) => a - b);
  let left = 1;
  let right = arr[N - 1] * M;
  let mid = Math.floor((left + right) / 2);

  while (left <= right) {
    let count = 0;
    for (let i = 0; i < N; i++) {
      count += Math.floor(mid / arr[i]);
      if (count >= M) {
        break;
      }
    }

    if (count >= M) {
      answer = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return answer;
}
console.log(solution());
