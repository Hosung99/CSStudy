const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let str = input.shift();
let ans = Infinity;
function solution() {
  let windowSize = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === "a") windowSize++;
  }
  for (let i = 0; i < str.length; i++) {
    let temp = 0;
    let idx = 0;
    while (idx < windowSize) {
      let tempIdx = (i + idx) % str.length;
      if (str[tempIdx] === "b") temp++;
      idx++;
    }
    ans = Math.min(ans, temp);
  }
  return ans;
}
console.log(solution());
