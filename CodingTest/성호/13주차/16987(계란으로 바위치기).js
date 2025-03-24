const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let N = +input.shift();
let arr = [];
for (let i = 0; i < N; i++) {
  const [S, W] = input[i].split(" ").map(Number);
  arr.push([S, W]);
}
let ans = 0;

function dfs(depth) {
  if (depth === N) {
    let tmp = 0;
    for (let i = 0; i < N; i++) {
      if (arr[i][0] <= 0) {
        tmp++;
      }
    }
    ans = Math.max(ans, tmp);
    return;
  }

  for (let i = 0; i < N; i++) {
    if (arr[depth][0] <= 0) {
      dfs(depth + 1);
    } else if (depth === i || arr[i][0] <= 0) {
      continue;
    } else {
      arr[depth][0] -= arr[i][1];
      arr[i][0] -= arr[depth][1];
      dfs(depth + 1);
      arr[depth][0] += arr[i][1];
      arr[i][0] += arr[depth][1];
    }
  }

  let cnt = 0;
  for (let i = 0; i < N; i++) {
    if (arr[i][0] <= 0) {
      cnt++;
    }
  }
  ans = Math.max(ans, cnt);
}

function solution() {
  dfs(0);
  return ans;
}

console.log(solution());
