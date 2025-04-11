const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let [A, B, C] = input.shift().split(" ").map(Number);
const sum = A + B + C;
const visited = Array.from({ length: sum + 1 }, () =>
  Array(sum + 1).fill(false)
);

function solution() {
  if (sum % 3 !== 0) return 0;

  const queue = [[A, B]];
  visited[A][B] = true;

  while (queue.length > 0) {
    const [a, b] = queue.shift();
    const c = sum - a - b;

    if (a === b && b === c) return 1;

    const pairs = [
      [a, b],
      [b, c],
      [a, c],
    ];

    for (const [x, y] of pairs) {
      if (x === y) {
        continue;
      }

      const small = Math.min(x, y);
      const large = Math.max(x, y);
      const newSmall = small * 2;
      const newLarge = large - small;

      const newThird = sum - newSmall - newLarge;
      const stones = [newSmall, newLarge, newThird].sort((a, b) => a - b);

      if (!visited[stones[0]][stones[1]]) {
        visited[stones[0]][stones[1]] = true;
        queue.push([stones[0], stones[1]]);
      }
    }
  }

  return 0;
}

console.log(solution());
