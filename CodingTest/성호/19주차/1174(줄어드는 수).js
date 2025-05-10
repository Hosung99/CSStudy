const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let N = +input.shift();
let arr = [];

function dfs(num) {
  arr.push(num);

  let digit = num % 10;
  for (let i = 0; i < digit; i++) {
    dfs(num * 10 + i);
  }
}

function solution() {
  for (let i = 0; i <= 9; i++) {
    dfs(i);
  }
  arr.sort((a, b) => a - b);
  if (N > arr.length) {
    return -1;
  }
  return arr[N - 1];
}
console.log(solution());
