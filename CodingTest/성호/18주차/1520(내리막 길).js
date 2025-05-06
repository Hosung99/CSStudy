const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(input[i].split(" ").map(Number));
}
let visited = Array.from({ length: N }, () => Array(M).fill(-1));
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

function dfs(x, y) {
  if (x === N - 1 && y === M - 1) {
    return 1;
  }
  let cnt = 0;
  for (let dir = 0; dir < 4; dir++) {
    let nx = x + dx[dir];
    let ny = y + dy[dir];
    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
      continue;
    }
    if (arr[x][y] > arr[nx][ny]) {
      if (visited[nx][ny] === -1) {
        visited[nx][ny] = dfs(nx, ny);
      }
      cnt += visited[nx][ny];
    }
  }
  return cnt;
}

function solution() {
  return dfs(0, 0);
}
console.log(solution());

