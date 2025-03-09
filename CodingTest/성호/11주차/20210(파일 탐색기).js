const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input.shift();
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(input.shift());
}

function splitToken(str) {
  const tokens = [];
  let currentToken = "";
  let isCurrentNumeric = false;

  for (let i = 0; i < str.length; i++) {
    const char = str[i];
    const isNumeric = /\d/.test(char);

    if (currentToken === "" || isNumeric === isCurrentNumeric) {
      currentToken += char;
    } else {
      tokens.push({
        value: currentToken,
        isNumeric: isCurrentNumeric,
      });
      currentToken = char;
    }

    isCurrentNumeric = isNumeric;
  }

  if (currentToken !== "") {
    tokens.push({
      value: currentToken,
      isNumeric: isCurrentNumeric,
    });
  }

  return tokens;
}

function naturalCompare(a, b) {
  const tokensA = splitToken(a);
  const tokensB = splitToken(b);

  for (let i = 0; i < Math.min(tokensA.length, tokensB.length); i++) {
    const tokenA = tokensA[i];
    const tokenB = tokensB[i];

    if (tokenA.isNumeric && tokenB.isNumeric) {
      const numA = BigInt(tokenA.value);
      const numB = BigInt(tokenB.value);

      if (numA !== numB) {
        if (numA < numB) {
          return -1;
        } else {
          return 1;
        }
      }

      if (tokenA.value.length !== tokenB.value.length) {
        if (tokenA.value.length < tokenB.value.length) {
          return -1;
        } else {
          return 1;
        }
      }
    } else if (tokenA.isNumeric !== tokenB.isNumeric) {
      if (tokenA.isNumeric) {
        return -1;
      } else {
        return 1;
      }
    } else {
      for (
        let j = 0;
        j < Math.min(tokenA.value.length, tokenB.value.length);
        j++
      ) {
        const charA = tokenA.value[j].toLowerCase();
        const charB = tokenB.value[j].toLowerCase();

        if (charA !== charB) {
          if (charA < charB) {
            return -1;
          } else {
            return 1;
          }
        }
        if (tokenA.value[j] !== tokenB.value[j]) {
          if (tokenA.value[j].toLowerCase() === tokenA.value[j]) {
            return 1;
          } else {
            return -1;
          }
        }
      }
      if (tokenA.value.length !== tokenB.value.length) {
        if (tokenA.value.length < tokenB.value.length) {
          return -1;
        } else {
          return 1;
        }
      }
    }
  }
  if (tokensA.length < tokensB.length) {
    return -1;
  } else if (tokensA.length > tokensB.length) {
    return 1;
  } else {
    return 0;
  }
}

function solution() {
  arr.sort(naturalCompare);

  return arr.join("\n");
}

console.log(solution());
