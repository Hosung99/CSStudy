const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = input.shift();
const T = input.shift();
let str = "";

function dfs(s, t) {
  if (s === t) {
    console.log(1);
    process.exit(0);
  }

  if (s.length >= t.length) return;

  if (t[t.length - 1] === "A") {
    let temp = t;
    temp = temp.slice(0, -1);
    dfs(s, temp);
  }

  if (t[0] === "B") {
    let temp = t;
    temp = temp.slice(1);
    temp = temp.split("").reverse().join("");
    dfs(s, temp);
  }
}

function solution() {
  dfs(N, T);
  return "0";
}
console.log(solution());
