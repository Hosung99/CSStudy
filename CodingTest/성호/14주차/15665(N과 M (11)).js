const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = input.shift().split(" ").map(Number);
arr = [...new Set(arr)];
arr.sort((a, b) => a - b);
let ans = "";
let temp = [];
function dfs(depth) {
  if (depth === M) {
    ans += temp.join(" ") + "\n";
    return;
  }
  for (let i = 0; i < arr.length; i++) {
    temp.push(arr[i]);
    dfs(depth + 1);
    temp.pop();
  }
}

function solution() {
  dfs(0);
  return ans;
}
console.log(solution());
