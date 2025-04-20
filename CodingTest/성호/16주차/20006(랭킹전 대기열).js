const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [p, m] = input.shift().split(" ").map(Number);
let arr = [];

function print() {
  let ans = "";
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].player.length === m) {
      ans += "Started!\n";
    } else {
      ans += "Waiting!\n";
    }
	arr[i].player.sort((a, b) => a.n.localeCompare(b.n));
    for (let j = 0; j < arr[i].player.length; j++) {
      ans += arr[i].player[j].l + " " + arr[i].player[j].n + "\n";
    }
  }
  return ans;
}

function solution() {
  for (let i = 0; i < p; i++) {
    let [l, n] = input[i].split(" ");
    l = +l;
    if (arr.length === 0) {
      arr.push({ level: l, player: [{ l, n }] });
    } else {
      let flag = true;
      for (let j = 0; j < arr.length; j++) {
        if (Math.abs(arr[j].level - l) <= 10) {
          if (arr[j].player.length < m) {
            arr[j].player.push({ l, n });
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        arr.push({ level: l, player: [{ l, n }] });
      }
    }
  }
  return print();
}
console.log(solution());
