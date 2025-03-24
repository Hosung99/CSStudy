const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let arr = [];
let blank = [];
let cnt = 0;

for (let i = 0; i < 9; i++) {
  arr.push(input[i].split(" ").map(Number));
}

for (let i = 0; i < 9; i++) {
  for (let j = 0; j < 9; j++) {
    if (arr[i][j] === 0) {
      blank.push({ x: i, y: j });
      cnt++;
    }
  }
}

function print() {
  let result = "";
  for (let i = 0; i < 9; i++) {
    result += arr[i].join(" ") + "\n";
  }
  console.log(result);
}

function isPossible(x, y, num) {
  for (let i = 0; i < 9; i++) {
    if (arr[x][i] === num) {
      return false;
    }
  }

  for (let i = 0; i < 9; i++) {
    if (arr[i][y] === num) {
      return false;
    }
  }

  let row = Math.floor(x / 3) * 3;
  let col = Math.floor(y / 3) * 3;

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (arr[row + i][col + j] === num) {
        return false;
      }
    }
  }

  return true;
}

function dfs(depth) {
  if (depth === cnt) {
    print();
    process.exit(0);
  }

  let x = blank[depth].x;
  let y = blank[depth].y;

  for (let num = 1; num <= 9; num++) {
    if (isPossible(x, y, num)) {
      arr[x][y] = num;
      dfs(depth + 1);
      arr[x][y] = 0;
    }
  }
}

function solution() {
  dfs(0);
}

solution();
