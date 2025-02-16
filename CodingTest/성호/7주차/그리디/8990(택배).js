const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let [N, C] = input[0].split(" ").map(Number);
let M = +input[1];
let arr = [];
let ans = 0;
let capacity = Array(N + 1).fill(0);

function solution() {
  for (let i = 0; i < M; i++) {
    const [from, to, cnt] = input[i + 2].split(" ").map(Number);
    arr.push({ from, to, cnt });
  }
  arr.sort((a, b) => {
    if (a.to === b.to) {
      return a.from - b.from;
    }
    return a.to - b.to;
  });
  for (let box of arr) {
    let p = C;
    for (let i = box.from; i < box.to; i++) {
      p = Math.min(p, C - capacity[i]);
    }
    let mn = Math.min(p, box.cnt);
    if (mn > 0) {
      for (let i = box.from; i < box.to; i++) {
        capacity[i] += mn;
      }
      ans += mn;
    }
  }
  return ans;
}

console.log(solution());
