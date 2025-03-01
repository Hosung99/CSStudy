const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = input.shift().split(" ").map(Number);
let ans = 0;
let cntArr = Array(10).fill(0);

function checkCnt() {
  let cnt = 0;
  for (let i = 0; i < 10; i++) {
    if (cntArr[i] > 0) {
      cnt++;
    }
  }
  return cnt;
}

function solution() {
  let st = 0,
    end = 0;
  cntArr[arr[st]]++;
  while (st < N) {
    while (end < N) {
      end++;
      cntArr[arr[end]]++;
      if (checkCnt() > 2) {
        cntArr[arr[end]]--;
        ans = Math.max(ans, end - st);
        end--;
        break;
      } else {
        ans = Math.max(ans, end - st);
      }
    }
    cntArr[arr[st]]--;
    st++;
  }
  return ans;
}

console.log(solution());
