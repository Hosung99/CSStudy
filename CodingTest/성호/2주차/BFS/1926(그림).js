const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, m] = input[0].split(" ").map(Number);
const arr = Array.from({ length: n }, () => Array(m).fill(0));
for (let i = 0; i < n; i++) {
  arr[i] = input[i + 1].split(" ").map(Number);
}
let visited = Array.from({ length: n }, () => Array(m).fill(false));
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];
let picCnt = 0;
let area = 0;

function bfs(x, y) {
  let queue = [];
  let cnt = 1;
  visited[x][y] = true;
  queue.push({ curX: x, curY: y });
  while (queue.length > 0) {
    const { curX, curY } = queue.shift();
    for (let i = 0; i < 4; i++) {
      let nx = curX + dx[i];
      let ny = curY + dy[i];
      if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
        continue;
      }
      if (visited[nx][ny] || arr[nx][ny] === 0) {
        continue;
      }
      visited[nx][ny] = true;
      queue.push({ curX: nx, curY: ny });
      cnt++;
    }
  }
  picCnt++;
  area = Math.max(area, cnt);
}

function solution() {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (!visited[i][j] && arr[i][j] === 1) {
        bfs(i, j);
      }
    }
  }
  return picCnt.toString() + "\n" + area.toString();
}

console.log(solution());
