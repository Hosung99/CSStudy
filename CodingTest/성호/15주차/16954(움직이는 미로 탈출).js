const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let board = [];
const dx = [-1, 0, 1, -1, 0, 1, -1, 0, 1];
const dy = [-1, -1, -1, 0, 0, 0, 1, 1, 1];
let visited = Array.from({ length: 64 }, () =>
  Array.from({ length: 8 }, () => Array(8).fill(false))
);

function bfs() {
  const queue = [];
  queue.push([0, 7, 0]);
  visited[0][7][0] = true;

  let currentTurn = 0;

  while (queue.length > 0) {
    const [x, y, turn] = queue.shift();

    if (turn > currentTurn) {
      for (let t = 0; t < turn - currentTurn; t++) {
        wallDrop();
      }
      currentTurn = turn;
    }

    if (y < 8 && board[y][x] === "#") {
      continue;
    }

    if (y === 0 && x === 7) {
      return 1;
    }

    for (let i = 0; i < 9; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];
      const nextTurn = turn + 1;

      if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;

      if (ny < 8 && board[ny][nx] === "." && !visited[nextTurn][ny][nx]) {
        visited[nextTurn][ny][nx] = true;
        queue.push([nx, ny, nextTurn]);
      }
    }
  }

  return 0;
}

function wallDrop() {
  for (let i = 6; i >= 0; i--) {
    for (let j = 0; j < 8; j++) {
      board[i + 1][j] = board[i][j];
    }
  }
  for (let i = 0; i < 8; i++) {
    board[0][i] = ".";
  }
}

function solution() {
  for (let i = 0; i < 8; i++) {
    board.push(input[i].split(""));
  }
  return bfs();
}

console.log(solution());
