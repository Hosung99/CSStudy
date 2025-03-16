const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let str = "";
let ans = "";
let arr, tempArr, visited;

function dfs(depth) {
  if (depth === str.length) {
    let temp = "";
    for (let i = 0; i < arr.length; i++) {
      temp += str[arr[i]];
    }
    tempArr.push(temp);
    return;
  }
  let usedChar = new Set();
  for (let i = 0; i < str.length; i++) {
    if (!visited[i]) {
      if (usedChar.has(str[i])) {
        continue;
      }
      arr.push(i);
      usedChar.add(str[i]);
      visited[i] = true;
      dfs(depth + 1);
      arr.pop();
      visited[i] = false;
    }
  }
}

function solution() {
  for (let i = 0; i < N; i++) {
    str = input[i];
    visited = new Array(str.length).fill(false);
    arr = [];
    tempArr = [];
    dfs(0);
    tempArr = [...new Set(tempArr)];
    tempArr.sort();
    tempArr.forEach((item) => {
      ans += item + "\n";
    });
  }
  return ans;
}
console.log(solution());
