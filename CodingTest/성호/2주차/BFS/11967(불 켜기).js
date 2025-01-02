const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
const board = Array.from({ length: N }, () => Array(N).fill(0));
let s = new Map();
let ans = 1;
let curQ = [];
let nextQ = [];
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

for (let i = 0; i < M; i++) {
  const [x, y, a, b] = input[i + 1].split(" ").map((item) => item - 1);
  const key = `${x}_${y}`;
  if (s.has(key)) {
    s.set(key, [...s.get(key), [a, b]]);
  } else {
    s.set(key, [[a, b]]);
  }
}

function solution() {
  board[0][0] = 2;
  curQ.push({ curX: 0, curY: 0 });
  while (curQ.length > 0) {
    const { curX, curY } = curQ.shift();
    const key = `${curX}_${curY}`;
    const value = s.get(key);
    if (value) {
      value.forEach((item) => {
        const [a, b] = item;
        if (board[a][b] === 0) {
          board[a][b] = 1;
          nextQ.push({ curX: a, curY: b });
          ans++;
        }
      });
    }
    const len = nextQ.length;
    for (let i = 0; i < len; i++) {
      const { curX, curY } = nextQ.shift();
      let flag = false;
      for (let j = 0; j < 4; j++) {
        const nx = curX + dx[j];
        const ny = curY + dy[j];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
          continue;
        }
        if (board[nx][ny] === 0) {
          continue;
        }
        if (board[nx][ny] === 2) {
          board[curX][curY] = 2;
          curQ.push({ curX, curY });
          flag = true;
          break;
        }
      }
      if (!flag) {
        nextQ.push({ curX, curY });
      }
    }
  }
  return ans;
}

console.log(solution());
