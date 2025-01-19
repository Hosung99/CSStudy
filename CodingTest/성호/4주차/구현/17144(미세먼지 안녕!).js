const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let [R, C, T] = input[0].split(" ").map(Number);
let board = [];
for (let i = 0; i < R; i++) {
  board.push(input[i + 1].split(" ").map(Number));
}
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

function doAirCondition() {
  let airPos = -1;
  for (let i = 0; i < R; i++) {
    if (board[i][0] === -1) {
      airPos = i;
      break;
    }
  }
  for (let i = airPos - 1; i > 0; i--) {
    board[i][0] = board[i - 1][0];
  }
  for (let j = 0; j < C - 1; j++) {
    board[0][j] = board[0][j + 1];
  }
  for (let i = 0; i < airPos; i++) {
    board[i][C - 1] = board[i + 1][C - 1];
  }
  for (let j = C - 1; j > 1; j--) {
    board[airPos][j] = board[airPos][j - 1];
  }
  board[airPos][1] = 0;
  for (let i = airPos + 2; i < R - 1; i++) {
    board[i][0] = board[i + 1][0];
  }
  for (let j = 0; j < C - 1; j++) {
    board[R - 1][j] = board[R - 1][j + 1];
  }
  for (let i = R - 1; i > airPos + 1; i--) {
    board[i][C - 1] = board[i - 1][C - 1];
  }
  for (let j = C - 1; j > 1; j--) {
    board[airPos + 1][j] = board[airPos + 1][j - 1];
  }
  board[airPos + 1][1] = 0;
}

function diffuse() {
  const tempBoard = board.map((row) => [...row]);

  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (tempBoard[i][j] > 0) {
        let dirCnt = 0;
        let amount = Math.floor(tempBoard[i][j] / 5);

        for (let dir = 0; dir < 4; dir++) {
          let nx = i + dx[dir];
          let ny = j + dy[dir];
          if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
            continue;
          }
          if (tempBoard[nx][ny] === -1) {
            continue;
          }
          board[nx][ny] += amount;
          dirCnt++;
        }
        board[i][j] -= amount * dirCnt;
      }
    }
  }
}

function getResult() {
  let sum = 0;
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      sum += board[i][j];
    }
  }
  return sum + 2;
}

function solution() {
  while (T--) {
    diffuse();
    doAirCondition();
  }
  return getResult();
}

console.log(solution());
