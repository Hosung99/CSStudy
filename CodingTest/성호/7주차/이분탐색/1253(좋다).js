const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
let arr = input[1].split(" ").map(Number);
let ans = 0;

function binarySearch(findNum) {
  const list = [...arr.slice(0, findNum), ...arr.slice(findNum + 1)];
  let [left, right] = [0, N - 1];
  while (left < right) {
    const mid = list[left] + list[right];
    if (mid === arr[findNum]) {
      return 1;
    }
    if (arr[findNum] > mid) {
      left++;
    } else {
      right--;
    }
  }
  return 0;
}

function solution() {
  arr.sort((a, b) => a - b);
  for (let i = 0; i < N; i++) {
    ans += binarySearch(i);
  }
  return ans;
}

console.log(solution());
