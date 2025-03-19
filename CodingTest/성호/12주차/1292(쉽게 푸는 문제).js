const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [A, B] = input.shift().split(" ").map(Number);
let arr = [];
function solution() {
  for (let i = 1; i <= 1000; i++) {
    for (let j = 0; j < i; j++) {
      arr.push(i);
    }
  }
  let tempArr = arr.slice(A - 1, B);
  return tempArr.reduce((acc, cur) => acc + cur);
}
console.log(solution());
