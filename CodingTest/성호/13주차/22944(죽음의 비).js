const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, H, D] = input.shift().split(" ").map(Number);
let visited = Array.from({ length: N }, () => Array(N).fill(0));
let arr = [];
let start;
let ans = Infinity;

for (let i = 0; i < N; i++) {
  arr.push(input[i].split(""));
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (arr[i][j] === "S") {
      start = { x: i, y: j };
    }
  }
}

const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

function bfs(startX, startY) {
  let queue = [[startX, startY, H, 0, 0]];
  visited[startX][startY] = H;

  while (queue.length > 0) {
    const [x, y, health, umbrella, moves] = queue.shift();

    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
        continue;
      }

      let newHealth = health;
      let newUmbrella = umbrella;

      if (arr[nx][ny] === "E") {
        ans = Math.min(ans, moves + 1);
        continue;
      }

      if (arr[nx][ny] === "U") {
        newUmbrella = D;
      }

      if (newUmbrella > 0) {
        newUmbrella--;
      } else {
        newHealth--;
      }

      if (newHealth <= 0) {
        continue;
      }

      if (visited[nx][ny] < newHealth + newUmbrella) {
        visited[nx][ny] = newHealth + newUmbrella;
        queue.push([nx, ny, newHealth, newUmbrella, moves + 1]);
      }
    }
  }
}

function solution() {
  bfs(start.x, start.y);
  if (ans === Infinity) {
    return -1;
  }
  return ans;
}

console.log(solution());
