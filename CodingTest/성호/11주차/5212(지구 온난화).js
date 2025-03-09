const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [R, C] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < R; i++) {
  arr.push(input.shift().split(""));
}
let tempArr = arr.map((item) => [...item]);
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];
let ans = "";

function sink(i, j) {
  let cnt = 0;
  for (let dir = 0; dir < 4; dir++) {
    let nx = i + dx[dir];
    let ny = j + dy[dir];
    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
      cnt++;
      continue;
    }
    if (arr[nx][ny] === ".") {
      cnt++;
    }
  }
  if (cnt >= 3) {
    tempArr[i][j] = ".";
  }
}

function solution() {
  let startX = Infinity;
  let endX = 0;
  let startY = Infinity;
  let endY = 0;
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (arr[i][j] === "X") {
        sink(i, j);
      }
    }
  }
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (tempArr[i][j] === "X") {
        startX = Math.min(startX, i);
        endX = Math.max(endX, i);
        startY = Math.min(startY, j);
        endY = Math.max(endY, j);
      }
    }
  }
  for (let i = startX; i <= endX; i++) {
    for (let j = startY; j <= endY; j++) {
      ans += tempArr[i][j];
    }
    ans += "\n";
  }
  return ans;
}
console.log(solution());
