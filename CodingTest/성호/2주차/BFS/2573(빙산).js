const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
let board = Array.from({ length: N }, () => Array(M).fill(0));
for (let i = 0; i < N; i++) {
  board[i] = input[i + 1].split(" ").map(Number);
}
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];
let time = 0;
let visited;
let queue = [];

function melt() {
  let tempBoard = Array.from({ length: N }, () => Array(M).fill(0));
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      tempBoard[i][j] = board[i][j];
      let meltCnt = 0;
      for (let k = 0; k < 4; k++) {
        let nx = i + dx[k];
        let ny = j + dy[k];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          continue;
        }
        if (board[nx][ny] === 0) {
          meltCnt++;
        }
      }
      tempBoard[i][j] -= meltCnt;
      if (tempBoard[i][j] < 0) {
        tempBoard[i][j] = 0;
      }
    }
  }
  board = tempBoard;
}

function bfs(x, y) {
  visited[x][y] = true;
  queue.push({ curX: x, curY: y });
  while (queue.length > 0) {
    let { curX, curY } = queue.shift();
    for (let i = 0; i < 4; i++) {
      let nx = curX + dx[i];
      let ny = curY + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
        continue;
      }
      if (visited[nx][ny] === true || board[nx][ny] === 0) {
        continue;
      }
      queue.push({ curX: nx, curY: ny });
      visited[nx][ny] = true;
    }
  }
}

function checkIsEnd() {
  let areaCnt = 0;
  visited = Array.from({ length: N }, () => Array(M).fill(false));
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (visited[i][j] === false && board[i][j] !== 0) {
        bfs(i, j);
        areaCnt++;
      }
    }
  }
  if (areaCnt === 0) {
    console.log(0);
    process.exit();
  }
  if (areaCnt > 1) {
    return true;
  }
  return false;
}

function solution() {
  while (true) {
    if (checkIsEnd()) {
      break;
    }
    melt();
    time++;
  }
  return time;
}

console.log(solution());
