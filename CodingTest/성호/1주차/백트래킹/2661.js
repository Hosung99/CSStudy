const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim();

const N = +input;
let ans = "";

function isValid(str) {
  let len = str.length;
  for (let i = 1; i <= Math.floor(len / 2); i++) {
    if (str.substr(len - i, i) === str.substr(len - i * 2, i)) {
      return false;
    }
  }
  return true;
}

function dfs(ans, depth) {
  if (isValid(ans) === false) {
    return;
  }
  if (depth === N) {
    console.log(ans);
    process.exit();
  }
  dfs(ans + "1", depth + 1);
  dfs(ans + "2", depth + 1);
  dfs(ans + "3", depth + 1);
}

function solution() {
  dfs(ans, 0);
}

solution();
