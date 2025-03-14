const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let arr = [];
for (let i = 0; i < 4; i++) {
  arr.push(input.shift().split(""));
}
let K = +input.shift();
let KArr = [];
for (let i = 0; i < K; i++) {
  KArr.push(input.shift().split(" ").map(Number));
}

function spin() {
  let [num, dir] = KArr.shift();
  num--;
  let directions = [0, 0, 0, 0];
  directions[num] = dir;
  for (let i = num - 1; i >= 0; i--) {
    if (arr[i][2] !== arr[i + 1][6]) {
      directions[i] = -directions[i + 1];
    } else {
      break;
    }
  }
  for (let i = num + 1; i < 4; i++) {
    if (arr[i - 1][2] !== arr[i][6]) {
      directions[i] = -directions[i - 1];
    } else {
      break;
    }
  }
  for (let i = 0; i < 4; i++) {
    if (directions[i] === 1) {
      let temp = arr[i].pop();
      arr[i].unshift(temp);
    } else if (directions[i] === -1) {
      let temp = arr[i].shift();
      arr[i].push(temp);
    }
  }
}

function calc() {
  for (let i = 0; i < 4; i++) {
    if (arr[i][0] === "1") {
      ans += Math.pow(2, i);
    }
  }
}

let ans = 0;
function solution() {
  while (K--) {
    spin();
  }
  calc();
  return ans;
}

console.log(solution());
