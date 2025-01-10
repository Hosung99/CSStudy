const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];
let arr = [];
let landCnt = 2;
let visited = Array.from({ length: N }, () => Array(N).fill(false));
let q = [];
let ans = 2147483647;
for (let i = 1; i <= N; i++) {
  arr.push(input[i].split(" ").map(Number));
}

function fillLand(x, y) {
  visited[x][y] = true;
  arr[x][y] = landCnt;
  q.push({ curX: x, curY: y });
  while (q.length > 0) {
    let { curX, curY } = q.shift();
    for (let dir = 0; dir < 4; dir++) {
      let nx = curX + dx[dir];
      let ny = curY + dy[dir];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
        continue;
      }
      if (visited[nx][ny] === true || arr[nx][ny] === 0) {
        continue;
      }
      visited[nx][ny] = true;
      arr[nx][ny] = landCnt;
      q.push({ curX: nx, curY: ny });
    }
  }
  landCnt++;
}

function calcBridge(x, y, land) {
  visited = Array.from({ length: N }, () => Array(N).fill(false));
  q = [];
  visited[x][y] = true;
  q.push({ curX: x, curY: y, cnt: 0 });
  while (q.length > 0) {
    let { curX, curY, cnt } = q.shift();
    if (arr[curX][curY] !== 0 && arr[curX][curY] !== land) {
      return cnt - 1;
    }
    for (let dir = 0; dir < 4; dir++) {
      let nx = curX + dx[dir];
      let ny = curY + dy[dir];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
        continue;
      }
      if (visited[nx][ny] === true || arr[nx][ny] === land) {
        continue;
      }
      visited[nx][ny] = true;
      q.push({ curX: nx, curY: ny, cnt: cnt + 1 });
    }
  }
  return 2147483647;
}

function solution() {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (visited[i][j] === false && arr[i][j] === 1) {
        fillLand(i, j);
      }
    }
  }
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (arr[i][j] !== 0) {
        ans = Math.min(ans, calcBridge(i, j, arr[i][j]));
      }
    }
  }
  return ans;
}

console.log(solution());
