const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(input[i].split(""));
}
let q = [];
let visited = Array.from({ length: N }, () => Array(N).fill(Infinity));
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

function bfs() {
  q.push({ curX: 0, curY: 0, cnt: 0 });
  visited[0][0] = 0;
  while (q.length > 0) {
    const { curX, curY, cnt } = q.shift();
    if (curX === N - 1 && curY === N - 1) {
      return cnt;
    }
    for (let dir = 0; dir < 4; dir++) {
      const nx = curX + dx[dir];
      const ny = curY + dy[dir];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
        continue;
      }
      let temp = cnt;
      if (arr[nx][ny] === "0") {
        temp++;
      }
      if (temp < visited[nx][ny]) {
        visited[nx][ny] = temp;
        if (arr[nx][ny] === "1") {
          q.unshift({ curX: nx, curY: ny, cnt: temp });
        } else {
          q.push({ curX: nx, curY: ny, cnt: temp });
        }
      }
    }
  }
  return 0;
}

function solution() {
  return bfs();
}
console.log(solution());
