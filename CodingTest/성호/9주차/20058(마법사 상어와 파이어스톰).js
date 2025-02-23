const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, Q] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < 2 ** N; i++) {
  let line = input[i].split(" ").map(Number);
  arr.push(line);
}
let level = input[2 ** N].split(" ").map(Number);
let visited = Array.from({ length: 2 ** N }, () => Array(2 ** N).fill(false));
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

function turning(a, b, len) {
  const square = len / 2;
  for (let number = 0; number < square; number++) {
    const startX = a + number;
    const startY = b + number;
    const endX = a + len - number - 1;
    const endY = b + len - number - 1;

    let xIdx = endX;
    let yIdx = startY;
    let idx = 0;
    const temp = [];

    // 왼쪽 저장
    for (let i = startX; i < endX; i++) {
      temp.push(arr[i][startY]);
    }

    // 위 이동
    for (let i = startX; i < endX; i++) {
      arr[i][startY] = arr[endX][yIdx++];
    }

    // 오른쪽 이동
    for (let i = startY; i < endY; i++) {
      arr[endX][i] = arr[xIdx--][endY];
    }

    // 아래 이동
    for (let i = endX; i > startX; i--) {
      arr[i][endY] = arr[startX][yIdx--];
    }

    // 임시 저장 이동
    for (let i = endY; i > startY; i--) {
      arr[startX][i] = temp[idx++];
    }
  }
}

function spin(len) {
  for (let i = 0; i < 2 ** N; i += len) {
    for (let j = 0; j < 2 ** N; j += len) {
      turning(i, j, len);
    }
  }
}

function melt() {
  let meltingPositions = [];

  for (let i = 0; i < 2 ** N; i++) {
    for (let j = 0; j < 2 ** N; j++) {
      if (arr[i][j] === 0) {
        continue;
      }

      let cnt = 0;
      for (let dir = 0; dir < 4; dir++) {
        const nx = i + dx[dir];
        const ny = j + dy[dir];
        if (nx < 0 || ny < 0 || nx >= 2 ** N || ny >= 2 ** N) {
          continue;
        }
        if (arr[nx][ny] === 0) {
          continue;
        }
        cnt++;
      }

      if (cnt < 3) {
        meltingPositions.push([i, j]);
      }
    }
  }

  for (const [x, y] of meltingPositions) {
    arr[x][y]--;
  }
}

function bfs(a, b) {
  const queue = [[a, b]];
  visited[a][b] = true;
  let cnt = 1;

  while (queue.length > 0) {
    const [x, y] = queue.shift();

    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (nx < 0 || ny < 0 || nx >= 2 ** N || ny >= 2 ** N) {
        continue;
      }

      if (arr[nx][ny] === 0) {
        continue;
      }

      if (visited[nx][ny]) {
        continue;
      }

      visited[nx][ny] = true;
      queue.push([nx, ny]);
      cnt++;
    }
  }

  return cnt;
}

function calculateIce() {
  let sum = 0;
  let mxSum = 0;

  for (let i = 0; i < 2 ** N; i++) {
    for (let j = 0; j < 2 ** N; j++) {
      sum += arr[i][j];
      if (arr[i][j] === 0) {
        continue;
      }
      if (visited[i][j]) {
        continue;
      }

      const result = bfs(i, j);
      mxSum = Math.max(mxSum, result);
    }
  }

  return [sum, mxSum];
}

function solution() {
  for (let i = 0; i < Q; i++) {
    spin(2 ** level[i]);
    melt();
  }
  const [sum, mxSum] = calculateIce();
  return sum + "\n" + mxSum;
}

console.log(solution());
