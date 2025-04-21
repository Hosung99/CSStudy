const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
	arr.push(input[i].split(" ").map(Number));
}
let board = Array.from({ length: 8 }, () => Array(8).fill(0));
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
let min = 64;
let cctvs = [];

function check(curX, curY, dir) {
  dir = dir % 4;

  while (true) {
    const nx = curX + dx[dir];
    const ny = curY + dy[dir];
    curX = nx;
    curY = ny;

    if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;

    if (board[nx][ny] === 6) break;

    if (board[nx][ny] !== 0) continue;

    board[nx][ny] = -1;
  }
}

function dfs(cnt) {
  if (cnt === cctvs.length) {
    let area = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (board[i][j] === 0) area++;
      }
    }
    min = Math.min(min, area);
    return;
  }

  const curX = cctvs[cnt][0];
  const curY = cctvs[cnt][1];

  let temp_board = Array.from({ length: 8 }, () => Array(8).fill(0));

  for (let dir = 0; dir < 4; dir++) {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        temp_board[i][j] = board[i][j];
      }
    }

    if (board[curX][curY] === 1) {
      check(curX, curY, dir);
    } else if (board[curX][curY] === 2) {
      check(curX, curY, dir);
      check(curX, curY, dir + 2);
    } else if (board[curX][curY] === 3) {
      check(curX, curY, dir);
      check(curX, curY, dir + 1);
    } else if (board[curX][curY] === 4) {
      check(curX, curY, dir);
      check(curX, curY, dir + 1);
      check(curX, curY, dir + 2);
    } else if (board[curX][curY] === 5) {
      check(curX, curY, dir);
      check(curX, curY, dir + 1);
      check(curX, curY, dir + 2);
      check(curX, curY, dir + 3);
    }

    dfs(cnt + 1);

    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        board[i][j] = temp_board[i][j];
      }
    }
  }
}

function solution() {

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      board[i][j] = arr[i][j];
      if (board[i][j] !== 0 && board[i][j] !== 6) {
        cctvs.push([i, j]);
      }
    }
  }

  dfs(0);

  return min;
}

console.log(solution());
