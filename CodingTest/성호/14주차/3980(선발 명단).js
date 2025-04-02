const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const tc = +input.shift();
let visited, mx, q, arr;
let ans = "";

function calc() {
  let sum = 0;
  for (let i = 0; i < 11; i++) {
    sum += arr[i][q[i]];
  }
  return sum;
}

function dfs(depth) {
  if (depth === 11) {
    mx = Math.max(mx, calc());
    return;
  }
  for (let i = 0; i < 11; i++) {
    if (!visited[i] && arr[depth][i] !== 0) {
      q.push(i);
      visited[i] = true;
      dfs(depth + 1);
      q.pop();
      visited[i] = false;
    }
  }
}

function solution() {
  for (let i = 0; i < tc; i++) {
    visited = Array(11).fill(false);
    mx = 0;
    q = [];
    arr = [];
    for (let j = 0; j < 11; j++) {
      let temp = i * 11 + j;
      arr.push(input[temp].split(" ").map(Number));
    }
    dfs(0);
    ans += mx.toString() + "\n";
  }
  return ans;
}
console.log(solution());
