const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [F, S, G, U, D] = input.shift().split(" ").map(Number);
let visited = Array(F + 1).fill(0);
const dx = [U, -D];

function bfs() {
  let q = [{ curr: S }];
  visited[S] = true;
  while (q.length > 0) {
    const { curr } = q.shift();
    if (curr === G) {
      return;
    }
    for (let dir = 0; dir < 2; dir++) {
      const nX = curr + dx[dir];
      if (nX <= 0 || nX > F) {
        continue;
      }
      if (visited[nX] !== 0) {
        continue;
      }
      visited[nX] = visited[curr] + 1;
      q.push({ curr: nX });
    }
  }
}

function solution() {
  bfs();
  return visited[G] === 0 ? "use the stairs" : visited[G] - 1;
}
console.log(solution());
