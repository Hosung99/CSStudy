const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = [];
let ans = "";
function solution() {
  for (let i = 0; i < N; i++) {
    arr.push(input[i]);
  }
  for (let i = 0; i < N; i++) {
    if (arr[i] === "KBS1") {
      ans += "1".repeat(i) + "4".repeat(i);
      arr.splice(i, 1);
      arr.unshift("KBS1");
    }
  }
  for (let i = 0; i < N; i++) {
    if (arr[i] === "KBS2") {
      ans += "1".repeat(i) + "4".repeat(i - 1);
    }
  }
  return ans;
}
console.log(solution());
