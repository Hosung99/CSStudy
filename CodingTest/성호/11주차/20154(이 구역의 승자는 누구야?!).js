const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const str = input[0];
const obj = {
  A: 3,
  B: 2,
  C: 1,
  D: 2,
  E: 3,
  F: 3,
  G: 3,
  H: 3,
  I: 1,
  J: 1,
  K: 3,
  L: 1,
  M: 3,
  N: 3,
  O: 1,
  P: 2,
  Q: 2,
  R: 2,
  S: 1,
  T: 2,
  U: 1,
  V: 1,
  W: 2,
  X: 2,
  Y: 2,
  Z: 1,
};
function solution() {
  let sum = 0;
  for (let i = 0; i < str.length; i++) {
    sum += obj[str[i]];
    if (sum > 10) {
      sum %= 10;
    }
  }
  if (sum & 1) console.log("I'm a winner!");
  else console.log("You're the winner?");
}

solution();
