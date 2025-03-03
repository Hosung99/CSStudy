const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = input.shift();
let ans = Infinity;
let flag = false;
let cnt = 0;

function reset() {
  ans = Math.min(ans, cnt);
  flag = false;
  cnt = 0;
}

function solution() {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "B") {
      flag = true;
    }
    if (flag && arr[i] === "R") {
      cnt++;
    }
  }
  reset();
  for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] === "B") {
      flag = true;
    }
    if (flag && arr[i] === "R") {
      cnt++;
    }
  }
  reset();
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "R") {
      flag = true;
    }
    if (flag && arr[i] === "B") {
      cnt++;
    }
  }
  reset();
  for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] === "R") {
      flag = true;
    }
    if (flag && arr[i] === "B") {
      cnt++;
    }
  }
  reset();
  return ans;
}

console.log(solution());
