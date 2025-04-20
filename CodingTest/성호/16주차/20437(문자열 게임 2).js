const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const T = +input.shift();
let ans = "";

function solution() {
  for (let i = 0; i < T; i++) {
    let W = input.shift();
    let K = +input.shift();

    let count = new Array(26).fill(0);
    for (let j = 0; j < W.length; j++) {
      count[W.charCodeAt(j) - 97]++;
    }

    let minLength = Infinity;
    let maxLength = -1;

    for (let j = 0; j < W.length; j++) {
      const charIndex = W.charCodeAt(j) - 97;
      if (count[charIndex] < K) continue;

      let cnt = 0;
      for (let k = j; k < W.length; k++) {
        if (W[j] === W[k]) cnt++;

        if (cnt === K) {
          minLength = Math.min(minLength, k - j + 1);
          maxLength = Math.max(maxLength, k - j + 1);
          break;
        }
      }
    }

    if (minLength === Infinity || maxLength === -1) {
      ans += "-1\n";
    } else {
      ans += `${minLength} ${maxLength}\n`;
    }
  }

  return ans.trim();
}

console.log(solution());
