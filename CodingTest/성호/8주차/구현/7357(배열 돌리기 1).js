const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M, R] = input[0].split(" ").map(Number);
let arr = Array.from({ length: N }, (_, i) =>
  input[i + 1].split(" ").map(Number)
);

function rotate() {
  const temp = Array.from({ length: N }, () => Array(M).fill(0));

  for (let i = 0; i < Math.min(N, M) / 2; i++) {
    let x1 = i;
    let x2 = N - 1 - i;
    let y1 = i;
    let y2 = M - 1 - i;
    for (let j = x1 + 1; j <= x2; j++) {
      temp[j][y1] = arr[j - 1][y1];
    }
    for (let j = x2 - 1; j >= x1; j--) {
      temp[j][y2] = arr[j + 1][y2];
    }
    for (let j = y1 + 1; j <= y2; j++) {
      temp[x2][j] = arr[x2][j - 1];
    }
    for (let j = y2 - 1; j >= y1; j--) {
      temp[x1][j] = arr[x1][j + 1];
    }
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (temp[i][j] !== 0) {
        arr[i][j] = temp[i][j];
      }
    }
  }
}

function solution() {
  for (let i = 0; i < R; i++) {
    rotate();
  }
  return arr.map((row) => row.join(" ")).join("\n");
}

console.log(solution());
