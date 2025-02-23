const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
let S = input.shift();
let q = +input.shift();
let arr = [];
let ans = "";

function solution() {
  for (let i = 0; i < S.length; i++) {
    let tempArr;
    if (i === 0) {
      tempArr = Array(26).fill(0);
    } else {
      tempArr = arr[i - 1].slice();
    }
    tempArr[S[i].charCodeAt() - 97]++;
    arr.push(tempArr);
  }
  for (let i = 0; i < q; i++) {
    let [a, l, r] = input[i].split(" ");
    l = +l;
    r = +r;
    let charIndex = a.charCodeAt() - 97;
    let count =
      l === 0 ? arr[r][charIndex] : arr[r][charIndex] - arr[l - 1][charIndex];
    ans += count.toString() + "\n";
  }
  return ans;
}

console.log(solution());
