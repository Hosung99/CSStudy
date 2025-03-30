const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const K = +input.shift();
const [W, H] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < H; i++) {
  arr.push(input[i].split(" ").map(Number));
}
let visited = Array.from({ length: H }, () =>
  Array.from({ length: W }, () => Array(K + 1).fill(-1))
);
const kdx = [-2, -1, 1, 2, -2, -1, 1, 2];
const kdy = [-1, -2, -2, -1, 1, 2, 2, 1];
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

function bfs(startX, startY) {
  let q = [{ curX: startX, curY: startY, kCnt: K, move: 0 }];

  for (let i = 0; i <= K; i++) {
    visited[startX][startY][i] = 0;
  }

  while (q.length > 0) {
    let { curX, curY, kCnt, move } = q.shift();
    if (curX === H - 1 && curY === W - 1) {
      return move;
    }
    if (kCnt > 0) {
      for (let dir = 0; dir < 8; dir++) {
        let nX = curX + kdx[dir];
        let nY = curY + kdy[dir];
        if (nX < 0 || nY < 0 || nX >= H || nY >= W) {
          continue;
        }
        if (visited[nX][nY][kCnt - 1] !== -1 || arr[nX][nY] === 1) {
          continue;
        }
        visited[nX][nY][kCnt - 1] = move + 1;
        q.push({ curX: nX, curY: nY, kCnt: kCnt - 1, move: move + 1 });
      }
    }
    for (let dir = 0; dir < 4; dir++) {
      let nX = curX + dx[dir];
      let nY = curY + dy[dir];
      if (nX < 0 || nY < 0 || nX >= H || nY >= W) {
        continue;
      }
      if (visited[nX][nY][kCnt] !== -1 || arr[nX][nY] === 1) {
        continue;
      }
      visited[nX][nY][kCnt] = move + 1;
      q.push({ curX: nX, curY: nY, kCnt: kCnt, move: move + 1 });
    }
  }
  return -1;
}

function solution() {
  return bfs(0, 0);
}
console.log(solution());
