const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, C] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(+input[i]);
}
let ans = 0;

function binarySearch() {
  let start = 1;
  let end = arr[N - 1] - arr[0];
  while (start <= end) {
    let router = 1;
    let mid = Math.floor((start + end) / 2);
    let st = arr[0];

    for (let i = 1; i < N; i++) {
      if (arr[i] - st >= mid) {
        router++;
        st = arr[i];
      }
    }

    if (router >= C) {
      ans = Math.max(ans, mid);
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
}

function solution() {
  arr.sort((a, b) => a - b);
  binarySearch();
  return ans;
}
console.log(solution());
