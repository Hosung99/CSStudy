const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
let board = Array.from({ length: N }, () => []);
for (let i = 0; i < N; i++) {
  board[i] = input[i + 1].split(" ").map(Number);
}
let visited = Array.from({ length: N }, () => Array(M).fill(false));
let ans = 0;
const dx = [
  [-1, 0],
  [-1, 0],
  [1, 0],
  [1, 0],
];
const dy = [
  [0, 1],
  [0, -1],
  [0, -1],
  [0, 1],
];

function dfs(x, y, cnt) {
  ans = Math.max(ans, cnt);
  if (x === N) {
    return;
  }
  if (!visited[x][y]) {
    for (let i = 0; i < 4; i++) {
      const [x1, y1] = [x + dx[i][0], y + dy[i][0]];
      const [x2, y2] = [x + dx[i][1], y + dy[i][1]];
      if (
        x1 < 0 ||
        N <= x1 ||
        y1 < 0 ||
        M <= y1 ||
        x2 < 0 ||
        N <= x2 ||
        y2 < 0 ||
        M <= y2
      ) {
        continue;
      }
      if (visited[x1][y1] || visited[x2][y2]) {
        continue;
      }
      visited[x1][y1] = true;
      visited[x2][y2] = true;
      visited[x][y] = true;
      if (y === M - 1) {
        dfs(x + 1, 0, cnt + board[x][y] * 2 + board[x1][y1] + board[x2][y2]);
      } else {
        dfs(x, y + 1, cnt + board[x][y] * 2 + board[x1][y1] + board[x2][y2]);
      }
      visited[x1][y1] = false;
      visited[x2][y2] = false;
      visited[x][y] = false;
    }
  }
  if (y === M - 1) {
    dfs(x + 1, 0, cnt);
  } else {
    dfs(x, y + 1, cnt);
  }
}

function solution() {
  dfs(0, 0, 0);
  return ans;
}

console.log(solution());
