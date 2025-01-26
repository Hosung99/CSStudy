const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let inputArr;
let ans = "";
let k;
let arr = [];
let visited;

function dfs(depth, idx) {
  if (depth === 6) {
    ans += arr.join(" ") + "\n";
    return;
  }
  for (let i = idx; i < k; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(inputArr[i]);
      dfs(depth + 1, i + 1);
      arr.pop();
      visited[i] = false;
    }
  }
}

function solution() {
  input.forEach((item) => {
    inputArr = item.split(" ").map(Number);
    k = inputArr[0];
    visited = Array(k).fill(false);
    inputArr.shift();
    if (k === 0) {
      console.log(ans);
      process.exit();
    }
    dfs(0, 0);
    ans += "\n";
  });
}

solution();
