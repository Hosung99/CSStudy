const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [R, C] = input[0].split(" ").map(Number);
let arr = new Array(R);
for (let i = 0; i < R; i++) {
  arr[i] = input[i + 1].trim().split("");
}
let visited = new Array(26).fill(false);
let dx = [1, 0, -1, 0];
let dy = [0, 1, 0, -1];
let ans = 0;

function dfs(x, y, cnt) {
  ans = Math.max(ans, cnt);
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];
    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
      continue;
    }
    let str = arr[nx][ny].charCodeAt() - 65;
    if (visited[str] === false) {
      visited[str] = true;
      dfs(nx, ny, cnt + 1);
      visited[str] = false;
    }
  }
}

function solution() {
  visited[arr[0][0].charCodeAt() - 65] = true;
  dfs(0, 0, 1);
  return ans;
}

console.log(solution());
