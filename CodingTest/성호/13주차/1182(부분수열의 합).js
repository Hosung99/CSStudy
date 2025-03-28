const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, S] = input.shift().split(" ").map(Number);
let arr = input.shift().split(" ").map(Number);
let q = [];
let visited = Array(N).fill(false);
let ans = 0;

function check() {
  let sum = 0;
  let flag = q.length > 0;

  if (flag) {
    sum = q.reduce((acc, cur) => acc + cur, 0);
  }
  if (sum === S && flag) {
    ans++;
  }
}

function dfs(depth) {
  check();
  if (depth === N) {
    return;
  }
  for (let i = depth; i < N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      q.push(arr[i]);
      dfs(i + 1);
      visited[i] = false;
      q.pop();
    }
  }
}

function solution() {
  dfs(0);
  return ans;
}
console.log(solution());
