const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = Array(26).fill(false);
let ans = "";
function solution() {
  for (let i = 0; i < N; i++) {
    let str = input[i].split(" ");
    let flag = true;
    for (let j = 0; j < str.length; j++) {
      let idx = str[j][0].toLowerCase().charCodeAt() - 97;
      if (!arr[idx]) {
        arr[idx] = true;
        flag = false;
        str[j] = `[${str[j][0]}]${str[j].substring(1)}`;
        break;
      }
    }
    if (flag) {
      let flag2 = true;
      for (let j = 0; j < str.length; j++) {
        if (flag2) {
          for (let k = 0; k < str[j].length; k++) {
            let idx = str[j][k].toLowerCase().charCodeAt() - 97;
            if (!arr[idx]) {
              str[j] =
                str[j].substring(0, k) +
                `[${str[j][k]}]` +
                str[j].substring(k + 1);
              arr[idx] = true;
              flag2 = false;
              break;
            }
          }
        }
      }
    }
    ans += str.join(" ") + "\n";
  }
  return ans;
}
console.log(solution());
