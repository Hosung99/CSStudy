const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = input.shift().split(" ").map(Number);
let operatorArr = input.shift().split(" ").map(Number); //[+,-,*,/];
let max = -Infinity,
  min = Infinity;
let visited = Array(N - 1).fill(false);
let tempArr = [];
let idxArr = [];

function calc() {
  let temp = arr[0];
  for (let i = 1; i < N; i++) {
    if (tempArr[i - 1] === 0) {
      temp += arr[i];
    } else if (tempArr[i - 1] === 1) {
      temp -= arr[i];
    } else if (tempArr[i - 1] === 2) {
      temp *= arr[i];
    } else {
      if (temp < 0) {
        temp = Math.floor(Math.abs(temp) / Math.abs(arr[i]));
        temp *= -1;
      } else {
        temp = Math.floor(Math.abs(temp) / Math.abs(arr[i]));
      }
    }
  }
  max = Math.max(max, temp);
  min = Math.min(min, temp);
}

function dfs(depth) {
  if (depth === N - 1) {
    calc();
    return;
  }
  for (let i = 0; i < N - 1; i++) {
    if (!visited[i]) {
      visited[i] = true;
      tempArr.push(idxArr[i]);
      dfs(depth + 1);
      visited[i] = false;
      tempArr.pop();
    }
  }
}

function solution() {
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < operatorArr[i]; j++) {
      idxArr.push(i);
    }
  }
  dfs(0);
  return [max, min].join("\n");
}
console.log(solution());
