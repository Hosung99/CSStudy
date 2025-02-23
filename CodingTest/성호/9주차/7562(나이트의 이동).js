const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let tc = +input.shift();
const dx = [2, 1, -2, -1, 2, 1, -2, -1];
const dy = [1, 2, 1, 2, -1, -2, -1, -2];
let l, curr, result;
let ans = "";

function bfs() {
  let visited = Array.from({ length: l }, () => Array(l).fill(false));
  let q = [{ curX: curr[0], curY: curr[1], depth: 0 }];
  visited[curr[0]][curr[1]] = true;
  while (q.length > 0) {
    const { curX, curY, depth } = q.shift();
    if (curX === result[0] && curY === result[1]) {
      ans += depth.toString() + "\n";
      return;
    }
    for (let dir = 0; dir < 8; dir++) {
      const nX = curX + dx[dir];
      const nY = curY + dy[dir];
      if (nX < 0 || nY < 0 || nX >= l || nY >= l) {
        continue;
      }
      if (visited[nX][nY]) {
        continue;
      }
      visited[nX][nY] = true;
      q.push({ curX: nX, curY: nY, depth: depth + 1 });
    }
  }
}

function solution() {
  let i = 0;
  while (tc--) {
    l = +input[i];
    curr = input[i + 1].split(" ").map(Number);
    result = input[i + 2].split(" ").map(Number);
    bfs();
    i += 3;
  }
  return ans;
}

console.log(solution());
