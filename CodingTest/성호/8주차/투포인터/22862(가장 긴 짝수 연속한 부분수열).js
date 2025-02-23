const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, k] = input[0].split(" ").map(Number);
const seq = input[1].split(" ").map(Number);

function solution() {
  let st = 0;
  let en = 0;
  let cnt;
  if (seq[0] & 1) {
    cnt = 1;
  } else {
    cnt = 0;
  }

  let maxLen = 0;

  while (true) {
    while (en < n - 1) {
      if (seq[en + 1] & 1) {
        if (cnt < k) {
          cnt++;
        } else {
          break;
        }
      }
      en++;
    }

    if (st >= n || en >= n) {
      break;
    }
    maxLen = Math.max(maxLen, en - st + 1 - cnt);

    if (seq[st] & 1) {
      cnt--;
    }
    st++;
  }

  return maxLen;
}

console.log(solution());
