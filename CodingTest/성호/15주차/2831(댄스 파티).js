const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input.shift();
const maleValues = input.shift().split(" ").map(Number);
const femaleValues = input.shift().split(" ").map(Number);
let male_pos = [];
let male_neg = [];
let female_pos = [];
let female_neg = [];
let ans = 0;

function solution() {
  for (let i = 0; i < n; i++) {
    const temp = maleValues[i];
    if (temp > 0) male_pos.push(temp);
    else male_neg.push(Math.abs(temp));
  }

  for (let i = 0; i < n; i++) {
    const temp = femaleValues[i];
    if (temp > 0) female_pos.push(temp);
    else female_neg.push(Math.abs(temp));
  }

  male_pos.sort((a, b) => b - a);
  male_neg.sort((a, b) => b - a);
  female_pos.sort((a, b) => b - a);
  female_neg.sort((a, b) => b - a);

  let i = 0,
    j = 0;
  while (i < male_pos.length && j < female_neg.length) {
    if (male_pos[i] < female_neg[j]) {
      ans++;
      i++;
      j++;
    } else {
      i++;
    }
  }

  i = 0;
  j = 0;
  while (i < female_pos.length && j < male_neg.length) {
    if (female_pos[i] < male_neg[j]) {
      ans++;
      i++;
      j++;
    } else {
      i++;
    }
  }

  return ans;
}

console.log(solution());
