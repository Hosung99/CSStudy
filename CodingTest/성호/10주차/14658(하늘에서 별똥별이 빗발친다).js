const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, M, L, K] = input.shift().split(" ").map(Number);
let ans = K;
const shootingStars = [];
for (let i = 0; i < K; i++) {
  const [x, y] = input[i].split(" ").map(Number);
  shootingStars.push({ x, y });
}

function solution() {
  for (let i = 0; i < K; i++) {
    const startX = shootingStars[i].x;

    for (let j = 0; j < K; j++) {
      const startY = shootingStars[j].y;
      let cnt = 0;

      for (let k = 0; k < K; k++) {
        const currentX = shootingStars[k].x;
        const currentY = shootingStars[k].y;
        if (
          startX <= currentX &&
          currentX <= startX + L &&
          startY <= currentY &&
          currentY <= startY + L
        ) {
          cnt++;
        }
      }
      ans = Math.min(ans, K - cnt);
    }
  }

  return ans;
}

console.log(solution());
