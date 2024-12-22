const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let [N, M] = input[0].split(" ").map(Number);
let arr = input[1].split(" ").sort((a, b) => a - b);
arr = [...new Set(arr)];
N = arr.length;
const temp = [];
let ans = "";

function recursive(num, depth) {
  if (depth === M) {
    ans += temp.join(" ") + "\n";
    return;
  }
  for (let i = num; i < N; i++) {
    temp.push(arr[i]);
    recursive(i, depth + 1);
    temp.pop();
  }
}

function solution() {
  recursive(0, 0);
  return ans;
}

console.log(solution());
