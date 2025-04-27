const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M] = input.shift().split(" ").map(Number);
let arr = Array.from({ length: N + 1 }, () => []);
let ansArr = [];
let res = "";
let maxCnt = 0;

function bfs(idx) {
  let visited = Array(N + 1).fill(false);
  let q = [];
  let cnt = 1;
  visited[idx] = true;
  q.push(idx);

  while (q.length > 0) {
    const curr = q.shift();

    for (let i = 0; i < arr[curr].length; i++) {
      const next = arr[curr][i];
      if (!visited[next]) {
        visited[next] = true;
        q.push(next);
        cnt++;
      }
    }
  }

  return cnt;
}

function solution() {
  for (let i = 0; i < M; i++) {
    const [A, B] = input[i].split(" ").map(Number);
    arr[B].push(A);
  }
  for (let i = 1; i <= N; i++) {
    ansArr.push({ idx: i, cnt: bfs(i) });
  }
  for (let i = 0; i < ansArr.length; i++) {
    maxCnt = Math.max(maxCnt, ansArr[i].cnt);
  }
  for (let i = 0; i < ansArr.length; i++) {
    if (ansArr[i].cnt === maxCnt) {
      res += ansArr[i].idx + " ";
    }
  }

  return res.trim();
}

console.log(solution());
